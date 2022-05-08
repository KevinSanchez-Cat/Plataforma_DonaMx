/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo.estudiante;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import manipula.ManipulaEstudiante;
import manipula.ManipulaUsuario;
import model.Deseo;
import model.Direccion;
import model.Donacion;
import model.Estudiante;
import model.Notificacion;
import model.Solicitud;
import model.Usuario;
import org.apache.jasper.tagplugins.jstl.core.ForEach;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Modulo_Estudiante extends HttpServlet {

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
                    if (rol.equals("DONATARIO")) {

                        ManipulaUsuario mUsuario = new ManipulaUsuario();
                        int idUser = (int) session.getAttribute("idUser");
                        System.out.println(idUser + " modulo");
                        List<Deseo> lstDeseos = new ArrayList<>();

                        Direccion direccion = mUsuario.getDireccion(idUser);
                        List<Donacion> lstDonaciones = mUsuario.getDonacionRecibidas(idUser);
                        Estudiante estudiante = mUsuario.getEstudiante(idUser);
                        List<Notificacion> lstNotificaciones = mUsuario.getNotificacion(idUser);
                        List<Solicitud> lstSolicitudes = mUsuario.getSolicitudes(idUser);

                        if (estudiante != null) {
                            ManipulaEstudiante mEstudiante = new ManipulaEstudiante();
                            lstDeseos = mEstudiante.getListaDeseos(estudiante.getIdEstudiante());
                        }
                        if (lstDeseos == null) {
                            lstDeseos = new ArrayList<>();
                        } else {
                            lstDeseos.forEach(System.out::println);
                        }
                        if (lstDonaciones == null) {
                            lstDonaciones = new ArrayList<>();
                        } else {
                            lstDonaciones.forEach(System.out::println);
                        }
                        if (lstNotificaciones == null) {
                            lstNotificaciones = new ArrayList<>();
                        } else {
                            lstNotificaciones.forEach(System.out::println);
                        }

                        // session.setAttribute("direccion", direccion);
                        // session.setAttribute("lstDeseos", lstDeseos);
                        // session.setAttribute("lstDonaciones", lstDonaciones);
                        // session.setAttribute("lstSolicitudes", lstSolicitudes);
                        // session.setAttribute("lstNotificaciones", lstNotificaciones);
                        // session.setAttribute("estudiante", estudiante);
                        request.setAttribute("direccion", direccion);
                        request.setAttribute("lstDeseos", lstDeseos);
                        request.setAttribute("lstDonaciones", lstDonaciones);
                        request.setAttribute("lstSolicitudes", lstSolicitudes);
                        request.setAttribute("lstNotificaciones", lstNotificaciones);
                        request.setAttribute("estudiante", estudiante);

                        if (page == null) {
                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/home.jsp");
                            dispatcher.forward(request, response);
                        } else {
                            switch (page) {
                                case "catalogo": {
                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/categorias.jsp");
                                    dispatcher.forward(request, response);

                                }
                                break;
                                case "equipos_remunerados": {
                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/equipos_remunerados.jsp");
                                    dispatcher.forward(request, response);

                                }
                                break;
                                case "equipos_donados": {
                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/equipos_donados.jsp");
                                    dispatcher.forward(request, response);
                                    break;
                                }
                                case "informacion_personal": {
                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/informacion_personal.jsp");
                                    dispatcher.forward(request, response);

                                }
                                break;
                                case "informacion_escolar": {
                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/informacion_escolar.jsp");
                                    dispatcher.forward(request, response);
                                    break;
                                }
                                case "informacion_domiciliaria": {
                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/informacion_domiciliaria.jsp");
                                    dispatcher.forward(request, response);

                                }
                                break;
                                case "mi_mochila": {
                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/mi_mochila.jsp");
                                    dispatcher.forward(request, response);

                                }
                                break;
                                case "deseos": {
                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/lista_deseos.jsp");
                                    dispatcher.forward(request, response);

                                }
                                break;
                                case "solicitudes": {
                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/solicitudes.jsp");
                                    dispatcher.forward(request, response);

                                }
                                break;
                                case "perfil": {
                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/perfil.jsp");
                                    dispatcher.forward(request, response);
                                    break;
                                }
                                case "notificaciones": {
                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/notificaciones.jsp");
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

                                default:
                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/home.jsp");
                                    dispatcher.forward(request, response);
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
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/home.jsp");
        dispatcher.forward(request, response);
    }
}
