package manipula;

import config.conexion.ConexionFactory;
import config.conexion.IConexion;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Archivo;
import utils.GenericResponse;
import utils.Logg;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ManipulaArchivo implements Manipula<Archivo> {

    @Override
    public GenericResponse<Archivo> registrar(Archivo obj) {
        GenericResponse<Archivo> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "INSERT INTO archivo ("
                        + "nombreArchivo, "
                        + "extension, "
                        + "tamanio, "
                        + "fechaCreacion, "
                        + "urlDestino, "
                        + "idUsuario "
                        + ") VALUES (?,?,?,?,?,?)";
                PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                registro.setString(1, obj.getNombreArchivo());
                registro.setString(2, obj.getExtension());
                registro.setDouble(3, obj.getTamanio());
                registro.setDate(4, (Date) obj.getFechaCreacion());
                registro.setString(5, obj.getUrlDestino());
                registro.setInt(6, obj.getIdUsuario());
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
    public GenericResponse<Archivo> actualizar(int id) {
        GenericResponse<Archivo> response = new GenericResponse<>();
        response.setMensaje("Accion no implementada");
        response.setStatus(utils.Constantes.LOGIC_WARNING);
        response.setResponseObject(null);
        return response;
    }

    @Override
    public GenericResponse<Archivo> editar(int id, Archivo nvoObj) {
        GenericResponse<Archivo> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (encontrarId(id) != null) {
                try {
                    String sql = "UPDATE archivo SET "
                            + "nombreArchivo=?, "
                            + "extension=?, "
                            + "tamanio=?, "
                            + "fechaCreacion=?, "
                            + "urlDestino=?, "
                            + "idUsuario=? "
                            + "WHERE idArchivo=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setString(1, nvoObj.getNombreArchivo());
                    registro.setString(2, nvoObj.getExtension());
                    registro.setDouble(3, nvoObj.getTamanio());
                    registro.setDate(4, (Date) nvoObj.getFechaCreacion());
                    registro.setString(5, nvoObj.getUrlDestino());
                    registro.setInt(6, nvoObj.getIdUsuario());
                    registro.setInt(7, id);
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
    public GenericResponse<Archivo> eliminar(int id) {
        GenericResponse<Archivo> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            Archivo obj = encontrarId(id);
            if (obj != null) {
                try {
                    String sql = "DELETE FROM archivo "
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
    public List<Archivo> getData() {
        List<Archivo> response = new ArrayList<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "SELECT "
                        + "idArchivo, "
                        + "nombreArchivo, "
                        + "extension, "
                        + "tamanio, "
                        + "fechaCreacion, "
                        + "urlDestino, "
                        + "idUsuario "
                        + "FROM archivo";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    Archivo sol = new Archivo();
                    sol.setIdArchivo(rs.getInt(1));
                    sol.setNombreArchivo(rs.getString(2));
                    sol.setExtension(rs.getString(3));
                    sol.setTamanio(rs.getDouble(4));
                    sol.setFechaCreacion(rs.getDate(5));
                    sol.setUrlDestino(rs.getString(6));
                    sol.setIdUsuario(rs.getInt(7));
                    response.add(sol);
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
    public List<Archivo> consultar(String... filtros) {
        List<Archivo> response = new ArrayList<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "SELECT "
                        + "idArchivo, "
                        + "nombreArchivo, "
                        + "extension, "
                        + "tamanio, "
                        + "fechaCreacion, "
                        + "urlDestino, "
                        + "idUsuario "
                        + "FROM archivo";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    Archivo sol = new Archivo();
                    sol.setIdArchivo(rs.getInt(1));
                    sol.setNombreArchivo(rs.getString(2));
                    sol.setExtension(rs.getString(3));
                    sol.setTamanio(rs.getDouble(4));
                    sol.setFechaCreacion(rs.getDate(5));
                    sol.setUrlDestino(rs.getString(6));
                    sol.setIdUsuario(rs.getInt(7));
                    response.add(sol);
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
    public Archivo encontrarId(int id) {
        Archivo response = null;
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "SELECT "
                        + "idArchivo, "
                        + "nombreArchivo, "
                        + "extension, "
                        + "tamanio, "
                        + "fechaCreacion, "
                        + "urlDestino, "
                        + "idUsuario "
                        + "FROM archivo"
                        + "WHERE idArchivo=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs;
                rs = ps.executeQuery();
                if (rs.next()) {
                    response = new Archivo();
                    response.setIdArchivo(rs.getInt(1));
                    response.setNombreArchivo(rs.getString(2));
                    response.setExtension(rs.getString(3));
                    response.setTamanio(rs.getDouble(4));
                    response.setFechaCreacion(rs.getDate(5));
                    response.setUrlDestino(rs.getString(6));
                    response.setIdUsuario(rs.getInt(7));
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
}
