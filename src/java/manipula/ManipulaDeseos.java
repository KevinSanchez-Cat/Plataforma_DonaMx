package manipula;

import config.conexion.ConexionFactory;
import config.conexion.IConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Deseo;
import utils.GenericResponse;
import utils.Logg;
import utils.Misc;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ManipulaDeseos implements Manipula<Deseo> {

    @Override
    public GenericResponse<Deseo> registrar(IConexion conexionDB,Deseo obj) {
        GenericResponse<Deseo> response = new GenericResponse<>();
        
        if (conexionDB.getConexion()!=null) {
            try {

                String sql = "INSERT INTO Deseo ("
                        + "idRecurso, "
                        + "idEstudiante, "
                        + "fecha "
                        + ") VALUES (?,?,?)";
                PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                registro.setInt(1, obj.getIdRecurso());
                registro.setInt(2, obj.getIdEstudiante());
                registro.setTimestamp(3, obj.getFecha());
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
    public GenericResponse<Deseo> actualizar(IConexion conexionDB,int id) {
        GenericResponse<Deseo> response = new GenericResponse<>();
        response.setMensaje("Accion no implementada");
        response.setStatus(utils.Constantes.LOGIC_WARNING);
        response.setResponseObject(null);
        return response;
    }

    @Override
    public GenericResponse<Deseo> editar(IConexion conexionDB,int id, Deseo nvoObj) {
        GenericResponse<Deseo> response = new GenericResponse<>();
        response.setMensaje("Accion no implementada");
        response.setStatus(utils.Constantes.LOGIC_WARNING);
        response.setResponseObject(null);
        return response;
    }

    @Override
    public GenericResponse<Deseo> eliminar(IConexion conexionDB,int id) {
        GenericResponse<Deseo> response = new GenericResponse<>();
        
        if (conexionDB.getConexion()!=null) {
            Deseo obj = encontrarId(conexionDB,id);
            if (obj != null) {
                try {
                    String sql = "DELETE FROM Deseo "
                            + "WHERE idItem=?";
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
    public List<Deseo> getData(IConexion conexionDB) {
        List<Deseo> response = new ArrayList<>();
        
        if (conexionDB.getConexion()!=null) {
            try {
                String sql = "SELECT "
                        + "idItem, "
                        + "idRecurso, "
                        + "idEstudiante, "
                        + "fecha "
                        + "FROM Deseo";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    Deseo sol = new Deseo();
                    sol.setIdItem(rs.getInt(1));
                    sol.setIdRecurso(rs.getInt(2));
                    sol.setIdEstudiante(rs.getInt(3));
                    sol.setFecha(rs.getTimestamp(4));
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
    public List<Deseo> consultar(IConexion conexionDB,String... filtros) {
        List<Deseo> response = new ArrayList<>();
        
        if (conexionDB.getConexion()!=null) {
            try {
                String sql = "SELECT "
                        + "idItem, "
                        + "idRecurso, "
                        + "idEstudiante, "
                        + "fecha "
                        + "FROM Deseo";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    Deseo sol = new Deseo();
                    sol.setIdItem(rs.getInt(1));
                    sol.setIdRecurso(rs.getInt(2));
                    sol.setIdEstudiante(rs.getInt(3));
                    sol.setFecha(rs.getTimestamp(4));
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
    public Deseo encontrarId(IConexion conexionDB,int id) {
        Deseo response = null;
        
        if (conexionDB.getConexion()!=null) {
            try {
                String sql = "SELECT "
                        + "idItem, "
                        + "idRecurso, "
                        + "idEstudiante, "
                        + "fecha "
                        + "FROM Deseo "
                        + "WHERE idItem=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs;
                rs = ps.executeQuery();
                if (rs.next()) {
                    response = new Deseo();
                    response.setIdItem(rs.getInt(1));
                    response.setIdRecurso(rs.getInt(2));
                    response.setIdEstudiante(rs.getInt(3));
                    response.setFecha(rs.getTimestamp(4));
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
