/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.inicio;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import manipula.ManipulaAutenticacion;
import model.Usuario;
import utils.GenericResponse;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Srv_registro extends HttpServlet implements HttpSessionBindingListener {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ser = request.getParameter("ser");
        HttpSession session = request.getSession(false);
        request.removeAttribute("ser");
        if (ser != null) {
            switch (ser) {
                case "donador": {
                    /* session.setAttribute("rol", "DONADOR");
                    Usuario user = (Usuario) session.getAttribute("usuario");
                    ManipulaUsuario mUsuario = new ManipulaUsuario();
                    Usuario usuario = mUsuario.encontrarCorreo(user.getCorreoElectronico());
                    ManipulaRol mRol = new ManipulaRol();
                    Rol r = mRol.encontrarRol("DONADOR");
                    usuario.setRol(r.getIdRol());
                    mUsuario.changeRol(usuario.getIdUsuario(), r.getIdRol());
                    session.setAttribute("usuario", usuario);*/
                    redirectServlet(request, response, "donador");
                }
                break;
                case "donatario": {
                    /* session.setAttribute("rol", "DONATARIO");
                    Usuario user = (Usuario) session.getAttribute("usuario");
                    ManipulaUsuario mUsuario = new ManipulaUsuario();
                    Usuario usuario = mUsuario.encontrarCorreo(user.getCorreoElectronico());
                    ManipulaRol mRol = new ManipulaRol();
                    Rol r = mRol.encontrarRol("DONATARIO");
                    usuario.setRol(r.getIdRol());
                    mUsuario.changeRol(usuario.getIdUsuario(), r.getIdRol());
                    session.setAttribute("usuario", usuario);*/
                    redirectServlet(request, response, "estudiante");
                }
                break;
                case "voluntario": {
                    /*session.setAttribute("rol", "VOLUNTARIO");
                    Usuario user = (Usuario) session.getAttribute("usuario");
                    ManipulaUsuario mUsuario = new ManipulaUsuario();
                    Usuario usuario = mUsuario.encontrarCorreo(user.getCorreoElectronico());
                    ManipulaRol mRol = new ManipulaRol();
                    Rol r = mRol.encontrarRol("VOLUNTARIO");
                    usuario.setRol(r.getIdRol());
                    mUsuario.changeRol(usuario.getIdUsuario(), r.getIdRol());
                    session.setAttribute("usuario", usuario);*/
                    redirectServlet(request, response, "voluntario");
                }
                break;
                default:
                    session.setAttribute("rol", "PENDIENTE");
                    redirectView(request, response, "/destino.jsp");
                    break;
            }
        } else {
            session.setAttribute("rol", "PENDIENTE");
            redirectView(request, response, "/destino.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String s = request.getParameter("terms");
        String terms = "";
        if (s != null) {
            if (s.equals("on")) {
                terms = "ON";
            } else {
                terms = "OFF";
            }
        } else {
            terms = "OFF";
        }

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmar_password = request.getParameter("confirmar_password");
        String passwordCifrado = utils.Hash.sha1(password);

        Usuario user = new Usuario();
        user.setNombreUsuario(username);
        user.setContraseniia(passwordCifrado);
        user.setFechaCreacion(utils.Misc.getDateTimeActualJava());
        user.setUltimaConexion(utils.Misc.getDateTimeActualJava());
        user.setEstadoCuenta("C");
        user.setEstadoLogico(true);
        user.setConectado(false);
        user.setCorreoElectronico(email);
        user.setCorreoConfirmado(false);
        user.setNumeroCelular(-1);
        user.setNumeroCelularConfirmado(false);
        user.setAutenticacionDosPasos(false);
        user.setConteoAccesosFallidos(0);
        user.setFoto("");
        user.setIdRol(10);

        GenericResponse<Usuario> registrar = ManipulaAutenticacion.registrar(user);
        if (registrar.getStatus() != utils.Constantes.STATUS_NOT_ACCEPTABLE
                || registrar.getStatus() != utils.Constantes.STATUS_CONEXION_FALLIDA_BD) {
            HttpSession session = request.getSession(true);
            session.setAttribute("usuario", user);
            session.setAttribute("nombre", name);
            session.setAttribute("rol", "PENDIENTE");
            redirectView(request, response, "/destino.jsp");
            Cookie miCookie = new Cookie("nombre", "objetos");
        } else {
            System.out.println("Registro fallido " + registrar.getMensaje());

            HttpSession session = request.getSession(false);
            session.invalidate();//para invalidar manualmente la sessión si hay una creada
            //session.setAttribute("usuario", null);
            //session.setAttribute("nombre", "");
            ///session.setAttribute("rol", "");
            redirectView(request, response, "/registrarse.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void redirectView(HttpServletRequest req, HttpServletResponse resp, String pathView)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pathView);
        req.setAttribute("status", "Enviado");
        dispatcher.forward(req, resp);
    }

    private void redirectServlet(HttpServletRequest req, HttpServletResponse resp, String servlet) throws ServletException, IOException {
        req.getRequestDispatcher(servlet)
                .forward(req, resp);
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        //cuando almacena datos de session
        System.out.println("Almaceno " + event.getName() + "  " + event.getValue() + " en la session " + event.getSession());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        //cuando elimina datos de session
        System.out.println("Elimino " + event.getName() + "  " + event.getValue() + " en la session " + event.getSession());
    }
}
