package controller.donacion;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manipula.ManipulaDonacion;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Srv_donacion extends HttpServlet {

     ManipulaDonacion mUsuario = new ManipulaDonacion();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("page");
        if (action != null) {
            switch (action) {
                case "create":
                    vCreate(request, response);
                    break;
                case "edit":
                    vEdit(request, response);
                    break;
                case "find":
                    vFind(request, response);
                    break;
                case "details":
                    vDetails(request, response);
                    break;
                default:
                    index(request, response);
                    break;
            }
        } else {
            index(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "registrar":
                    registrar(request, response);
                    break;
                case "editar":
                    editar(request, response);
                    break;
                case "actualizar":
                    actualizar(request, response);
                    break;
                case "eliminar":
                    eliminar(request, response);
                    break;
                default:
                    index(request, response);
            }
        } else {
            index(request, response);
        }
    }

    private void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  String paginaJsp = "/views/usuario/index.jsp";
        String paginaJsp = "/views/dashboard/index.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaJsp);
        // req.setAttribute("listaEstudiantes", listaEstudiantes);
        dispatcher.forward(req, resp);
    }

    private void registrar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paginaJsp = "/vista/lista-estudiantes.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaJsp);
        // req.setAttribute("listaEstudiantes", listaEstudiantes);
        dispatcher.forward(req, resp);
    }

    private void editar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paginaJsp = "/vista/lista-estudiantes.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaJsp);
        // req.setAttribute("listaEstudiantes", listaEstudiantes);
        dispatcher.forward(req, resp);
    }

    private void actualizar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paginaJsp = "/vista/lista-estudiantes.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaJsp);
        // req.setAttribute("listaEstudiantes", listaEstudiantes);
        dispatcher.forward(req, resp);
    }

    private void eliminar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paginaJsp = "/vista/lista-estudiantes.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaJsp);
        //req.setAttribute("listaEstudiantes", listaEstudiantes);
        dispatcher.forward(req, resp);
    }

    private void info(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paginaJsp = "/vista/lista-estudiantes.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaJsp);
        //req.setAttribute("listaEstudiantes", listaEstudiantes);
        dispatcher.forward(req, resp);
    }

    private void vCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paginaJsp = "/vista/lista-estudiantes.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaJsp);
        // req.setAttribute("listaEstudiantes", listaEstudiantes);
        dispatcher.forward(req, resp);
    }

    private void vEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paginaJsp = "/vista/lista-estudiantes.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaJsp);
        // req.setAttribute("listaEstudiantes", listaEstudiantes);
        dispatcher.forward(req, resp);
    }

    private void vFind(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paginaJsp = "/vista/lista-estudiantes.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaJsp);
        // req.setAttribute("listaEstudiantes", listaEstudiantes);
        dispatcher.forward(req, resp);
    }

    private void vDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paginaJsp = "/vista/lista-estudiantes.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaJsp);
        // req.setAttribute("listaEstudiantes", listaEstudiantes);
        dispatcher.forward(req, resp);
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
   
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
