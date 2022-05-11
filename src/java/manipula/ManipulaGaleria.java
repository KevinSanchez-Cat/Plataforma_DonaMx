package manipula;

import config.conexion.ConexionFactory;
import config.conexion.IConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Galeria;
import utils.GenericResponse;
import utils.Logg;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ManipulaGaleria implements Manipula<Galeria> {

    @Override
    public GenericResponse<Galeria> registrar(Galeria obj) {
        GenericResponse<Galeria> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "INSERT INTO Galeria ("
                        + "idUsuario, "
                        + "nombreImagen, "
                        + "tamanio, "
                        + "extension, "
                        + "urlDestino "
                        + ") VALUES (?,?,?,?,?)";
                PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                registro.setInt(1, obj.getIdUsuario());
                registro.setString(2, obj.getNombreImagen());
                registro.setDouble(3, obj.getTamanio());
                registro.setString(4, obj.getExtension());
                registro.setString(5, obj.getUrlDestino());
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
    public GenericResponse<Galeria> actualizar(int id) {
        GenericResponse<Galeria> response = new GenericResponse<>();
        response.setMensaje("Accion no implementada");
        response.setStatus(utils.Constantes.LOGIC_WARNING);
        response.setResponseObject(null);
        return response;
    }

    @Override
    public GenericResponse<Galeria> editar(int id, Galeria nvoObj) {
        GenericResponse<Galeria> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            Galeria obj = encontrarId(id);
            if (obj != null) {
                try {
                    String sql = "UPDATE Galeria SET "
                            + "idUsuario=?, "
                            + "nombreImagen=?, "
                            + "tamanio=?, "
                            + "extension=?, "
                            + "urlDestino=? "
                            + "WHERE idGaleria=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setInt(1, nvoObj.getIdUsuario());
                    registro.setString(2, nvoObj.getNombreImagen());
                    registro.setDouble(3, nvoObj.getTamanio());
                    registro.setString(4, nvoObj.getExtension());
                    registro.setString(5, nvoObj.getUrlDestino());
                    registro.setInt(6, id);
                    int r = registro.executeUpdate();
                    if (r > 0) {
                        nvoObj.setIdGaleria(id);
                        response.setStatus(utils.Constantes.STATUS_ACTUALIZACION_EXITOSA_BD);
                        response.setResponseObject(nvoObj);
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
    public GenericResponse<Galeria> eliminar(int id) {
        GenericResponse<Galeria> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            Galeria obj = encontrarId(id);
            if (obj != null) {
                try {
                    String sql = "DELETE FROM Galeria "
                            + "WHERE idGaleria=?";
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
    public List<Galeria> getData() {
        List<Galeria> response = new ArrayList<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "SELECT idGaleria, "
                        + "idUsuario, "
                        + "nombreImagen, "
                        + "tamanio, "
                        + "extension, "
                        + "urlDestino "
                        + "FROM Galeria";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    response.add(new Galeria(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6)));
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
    public List<Galeria> consultar(String... filtros) {
        List<Galeria> response = new ArrayList<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "SELECT "
                        + "idGaleria, "
                        + "idUsuario, "
                        + "nombreImagen, "
                        + "tamanio, "
                        + "extension, "
                        + "urlDestino "
                        + "FROM Galeria";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    response.add(new Galeria(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6)));
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
    public Galeria encontrarId(int id) {
        Galeria response = null;
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "SELECT "
                        + "idGaleria, "
                        + "idUsuario, "
                        + "nombreImagen, "
                        + "tamanio, "
                        + "extension, "
                        + "urlDestino "
                        + "FROM Galeria "
                        + "WHERE idGaleria=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs;
                rs = ps.executeQuery();
                if (rs.next()) {
                    response = new Galeria();
                    response.setIdGaleria(rs.getInt(1));
                    response.setIdUsuario(rs.getInt(2));
                    response.setNombreImagen(rs.getString(3));
                    response.setTamanio(rs.getDouble(4));
                    response.setExtension(rs.getString(5));
                    response.setUrlDestino(rs.getString(6));
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
