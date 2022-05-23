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
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.util.*;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Captcha extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8;autoFlush=true");
            /* TODO output your page here. You may use following sample code. */
            try {
                int width = 80;
                int height = 13;
                Random rdm = new Random();
                int rl = rdm.nextInt();
                String hash1 = Integer.toHexString(rl);
                String capstr = hash1.substring(0, 5);
                HttpSession session_actual = request.getSession(true);
                String codigo_generado = (String) session_actual.getAttribute("key");
                if (codigo_generado == null) {
                    session_actual.setAttribute("key", capstr);
                } else {
                    session_actual.invalidate();
                    HttpSession nueva_session = request.getSession(true);
                    nueva_session.setAttribute("key", capstr);
                }
                // Color background = new Color(255, 255, 255);
                GradientPaint background = new GradientPaint(0, 0, Color.blue, 0, height, Color.cyan);
                Color fbl = new Color(255, 255, 255);
                Font fnt = new Font("SansSerif", 1, 10);
                BufferedImage cpimg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                Graphics2D g = cpimg.createGraphics();
                g.setPaint(background);
                g.fillRect(0, 0, width, height);
                g.setColor(fbl);
                g.setFont(fnt);
                g.drawString(capstr, 10, 10);
                g.setColor(new Color(255, 255, 255));
                g.drawLine(40, 9, 80, 9);
                g.drawLine(40, 11, 80, 11);
                response.setContentType("image/jpeg");
                OutputStream strm = null;
                strm = response.getOutputStream();
                ImageIO.write(cpimg, "jpeg", strm);
                cpimg.flush();
                strm.flush();
                strm.close();
                strm = null;
                response.flushBuffer();
               // out.clear();
               // out = pageContext.pushBody();
            } catch (Exception ex) {
               // out.println(ex.getMessage());
            }

        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
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
