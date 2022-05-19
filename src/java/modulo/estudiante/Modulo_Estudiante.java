/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo.estudiante;

import bussisness.ProcesosEstudiante;
import config.conexion.ConexionFactory;
import config.conexion.IConexion;
import java.io.IOException;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import utils.Logg;

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

            RequestDispatcher dispatcher = null;
            List<RecursoTecnologico> lstRecursosTecnologicos = null;
            List<Categoria> lstCategorias = null;
            List<EquipoComputacional> lstEquiposComputacionalesDonados = new ArrayList<>();
            List<EquipoComputacional> lstEquiposComputacionalesRemunerados = new ArrayList<>();
            List<Deseo> lstDeseos = new ArrayList<>();
            List<Donacion> lstDonaciones = new ArrayList<>();
            List<Notificacion> lstNotificaciones = new ArrayList<>();
            List<Noticia> lstNoticias = new ArrayList<>();
            List<Solicitud> lstSolicitudes = new ArrayList<>();
            Estudiante estudiante = null;
            RecursoTecnologico recTec = null;
            EquipoComputacional equipoComputacional = null;
            Direccion dir = null;
            if (username != null) {
                String rol = String.valueOf(session.getAttribute("rol"));
                if (rol == null) {
                    dispatcher = getServletContext().getRequestDispatcher("/views/templates/errores/no_autorizado.jsp");
                } else {
                    if (rol.equals("DONATARIO")) {
                        int idUser = (int) session.getAttribute("idUser");
                        infoPrincipal(idUser, lstDonaciones, lstDeseos, lstNotificaciones, estudiante);
                        request.setAttribute("lstDeseos", lstDeseos);
                        request.setAttribute("estudiante", estudiante);
                        request.setAttribute("lstNotificaciones", lstNotificaciones);
                        request.setAttribute("lstDonaciones", lstDonaciones);

                        if (page == null) {
                            lstNoticias = processHome(lstNoticias);
                            request.setAttribute("lstNoticias", lstNoticias);
                            dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/home.jsp");
                        } else {
                            switch (page) {
                                case "catalogo":
                                    String idCat = request.getParameter("id_categoria");
                                    String categoria = request.getParameter("nombre_categoria");
                                    if (idCat == null) {
                                        lstCategorias = processCatalogo(lstCategorias);
                                        request.setAttribute("lstCategorias", lstCategorias);
                                        dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/catalogo.jsp");
                                    } else {
                                        if (categoria != null) {
                                            String idRecurso = request.getParameter("id_recurso_tecnologico");
                                            if (idRecurso != null) {
                                                try {
                                                    int idRecTec = Integer.parseInt(idRecurso);
                                                    recTec = processRecursoCategoria(idRecTec, recTec);
                                                    if (recTec != null) {
                                                        equipoComputacional = processRecursoEquipoComputo(idRecTec, equipoComputacional);
                                                        if (equipoComputacional != null) {
                                                            request.setAttribute("equipo_computo", equipoComputacional);
                                                            dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/equipo_computacional_categoria.jsp");
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
                                                    lstCategorias = processCatalogo(lstCategorias);
                                                    request.setAttribute("lstCategorias", lstCategorias);
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/catalogo.jsp");
                                                }
                                            } else {
                                                try {
                                                    int idCategoria = Integer.parseInt(idCat);
                                                    lstRecursosTecnologicos = processCategoria(idCategoria, lstRecursosTecnologicos);
                                                    request.setAttribute("lstRecursosTecnologicos", lstRecursosTecnologicos);
                                                    request.setAttribute("categoria", categoria);
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/categoria.jsp");
                                                } catch (NumberFormatException e) {
                                                    lstCategorias = processCatalogo(lstCategorias);
                                                    request.setAttribute("lstCategorias", lstCategorias);
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/catalogo.jsp");
                                                }
                                            }
                                        } else {
                                            lstCategorias = processCatalogo(lstCategorias);
                                            request.setAttribute("lstCategorias", lstCategorias);
                                            dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/catalogo.jsp");
                                        }
                                    }
                                    break;
                                case "equipos_remunerados":
                                    lstEquiposComputacionalesRemunerados = processEquiposRemunerados(lstEquiposComputacionalesRemunerados);
                                    request.setAttribute("lstEquiposRemunerados", lstEquiposComputacionalesRemunerados);
                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/equipos_remunerados.jsp");
                                    break;
                                case "equipos_donados":
                                    lstEquiposComputacionalesDonados = processEquiposDonados(lstEquiposComputacionalesDonados);
                                    request.setAttribute("lstEquiposDonados", lstEquiposComputacionalesDonados);
                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/equipos_donados.jsp");
                                    break;
                                case "informacion_personal":
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
                                        request.setAttribute("persona_curp", estudiante.getCurp());
                                        request.setAttribute("persona_habilidades", estudiante.getHabilidades());
                                        request.setAttribute("persona_intereses", estudiante.getIntereses());
                                    }
                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/informacion_personal.jsp");
                                    break;
                                case "informacion_escolar":
                                    if (estudiante != null) {
                                        request.setAttribute("estudiante_idEstudiante", estudiante.getIdEstudiante());
                                        request.setAttribute("estudiante_nivel_educativo", estudiante.getNivelEducativo());
                                        request.setAttribute("estudiante_nombre_institucion", estudiante.getNombreEscuela());
                                        request.setAttribute("estudiante_tipo_escuela", estudiante.getTipoEscuela());
                                        request.setAttribute("estudiante_tipo_periodo", estudiante.getTipoPeriodo());
                                        request.setAttribute("estudiante_total_periodos", estudiante.getTotalPeriodos());
                                        request.setAttribute("estudiante_periodo_actual", estudiante.getPeriodoActual());
                                        request.setAttribute("estudiante_periodo", estudiante.getPeriodo());
                                        request.setAttribute("estudiante_matricula", estudiante.getMatricula());
                                        request.setAttribute("estudiante_matricula_escuela", estudiante.getPresentacion());
                                        request.setAttribute("estudiante_estatus_escolar", estudiante.isEstatusEscolar());
                                        request.setAttribute("estudiante_regular", estudiante.isRegular());
                                        request.setAttribute("estudiante_promedio_anterior", estudiante.getPromedioAnterior());
                                        request.setAttribute("estudiante_promedio_general", estudiante.getPromedioGeneral());
                                    }
                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/informacion_escolar.jsp");
                                    break;
                                case "informacion_domiciliaria":
                                    //Si no existen registros de estados, municipios y localidades en la base de datos, se recurre a los datos 
                                    //Dentro de la apliacion
                                    dir = processDireccion(idUser, dir);
                                    if (dir != null) {
                                        request.setAttribute("direccion_id_direccion", dir.getIdDireccion());
                                        request.setAttribute("direccion_codigo_postal", dir.getCodigoPostal());
                                        request.setAttribute("direccion_id_estado", dir.getIdEstado());
                                        request.setAttribute("direccion_id_municipio", dir.getIdMunicipio());
                                        request.setAttribute("direccion_id_localidad", dir.getIdLocalidad());
                                        request.setAttribute("direccion_calle_interior", dir.getCalleInteriorYNumero());
                                        request.setAttribute("direccion_calle_exterior", dir.getCalleExteriorYNumero());
                                        request.setAttribute("direccion_calle_frontal", dir.getCalleFrontal());
                                        request.setAttribute("direccion_calle_trasera", dir.getCalleTrasera());
                                        request.setAttribute("direccion_calle_izquierda", dir.getCalleIzquierda());
                                        request.setAttribute("direccion_calle_derecha", dir.getCalleDerecha());
                                        request.setAttribute("direccion_nombre_asentamiento", dir.getNombreAsentamiento());
                                        request.setAttribute("direccion_tipo_asentamiento", dir.getTipoAsentamiento());
                                        request.setAttribute("direccion_referencias", dir.getReferencias());
                                    }
                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/informacion_domiciliaria.jsp");
                                    break;
                                case "mi_mochila":
                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/mi_mochila.jsp");
                                    break;
                                case "deseos":
                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/lista_deseos.jsp");
                                    break;
                                case "solicitudes":
                                    processSolicitudes(idUser, lstSolicitudes);
                                    request.setAttribute("lstSolicitudes", lstSolicitudes);
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
                                    IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
                                    if (conexionDB.conectar() == 1) {
                                        Usuario user = (Usuario) session.getAttribute("user");
                                        manipula.ManipulaAutenticacion.cerrarSesionUsuario(conexionDB, user);
                                        conexionDB.desconectar();
                                        session.invalidate();
                                        response.sendRedirect("home.do");
                                    } else {
                                        session.invalidate();
                                        response.sendRedirect("home.do");
                                    }
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
        String formulario = request.getParameter("form");
        RequestDispatcher dispatcher;
        if (formulario != null) {
            switch (formulario) {
                case "FORMULARIO-INFORMACION_PERSONAL":

                    break;
                case "FORMULARIO-INFORMACION_ESCOLAR":
                    break;
                case "FORMULARIO-INFORMACION_DOMICILIARIA":
                    break;
                case "FORMULARIO-PERFIL":
                    break;
                case "FORMULARIO-CAMBIAR-CONTRASENIA":
                  
                    
                    break;
                case "FORMULARIO-SOLICITAR":
                    break;
                case "FORMULARIO-GUARDAR":
                    break;
                default:
                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/home.jsp");
                    dispatcher.forward(request, response);
                    break;
            }
        } else {
            dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/home.jsp");
            dispatcher.forward(request, response);
        }

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

    private List<Noticia> processHome(List<Noticia> lstNoticias) {
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (conexionDB.getConexion() != null) {
                ManipulaNoticia mNoticia = new ManipulaNoticia();
                lstNoticias = mNoticia.getData(conexionDB);
                conexionDB.desconectar();
            }
        }
        return lstNoticias;
    }

    private void infoPrincipal(int idUser, List<Donacion> lstDonaciones, List<Deseo> lstDeseos, List<Notificacion> lstNotificaciones, Estudiante estudiante) {
        ManipulaUsuario mUsuario = new ManipulaUsuario();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (conexionDB.getConexion() != null) {
                lstDonaciones = mUsuario.getDonacionRecibidas(conexionDB, idUser);
            }
            if (conexionDB.getConexion() != null) {
                estudiante = mUsuario.getEstudiante(conexionDB, idUser);
            }
            if (conexionDB.getConexion() != null) {
                lstNotificaciones = mUsuario.getNotificacion(conexionDB, idUser);
            }
            if (conexionDB.getConexion() != null) {
                if (estudiante != null) {
                    ManipulaEstudiante mEstudiante = new ManipulaEstudiante();
                    lstDeseos = mEstudiante.getListaDeseos(conexionDB, idUser);
                }
            }
            if (conexionDB.getConexion() != null) {
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }

    }

    private List<Categoria> processCatalogo(List<Categoria> lstCategorias) {
        ManipulaCategoria mCategoria = new ManipulaCategoria();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (conexionDB.getConexion() != null) {
                lstCategorias = mCategoria.getData(conexionDB);
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return lstCategorias;
    }

    private List<RecursoTecnologico> processCategoria(int idCategoria, List<RecursoTecnologico> lstRecursoTecnologicos) {
        ManipulaCategoria mCategoria = new ManipulaCategoria();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (conexionDB.getConexion() != null) {
                lstRecursoTecnologicos = mCategoria.getLstRecursosTecnologicos(conexionDB, idCategoria);
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return lstRecursoTecnologicos;
    }

    private RecursoTecnologico processRecursoCategoria(int idRecursoTecnologico, RecursoTecnologico recursoTecnologico) {
        ManipulaRecursoTecnologico mRecursoTecnologico = new ManipulaRecursoTecnologico();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (conexionDB.getConexion() != null) {
                recursoTecnologico = mRecursoTecnologico.encontrarId(conexionDB, idRecursoTecnologico);
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return recursoTecnologico;
    }

    private EquipoComputacional processRecursoEquipoComputo(int idRecursoTecnologico, EquipoComputacional eqComputo) {
        ManipulaEquipoComputacional mEquipoComputacional = new ManipulaEquipoComputacional();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (conexionDB.getConexion() != null) {
                eqComputo = mEquipoComputacional.encontrarIdRecurso(conexionDB, idRecursoTecnologico);

                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return eqComputo;
    }

    private List<EquipoComputacional> processEquiposDonados(List<EquipoComputacional> lstEquiposComputacionalesDonados) {
        ManipulaEquipoComputacional mEquipoComputacional = new ManipulaEquipoComputacional();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (conexionDB.getConexion() != null) {
                lstEquiposComputacionalesDonados = mEquipoComputacional.getEquiposComputacionalesDonados(conexionDB);
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return lstEquiposComputacionalesDonados;
    }

    private List<EquipoComputacional> processEquiposRemunerados(List<EquipoComputacional> lstEquiposComputacionalesRemunerados) {
        ManipulaEquipoComputacional mEquipoComputacional = new ManipulaEquipoComputacional();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (conexionDB.getConexion() != null) {
                lstEquiposComputacionalesRemunerados = mEquipoComputacional.getEquiposComputacionalesRemunerados(conexionDB);
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return lstEquiposComputacionalesRemunerados;
    }

    private Direccion processDireccion(int idUser, Direccion dir) {
        ManipulaUsuario mUsuario = new ManipulaUsuario();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (conexionDB.getConexion() != null) {
                dir = mUsuario.getDireccion(conexionDB, idUser);
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return dir;
    }

    private List<Solicitud> processSolicitudes(int idUser, List<Solicitud> lstSolicitudes) {
        ManipulaUsuario mUsuario = new ManipulaUsuario();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (conexionDB.getConexion() != null) {
                lstSolicitudes = mUsuario.getSolicitudesEnviadas(conexionDB, idUser);
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return lstSolicitudes;
    }

}
