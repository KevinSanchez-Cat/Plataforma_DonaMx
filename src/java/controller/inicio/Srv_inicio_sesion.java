/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.inicio;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Srv_inicio_sesion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Srv_inicio_sesion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Srv_inicio_sesion at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        
        HttpSession session=request.getSession(false);
       
        if(!session.getId().isEmpty()){
            //Session recuperada, continua con operaciones del servlet
            session=request.getSession(true);//crea una sesion
            
        }else{
            
            //Sin session, devuelve una pagina de error
        }
        
        if(request.isRequestedSessionIdValid()){
            if(request.isRequestedSessionIdFromCookie()){
                //Se obtubo de una cokkie, y se mantiene la session en la cokkie
            }
            //cualquier otra tarea que requiera de una sesion valida
        }else{
            //registra un error de session
        }
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Srv_inicio_sesion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Srv_inicio_sesion at " + request.getContextPath() + "</h1>");
            out.print("<p>" + request.getParameter("username") + "</p>");
            out.print("<p>" + request.getParameter("password") + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
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

}
