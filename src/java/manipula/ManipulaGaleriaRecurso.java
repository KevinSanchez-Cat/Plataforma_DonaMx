package manipula;

import config.conexion.ConexionFactory;
import config.conexion.IConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Galeria;
import model.GaleriaRecurso;
import utils.GenericResponse;
import utils.Logg;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ManipulaGaleriaRecurso implements Manipula<GaleriaRecurso> {

    @Override
    public GenericResponse<GaleriaRecurso> registrar(GaleriaRecurso obj) {
        GenericResponse<GaleriaRecurso> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "INSERT INTO GaleriaRecursos ("
                        + "idRecurso, "
                        + "nombreImagen, "
                        + "tamanio, "
                        + "extension, "
                        + "urlDestino "
                        + ") VALUES (?,?,?,?,?)";
                PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                registro.setInt(1, obj.getIdRecurso());
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
    public GenericResponse<GaleriaRecurso> actualizar(int id) {
        GenericResponse<GaleriaRecurso> response = new GenericResponse<>();
        response.setMensaje("Accion no implementada");
        response.setStatus(utils.Constantes.LOGIC_WARNING);
        response.setResponseObject(null);
        return response;
    }

    @Override
    public GenericResponse<GaleriaRecurso> editar(int id, GaleriaRecurso nvoObj) {
        GenericResponse<GaleriaRecurso> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            GaleriaRecurso obj = encontrarId(id);
            if (obj != null) {
                try {
                    String sql = "UPDATE GaleriaRecursos SET "
                            + "idRecurso=?, "
                            + "nombreImagen=?, "
                            + "tamanio=?, "
                            + "extension=?, "
                            + "urlDestino=? "
                            + "WHERE idGaleriaRecursos=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setInt(1, nvoObj.getIdGaleriaRecursos());
                    registro.setString(2, nvoObj.getNombreImagen());
                    registro.setDouble(3, nvoObj.getTamanio());
                    registro.setString(4, nvoObj.getExtension());
                    registro.setString(5, nvoObj.getUrlDestino());
                    registro.setInt(6, id);
                    int r = registro.executeUpdate();
                    if (r > 0) {
                        nvoObj.setIdGaleriaRecursos(id);
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
    public GenericResponse<GaleriaRecurso> eliminar(int id) {
        GenericResponse<GaleriaRecurso> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            GaleriaRecurso obj = encontrarId(id);
            if (obj != null) {
                try {
                    String sql = "DELETE FROM GaleriaRecursos "
                            + "WHERE idGaleriaRecursos=?";
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
    public List<GaleriaRecurso> getData() {
        List<GaleriaRecurso> response = new ArrayList<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "SELECT idGaleriaRecursos, "
                        + "idRecurso, "
                        + "nombreImagen, "
                        + "tamanio, "
                        + "extension, "
                        + "urlDestino "
                        + "FROM GaleriaRecursos ";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    response.add(new GaleriaRecurso(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6)));
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
    public List<GaleriaRecurso> consultar(String... filtros) {
        List<GaleriaRecurso> response = new ArrayList<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "SELECT "
                        + "idGaleriaRecursos, "
                        + "idRecurso, "
                        + "nombreImagen, "
                        + "tamanio, "
                        + "extension, "
                        + "urlDestino "
                        + "FROM GaleriaRecursos";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    response.add(new GaleriaRecurso(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6)));
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
    public GaleriaRecurso encontrarId(int id) {
        GaleriaRecurso response = null;
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "SELECT "
                        + "idGaleriaRecursos, "
                        + "idRecurso, "
                        + "nombreImagen, "
                        + "tamanio, "
                        + "extension, "
                        + "urlDestino "
                        + "FROM GaleriaRecursos  "
                        + "WHERE idGaleriaRecursos=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs;
                rs = ps.executeQuery();
                if (rs.next()) {
                    response = new GaleriaRecurso();
                    response.setIdGaleriaRecursos(rs.getInt(1));
                    response.setIdRecurso(rs.getInt(2));
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
