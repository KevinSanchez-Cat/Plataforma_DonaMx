<%@page contentType="text/html" pageEncoding="UTF-8" autoFlush="true"%>
<%@ page import="java.io.*"%>
<%@ page import="java.awt.*"%>
<%@ page import="java.awt.image.*"%>
<%@ page import="javax.imageio.ImageIO"%>
<%@ page import="java.util.*"%>
<%--
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
        strm=null;
        response.flushBuffer();
        out.clear();
        out=pageContext.pushBody();
    } catch (Exception ex) {
        out.println(ex.getMessage());
    }
--%>