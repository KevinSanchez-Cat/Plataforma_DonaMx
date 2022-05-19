package manipula;

import config.conexion.ConexionFactory;
import config.conexion.IConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
    public GenericResponse<Solicitud> registrar(IConexion conexionDB,Solicitud obj) {
        GenericResponse<Solicitud> response = new GenericResponse<>();
        
        if (conexionDB.getConexion()!=null) {
            try {
                String sql = "INSERT INTO Solicitud ("
                        + "idUsuario, "
                        + "idRecurso, "
                        + "estadoSolicitud, "
                        + "fechaSolicitud, "
                        + "fechaRespuesta, "
                        + "idUsuarioDonador "
                        + ") VALUES (?,?,?,?,?,?)";
                PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                registro.setInt(1, obj.getIdUsuarioDonatario());
                registro.setInt(2, obj.getIdRecursoTecnologico());
                registro.setString(3, obj.getEstadoSolicitud());
                registro.setTimestamp(4, obj.getFechaSolicitud());
                registro.setTimestamp(5, obj.getFechaRespuesta());
                registro.setInt(6, obj.getIdUsuarioDonador());
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
    public GenericResponse<Solicitud> actualizar(IConexion conexionDB,int id) {
        GenericResponse<Solicitud> response = new GenericResponse<>();
        response.setMensaje("Accion no implementada");
        response.setStatus(utils.Constantes.LOGIC_WARNING);
        response.setResponseObject(null);
        return response;
    }

    public GenericResponse<Solicitud> actualizar(IConexion conexionDB,int id, Timestamp fechaRespuesta, String estadoSolicitud) {
        GenericResponse<Solicitud> response = new GenericResponse<>();
        
        if (conexionDB.getConexion()!=null) {
            Solicitud sol = encontrarId(conexionDB,id);
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
                    registro.setTimestamp(2, sol.getFechaRespuesta());
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
    public GenericResponse<Solicitud> editar(IConexion conexionDB,int id, Solicitud nvoObj) {
        GenericResponse<Solicitud> response = new GenericResponse<>();
        
        if (conexionDB.getConexion()!=null) {
            if (encontrarId(conexionDB,id) != null) {
                try {
                    String sql = "UPDATE Solicitud SET "
                            + "idUsuario=?, "
                            + "idRecurso=?, "
                            + "estadoSolicitud=?, "
                            + "fechaSolicitud=?, "
                            + "fechaRespuesta=?, "
                            + "idUsuarioDonador=? "
                            + "WHERE idSolicitud=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setInt(1, nvoObj.getIdUsuarioDonatario());
                    registro.setInt(2, nvoObj.getIdRecursoTecnologico());
                    registro.setString(3, nvoObj.getEstadoSolicitud());
                    registro.setTimestamp(4, nvoObj.getFechaSolicitud());
                    registro.setTimestamp(5, nvoObj.getFechaRespuesta());
                    registro.setInt(6, nvoObj.getIdUsuarioDonador());
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
    public GenericResponse<Solicitud> eliminar(IConexion conexionDB,int id) {
        GenericResponse<Solicitud> response = new GenericResponse<>();
        
        if (conexionDB.getConexion()!=null) {
            Solicitud obj = encontrarId(conexionDB,id);
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
    public List<Solicitud> getData(IConexion conexionDB) {
        List<Solicitud> response = new ArrayList<>();
        
        if (conexionDB.getConexion()!=null) {
            try {
                String sql = "SELECT "
                        + "idSolicitud, "
                        + "idUsuario, "
                        + "idRecurso, "
                        + "estadoSolicitud, "
                        + "fechaSolicitud, "
                        + "fechaRespuesta, "
                        + "idUsuarioDonador "
                        + "FROM Solicitud";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    Solicitud sol = new Solicitud();
                    sol.setIdSolicitud(rs.getInt(1));
                    sol.setIdUsuarioDonatario(rs.getInt(2));
                    sol.setIdRecursoTecnologico(rs.getInt(3));
                    sol.setEstadoSolicitud(rs.getString(4));
                    sol.setFechaSolicitud(rs.getTimestamp(5));
                    sol.setFechaRespuesta(rs.getTimestamp(6));
                    sol.setIdUsuarioDonador(rs.getInt(7));
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
    public List<Solicitud> consultar(IConexion conexionDB,String... filtros) {
        List<Solicitud> response = new ArrayList<>();
        
        if (conexionDB.getConexion()!=null) {
            try {
                String sql = "SELECT "
                        + "idSolicitud, "
                        + "idUsuario, "
                        + "idRecurso, "
                        + "estadoSolicitud, "
                        + "fechaSolicitud, "
                        + "fechaRespuesta, "
                        + "idUsuarioDonador "
                        + "FROM Solicitud";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    Solicitud sol = new Solicitud();
                    sol.setIdSolicitud(rs.getInt(1));
                    sol.setIdUsuarioDonatario(rs.getInt(2));
                    sol.setIdRecursoTecnologico(rs.getInt(3));
                    sol.setEstadoSolicitud(rs.getString(4));
                    sol.setFechaSolicitud(rs.getTimestamp(5));
                    sol.setFechaRespuesta(rs.getTimestamp(6));
                    sol.setIdUsuarioDonador(rs.getInt(7));
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
    public Solicitud encontrarId(IConexion conexionDB,int id) {
        Solicitud response = null;
        
        if (conexionDB.getConexion()!=null) {
            try {
                String sql = "SELECT "
                        + "idSolicitud, "
                        + "idUsuario, "
                        + "idRecurso, "
                        + "estadoSolicitud, "
                        + "fechaSolicitud, "
                        + "fechaRespuesta, "
                        + "idUsuarioDonador "
                        + "FROM Solicitud "
                        + "WHERE idSolicitud=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs;
                rs = ps.executeQuery();
                if (rs.next()) {
                    response = new Solicitud();
                    response.setIdSolicitud(rs.getInt(1));
                    response.setIdUsuarioDonatario(rs.getInt(2));
                    response.setIdRecursoTecnologico(rs.getInt(3));
                    response.setEstadoSolicitud(rs.getString(4));
                    response.setFechaSolicitud(rs.getTimestamp(5));
                    response.setFechaRespuesta(rs.getTimestamp(6));
                    response.setIdUsuarioDonador(rs.getInt(7));
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
