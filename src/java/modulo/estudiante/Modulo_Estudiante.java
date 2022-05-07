/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo.estudiante;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Modulo_Estudiante extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = request.getParameter("page");

        if (page == null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/home.jsp");
            dispatcher.forward(request, response);

        } else if (page.equals("catalogo")) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/categorias.jsp");
            dispatcher.forward(request, response);
        } else if (page.equals("equipos_remunerados")) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/equipos_remunerados.jsp");
            dispatcher.forward(request, response);
        } else if (page.equals("equipos_donados")) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/equipos_donados.jsp");
            dispatcher.forward(request, response);
        } else if (page.equals("informacion_personal")) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/informacion_personal.jsp");
            dispatcher.forward(request, response);
        } else if (page.equals("informacion_escolar")) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/informacion_escolar.jsp");
            dispatcher.forward(request, response);
        } else if (page.equals("informacion_domiciliaria")) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/informacion_domiciliaria.jsp");
            dispatcher.forward(request, response);
        } else if (page.equals("mi_mochila")) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/mi_mochila.jsp");
            dispatcher.forward(request, response);
        } else if (page.equals("deseos")) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/lista_deseos.jsp");
            dispatcher.forward(request, response);
        } else if (page.equals("solicitudes")) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/solicitudes.jsp");
            dispatcher.forward(request, response);
        } else if (page.equals("perfil")) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/perfil.jsp");
            dispatcher.forward(request, response);
        } else if (page.equals("notificaciones")) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_estudiante/notificaciones.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
