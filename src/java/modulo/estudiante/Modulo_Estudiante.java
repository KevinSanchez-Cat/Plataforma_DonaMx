/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo.estudiante;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
import java.io.IOException;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import manipula.*;
import model.*;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Modulo_Estudiante extends HttpServlet implements ServletContextListener, HttpSessionBindingListener {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        String page = request.getParameter("page");

        if (session != null) {
            String username = (String) session.getAttribute("username");
            //  session.setMaxInactiveInterval(60);//session timeout in seconds 
            // long hora = utils.Misc.getDateTimeActualJava().getTime();
            // long milisegundos = hora - (session.getLastAccessedTime());
            //int timepoInactividad = (int) (milisegundos / 1000 / 60);
            ManipulaCategoria mCategoria = null;
            ManipulaUsuario mUsuario = null;
            ManipulaEstudiante mEstudiante = null;
            ManipulaDireccion mDireccion = null;
            ManipulaEstado mEstado = null;
            ManipulaMunicipio mMunicipio = null;
            ManipulaLocalidad mLocalidad = null;
            ManipulaRecursoTecnologico mRecursosTecnologicos = null;
            ManipulaEquipoComputacional mEquiposComputacionales = null;
            ManipulaSolicitud mSolicitudes = null;
            ManipulaDeseos mDeseos = null;
            ManipulaDonacion mDonaciones = null;

            RequestDispatcher dispatcher = null;
            List<RecursoTecnologico> lstRecursosTecnologicos = null;
            List<Categoria> lstCategorias = null;
            List<EquipoComputacional> lstEquiposComputacionalesDonados = null;
            List<EquipoComputacional> lstEquiposComputacionalesRemunerados = null;
            List<Deseo> lstDeseos = null;
            List<Donacion> lstDonaciones = null;
            List<Notificacion> lstNotificaciones = null;
            Estudiante estudiante = null;

            if (username != null) {
                String rol = String.valueOf(session.getAttribute("rol"));
                if (rol == null) {
                    dispatcher = getServletContext().getRequestDispatcher("/views/templates/errores/no_autorizado.jsp");
                } else {
                    if (rol.equals("DONATARIO")) {
                        mUsuario = new ManipulaUsuario();
                        int idUser = (int) session.getAttribute("idUser");

                        lstDonaciones = mUsuario.getDonacionRecibidas(idUser);
                        lstNotificaciones = mUsuario.getNotificacion(idUser);
                        estudiante = mUsuario.getEstudiante(idUser);

                        if (estudiante != null) {
                            mEstudiante = new ManipulaEstudiante();
                            lstDeseos = mEstudiante.getListaDeseos(estudiante.getIdEstudiante());
                        }

                        request.setAttribute("lstDeseos", lstDeseos);
                        request.setAttribute("estudiante", estudiante);
                        request.setAttribute("lstNotificaciones", lstNotificaciones);
                        request.setAttribute("lstDonaciones", lstDonaciones);

                        if (page == null) {
                            dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/home.jsp");
                        } else {
                            switch (page) {
                                case "catalogo":
                                    String idCat = request.getParameter("id_categoria");
                                    String categoria = request.getParameter("nombre_categoria");
                                    if (idCat == null) {
                                        dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/catalogo.jsp");
                                        mCategoria = new ManipulaCategoria();
                                        lstCategorias = mCategoria.getData();
                                        request.setAttribute("lstCategorias", lstCategorias);
                                    } else {
                                        if (categoria != null) {
                                            String idRecurso = request.getParameter("id_recurso_tecnologico");
                                            if (idRecurso != null) {
                                                try {
                                                    int idRecTec = Integer.parseInt(idRecurso);
                                                    ManipulaRecursoTecnologico mRecursoTecnologico = new ManipulaRecursoTecnologico();
                                                    RecursoTecnologico recTec = mRecursoTecnologico.encontrarId(idRecTec);
                                                    //saber que es para mostrar la información correcta
                                                    EquipoComputacional equipoComuto = null;
                                                    if (recTec != null) {
                                                        mEquiposComputacionales = new ManipulaEquipoComputacional();
                                                        equipoComuto = mEquiposComputacionales.encontrarIdRecurso(recTec.getIdRecursoTecnologico());
                                                        if (equipoComuto != null) {
                                                            dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/equipo_computacional_categoria.jsp");
                                                            request.setAttribute("equipo_computo", equipoComuto);
                                                        } else {
                                                            dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/recurso_tecnologico_categoria.jsp");
                                                        }
                                                    } else {
                                                        dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/recurso_tecnologico_categoria.jsp");
                                                    }
                                                    request.setAttribute("recurso_tecnologico", recTec);
                                                    request.setAttribute("id_categoria", idCat);
                                                    request.setAttribute("nombre_categoria", categoria);
                                                } catch (NumberFormatException e) {
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/categoria.jsp");
                                                    mCategoria = new ManipulaCategoria();
                                                    lstCategorias = mCategoria.getData();
                                                    request.setAttribute("lstCategorias", lstCategorias);
                                                }
                                            } else {
                                                try {
                                                    int cat = Integer.parseInt(idCat);
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/categoria.jsp");
                                                    mCategoria = new ManipulaCategoria();
                                                    lstRecursosTecnologicos = mCategoria.getLstRecursosTecnologicos(cat);
                                                    request.setAttribute("lstRecursosTecnologicos", lstRecursosTecnologicos);
                                                    request.setAttribute("categoria", categoria);
                                                } catch (NumberFormatException e) {
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/catalogo.jsp");
                                                    mCategoria = new ManipulaCategoria();
                                                    lstCategorias = mCategoria.getData();
                                                    request.setAttribute("lstCategorias", lstCategorias);
                                                }
                                            }
                                        } else {
                                            dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/catalogo.jsp");
                                            mCategoria = new ManipulaCategoria();
                                            lstCategorias = mCategoria.getData();
                                            request.setAttribute("lstCategorias", lstCategorias);
                                        }
                                    }
                                    break;
                                case "equipos_remunerados":
                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/equipos_remunerados.jsp");

                                    break;
                                case "equipos_donados":
                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/equipos_donados.jsp");

                                    break;
                                case "informacion_personal":
                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/informacion_personal.jsp");
                                    if (estudiante != null) {
                                        request.setAttribute("persona_nombre", estudiante.getNombres());
                                        request.setAttribute("persona_apellido_paterno", estudiante.getApellidoPaterno());
                                        request.setAttribute("persona_apellido_materno", estudiante.getApellidoMaterno());
                                        request.setAttribute("persona_fecha_nacimiento", estudiante.getFechaNacimiento());
                                        request.setAttribute("persona_lugar_nacimiento", estudiante.getLugarNacimiento());
                                        request.setAttribute("persona_nacionalidad", estudiante.getNacionalidad());
                                        request.setAttribute("persona_telefono_movil", estudiante.getNumeroTelMovil());
                                        request.setAttribute("persona_telefono_fijo", estudiante.getNumeroTelFijo());
                                        request.setAttribute("persona_estado_civil", "");
                                        request.setAttribute("persona_genero", estudiante.getGenero());
                                        request.setAttribute("curp", "");
                                    }
                                    break;
                                case "informacion_escolar":
                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/informacion_escolar.jsp");
                                    if (estudiante != null) {
                                        request.setAttribute("estudiante_idEstudiante", estudiante.getIdEstudiante());
                                        request.setAttribute("estudiante_nombres", estudiante.getNombres());
                                        request.setAttribute("estudiante_apellido_paterno", estudiante.getApellidoPaterno());
                                        request.setAttribute("estudiante_apellido_materno", estudiante.getApellidoPaterno());
                                        request.setAttribute("estudiante_nivel_educativo", estudiante.getNivelEducativo());
                                        request.setAttribute("estudiante_ocupacion", estudiante.getOcupacion());
                                        request.setAttribute("estudiante_tipo_escuela", estudiante.getTipoEscuela());
                                        request.setAttribute("estudiante_promedio_anterior", estudiante.getPromedioAnterior());
                                        request.setAttribute("estudiante_estatus_escolar", estudiante.isEstatusEscolar());
                                    }
                                    break;
                                case "informacion_domiciliaria":
                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/informacion_domiciliaria.jsp");
                                    //Si no existen registros de estados, municipios y localidades en la base de datos, se recurre a los datos 
                                    //Dentro de la apliacion
                                    Direccion dir = new Direccion();
                                    if (estudiante != null) {
                                        request.setAttribute("estudiante_id_direccion", dir.getIdDireccion());
                                        request.setAttribute("estudiante_codigo_postal", dir.getCalleDerecha());
                                        request.setAttribute("estudiante_id_estado", dir.getCalleDerecha());
                                        request.setAttribute("estudiante_id_municipio", estudiante.getApellidoPaterno());
                                        request.setAttribute("estudiante_id_localidad", estudiante.getApellidoPaterno());
                                        request.setAttribute("estudiante_calle_interior", estudiante.getNivelEducativo());
                                        request.setAttribute("estudiante_calle_exterior", estudiante.getOcupacion());
                                        request.setAttribute("estudiante_calle_frontal", estudiante.getTipoEscuela());
                                        request.setAttribute("estudiante_calle_trasera", dir.getCalleTrasera());
                                        request.setAttribute("estudiante_calle_izquierda", estudiante.getPromedioAnterior());
                                        request.setAttribute("estudiante_calle_derecha", estudiante.isEstatusEscolar());
                                        request.setAttribute("estudiante_nombre_asentamiento", estudiante.isEstatusEscolar());
                                        request.setAttribute("estudiante_tipo_asentamiento", estudiante.isEstatusEscolar());
                                    }
                                    break;
                                case "mi_mochila":
                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/mi_mochila.jsp");

                                    break;
                                case "deseos":
                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/lista_deseos.jsp");
                                    break;
                                case "solicitudes":
                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/solicitudes.jsp");
                                    break;
                                case "perfil":
                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/perfil.jsp");
                                    break;
                                case "notificaciones":
                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/notificaciones.jsp");

                                    break;
                                case "cambiar_contrasenia":
                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/cambiar_contrasenia.jsp");
                                    break;
                                case "cerrar_sesion":
                                    Usuario user = (Usuario) session.getAttribute("user");
                                    manipula.ManipulaAutenticacion.cerrarSesionUsuario(user);
                                    session.invalidate();

                                    //dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                                    response.sendRedirect("home.do");
                                    break;
                                default:
                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/home.jsp");
                                    break;
                            }
                        }
                    } else {
                        dispatcher = getServletContext().getRequestDispatcher("/views/templates/errores/no_autorizado.jsp");
                    }
                }
                if (dispatcher != null) {
                    dispatcher.forward(request, response);
                }
            } else {
                response.sendRedirect("autenticacion");
            }
        } else {
            response.sendRedirect("autenticacion");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/home.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Iterator<Driver> driversIterator = ServiceLoader.load(Driver.class).iterator();
        while (driversIterator.hasNext()) {
            try {
                // Instantiates the driver
                driversIterator.next();
            } catch (Throwable t) {
                sce.getServletContext().log("JDBC Driver registration failure.", t);
            }
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // AbandonedConnectionCleanupThread.checkedShutdown();
        final ClassLoader cl = sce.getServletContext().getClassLoader();
        final Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            final Driver driver = drivers.nextElement();
            // We deregister only the classes loaded by this application's classloader
            if (driver.getClass().getClassLoader() == cl) {
                try {
                    DriverManager.deregisterDriver(driver);
                } catch (SQLException e) {
                    sce.getServletContext().log("JDBC Driver deregistration failure.", e);
                }
            }
        }
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("Se quito un atributo a la sesion" + event.getSession());

    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("Se agrego un atributo a la sesion" + event.getSession());
    }

}
