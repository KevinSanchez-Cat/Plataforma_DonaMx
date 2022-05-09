/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo.donador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import manipula.ManipulaUsuario;
import model.Notificacion;
import model.Usuario;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Modulo_Donador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String page = request.getParameter("page");
        if (session != null) {
            String username = (String) session.getAttribute("username");

            if (username != null) {
                String rol = (String) session.getAttribute("rol");
                if (rol != null) {
                    if (rol.equals("DONADOR")) {

                        ManipulaUsuario mUsuario = new ManipulaUsuario();
                        int idUser = (int) session.getAttribute("idUser");
                        List<Notificacion> lstNotificaciones = mUsuario.getNotificacion(idUser);

                        if (lstNotificaciones == null) {
                            lstNotificaciones = new ArrayList<>();
                        } else {
                        }
                        request.setAttribute("lstNotificaciones", lstNotificaciones);

                        if (page == null) {
                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_donador/home.jsp");
                            dispatcher.forward(request, response);
                        } else {
                            switch (page) {
                                case "organizacion": {
                                    String accion = request.getParameter("accion");
                                    if (accion == null) {
                                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_donador/home.jsp");
                                        dispatcher.forward(request, response);
                                    } else {
                                        switch (accion) {
                                            case "consultar": {
                                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_donador/organizacion_consultar.jsp");
                                                dispatcher.forward(request, response);
                                            }
                                            break;
                                            case "registrar": {
                                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_donador/organizacion_registrar.jsp");
                                                dispatcher.forward(request, response);
                                            }
                                            break;
                                            case "editar": {
                                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_donador/organizacion_editar.jsp");
                                                dispatcher.forward(request, response);
                                            }
                                            break;
                                            case "eliminar": {
                                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_donador/organizacion_eliminar.jsp");
                                                dispatcher.forward(request, response);
                                            }
                                            break;
                                            default: {
                                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_donador/home.jsp");
                                                dispatcher.forward(request, response);
                                            }
                                            break;
                                        }
                                    }

                                }
                                break;
                                case "recursos_tecnologicos": {
                                    String accion = request.getParameter("accion");
                                    if (accion == null) {
                                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_donador/home.jsp");
                                        dispatcher.forward(request, response);
                                    } else {
                                        switch (accion) {
                                            case "registrar": {
                                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_donador/recursos_tecnologicos_registrar.jsp");
                                                dispatcher.forward(request, response);
                                            }
                                            break;
                                            case "buscar": {
                                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_donador/recursos_tecnologicos_buscar.jsp");
                                                dispatcher.forward(request, response);
                                            }
                                            break;
                                            case "consultar": {
                                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_donador/recursos_tecnologicos_consultar.jsp");
                                                dispatcher.forward(request, response);
                                            }
                                            break;
                                            default: {
                                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_donador/home.jsp");
                                                dispatcher.forward(request, response);
                                            }
                                            break;
                                        }
                                    }
                                }
                                break;
                                case "equipos_computacionales": {
                                    String accion = request.getParameter("accion");
                                    if (accion == null) {
                                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_donador/home.jsp");
                                        dispatcher.forward(request, response);
                                    } else {
                                        switch (accion) {
                                            case "agregar": {
                                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_donador/equipos_computacionales_agregar.jsp");
                                                dispatcher.forward(request, response);
                                            }
                                            break;
                                            case "buscar": {
                                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_donador/equipos_computacionales_buscar.jsp");
                                                dispatcher.forward(request, response);
                                            }
                                            break;
                                            case "consultar": {
                                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_donador/equipos_computacionales_consultar.jsp");
                                                dispatcher.forward(request, response);
                                            }
                                            break;
                                            default: {
                                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_donador/home.jsp");
                                                dispatcher.forward(request, response);
                                            }
                                            break;
                                        }
                                    }
                                }
                                break;
                                case "solicitudes": {
                                    String accion = request.getParameter("accion");
                                    if (accion == null) {
                                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_donador/home.jsp");
                                        dispatcher.forward(request, response);
                                    } else {
                                        switch (accion) {
                                            case "buscar": {
                                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_donador/solicitudes_buscar.jsp");
                                                dispatcher.forward(request, response);
                                            }
                                            break;
                                            case "consultar": {
                                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_donador/solicitudes_consultar.jsp");
                                                dispatcher.forward(request, response);
                                            }
                                            break;

                                            default: {
                                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_donador/home.jsp");
                                                dispatcher.forward(request, response);
                                            }
                                            break;
                                        }
                                    }
                                }
                                break;
                                case "donaciones": {
                                    String accion = request.getParameter("accion");
                                    if (accion == null) {
                                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_donador/home.jsp");
                                        dispatcher.forward(request, response);
                                    } else {
                                        switch (accion) {
                                            case "buscar": {
                                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_donador/donaciones_buscar.jsp");
                                                dispatcher.forward(request, response);
                                            }
                                            break;
                                            case "consultar": {
                                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_donador/donaciones_consultar.jsp");
                                                dispatcher.forward(request, response);
                                            }
                                            break;
                                            default: {
                                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_donador/home.jsp");
                                                dispatcher.forward(request, response);
                                            }
                                            break;
                                        }
                                    }
                                }
                                break;
                                case "peticion": {
                                    String accion = request.getParameter("accion");
                                    if (accion == null) {
                                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_donador/home.jsp");
                                        dispatcher.forward(request, response);
                                    } else {
                                        switch (accion) {
                                            case "crear": {
                                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_donador/peticiones_crear.jsp");
                                                dispatcher.forward(request, response);
                                            }
                                            break;
                                            case "consultar": {
                                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_donador/peticiones_consultar.jsp");
                                                dispatcher.forward(request, response);
                                            }
                                            break;
                                            default: {
                                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_donador/home.jsp");
                                                dispatcher.forward(request, response);
                                            }
                                            break;
                                        }
                                    }
                                }
                                break;
                                case "categorias": {
                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_donador/categorias.jsp");
                                    dispatcher.forward(request, response);
                                }
                                break;
                                case "estadisticas": {
                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_donador/estadisticas.jsp");
                                    dispatcher.forward(request, response);
                                }
                                break;
                                case "perfil": {
                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_donador/perfil.jsp");
                                    dispatcher.forward(request, response);
                                }
                                break;
                                case "contacto": {
                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_donador/contacto.jsp");
                                    dispatcher.forward(request, response);
                                }
                                break;
                                case "notificaciones": {
                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_donador/notificaciones.jsp");
                                    dispatcher.forward(request, response);
                                }
                                break;
                                case "cerrar_sesion": {
                                    Usuario user = (Usuario) session.getAttribute("user");
                                    manipula.ManipulaAutenticacion.cerrarSesionUsuario(user);
                                    session.invalidate();
                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                                    dispatcher.forward(request, response);
                                }
                                break;
                                default: {
                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_donador/home.jsp");
                                    dispatcher.forward(request, response);
                                }
                                break;
                            }
                        }
                    } else {
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/templates/errores/no_autorizado.jsp");
                        dispatcher.forward(request, response);
                    }
                } else {
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/templates/errores/no_autorizado.jsp");
                    dispatcher.forward(request, response);
                }

            } else {
                response.sendRedirect("autenticacion");
                //RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/iniciarSesion.jsp");
                // dispatcher.forward(request, response);
                // System.out.println("No autenticado");
            }
        } else {
            response.sendRedirect("autenticacion");
            // System.out.println("No autenticado");
            //RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/iniciarSesion.jsp");
            //dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_donador/home.jsp");
        dispatcher.forward(request, response);
    }
}
