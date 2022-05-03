/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.inicio;

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
public class Srv_registro extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Srv_inicio_sesion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Srv_inicio_sesion at " + request.getContextPath()
                    + "</h1>");
            out.println("<p>" + request.getParameter("name") + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Srv_inicio_sesion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Srv_inicio_sesion at " + request.getContextPath()
                    + "</h1>");
            out.println("<p>" + request.getParameter("name") + "</p>");
            out.println("<p>" + request.getParameter("email") + "</p>");
            out.println("<p>" + request.getParameter("username") + "</p>");
            out.println("<p>" + request.getParameter("password") + "</p>");
            out.println("<p>" + request.getParameter("confirmar_password") + "</p>");
            out.println("<p>" + request.getParameter("terms") + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
