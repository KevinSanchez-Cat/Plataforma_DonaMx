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
public class Srv_contacto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //redirectView(request, response, "/registrarse.jsp");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Srv_contacto</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Srv_contacto at " + request.getContextPath() + "</h1>");
            out.println("<p>" + request.getParameter("name") + "</p>");
            out.println("<p>" + request.getParameter("email") + "</p>");
            out.println("<p>" + request.getParameter("subject") + "</p>");
            out.println("<p>" + request.getParameter("message") + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
        */
        redirectView(request, response, "/contacto.jsp");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
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
}
