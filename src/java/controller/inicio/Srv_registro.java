/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.inicio;

import java.io.IOException;
import java.util.UUID;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import manipula.ManipulaAutenticacion;
import manipula.ManipulaRol;
import manipula.ManipulaUsuario;
import model.Rol;
import model.Usuario;
import utils.GenericResponse;
import utils.Logg;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Srv_registro extends HttpServlet implements HttpSessionBindingListener {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ser = request.getParameter("ser");
        HttpSession session = request.getSession();
        if (ser != null) {
            switch (ser) {
                case "donador": {
                    try {
                        Usuario user = (Usuario) session.getAttribute("user");
                        ManipulaUsuario mUsuario = new ManipulaUsuario();
                        Usuario usuario = mUsuario.encontrarCorreo(user.getCorreoElectronico());
                        ManipulaRol mRol = new ManipulaRol();
                        Rol r = mRol.encontrarRol("DONADOR");
                        usuario.setRol(r.getIdRol());
                        mUsuario.changeRol(usuario.getIdUsuario(), r.getIdRol());
                        session.setAttribute("rol", "DONADOR");
                        session.setAttribute("idUser", usuario.getIdUsuario());
                        session.setAttribute("usuario", usuario);
                        response.sendRedirect("donador");
                    } catch (IOException e) {
                        System.out.println("Error");
                    }

                }
                break;
                case "donatario": {
                    session.setAttribute("rol", "DONATARIO");
                    //Usuario
                    Usuario user = (Usuario) session.getAttribute("user");
                    ManipulaUsuario mUsuario = new ManipulaUsuario();
                    System.out.println(user);
                    Usuario usuario = mUsuario.encontrarCorreo(user.getCorreoElectronico());
                    System.out.println("usuario" + usuario);
                    ManipulaRol mRol = new ManipulaRol();
                    Rol r = mRol.encontrarRol("DONATARIO");
                    usuario.setRol(r.getIdRol());
                    mUsuario.changeRol(usuario.getIdUsuario(), r.getIdRol());
                    session.setAttribute("usuario", usuario);
                    session.setAttribute("idUser", usuario.getIdUsuario());
                    response.sendRedirect("estudiante");

                }
                break;
                case "voluntario": {
                    session.setAttribute("rol", "VOLUNTARIO");
                    Usuario user = (Usuario) session.getAttribute("user");
                    ManipulaUsuario mUsuario = new ManipulaUsuario();
                    Usuario usuario = mUsuario.encontrarCorreo(user.getCorreoElectronico());
                    ManipulaRol mRol = new ManipulaRol();
                    Rol r = mRol.encontrarRol("VOLUNTARIO");
                    usuario.setRol(r.getIdRol());
                    mUsuario.changeRol(usuario.getIdUsuario(), r.getIdRol());
                    session.setAttribute("usuario", usuario);
                    session.setAttribute("idUser", usuario.getIdUsuario());
                    response.sendRedirect("voluntario");
                }
                break;
                default:
                    session.setAttribute("rol", "PENDIENTE");
                    Usuario user = (Usuario) session.getAttribute("user");
                    ManipulaUsuario mUsuario = new ManipulaUsuario();
                    Usuario usuario = mUsuario.encontrarCorreo(user.getCorreoElectronico());
                    ManipulaRol mRol = new ManipulaRol();
                    Rol r = mRol.encontrarRol("PENDIENTE");
                    usuario.setRol(r.getIdRol());
                    mUsuario.changeRol(usuario.getIdUsuario(), r.getIdRol());
                    session.setAttribute("usuario", usuario);
                    session.setAttribute("idUser", usuario.getIdUsuario());

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
        if (s != null) {
            if (s.equals("on")) {
                String email = request.getParameter("email");
                String name = request.getParameter("name");
                String lastname = request.getParameter("lastname");
                String password = request.getParameter("password");
                String confirmar_password = request.getParameter("confirmar_password");

                System.out.println(email + " " + name + " " + lastname + " " + password + " " + confirmar_password);
                if (password.equals(confirmar_password)) {
                    String passwordCifrado = utils.Hash.sha1(password);

                    Usuario user = new Usuario();
                    user.setNombre(name);
                    user.setApellido(lastname);
                    String username2 = name + " " + lastname.substring(0, 1) + " " + UUID.randomUUID().toString().replace("-", "");
                    user.setNombreUsuario(username2);
                    user.setContraseniia(passwordCifrado);
                    user.setFechaCreacion(utils.Misc.getDateTimeActualSQL());
                    user.setUltimaConexion(utils.Misc.getDateTimeActualSQL());
                    user.setEstadoCuenta("C");
                    user.setEstadoLogico(1);
                    user.setConectado(0);
                    user.setCorreoElectronico(email);
                    user.setCorreoConfirmado(0);
                    user.setNumeroCelular(-1);
                    user.setNumeroCelularConfirmado(0);
                    user.setAutenticacionDosPasos(0);
                    user.setConteoAccesosFallidos(0);
                    user.setFoto("");
                    user.setToken(generarToken());
                    ManipulaRol mRol = new ManipulaRol();
                    Rol rol = mRol.encontrarRol("PENDIENTE");
                    user.setIdRol(rol.getIdRol());

                    GenericResponse<Usuario> registrar = ManipulaAutenticacion.registrar(user);
                    System.out.println(registrar.getResponseObject());
                    if (registrar.getResponseObject() != null) {
                        HttpSession session = request.getSession(true);
                        session.setAttribute("username", user.getNombre() + " " + user.getApellido());
                        session.setAttribute("user", user);
                        session.setAttribute("rol", "PENDIENTE");
                        redirectView(request, response, "/destino.jsp");
                    } else {
                        //Registro fallido
                        System.out.println("Registro fallido " + registrar.getMensaje());
                        HttpSession session = request.getSession();
                        session.invalidate();//para invalidar manualmente la sessión si hay una creada
                        request.setAttribute("respuesta", "Ups! Hubo un error en el registro");
                        redirectView(request, response, "/registrarse.jsp");
                    }
                } else {
                    //Las contraseñas no son iguales
                    HttpSession session = request.getSession();
                    session.invalidate();//para invalidar manualmente la sessión si hay una creada
                    request.setAttribute("respuesta", "Las contraseñas no son iguales");
                    redirectView(request, response, "/registrarse.jsp");
                }
            } else {
                //Tiene que aceptar los terminos y condiciones
                HttpSession session = request.getSession();
                session.invalidate();//para invalidar manualmente la sessión si hay una creada
                request.setAttribute("respuesta", "Tiene que aceptar los terminos y condiciones");
                redirectView(request, response, "/registrarse.jsp");
            }
        } else {
            //Tiene que aceptar los terminos y condiciones
            HttpSession session = request.getSession();
            session.invalidate();//para invalidar manualmente la sessión si hay una creada
            request.setAttribute("respuesta", "Tiene que aceptar los terminos y condiciones");
            redirectView(request, response, "/registrarse.jsp");
        }
    }

    private void redirectView(HttpServletRequest req, HttpServletResponse resp, String pathView)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pathView);
        req.setAttribute("status", "Enviado");
        dispatcher.forward(req, resp);
    }

    private void redirectServlet(HttpServletRequest req, HttpServletResponse resp, String servlet)
            throws ServletException, IOException {
        req.getRequestDispatcher(servlet)
                .forward(req, resp);
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        //cuando almacena datos de session
        Logg.info("Almaceno " + event.getName() + "  " + event.getValue() + " en la session " + event.getSession());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        //cuando elimina datos de session
        Logg.info("Elimino " + event.getName() + "  " + event.getValue() + " en la session " + event.getSession());
    }

    private String generarToken() {
        String uuidw = UUID.randomUUID().toString().replace("-", "");
        return uuidw;
    }
}
