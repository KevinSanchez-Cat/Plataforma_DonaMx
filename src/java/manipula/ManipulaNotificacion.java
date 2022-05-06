package manipula;

import config.conexion.ConexionFactory;
import config.conexion.IConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Notificacion;
import utils.GenericResponse;
import utils.Logg;
import utils.Misc;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ManipulaNotificacion implements Manipula<Notificacion> {

    @Override
    public GenericResponse<Notificacion> registrar(Notificacion obj) {
        GenericResponse<Notificacion> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "INSERT INTO Notificacion ("
                        + "idUsuarioDestino, "
                        + "fechaNotificacion, "
                        + "estadoVisualizacion, "
                        + "prioridad, "
                        + "mensaje "
                        + ") VALUES (?,?,?,?,?)";
                PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                registro.setInt(1, obj.getIdUsuarioDestino());
                registro.setDate(2, Misc.transformDateTimeJavaSql(obj.getFechaNotificacion()));
                registro.setString(3, obj.getEstadoVisualizacion());
                registro.setString(4, obj.getPrioridad());
                registro.setString(5, obj.getMensaje());
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
    public GenericResponse<Notificacion> actualizar(int id) {
        GenericResponse<Notificacion> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            Notificacion obj = encontrarId(id);
            if (obj != null) {
                switch (obj.getEstadoVisualizacion()) {
                    case "Re":
                        obj.setEstadoVisualizacion("Vi");
                        break;
                    case "Vi":
                        break;
                    default:
                        obj.setEstadoVisualizacion("Re");
                        break;
                }

                try {
                    String sql = "UPDATE Notificacion SET "
                            + "estadoVisualizacion=? "
                            + "WHERE idNotificacion=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setString(1, obj.getEstadoVisualizacion());
                    registro.setInt(2, id);
                    int r = registro.executeUpdate();
                    if (r > 0) {
                        response.setStatus(utils.Constantes.STATUS_ACTUALIZACION_EXITOSA_BD);
                        response.setResponseObject(obj);
                        response.setMensaje("Edición exitosa en la base de datos");
                    } else {
                        response.setStatus(utils.Constantes.STATUS_ACTUALIZACION_FALLIDA_BD);
                        response.setResponseObject(null);
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
    public GenericResponse<Notificacion> editar(int id, Notificacion nvoObj) {
        GenericResponse<Notificacion> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (encontrarId(id) != null) {
                try {
                    String sql = "UPDATE Notificacion SET "
                            + "idUsuarioDestino=?, "
                            + "fechaNotificacion=?, "
                            + "estadoVisualizacion=? "
                            + "prioridad=?, "
                            + "mensaje=? "
                            + "WHERE idNotificacion=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setInt(1, nvoObj.getIdUsuarioDestino());
                    registro.setDate(2, Misc.transformDateTimeJavaSql(nvoObj.getFechaNotificacion()));
                    registro.setString(3, nvoObj.getEstadoVisualizacion());
                    registro.setString(4, nvoObj.getPrioridad());
                    registro.setString(5, nvoObj.getMensaje());
                    registro.setInt(6, id);
                    int r = registro.executeUpdate();
                    if (r > 0) {
                        nvoObj.setIdNotificacion(id);
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
    public GenericResponse<Notificacion> eliminar(int id) {
        GenericResponse<Notificacion> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            Notificacion obj = encontrarId(id);
            if (obj != null) {
                try {
                    String sql = "DELETE FROM Notificacion "
                            + "WHERE idNotificacion=?";
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
    public List<Notificacion> getData() {
        List<Notificacion> response = new ArrayList<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "SELECT "
                        + "idNotificacion, "
                        + "idUsuario, "
                        + "fechaNotificacion, "
                        + "estadoVisualizacion, "
                        + "prioridad, "
                        + "mensaje "
                        + "FROM Notificacion";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    response.add(new Notificacion(rs.getInt(1),
                            rs.getInt(2),
                            Misc.transformDateTimeSqlJava(rs.getDate(3)),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6)));
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
    public List<Notificacion> consultar(String... filtros) {
        List<Notificacion> response = new ArrayList<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "SELECT "
                        + "idNotificacion, "
                        + "idUsuario, "
                        + "fechaNotificacion, "
                        + "estadoVisualizacion, "
                        + "prioridad, "
                        + "mensaje "
                        + "FROM Notificacion";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    response.add(new Notificacion(rs.getInt(1), rs.getInt(2), Misc.transformDateTimeSqlJava(rs.getDate(3)), rs.getString(4), rs.getString(5), rs.getString(6)));
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
    public Notificacion encontrarId(int id) {
        Notificacion response = null;
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "SELECT "
                        + "idNotificacion, "
                        + "idUsuario, "
                        + "fechaNotificacion, "
                        + "estadoVisualizacion, "
                        + "prioridad, "
                        + "mensaje "
                        + "FROM Notificacion "
                        + "WHERE idNotificacion=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs;
                rs = ps.executeQuery();
                if (rs.next()) {
                    response = new Notificacion();
                    response.setIdNotificacion(rs.getInt(1));
                    response.setIdUsuarioDestino(rs.getInt(2));
                    response.setFechaNotificacion(Misc.transformDateTimeSqlJava(rs.getDate(3)));
                    response.setEstadoVisualizacion(rs.getString(4));
                    response.setPrioridad(rs.getString(5));
                    response.setMensaje(rs.getString(6));
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
