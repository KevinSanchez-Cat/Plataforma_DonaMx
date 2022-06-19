package controller.usuario;

import config.conexion.ConexionFactory;
import config.conexion.IConexion;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manipula.ManipulaUsuario;
import utils.Logg;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Srv_usuario extends HttpServlet {

    ManipulaUsuario mUsuario = new ManipulaUsuario();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        listarImagen(id, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    private void listarImagen(int id, HttpServletResponse response) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        response.setContentType("image/*"); 
        ManipulaUsuario mUsuario = new ManipulaUsuario();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
       
       
        if (conexionDB.conectar() == 1) {

            if (conexionDB.getConexion() != null) {
                
                inputStream = mUsuario.getFotoPerfilUser(conexionDB, id);
                if(inputStream!=null){
                    try {
                        outputStream = response.getOutputStream();
                        bufferedInputStream = new BufferedInputStream(inputStream);
                        bufferedOutputStream = new BufferedOutputStream(outputStream);
                        int i = 0;
                        while ((i = bufferedInputStream.read()) != -1) {
                            bufferedOutputStream.write(i);
                        }
                    } catch (Exception e) {
                    }
                }else{
                    
                }
                if (conexionDB.getConexion() != null) {
                    conexionDB.desconectar();
                }
            } else {
                Logg.error("Conexión fallida con la base de datos");
            }

        }
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
