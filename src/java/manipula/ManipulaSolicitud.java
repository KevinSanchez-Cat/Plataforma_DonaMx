package manipula;

import config.conexion.ConexionFactory;
import config.conexion.IConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Solicitud;
import utils.GenericResponse;
import utils.Logg;
import utils.Misc;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ManipulaSolicitud implements Manipula<Solicitud> {
    @Override
    public GenericResponse<Solicitud> registrar(Solicitud obj) {
        GenericResponse<Solicitud> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "INSERT INTO Solicitud ("
                        + "idUsuario, "
                        + "idRecurso, "
                        + "idArchivo, "
                        + "estadoSolicitud, "
                        + "fechaSolicitud, "
                        + "fechaRespuesta "
                        + ") VALUES (?,?,?,?,?,?)";
                PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                registro.setInt(1, obj.getIdUsuario());
                registro.setInt(2, obj.getIdRecursoTecnologico());
                registro.setInt(3, obj.getIdArchivo());
                registro.setString(4, obj.getEstadoSolicitud());
                registro.setDate(5, Misc.transformDateTimeJavaSql(obj.getFechaSolicitud()));
                registro.setDate(6, Misc.transformDateTimeJavaSql(obj.getFechaRespuesta()));
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
    public GenericResponse<Solicitud> actualizar(int id) {
        GenericResponse<Solicitud> response = new GenericResponse<>();
        response.setMensaje("Accion no implementada");
        response.setStatus(utils.Constantes.LOGIC_WARNING);
        response.setResponseObject(null);
        return response;
    }

    public GenericResponse<Solicitud> actualizar(int id, java.util.Date fechaRespuesta, String estadoSolicitud) {
        GenericResponse<Solicitud> response = new GenericResponse<>();
          IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            Solicitud sol=encontrarId(id);
            if (sol != null) {
                //AC->ACEPTADA
                //RE->RECHAZADA
                //FI->FINALIZADA
                //PE->PENDIENTE
                //CA->CANCELADA
                sol.setEstadoSolicitud(estadoSolicitud);
                sol.setFechaRespuesta(fechaRespuesta);
                
                try {
                    String sql = "UPDATE Solicitud SET "
                            + "estadoSolicitud=?, "
                            + "fechaRespuesta=? "
                            + "WHERE idSolicitud=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setString(1, sol.getEstadoSolicitud());
                    registro.setDate(2, Misc.transformDateTimeJavaSql(sol.getFechaRespuesta()));
                    registro.setInt(3, id);
                    int r = registro.executeUpdate();
                    if (r > 0) {
                        response.setStatus(utils.Constantes.STATUS_ACTUALIZACION_EXITOSA_BD);
                        response.setResponseObject(sol);
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
    public GenericResponse<Solicitud> editar(int id, Solicitud nvoObj) {
        GenericResponse<Solicitud> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (encontrarId(id) != null) {
                try {
                    String sql = "UPDATE Solicitud SET "
                            + "idUsuario=?, "
                            + "idRecurso=?, "
                            + "idArchivo=?, "
                            + "estadoSolicitud=?, "
                            + "fechaSolicitud=?, "
                            + "fechaRespuesta=? "
                            + "WHERE idSolicitud=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setInt(1, nvoObj.getIdUsuario());
                    registro.setInt(2, nvoObj.getIdRecursoTecnologico());
                    registro.setInt(3, nvoObj.getIdArchivo());
                    registro.setString(4, nvoObj.getEstadoSolicitud());
                    registro.setDate(5, Misc.transformDateTimeJavaSql(nvoObj.getFechaSolicitud()));
                    registro.setDate(6, Misc.transformDateTimeJavaSql(nvoObj.getFechaRespuesta()));
                    registro.setInt(7, id);
                    int r = registro.executeUpdate();
                    if (r > 0) {
                        nvoObj.setIdSolicitud(id);
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
    public GenericResponse<Solicitud> eliminar(int id) {
        GenericResponse<Solicitud> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            Solicitud obj = encontrarId(id);
            if (obj != null) {
                try {
                    String sql = "DELETE FROM Solicitud "
                            + "WHERE idSolicitud=?";
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
    public List<Solicitud> getData() {
        List<Solicitud> response = new ArrayList<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "SELECT "
                        + "idSolicitud, "
                        + "idUsuario, "
                        + "idRecurso, "
                        + "idArchivo, "
                        + "estadoSolicitud, "
                        + "fechaSolicitud, "
                        + "fechaRespuesta "
                        + "FROM Solicitud";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    Solicitud sol = new Solicitud();
                    sol.setIdSolicitud(rs.getInt(1));
                    sol.setIdUsuario(rs.getInt(2));
                    sol.setIdRecursoTecnologico(rs.getInt(3));
                    sol.setIdArchivo(rs.getInt(4));
                    sol.setEstadoSolicitud(rs.getString(5));
                    sol.setFechaSolicitud(Misc.transformDateTimeSqlJava(rs.getDate(6)));
                    sol.setFechaRespuesta(Misc.transformDateTimeSqlJava(rs.getDate(7)));
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
    public List<Solicitud> consultar(String... filtros) {
        List<Solicitud> response = new ArrayList<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "SELECT "
                        + "idSolicitud, "
                        + "idUsuario, "
                        + "idRecurso, "
                        + "idArchivo, "
                        + "estadoSolicitud, "
                        + "fechaSolicitud, "
                        + "fechaRespuesta "
                        + "FROM Solicitud";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    Solicitud sol = new Solicitud();
                    sol.setIdSolicitud(rs.getInt(1));
                    sol.setIdUsuario(rs.getInt(2));
                    sol.setIdRecursoTecnologico(rs.getInt(3));
                    sol.setIdArchivo(rs.getInt(4));
                    sol.setEstadoSolicitud(rs.getString(5));
                    sol.setFechaSolicitud(Misc.transformDateTimeSqlJava(rs.getDate(6)));
                    sol.setFechaRespuesta(Misc.transformDateTimeSqlJava(rs.getDate(7)));
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
    public Solicitud encontrarId(int id) {
        Solicitud response = null;
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "SELECT "
                        + "idSolicitud, "
                        + "idUsuario, "
                        + "idRecurso, "
                        + "idArchivo, "
                        + "estadoSolicitud, "
                        + "fechaSolicitud, "
                        + "fechaRespuesta "
                        + "FROM Solicitud "
                        + "WHERE idSolicitud=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs;
                rs = ps.executeQuery();
                if (rs.next()) {
                    response = new Solicitud();
                    response.setIdSolicitud(rs.getInt(1));
                    response.setIdUsuario(rs.getInt(2));
                    response.setIdRecursoTecnologico(rs.getInt(3));
                    response.setIdArchivo(rs.getInt(4));
                    response.setEstadoSolicitud(rs.getString(5));
                    response.setFechaSolicitud(Misc.transformDateTimeSqlJava(rs.getDate(6)));
                    response.setFechaRespuesta(Misc.transformDateTimeSqlJava(rs.getDate(7)));
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
