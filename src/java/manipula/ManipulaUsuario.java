package manipula;

import config.conexion.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Direccion;
import model.Donacion;
import model.Notificacion;
import model.Solicitud;
import model.Usuario;
import utils.GenericResponse;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
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
                        + "correoElectronico,"
                        + "conteoAccesosFallidos,"
                        + "idRol"
                        + ") VALUES (?,?,?,?,?,?,?,?)";
                PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                registro.setString(1, obj.getNombreUsuario());
                registro.setString(2, obj.getContraseniia());
                registro.setString(3, obj.getEstadoCuenta());
                registro.setBoolean(4, obj.isEstadoLogico());
                registro.setString(5, obj.getCorreoElectronico());
                registro.setInt(6, obj.getConteoAccesosFallidos());
                registro.setInt(7, obj.getRol());
                registro.setString(8, obj.getNombreUsuario());
                int r = registro.executeUpdate();
                if (r > 0) {
                    response.setStatus(utils.Constantes.STATUS_REGISTRO_EXITOSO_BD);
                    response.setResponseObject(obj);
                    response.setMensaje("Registro exitoso en la base de datos");
                } else {
                    response.setStatus(utils.Constantes.STATUS_REGISTRO_FALLIDO_BD);
                    response.setResponseObject(obj);
                    response.setMensaje("Registro fallido en la base de datos");
                }
            } catch (SQLException ex) {
                response.setStatus(utils.Constantes.STATUS_CONEXION_FALLIDA_BD);
                response.setResponseObject(null);
                response.setMensaje("Error de comunicación con la base de datos " + ex.getMessage());
            } finally {
                conexionDB.desconectar();
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
        //Ultima conexion
        //Conectada ? desconectada
        return response;
    }

    @Override
    public GenericResponse<Usuario> editar(int id, Usuario nvoObj) {
        GenericResponse<Usuario> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Usuario> eliminar(int id) {
        GenericResponse<Usuario> response = new GenericResponse<>();

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

        return response;

    }

    public List<Solicitud> getSolicitudes(int idUsuario) {
        return null;
    }

    public List<Donacion> getDonacion(int idUsuario) {
        return null;
    }

    public List<Notificacion> getNotificacion(int idUsuario) {
        return null;
    }

    public String getTipoAcceso(int idUsuario) {
        return null;
    }

    public boolean changeContrasenia(int idUsuario, String contrasenia, String nvaContrasenia) {
        return false;
    }

    public boolean changeCorreoElectronico(int idUsuario, String nvoCorreoElectronico) {
        return false;
    }

    public boolean changeCelular(int idUsuario, int nvoCelular) {
        return false;
    }

    public boolean changeDireccion(int idUsuario, Direccion nvaDireccion) {
        return false;
    }

}
