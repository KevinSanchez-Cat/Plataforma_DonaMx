/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipula;

import config.conexion.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;
import utils.GenericResponse;

/**
 *
 * @author por_s
 */
public class ManipulaUsuario implements Manipula<Usuario> {

    @Override
    public GenericResponse<Usuario> registrar(Usuario obj) {
        GenericResponse<Usuario> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");

        if (conexionDB.conectar() == 1) {

            try {
                String sql = "INSERT INTO usuario ("
                        + "nombreUsuario, "
                        + "constrasenia,"
                        + "fechaCreacion,"
                        + "estadoCuenta,"
                        + "estadoLogico,"
                        + "conectado,"
                        + "correoElectronico,"
                        + "correoConfirmado, "
                        + "numeroCelular,"
                        + "numeroCelularConfirmado,"
                        + "autenticacionDosPasos,"
                        + "conteoAccesosFallidos,"
                        + "idRol"
                        + ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);

                registro.setString(1, obj.getNombreUsuario());
                registro.setString(2, "");
                registro.setString(3, "");
                registro.setString(4, "");
                registro.setString(5, obj.getContraseniia());
                registro.setString(6, obj.getContraseniia());
                registro.setString(7, obj.getContraseniia());
                registro.setString(8, obj.getContraseniia());
                registro.setString(9, obj.getContraseniia());
                registro.setString(10, obj.getContraseniia());
                registro.setString(11, obj.getContraseniia());
                registro.setString(12, obj.getContraseniia());
                registro.setString(13, obj.getRol().getRol());

                int r = registro.executeUpdate();
                if (r > 0) {
                    // String sql23 = "INSERT INTO t_usuario (usuar,password,tipo_usuario) VALUES(?,?,?)";
                } else {

                }
            } catch (SQLException ex) {
                response.setStatus(utils.Constantes.STATUS_REGISTRO_FALLIDO_BD);
                response.setResponseObject(null);
                response.setMensaje("Error al insertar en la base de datos " + ex.getSQLState());
            }
        } else {
            response.setStatus(utils.Constantes.STATUS_CONEXION_FALLIDA_BD);
            response.setResponseObject(null);
            response.setMensaje("Error de conexión a la base de datos");
        }
        return response;
    }

    @Override
    public GenericResponse<Usuario> actualizar(int id) {
        GenericResponse<Usuario> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Usuario> editar(int id, Usuario obj) {
        GenericResponse<Usuario> response = new GenericResponse<>();
        String sql = "UPDATE libros SET "
                + "nombre_libro=? ,"
                + "autor_libro=?, "
                + "editorial=? ,"
                + "edicion=? ,"
                + "cantidad=? ,"
                + "ISBM=? "
                + "WHERE id_libro=?";
        
        return response;
    }

    @Override
    public GenericResponse<Usuario> eliminar(int id) {
        GenericResponse<Usuario> response = new GenericResponse<>();
        
        String sql = "DELETE FROM t_libro "
                + "WHERE nombre_libro=?";
        
        return response;
    }

    @Override
    public List<Usuario> getData() {
        List<Usuario> response = new ArrayList<>();

        return response;
    }

    @Override
    public List<Usuario> consultar(String... filtros) {
        List<Usuario> response = new ArrayList<>();
        response.stream().filter(user -> user.getIdUsuario() > 20).forEach(
                //System.out::println
                //user->{System.out.println("Nombre: "+user.getNombreUsuario());}
                user -> System.out.println("Nombre: " + user.getNombreUsuario())
        );
        return response;
    }

    @Override
    public Usuario encontrarId(int id) {
        Usuario response = new Usuario();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");

        if (conexionDB.conectar() == 1) {
            try {
                String sql = "SELECT * FROM USUARIO WHERE idUsuario=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);

                String contrase = new String("pasword");
                String nuevopasword = utils.Hash.sha1(contrase);

                ps.setString(1, "user");
                ps.setString(2, nuevopasword);
                ResultSet rs;
                rs = ps.executeQuery();

                if (rs.next()) {
                    switch (rs.getString("tipo_usuario")) {
                        case "ADMINISTRADOR":
                            break;
                        default:
                            System.out.println("Usuario no reconocido");
                            break;
                    }
                }

            } catch (SQLException ex) {

            }

        } else {

        }
        return response;

    }

}
