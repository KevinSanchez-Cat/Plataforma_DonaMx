package manipula;

import config.conexion.*;
import java.sql.Date;
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
import utils.Logg;

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
                        + "contrasenia, "
                        + "fechaCreacion, "
                        + "ultimaConexion, "
                        + "estadoCuenta, "
                        + "estadoLogico, "
                        + "conectado, "
                        + "correoElectronico, "
                        + "correoConfirmado, "
                        + "numeroCelular, "
                        + "numeroCelularConfirmado, "
                        + "autenticacionDosPasos, "
                        + "conteoAccesosFallidos, "
                        + "foto, "
                        + "idRol "
                        + ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                registro.setString(1, obj.getNombreUsuario());
                registro.setString(2, obj.getContraseniia());
                registro.setDate(3, (Date) obj.getFechaCreacion());
                registro.setDate(4, (Date) obj.getUltimaConexion());
                registro.setString(5, obj.getEstadoCuenta());
                registro.setBoolean(6, obj.isEstadoLogico());
                registro.setBoolean(7, obj.isConectado());
                registro.setString(8, obj.getCorreoElectronico());
                registro.setBoolean(9, obj.isCorreoConfirmado());
                registro.setInt(10, obj.getNumeroCelular());
                registro.setBoolean(11, obj.isNumeroCelularConfirmado());
                registro.setBoolean(12, obj.isAutenticacionDosPasos());
                registro.setInt(13, obj.getConteoAccesosFallidos());
                registro.setString(14, obj.getFoto());
                registro.setInt(15, obj.getIdRol());
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
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            Usuario obj = encontrarId(id);
            if (obj != null) {
                try {
                    String sql = "UPDATE usuario SET "
                            + "nombreUsuario=?, "
                            + "estadoCuenta=?, "
                            + "estadoLogico=?, "
                            + "correoElectronico=?, "
                            + "correoConfirmado=?, "
                            + "numeroCelular=?, "
                            + "numeroCelularConfirmado=?, "
                            + "autenticacionDosPasos=?, "
                            + "conteoAccesosFallidos=?, "
                            + "foto=?, "
                            + "idRol=? "
                            + "WHERE idUsuario=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setString(1, nvoObj.getNombreUsuario());
                    registro.setString(2, nvoObj.getEstadoCuenta());
                    registro.setBoolean(3, nvoObj.isEstadoLogico());
                    registro.setString(4, nvoObj.getCorreoElectronico());
                    registro.setBoolean(5, nvoObj.isCorreoConfirmado());
                    registro.setInt(6, nvoObj.getNumeroCelular());
                    registro.setBoolean(7, nvoObj.isNumeroCelularConfirmado());
                    registro.setBoolean(8, nvoObj.isAutenticacionDosPasos());
                    registro.setInt(9, nvoObj.getConteoAccesosFallidos());
                    registro.setString(10, nvoObj.getFoto());
                    registro.setInt(11, nvoObj.getIdRol());
                    registro.setInt(12, id);
                    int r = registro.executeUpdate();
                    if (r > 0) {
                        nvoObj.setIdUsuario(id);
                        response.setStatus(utils.Constantes.STATUS_ACTUALIZACION_EXITOSA_BD);
                        response.setResponseObject(obj);
                        response.setMensaje("Edición exitosa en la base de datos");
                    } else {
                        response.setStatus(utils.Constantes.STATUS_ACTUALIZACION_FALLIDA_BD);
                        response.setResponseObject(obj);
                        response.setMensaje("Edición fallido en la base de datos");
                    }
                } catch (SQLException ex) {
                    response.setStatus(utils.Constantes.STATUS_CONEXION_FALLIDA_BD);
                    response.setResponseObject(null);
                    response.setMensaje("Error de comunicación con la base de datos " + ex.getSQLState());
                } finally {
                    conexionDB.desconectar();
                }
            } else {
                response.setStatus(utils.Constantes.STATUS_NO_DATA);
                response.setResponseObject(null);
                response.setMensaje("El registro no existe");
            }
        } else {
            response.setStatus(utils.Constantes.STATUS_CONEXION_FALLIDA_BD);
            response.setResponseObject(null);
            response.setMensaje("Error de conexión a la base de datos");
        }
        return response;
    }

    @Override
    public GenericResponse<Usuario> eliminar(int id) {
        GenericResponse<Usuario> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            Usuario obj = encontrarId(id);
            if (obj != null) {
                try {
                    String sql = "DELETE FROM usuario "
                            + "WHERE idUsuario=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setInt(1, id);
                    int r = registro.executeUpdate();
                    if (r > 0) {
                        response.setStatus(utils.Constantes.STATUS_ACTUALIZACION_EXITOSA_BD);
                        response.setResponseObject(obj);
                        response.setMensaje("Eliminacion exitosa en la base de datos");
                    } else {
                        response.setStatus(utils.Constantes.STATUS_ACTUALIZACION_FALLIDA_BD);
                        response.setResponseObject(null);
                        response.setMensaje("Eliminacion fallido en la base de datos");
                    }
                } catch (SQLException ex) {
                    response.setStatus(utils.Constantes.STATUS_CONEXION_FALLIDA_BD);
                    response.setResponseObject(null);
                    response.setMensaje("Error de comunicación con la base de datos " + ex.getSQLState());
                } finally {
                    conexionDB.desconectar();
                }
            } else {
                response.setStatus(utils.Constantes.STATUS_NO_DATA);
                response.setResponseObject(null);
                response.setMensaje("El registro no existe");
            }
        } else {
            response.setStatus(utils.Constantes.STATUS_CONEXION_FALLIDA_BD);
            response.setResponseObject(null);
            response.setMensaje("Error de conexión a la base de datos");
        }
        return response;
    }

    @Override
    public List<Usuario> getData() {
        List<Usuario> response = new ArrayList<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "SELECT "
                        + "idUsuario, "
                        + "nombreUsuario, "
                        + "fechaCreacion, "
                        + "ultimaConexion, "
                        + "estadoCuenta, "
                        + "estadoLogico, "
                        + "conectado, "
                        + "correoElectronico, "
                        + "correoConfirmado, "
                        + "numeroCelular, "
                        + "numeroCelularConfirmado, "
                        + "autenticacionDosPasos, "
                        + "conteoAccesosFallidos, "
                        + "foto, "
                        + "idRol "
                        + "FROM usuario";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    Usuario user = new Usuario();
                    user.setIdUsuario(rs.getInt(1));
                    user.setNombreUsuario(rs.getString(2));
                    user.setFechaCreacion(rs.getDate(3));
                    user.setUltimaConexion(rs.getDate(4));
                    user.setEstadoCuenta(rs.getString(5));
                    user.setEstadoLogico(rs.getBoolean(6));
                    user.setConectado(rs.getBoolean(7));
                    user.setCorreoElectronico(rs.getString(8));
                    user.setCorreoConfirmado(rs.getBoolean(9));
                    user.setNumeroCelular(rs.getInt(10));
                    user.setNumeroCelularConfirmado(rs.getBoolean(11));
                    user.setAutenticacionDosPasos(rs.getBoolean(12));
                    user.setConteoAccesosFallidos(rs.getInt(13));
                    user.setFoto(rs.getString(14));
                    user.setIdRol(rs.getInt(15));
                    response.add(user);
                }
            } catch (SQLException ex) {
                Logg.error("Comunicación fallida con la base de datos");
            } finally {
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
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
        Usuario response = null;
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "SELECT "
                        + "idUsuario, "
                        + "nombreUsuario, "
                        + "fechaCreacion, "
                        + "ultimaConexion, "
                        + "estadoCuenta, "
                        + "estadoLogico, "
                        + "conectado, "
                        + "correoElectronico, "
                        + "correoConfirmado, "
                        + "numeroCelular, "
                        + "numeroCelularConfirmado, "
                        + "autenticacionDosPasos, "
                        + "conteoAccesosFallidos, "
                        + "foto, "
                        + "idRol "
                        + "FROM usuario "
                        + "WHERE idUsuario=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs;
                rs = ps.executeQuery();
                if (rs.next()) {
                    response = new Usuario();
                    response.setIdUsuario(rs.getInt(1));
                    response.setNombreUsuario(rs.getString(2));
                    response.setFechaCreacion(rs.getDate(3));
                    response.setUltimaConexion(rs.getDate(4));
                    response.setEstadoCuenta(rs.getString(5));
                    response.setEstadoLogico(rs.getBoolean(6));
                    response.setConectado(rs.getBoolean(7));
                    response.setCorreoElectronico(rs.getString(8));
                    response.setCorreoConfirmado(rs.getBoolean(9));
                    response.setNumeroCelular(rs.getInt(10));
                    response.setNumeroCelularConfirmado(rs.getBoolean(11));
                    response.setAutenticacionDosPasos(rs.getBoolean(12));
                    response.setConteoAccesosFallidos(rs.getInt(13));
                    response.setFoto(rs.getString(14));
                    response.setIdRol(rs.getInt(15));
                } else {
                    Logg.error("No se encontro ningun registro");
                }
            } catch (SQLException ex) {
                Logg.error("Comunicación fallida con la base de datos");
            } finally {
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
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
