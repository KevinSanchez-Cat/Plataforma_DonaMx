/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.inicio;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Srv_inicio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        index(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("page");
        if (action != null) {
            switch (action) {
                case "registrarse":
                    redirectServlet(request, response, "Srv_registro");
                    break;
                case "iniciar_session":
                    redirectServlet(request, response, "Srv_inicio_sesion");
                    break;
                case "dona":
                    redirectView(request, response, "/views/principal/dona.jsp");
                    break;
                case "terminosycondiciones":
                    redirectView(request, response, "/views/principal/terminosycondiciones.jsp");
                    break;
                case "aviso_privacidad":
                    redirectView(request, response, "/views/principal/avisoprivacidad.jsp");
                    break;
                case "contacto":
                    redirectServlet(request, response, "Srv_contacto");
                    break;
                case "conocenos":
                    redirectView(request, response, "/views/principal/conocenos.jsp");
                    break;
                case "como_funciona":
                    redirectView(request, response, "/views/principal/comofunciona.jsp");
                    break;
                default:
                    index(request, response);
            }
        } else {
            index(request, response);
        }
    }

    private void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paginaJsp = "";
        
        HttpSession sesion = req.getSession();
        
        String user = (String) sesion.getAttribute("user");
        if (user == null) {
            paginaJsp = "/views/principal/index.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaJsp);
            // req.setAttribute("listaEstudiantes", listaEstudiantes);
            dispatcher.forward(req, resp);
        } else {
            switch (user.toUpperCase()) {
                case "ADMINISTRADOR":
                    req.getRequestDispatcher("Srv_dashboard")
                            .forward(req, resp);
                    break;
                case "VOLUNTARIO":
                    req.getRequestDispatcher("Srv_dashboard")
                            .forward(req, resp);
                    break;
                case "ESTUDIANTE":
                    index(req, resp);
                    break;
                case "ORGANIZACION":
                    req.getRequestDispatcher("Srv_dashboard")
                            .forward(req, resp);
                    break;
                case "DOCENTE":
                    req.getRequestDispatcher("Srv_dashboard")
                            .forward(req, resp);
                    break;
                case "DONADOR":
                    req.getRequestDispatcher("Srv_dashboard")
                            .forward(req, resp);
                    break;
                case "DONATARIO":
                    break;
                default:
                    index(req, resp);
                    break;
            }
        }

    }

    private void redirectView(HttpServletRequest req, HttpServletResponse resp, String pathView) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pathView);
        // req.setAttribute("listaEstudiantes", listaEstudiantes);
        dispatcher.forward(req, resp);
    }

    private void redirectServlet(HttpServletRequest req, HttpServletResponse resp, String servlet) throws ServletException, IOException {
        req.getRequestDispatcher(servlet)
                .forward(req, resp);
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
