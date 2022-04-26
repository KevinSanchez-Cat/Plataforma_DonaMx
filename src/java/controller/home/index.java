package controller.home;

import config.conexion.ConexionFactory;
import config.conexion.IConexion;
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
public class index extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String paginaJsp = "/index.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaJsp);
        // req.setAttribute("listaEstudiantes", listaEstudiantes);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String paginaJsp = "/index.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaJsp);
        // req.setAttribute("listaEstudiantes", listaEstudiantes);
        dispatcher.forward(request, response);
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
