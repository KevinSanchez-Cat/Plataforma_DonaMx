/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo.donador;

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
                        System.out.println(idUser + " modulo");
                        List<Intencion> lstIntenciones = mUsuario.getIntenciones(idUser);

                        Direccion direccion = mUsuario.getDireccion(idUser);
                        List<Donacion> lstDonaciones = mUsuario.getDonacionRecibidas(idUser);
                        Organizacion organizacion = mUsuario.getOrganizacion(idUser);
                        List<Notificacion> lstNotificaciones = mUsuario.getNotificacion(idUser);
                        List<Solicitud> lstSolicitudes = mUsuario.getSolicitudes(idUser);

                        if (organizacion != null) {

                        }
                        if (lstIntenciones == null) {
                            lstIntenciones = new ArrayList<>();
                        } else {
                            lstIntenciones.forEach(System.out::println);
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
                        request.setAttribute("direccion", direccion);
                        request.setAttribute("lstDeseos", lstIntenciones);
                        request.setAttribute("lstDonaciones", lstDonaciones);
                        request.setAttribute("lstSolicitudes", lstSolicitudes);
                        request.setAttribute("lstNotificaciones", lstNotificaciones);
                        request.setAttribute("organizacion", organizacion);

                        if (page == null) {
                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_donador/home.jsp");
                            dispatcher.forward(request, response);
                        } else {
                            switch (page) {
                                case "perfil": {
                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_donador/perfil.jsp");
                                    dispatcher.forward(request, response);
                                    break;
                                }
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
