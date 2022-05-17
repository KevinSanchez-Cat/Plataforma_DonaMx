/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo.voluntario;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import manipula.ManipulaUsuario;
import model.Direccion;
import model.Donacion;
import model.Intencion;
import model.Notificacion;
import model.Organizacion;
import model.Solicitud;
import model.Usuario;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Modulo_Voluntario extends HttpServlet {

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
                    if (rol.equals("VOLUNTARIO")) {

                        ManipulaUsuario mUsuario = new ManipulaUsuario();
                        int idUser = (int) session.getAttribute("idUser");
                        List<Notificacion> lstNotificaciones = mUsuario.getNotificacion(idUser);

                        if (lstNotificaciones == null) {
                            lstNotificaciones = new ArrayList<>();
                        }
                        request.setAttribute("lstNotificaciones", lstNotificaciones);

                        if (page == null) {
                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_voluntario/home.jsp");
                            dispatcher.forward(request, response);
                        } else {
                            switch (page) {
                                case "organizacion": {
                                    String accion = request.getParameter("accion");
                                    if (accion == null) {
                                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_voluntario/home.jsp");
                                        dispatcher.forward(request, response);
                                    } else {
                                        switch (accion) {
                                            case "consultar": {
                                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_voluntario/organizacion_consultar.jsp");
                                                dispatcher.forward(request, response);
                                            }
                                            break;
                                            case "registrar": {
                                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_voluntario/organizacion_registrar.jsp");
                                                dispatcher.forward(request, response);
                                            }
                                            break;
                                            case "editar": {
                                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_voluntario/organizacion_editar.jsp");
                                                dispatcher.forward(request, response);
                                            }
                                            break;
                                            case "eliminar": {
                                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_voluntario/organizacion_eliminar.jsp");
                                                dispatcher.forward(request, response);
                                            }
                                            break;
                                            default: {
                                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_voluntario/home.jsp");
                                                dispatcher.forward(request, response);
                                            }
                                            break;
                                        }
                                    }
                                }
                                break;
                                case "paqueteria": {
                                    String accion = request.getParameter("accion");
                                    if (accion == null) {
                                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_voluntario/home.jsp");
                                        dispatcher.forward(request, response);
                                    } else {
                                        switch (accion) {
                                            case "recoger": {
                                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_voluntario/paqueteria_recoger.jsp");
                                                dispatcher.forward(request, response);
                                            }
                                            break;
                                            case "trasladar": {
                                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_voluntario/paqueteria_trasladar.jsp");
                                                dispatcher.forward(request, response);
                                            }
                                            break;
                                            case "enviar": {
                                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_voluntario/paqueteria_enviar.jsp");
                                                dispatcher.forward(request, response);
                                            }
                                            break;
                                            case "directo": {
                                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_voluntario/paqueteria_directo.jsp");
                                                dispatcher.forward(request, response);
                                            }
                                            break;
                                            case "buscar_serial": {
                                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_voluntario/paqueteria_buscar_serial.jsp");
                                                dispatcher.forward(request, response);
                                            }
                                            break;
                                            case "consultar": {
                                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_voluntario/paqueteria_consultar.jsp");
                                                dispatcher.forward(request, response);
                                            }
                                            break;
                                            default: {
                                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_voluntario/home.jsp");
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
                                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_voluntario/home.jsp");
                                        dispatcher.forward(request, response);
                                    } else {
                                        switch (accion) {
                                            case "donacion_economica": {
                                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_voluntario/donaciones_donacion_economica.jsp");
                                                dispatcher.forward(request, response);
                                            }
                                            break;
                                            case "consultar": {
                                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_voluntario/donaciones_consultar.jsp");
                                                dispatcher.forward(request, response);
                                            }
                                            break;
                                            default: {
                                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_voluntario/home.jsp");
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
                                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_voluntario/home.jsp");
                                        dispatcher.forward(request, response);
                                    } else {
                                        switch (accion) {
                                            case "crear": {
                                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_voluntario/peticiones_crear.jsp");
                                                dispatcher.forward(request, response);
                                            }
                                            break;
                                            case "consultar": {
                                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_voluntario/peticiones_consultar.jsp");
                                                dispatcher.forward(request, response);
                                            }
                                            break;
                                            default: {
                                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_voluntario/home.jsp");
                                                dispatcher.forward(request, response);
                                            }
                                            break;
                                        }
                                    }
                                }
                                break;
                                case "categorias": {
                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_voluntario/categorias.jsp");
                                    dispatcher.forward(request, response);
                                }
                                break;
                                case "estadisticas": {
                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_voluntario/estadisticas.jsp");
                                    dispatcher.forward(request, response);
                                }
                                break;
                                case "contacto": {
                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_voluntario/contacto.jsp");
                                    dispatcher.forward(request, response);
                                }
                                break;
                                case "perfil": {
                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_voluntario/perfil.jsp");
                                    dispatcher.forward(request, response);
                                }
                                break;
                                case "notificaciones": {
                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_voluntario/notificaciones.jsp");
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
                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_voluntario/home.jsp");
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
    }

}
