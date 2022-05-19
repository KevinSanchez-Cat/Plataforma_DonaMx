package manipula;

import config.conexion.ConexionFactory;
import config.conexion.IConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Archivo;
import model.ArchivoSolicitud;
import utils.GenericResponse;
import utils.Logg;
import utils.Misc;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ManipulaArchivoSolicitud implements Manipula<ArchivoSolicitud> {

    @Override
    public GenericResponse<ArchivoSolicitud> registrar(IConexion conexionDB, ArchivoSolicitud obj) {
        GenericResponse<ArchivoSolicitud> response = new GenericResponse<>();

        if (conexionDB.getConexion() != null) {
            try {
                String sql = "INSERT INTO ArchivoSolicitud ("
                        + "nombreArchivo, "
                        + "extension, "
                        + "tamanio, "
                        + "fechaCreacion, "
                        + "urlDestino, "
                        + "idUsuario, "
                        + "idSolicitud "
                        + ") VALUES (?,?,?,?,?,?,?)";
                PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                registro.setString(1, obj.getNombreArchivo());
                registro.setString(2, obj.getExtension());
                registro.setDouble(3, obj.getTamanio());
                registro.setTimestamp(4, obj.getFechaCreacion());
                registro.setString(5, obj.getUrlDestino());
                registro.setInt(6, obj.getIdUsuario());
                registro.setInt(7, obj.getIdSolicitud());
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

            }
        } else {
            response.setStatus(utils.Constantes.STATUS_CONEXION_FALLIDA_BD);
            response.setResponseObject(null);
            response.setMensaje("Error de conexión a la base de datos");
        }
        return response;
    }

    @Override
    public GenericResponse<ArchivoSolicitud> actualizar(IConexion conexionDB, int id) {
        GenericResponse<ArchivoSolicitud> response = new GenericResponse<>();
        response.setMensaje("Accion no implementada");
        response.setStatus(utils.Constantes.LOGIC_WARNING);
        response.setResponseObject(null);
        return response;
    }

    @Override
    public GenericResponse<ArchivoSolicitud> editar(IConexion conexionDB, int id, ArchivoSolicitud nvoObj) {
        GenericResponse<ArchivoSolicitud> response = new GenericResponse<>();

        if (conexionDB.getConexion() != null) {
            if (encontrarId(conexionDB, id) != null) {
                try {
                    String sql = "UPDATE ArchivoSolicitud SET "
                            + "nombreArchivo=?, "
                            + "extension=?, "
                            + "tamanio=?, "
                            + "fechaCreacion=?, "
                            + "urlDestino=?, "
                            + "idUsuario=?, "
                            + "idSolicitud=? "
                            + "WHERE idArchivo=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setString(1, nvoObj.getNombreArchivo());
                    registro.setString(2, nvoObj.getExtension());
                    registro.setDouble(3, nvoObj.getTamanio());
                    registro.setTimestamp(4, nvoObj.getFechaCreacion());
                    registro.setString(5, nvoObj.getUrlDestino());
                    registro.setInt(6, nvoObj.getIdUsuario());
                    registro.setInt(7, nvoObj.getIdSolicitud());
                    registro.setInt(8, id);
                    int r = registro.executeUpdate();
                    if (r > 0) {
                        nvoObj.setIdArchivo(id);
                        response.setStatus(utils.Constantes.STATUS_ACTUALIZACION_EXITOSA_BD);
                        response.setResponseObject(nvoObj);
                        response.setMensaje("Edición exitosa en la base de datos");
                    } else {
                        response.setStatus(utils.Constantes.STATUS_ACTUALIZACION_FALLIDA_BD);
                        response.setResponseObject(nvoObj);
                        response.setMensaje("Edición fallido en la base de datos");
                    }
                } catch (SQLException ex) {
                    response.setStatus(utils.Constantes.STATUS_CONEXION_FALLIDA_BD);
                    response.setResponseObject(null);
                    response.setMensaje("Error de comunicación con la base de datos " + ex.getSQLState());
                } finally {

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
    public GenericResponse<ArchivoSolicitud> eliminar(IConexion conexionDB, int id) {
        GenericResponse<ArchivoSolicitud> response = new GenericResponse<>();

        if (conexionDB.getConexion() != null) {
            ArchivoSolicitud obj = encontrarId(conexionDB, id);
            if (obj != null) {
                try {
                    String sql = "DELETE FROM ArchivoSolicitud "
                            + "WHERE idArchivo=?";
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
    public List<ArchivoSolicitud> getData(IConexion conexionDB) {
        List<ArchivoSolicitud> response = new ArrayList<>();

        if (conexionDB.getConexion() != null) {
            try {
                String sql = "SELECT "
                        + "idArchivo, "
                        + "nombreArchivo, "
                        + "extension, "
                        + "tamanio, "
                        + "fechaCreacion, "
                        + "urlDestino, "
                        + "idUsuario, "
                        + "idSolicitud "
                        + "FROM ArchivoSolicitud";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    ArchivoSolicitud sol = new ArchivoSolicitud();
                    sol.setIdArchivo(rs.getInt(1));
                    sol.setNombreArchivo(rs.getString(2));
                    sol.setExtension(rs.getString(3));
                    sol.setTamanio(rs.getDouble(4));
                    sol.setFechaCreacion(rs.getTimestamp(5));
                    sol.setUrlDestino(rs.getString(6));
                    sol.setIdUsuario(rs.getInt(7));
                    sol.setIdSolicitud(rs.getInt(8));
                    response.add(sol);
                }
            } catch (SQLException ex) {
                Logg.error("Comunicación fallida con la base de datos");
            } finally {

            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return response;
    }

    @Override
    public List<ArchivoSolicitud> consultar(IConexion conexionDB, String... filtros) {
        List<ArchivoSolicitud> response = new ArrayList<>();

        if (conexionDB.getConexion() != null) {
            try {
                String sql = "SELECT "
                        + "idArchivo, "
                        + "nombreArchivo, "
                        + "extension, "
                        + "tamanio, "
                        + "fechaCreacion, "
                        + "urlDestino, "
                        + "idUsuario, "
                        + "idSolicitud "
                        + "FROM ArchivoSolicitud";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    ArchivoSolicitud sol = new ArchivoSolicitud();
                    sol.setIdArchivo(rs.getInt(1));
                    sol.setNombreArchivo(rs.getString(2));
                    sol.setExtension(rs.getString(3));
                    sol.setTamanio(rs.getDouble(4));
                    sol.setFechaCreacion(rs.getTimestamp(5));
                    sol.setUrlDestino(rs.getString(6));
                    sol.setIdUsuario(rs.getInt(7));
                    sol.setIdSolicitud(rs.getInt(8));
                    response.add(sol);
                }
            } catch (SQLException ex) {
                Logg.error("Comunicación fallida con la base de datos");
            } finally {

            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return response;
    }

    @Override
    public ArchivoSolicitud encontrarId(IConexion conexionDB, int id) {
        ArchivoSolicitud response = null;

        if (conexionDB.getConexion() != null) {
            try {
                String sql = "SELECT "
                        + "idArchivo, "
                        + "nombreArchivo, "
                        + "extension, "
                        + "tamanio, "
                        + "fechaCreacion, "
                        + "urlDestino, "
                        + "idUsuario, "
                        + "idSolicitud "
                        + "FROM ArchivoSolicitud "
                        + "WHERE idArchivo=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs;
                rs = ps.executeQuery();
                if (rs.next()) {
                    response = new ArchivoSolicitud();
                    response.setIdArchivo(rs.getInt(1));
                    response.setNombreArchivo(rs.getString(2));
                    response.setExtension(rs.getString(3));
                    response.setTamanio(rs.getDouble(4));
                    response.setFechaCreacion(rs.getTimestamp(5));
                    response.setUrlDestino(rs.getString(6));
                    response.setIdUsuario(rs.getInt(7));
                    response.setIdSolicitud(rs.getInt(8));
                } else {
                    Logg.error("No se encontro ningun registro");
                }
            } catch (SQLException ex) {
                Logg.error("Comunicación fallida con la base de datos");
            } finally {

            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return response;
    }
}
