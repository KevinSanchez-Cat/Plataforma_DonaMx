/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo.administrador;

import config.conexion.ConexionFactory;
import config.conexion.IConexion;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import manipula.*;
import model.*;
import utils.Logg;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Modulo_Administrador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String page = request.getParameter("page");
        RequestDispatcher dispatcher = null;
        String accion = request.getParameter("accion");
        if (session != null) {
            if (!session.isNew()) {
                String username = (String) session.getAttribute("username");
                //  session.setMaxInactiveInterval(60);//session timeout in seconds 
                if (username != null) {
                    String rol = (String) session.getAttribute("rol");
                    if (rol != null) {
                        if (rol.equals("ADMINISTRADOR")) {
                            ManipulaUsuario mUsuario = new ManipulaUsuario();
                            int idUser = (int) session.getAttribute("idUser");
                            List<Notificacion> lstNotificaciones = new ArrayList<>();
                            infoPrincipal(idUser, lstNotificaciones);

                            request.setAttribute("lstNotificaciones", lstNotificaciones);
                            if (page == null) {
                                dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                            } else {
                                switch (page) {
                                    case "roles": {
                                        if (accion == null) {
                                            dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                        } else {
                                            switch (accion) {
                                                case "agregar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/roles_agregar.jsp");
                                                    break;
                                                case "buscar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/roles_buscar.jsp");
                                                    break;
                                                case "consultar":
                                                    List<Rol> lstRoles = null;
                                                    lstRoles = processRoles(lstRoles);
                                                    request.setAttribute("lstRoles", lstRoles);

                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/roles_consultar.jsp");
                                                    break;
                                                default:
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                                    break;
                                            }
                                        }
                                    }
                                    break;
                                    case "donadores": {
                                        if (accion == null) {
                                            dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                        } else {
                                            switch (accion) {
                                                case "registrar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/donadores_registrar.jsp");
                                                    break;
                                                case "buscar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/donadores_buscar.jsp");
                                                    break;
                                                case "autorizacion":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/donadores_autorizar.jsp");
                                                    break;
                                                case "bloquear_desbloquear":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/donadores_bloquear_desbloquear.jsp");
                                                    break;
                                                case "consultar":
                                                    List<Usuario> lstDonadores = null;
                                                    lstDonadores = processDonadores(lstDonadores);
                                                    request.setAttribute("lstDonadores", lstDonadores);

                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/donadores_consultar.jsp");
                                                    break;
                                                case "lista_negra":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/donadores_consultar_lista_negra.jsp");
                                                    break;
                                                default:
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                                    break;
                                            }
                                        }
                                    }
                                    break;
                                    case "voluntarios":
                                        if (accion == null) {
                                            dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                        } else {
                                            switch (accion) {
                                                case "registrar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/voluntarios_registrar.jsp");
                                                    break;
                                                case "buscar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/voluntarios_buscar.jsp");
                                                    break;
                                                case "bloquear_desbloquear":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/voluntarios_bloquear_desbloquear.jsp");
                                                    break;
                                                case "consultar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/voluntarios_consultar.jsp");
                                                    break;
                                                case "lista_negra":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/voluntarios_consultar_lista_negra.jsp");
                                                    break;
                                                default:
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                                    break;
                                            }
                                        }

                                        break;
                                    case "donatarios":
                                        if (accion == null) {
                                            dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                        } else {
                                            switch (accion) {
                                                case "registrar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/donatarios_registrar.jsp");
                                                    break;
                                                case "buscar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/donatarios_buscar.jsp");

                                                    break;
                                                case "bloquear_desbloquear":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/donatarios_bloquear_desbloquear.jsp");
                                                    break;
                                                case "lista_negra":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/donatarios_consultar_lista_negra.jsp");
                                                    break;
                                                case "consultar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/donatarios_consultar.jsp");
                                                    break;
                                                default:
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                                    break;
                                            }
                                        }
                                        break;
                                    case "estados":
                                        if (accion == null) {
                                            dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                        } else {
                                            switch (accion) {
                                                case "agregar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/estados_agregar.jsp");
                                                    break;
                                                case "buscar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/estados_buscar.jsp");
                                                    break;
                                                case "consultar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/estados_consultar.jsp");
                                                    break;
                                                default:
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                                    break;
                                            }
                                        }
                                        break;
                                    case "municipios":
                                        if (accion == null) {
                                            dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                        } else {
                                            switch (accion) {
                                                case "agregar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/municipios_agregar.jsp");
                                                    break;
                                                case "buscar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/municipios_buscar.jsp");
                                                    break;
                                                case "consultar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/municipios_consultar.jsp");
                                                    break;
                                                default:
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                                    break;
                                            }
                                        }
                                        break;
                                    case "localidades":
                                        if (accion == null) {
                                            dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                        } else {
                                            switch (accion) {
                                                case "agregar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/localidades_agregar.jsp");
                                                    break;
                                                case "buscar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/localidades_buscar.jsp");
                                                    break;
                                                case "consultar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/localidades_consultar.jsp");
                                                    break;
                                                default:
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                                    break;
                                            }
                                        }
                                        break;
                                    case "categorias":
                                        if (accion == null) {
                                            dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                        } else {
                                            switch (accion) {
                                                case "agregar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/categorias_agregar.jsp");
                                                    break;
                                                case "buscar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/categorias_buscar.jsp");
                                                    break;
                                                case "consultar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/categorias_consultar.jsp");
                                                    break;
                                                default:
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                                    break;
                                            }
                                        }
                                        break;
                                    case "sistemas_operativos":
                                        if (accion == null) {
                                            dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                        } else {
                                            switch (accion) {
                                                case "agregar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/sistemas_operativos_agregar.jsp");
                                                    break;
                                                case "buscar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/sistemas_operativos_buscar.jsp");

                                                    break;
                                                case "consultar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/sistemas_operativos_consultar.jsp");
                                                    break;
                                                default:
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                                    break;
                                            }
                                        }
                                        break;
                                    case "recursos_tecnologicos":
                                        if (accion == null) {
                                            dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");

                                        } else {
                                            switch (accion) {
                                                case "registrar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/recursos_tecnologicos_registrar.jsp");
                                                    break;
                                                case "buscar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/recursos_tecnologicos_buscar.jsp");
                                                    break;
                                                case "consultar_donador":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/recursos_tecnologicos_consultar_por_donador.jsp");
                                                    break;
                                                case "consultar_categoria":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/recursos_tecnologicos_consultar_por_categoria.jsp");
                                                    break;
                                                case "consultar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/recursos_tecnologicos_consultar.jsp");
                                                    break;
                                                default:
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                                    break;
                                            }
                                        }
                                        break;
                                    case "equipos_computacionales":
                                        if (accion == null) {
                                            dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                        } else {
                                            switch (accion) {
                                                case "registrar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/equipos_computacionales_registrar.jsp");
                                                    break;
                                                case "buscar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/equipos_computacionales_buscar.jsp");
                                                    break;
                                                case "consultar_donados":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/equipos_computacionales_consultar_donados.jsp");
                                                    break;
                                                case "consultar_remunerados":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/equipos_computacionales_consultar_remunerados.jsp");
                                                    break;
                                                default:
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                                    break;
                                            }
                                        }
                                        break;
                                    case "solicitudes":
                                        if (accion == null) {
                                            dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                        } else {
                                            switch (accion) {
                                                case "buscar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/solicitudes_buscar.jsp");
                                                    break;
                                                case "consultar_donador":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/solicitudes_consultar_por_donador.jsp");
                                                    break;
                                                case "consultar_donatario":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/solicitudes_consultar_por_donatario.jsp");
                                                    break;
                                                case "consultar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/solicitudes_consultar.jsp");
                                                    break;
                                                default:
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                                    break;
                                            }
                                        }
                                        break;
                                    case "noticias":
                                        if (accion == null) {
                                            dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                        } else {
                                            switch (accion) {
                                                case "buscar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/noticias_buscar.jsp");
                                                    break;
                                                case "consultar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/noticias_consultar_por_donador.jsp");
                                                    break;
                                                case "crear":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/noticias_crear.jsp");
                                                    break;
                                                default:
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                                    break;
                                            }
                                        }
                                        break;
                                    case "donaciones":
                                        if (accion == null) {
                                            dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                        } else {
                                            switch (accion) {
                                                case "registrar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/donaciones_registrar.jsp");
                                                    break;
                                                case "buscar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/donaciones_buscar.jsp");
                                                    break;
                                                case "consultar_donador":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/donaciones_consultar_por_donador.jsp");
                                                    break;
                                                case "consultar_donatario":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/donaciones_consultar_por_donatario.jsp");
                                                    break;
                                                case "consultar_en_especie":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/donaciones_consultar_por_especie.jsp");
                                                    break;
                                                case "consultar_economicas":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/donaciones_consultar_economicas.jsp");
                                                    break;
                                                case "consultar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/donaciones_consultar.jsp");
                                                    break;
                                                default:
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                                    break;
                                            }
                                        }
                                        break;
                                    case "intenciones":
                                        if (accion == null) {
                                            dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                        } else {
                                            switch (accion) {
                                                case "registrar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/intenciones_registrar.jsp");
                                                    break;
                                                case "buscar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/intenciones_buscar.jsp");
                                                    break;
                                                case "consultar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/intenciones_consultar.jsp");
                                                    break;
                                                default:
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                                    break;
                                            }
                                        }
                                        break;
                                    case "paqueteria":
                                        if (accion == null) {
                                            dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                        } else {
                                            switch (accion) {
                                                case "recoger":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/paqueteria_recoger.jsp");
                                                    break;
                                                case "trasladar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/paqueteria_trasladar.jsp");
                                                    break;
                                                case "enviar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/paqueteria_enviar.jsp");
                                                    break;
                                                case "directo":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/paqueteria_directo.jsp");
                                                    break;
                                                case "buscar_serial":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/paqueteria_buscar_serial.jsp");
                                                    break;
                                                case "consultar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/paqueteria_consultar.jsp");
                                                    break;
                                                default:
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                                    break;
                                            }
                                        }
                                        break;
                                    case "notificaciones":
                                        if (accion == null) {
                                            dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                        } else {
                                            switch (accion) {
                                                case "crear":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/notificaciones_donamx_crear.jsp");
                                                    break;
                                                case "buscar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/notificaciones_donamx_buscar.jsp");
                                                    break;
                                                case "consultar":
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/notificaciones_donamx_consultar.jsp");
                                                    break;
                                                default:
                                                    dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                                    break;
                                            }
                                        }
                                        break;
                                    case "perfil":
                                        dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/perfil.jsp");
                                        break;
                                    case "estadisticas":
                                        dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/estadisticas.jsp");
                                        break;
                                    case "servidor":
                                        dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/servidor.jsp");
                                        break;
                                    case "contacto":
                                        dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/contacto.jsp");
                                        break;
                                    case "mis_notificaciones":
                                        dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/notificaciones.jsp");
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
                                        dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                        break;
                                }
                            }
                        } else {
                            dispatcher = getServletContext().getRequestDispatcher("/views/templates/errores/no_autorizado.jsp");
                        }
                    } else {
                        dispatcher = getServletContext().getRequestDispatcher("/views/templates/errores/no_autorizado.jsp");
                    }
                } else {
                    response.sendRedirect("autenticacion");
                    // dispatcher = getServletContext().getRequestDispatcher("/iniciarSesion.jsp");
                    // dispatcher.forward(request, response);
                }
            } else {
                dispatcher = getServletContext().getRequestDispatcher("/views/templates/errores/session_expired.jsp");
                //Session has expired - redirect to login.jsp
            }
        } else {
            response.sendRedirect("autenticacion");
            // dispatcher = getServletContext().getRequestDispatcher("/iniciarSesion.jsp");
            //dispatcher.forward(request, response);
        }
        if (dispatcher != null) {
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String formulario = request.getParameter("form");
        RequestDispatcher dispatcher;
        String msg = "";
        HttpSession session = request.getSession(false);
        if (formulario != null) {
            switch (formulario) {
                case "FORMULARIO-PERFIL-IMG":
                    String idUsurio = request.getParameter("est-infPerIdUser");
                    int idUser = (int) session.getAttribute("idUser");
                    boolean b = formImgPerfil(idUser, "");
                    if (b) {
                        msg = "Datos actualizados correctamente... ";
                    } else {
                        msg = "Datos no actualizados...";
                    }
                    response.sendRedirect("estudiante?page=inicio");
                    break;

            }
        }
    }

    private void infoPrincipal(int idUser, List<Notificacion> lstNotificaciones) {

        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {

            if (conexionDB.getConexion() != null) {
                try {
                    String sql = "SELECT "
                            + "idNotificacion, "
                            + "idUsuarioDestino, "
                            + "fechaNotificacion, "
                            + "estadoVisualizacion, "
                            + "prioridad, "
                            + "mensaje "
                            + "FROM Notificacion "
                            + "WHERE idUsuarioDestino=?";
                    PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                    ps.setInt(1, idUser);
                    ResultSet rs;
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        lstNotificaciones.add(new Notificacion(rs.getInt(1),
                                rs.getInt(2),
                                rs.getTimestamp(3),
                                rs.getString(4),
                                rs.getString(5),
                                rs.getString(6)));
                    }
                } catch (SQLException ex) {
                    Logg.error("Comunicación fallida con la base de datos " + ex.getMessage());
                }
            } else {

            }

            if (conexionDB.getConexion() != null) {
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }

    }

    private boolean formImgPerfil(int idUsurio, String dato) {
        boolean b = false;
        ManipulaUsuario mUsuario = new ManipulaUsuario();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");

        if (conexionDB.conectar() == 1) {
            if (conexionDB.getConexion() != null) {
                //b = mUsuario.changeImagen(conexionDB, idUsurio, inputStream);
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return b;
    }

    private List<Rol> processRoles(List<Rol> lstRoles) {
        ManipulaRol mRol = new ManipulaRol();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (conexionDB.getConexion() != null) {
                lstRoles = mRol.getData(conexionDB);
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return lstRoles;
    }

    private List<Usuario> processDonadores(List<Usuario> lstDonadores) {
        ManipulaUsuario mUsuario = new ManipulaUsuario();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (conexionDB.getConexion() != null) {
                lstDonadores = mUsuario.getDonadores(conexionDB);
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return lstDonadores;
    }

    private List<Usuario> processVoluntarios(List<Usuario> lstVoluntarios) {
        ManipulaUsuario mUsuario = new ManipulaUsuario();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (conexionDB.getConexion() != null) {
                lstVoluntarios = mUsuario.getDonadores(conexionDB);
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return lstVoluntarios;
    }

    private List<Usuario> processDonadoresListaNegra(List<Usuario> lstDonadores) {
        ManipulaUsuario mUsuario = new ManipulaUsuario();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (conexionDB.getConexion() != null) {
                lstDonadores = mUsuario.getDonadoresListaNegra(conexionDB);
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return lstDonadores;
    }

    private List<Usuario> processVoluntariosListaNegra(List<Usuario> lstVoluntarios) {
        ManipulaUsuario mUsuario = new ManipulaUsuario();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (conexionDB.getConexion() != null) {
                lstVoluntarios = mUsuario.getDonadoresListaNegra(conexionDB);
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return lstVoluntarios;
    }

    private List<Estado> processEstados(List<Estado> lstEstados) {
        ManipulaEstado mEstado = new ManipulaEstado();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (conexionDB.getConexion() != null) {
                lstEstados = mEstado.getData(conexionDB);
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return lstEstados;
    }

    private List<Municipio> processMunicipios(List<Municipio> lstMunicipios) {
        ManipulaMunicipio mMunicipio = new ManipulaMunicipio();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (conexionDB.getConexion() != null) {
                lstMunicipios = mMunicipio.getData(conexionDB);
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return lstMunicipios;
    }

    private List<Localidad> processLocalidades(List<Localidad> lstLocalidades) {
        ManipulaLocalidad mLocalidad = new ManipulaLocalidad();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (conexionDB.getConexion() != null) {
                lstLocalidades = mLocalidad.getData(conexionDB);
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return lstLocalidades;
    }

    private List<Categoria> processCategorias(List<Categoria> lstCategorias) {
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

    private List<SistemaOperativo> processSistemasOperativos(List<SistemaOperativo> lstSistemasOperativos) {
        ManipulaSistemaOperativo mSistemaOperativo = new ManipulaSistemaOperativo();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (conexionDB.getConexion() != null) {
                lstSistemasOperativos = mSistemaOperativo.getData(conexionDB);
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return lstSistemasOperativos;
    }

    private List<RecursoTecnologico> processRecursosTecnologicosDonador(List<RecursoTecnologico> lstRecursosTecnologicos) {
        ManipulaRecursoTecnologico mRecursoTecnologico = new ManipulaRecursoTecnologico();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (conexionDB.getConexion() != null) {
                lstRecursosTecnologicos = mRecursoTecnologico.getData(conexionDB);
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return lstRecursosTecnologicos;
    }

    private List<RecursoTecnologico> processRecursosTecnologicosCategoria(List<RecursoTecnologico> lstRecursosTecnologicos) {
        ManipulaRecursoTecnologico mRecursoTecnologico = new ManipulaRecursoTecnologico();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (conexionDB.getConexion() != null) {
                lstRecursosTecnologicos = mRecursoTecnologico.getData(conexionDB);
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return lstRecursosTecnologicos;
    }

    private List<RecursoTecnologico> processRecursosTecnologicos(List<RecursoTecnologico> lstRecursosTecnologicos) {
        ManipulaRecursoTecnologico mRecursoTecnologico = new ManipulaRecursoTecnologico();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (conexionDB.getConexion() != null) {
                lstRecursosTecnologicos = mRecursoTecnologico.getData(conexionDB);
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return lstRecursosTecnologicos;
    }

    private List<EquipoComputacional> processEquiposComputacionalesDonados(List<EquipoComputacional> lstEquipoComputacionales) {
        ManipulaEquipoComputacional mEquipoComputacional = new ManipulaEquipoComputacional();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (conexionDB.getConexion() != null) {
                lstEquipoComputacionales = mEquipoComputacional.getData(conexionDB);
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return lstEquipoComputacionales;
    }

    private List<EquipoComputacional> processEquiposComputacionalesRemunerados(List<EquipoComputacional> lstEquipoComputacionales) {
        ManipulaEquipoComputacional mEquipoComputacional = new ManipulaEquipoComputacional();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (conexionDB.getConexion() != null) {
                lstEquipoComputacionales = mEquipoComputacional.getData(conexionDB);
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return lstEquipoComputacionales;
    }
    private List<Solicitud> processSolicitudesDonador(List<Solicitud> lstSolicitud) {
        ManipulaSolicitud mSolicitud = new ManipulaSolicitud();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (conexionDB.getConexion() != null) {
                lstSolicitud = mSolicitud.getData(conexionDB);
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return lstSolicitud;
    }
    private List<Solicitud> processSolicitudesDonatario(List<Solicitud> lstSolicitud) {
        ManipulaSolicitud mSolicitud = new ManipulaSolicitud();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (conexionDB.getConexion() != null) {
                lstSolicitud = mSolicitud.getData(conexionDB);
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return lstSolicitud;
    }
     private List<Donacion> processDonacionesDonatario(List<Donacion> lstDonacion) {
        ManipulaDonacion mDonacion = new ManipulaDonacion();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (conexionDB.getConexion() != null) {
                lstDonacion = mDonacion.getData(conexionDB);
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return lstDonacion;
    }
}
