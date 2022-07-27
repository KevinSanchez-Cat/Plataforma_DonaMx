/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.inicio;

import config.conexion.ConexionFactory;
import config.conexion.IConexion;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import manipula.ManipulaAutenticacion;
import manipula.ManipulaRol;
import model.Rol;
import model.Usuario;
import utils.GenericResponse;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Srv_inicio_sesion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/iniciar_session.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //  if (session != null) {
//            if (request.isRequestedSessionIdValid()) {
//                if (request.isRequestedSessionIdFromCookie()) {
//                    //Se obtubo de una cokkie, y se mantiene la session en la cokkie
//                }
//                //cualquier otra tarea que requiera de una sesion valida
//            } else {
//                //registra un error de session
//            }
        //}
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password_cifrado = utils.Hash.sha1(password);
        String cadena_ingresada = request.getParameter("captcha");
        HttpSession session_nueva = request.getSession(false);
        String key = (String) session_nueva.getAttribute("key");

        if (cadena_ingresada == null) {
            request.setAttribute("respuesta", "Tienes que ingresar el código ");
            redirectView(request, response, "/iniciarSesion.jsp");
        } else {
            if (key.equals(cadena_ingresada)) {
                IConexion conexionDB = ConexionFactory.getConexion("MYSQL");

                if (conexionDB.conectar() == 1) {
                    GenericResponse<Usuario> respuesta = ManipulaAutenticacion.iniciarSesionUsuario(conexionDB, username, password_cifrado);
                    if (respuesta.getResponseObject() != null) {
                        Usuario usuario = respuesta.getResponseObject();
                        if (usuario == null) {
                            System.out.println("Nulo?");
                        }else{
                         
                        }
                        HttpSession session = request.getSession();
                        String username2= usuario.getNombre() + " " + usuario.getApellido();
                        session.setAttribute("username",username2);
                        session.setAttribute("user", usuario);
                        session.setAttribute("idUser", usuario.getIdUsuario());
                        ManipulaRol mRol = new ManipulaRol();
                        Rol rol = mRol.encontrarId(conexionDB, usuario.getIdRol());

                        session.setAttribute("rol", rol.getRol());
                        session.setAttribute("saludo", "Hola" + usuario.getNombre());

                        switch (rol.getRol()) {
                            case "DONADOR": {
                                redirectServlet(request, response, "donador");
                                //response.sendRedirect("donador");
                            }
                            break;
                            case "DONATARIO": {
                                redirectServlet(request, response, "estudiante");
                                //response.sendRedirect("estudiante");
                            }
                            break;
                            case "VOLUNTARIO": {
                                redirectServlet(request, response, "voluntario");
                                //response.sendRedirect("voluntario");
                            }
                            break;
                            case "ADMINISTRADOR": {
                                redirectServlet(request, response, "administrador");
                                //response.sendRedirect("administrador");
                            }
                            break;
                            case "PENDIENTE": {
                                redirectServlet(request, response, "Srv_registro?ser=PENDIENTE");

                            }
                            break;
                        }
                        conexionDB.desconectar();
                    } else {
                        conexionDB.desconectar();
                        //no se pudo conectar
                        request.setAttribute("respuesta", "Datos incorrectos, intentelo de nuevo");
                        redirectView(request, response, "/iniciarSesion.jsp");
                    }
                } else {
                    request.setAttribute("respuesta", "Plataforma no disponible, intentelo más tarde");
                    redirectView(request, response, "/iniciarSesion.jsp");
                }
            } else {
                request.setAttribute("respuesta", "El código es incorrecto, ingresalo nuevamente ");
                redirectView(request, response, "/iniciarSesion.jsp");
            }
        }

    }

    private void redirectView(HttpServletRequest req, HttpServletResponse resp, String pathView)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pathView);
        dispatcher.forward(req, resp);
    }

    private void redirectServlet(HttpServletRequest req, HttpServletResponse resp, String servlet)
            throws ServletException, IOException {

        req.getRequestDispatcher(servlet)
                .forward(req, resp);
    }

}
