package manipula;

import config.conexion.ConexionFactory;
import config.conexion.IConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.SistemaOperativo;
import utils.GenericResponse;
import utils.Logg;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ManipulaSistemaOperativo implements Manipula<SistemaOperativo> {
    @Override
    public GenericResponse<SistemaOperativo> registrar(IConexion conexionDB,SistemaOperativo obj) {
        GenericResponse<SistemaOperativo> response = new GenericResponse<>();
        
        if (conexionDB.getConexion()!=null) {
            try {
                String sql = "INSERT INTO SistemaOperativo ("
                        + "sistemaOperativo,"
                        + "version, "
                        + "edicion, "
                        + "tipo "
                        + ") VALUES (?,?,?,?)";
                PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                registro.setString(1, obj.getSistemaOperativo());
                registro.setString(2, obj.getVersion());
                registro.setString(3, obj.getEdicion());
                registro.setString(4, obj.getTipo());
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
    public GenericResponse<SistemaOperativo> actualizar(IConexion conexionDB,int id) {
        GenericResponse<SistemaOperativo> response = new GenericResponse<>();
        response.setMensaje("Accion no implementada");
        response.setStatus(utils.Constantes.LOGIC_WARNING);
        response.setResponseObject(null);
        return response;
    }

    @Override
    public GenericResponse<SistemaOperativo> editar(IConexion conexionDB,int id, SistemaOperativo nvoObj) {
        GenericResponse<SistemaOperativo> response = new GenericResponse<>();
        
        if (conexionDB.getConexion()!=null) {
            if (encontrarId(conexionDB,id) != null) {
                try {
                    String sql = "UPDATE SistemaOperativo SET "
                            + "sistemaOperativo=?, "
                            + "version=?, "
                            + "edicion=?, "
                            + "tipo=? "
                            + "WHERE idSistemaOperativo=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setString(1, nvoObj.getSistemaOperativo());
                    registro.setString(2, nvoObj.getVersion());
                    registro.setString(3, nvoObj.getEdicion());
                    registro.setString(4, nvoObj.getTipo());
                    registro.setInt(5, id);
                    int r = registro.executeUpdate();
                    if (r > 0) {
                        nvoObj.setIdSistemaOperativo(id);
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
    public GenericResponse<SistemaOperativo> eliminar(IConexion conexionDB,int id) {
        GenericResponse<SistemaOperativo> response = new GenericResponse<>();
        
        if (conexionDB.getConexion()!=null) {
            SistemaOperativo obj = encontrarId(conexionDB,id);
            if (obj != null) {
                try {
                    String sql = "DELETE FROM SistemaOperativo "
                            + "WHERE idSistemaOperativo=?";
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
    public List<SistemaOperativo> getData(IConexion conexionDB) {
        List<SistemaOperativo> response = new ArrayList<>();
        
        if (conexionDB.getConexion()!=null) {
            try {
                String sql = "SELECT "
                        + "idSistemaOperativo, "
                        + "sistemaOperativo, "
                        + "version, "
                        + "edicion, "
                        + "tipo "
                        + "FROM SistemaOperativo";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    response.add(new SistemaOperativo(rs.getInt(1), 
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5)
                    ));
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
    public List<SistemaOperativo> consultar(IConexion conexionDB,String... filtros) {
        List<SistemaOperativo> response = new ArrayList<>();
        
        if (conexionDB.getConexion()!=null) {
            try {
                String sql = "SELECT idSistemaOperativo, "
                        + "sistemaOperativo, "
                        + "version, "
                        + "edicion, "
                        + "tipo "
                        + "FROM SistemaOperativo";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    response.add(new SistemaOperativo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5)));
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
    public SistemaOperativo encontrarId(IConexion conexionDB,int id) {
        SistemaOperativo response = null;
        
        if (conexionDB.getConexion()!=null) {
            try {
                String sql = "SELECT idSistemaOperativo, "
                        + "sistemaOperativo, "
                        + "version, "
                        + "edicion, "
                        + "tipo "
                        + "FROM SistemaOperativo "
                        + "WHERE idSistemaOperativo=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs;
                rs = ps.executeQuery();
                if (rs.next()) {
                    response = new SistemaOperativo();
                    response.setIdSistemaOperativo(rs.getInt(1));
                    response.setSistemaOperativo(rs.getString(2));
                    response.setVersion(rs.getString(3));
                    response.setEdicion(rs.getString(4));
                    response.setTipo(rs.getString(5));
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
