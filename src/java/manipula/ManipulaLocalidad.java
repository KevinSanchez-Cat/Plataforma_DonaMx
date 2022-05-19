package manipula;

import config.conexion.ConexionFactory;
import config.conexion.IConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Localidad;
import utils.GenericResponse;
import utils.Logg;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ManipulaLocalidad implements Manipula<Localidad> {

    @Override
    public GenericResponse<Localidad> registrar(IConexion conexionDB,Localidad obj) {
        GenericResponse<Localidad> response = new GenericResponse<>();
        
        if (conexionDB.getConexion()!=null) {
            try {
                String sql = "INSERT INTO Localidad ("
                        + "idMunicipio, "
                        + "localidad, "
                        + "codigoPostal "
                        + ") VALUES (?,?,?)";
                PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                registro.setInt(1, obj.getIdMunicipio());
                registro.setString(2, obj.getLocalidad());
                registro.setInt(3, obj.getCodigoPostal());
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
    public GenericResponse<Localidad> actualizar(IConexion conexionDB,int id) {
        GenericResponse<Localidad> response = new GenericResponse<>();
        response.setMensaje("Accion no implementada");
        response.setStatus(utils.Constantes.LOGIC_WARNING);
        response.setResponseObject(null);
        return response;
    }

    @Override
    public GenericResponse<Localidad> editar(IConexion conexionDB,int id, Localidad nvoObj) {
        GenericResponse<Localidad> response = new GenericResponse<>();
        
        if (conexionDB.getConexion()!=null) {
            Localidad obj = encontrarId(conexionDB,id);
            if (obj != null) {
                try {
                    String sql = "UPDATE Localidad SET "
                            + "idMunicipio=?, "
                            + "localidad=? "
                            + "codigoPostal=? "
                            + "WHERE idLocalidad=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setInt(1, nvoObj.getIdMunicipio());
                    registro.setString(2, nvoObj.getLocalidad());
                    registro.setInt(3, nvoObj.getCodigoPostal());
                    registro.setInt(4, id);
                    int r = registro.executeUpdate();
                    if (r > 0) {
                        obj.setIdMunicipio(id);
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
    public GenericResponse<Localidad> eliminar(IConexion conexionDB,int id) {
        GenericResponse<Localidad> response = new GenericResponse<>();
        
        if (conexionDB.getConexion()!=null) {
            Localidad obj = encontrarId(conexionDB,id);
            if (obj != null) {
                try {
                    String sql = "DELETE FROM Localidad "
                            + "WHERE idLocalidad=?";
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
    public List<Localidad> getData(IConexion conexionDB) {
        List<Localidad> response = new ArrayList<>();
        
        if (conexionDB.getConexion()!=null) {
            try {
                String sql = "SELECT "
                        + "idLocalidad, "
                        + "idMunicipio, "
                        + "localidad, "
                        + "codigoPostal "
                        + "FROM Localidad";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    response.add(new Localidad(rs.getInt(1), rs.getString(3), rs.getInt(4), rs.getInt(2)));
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
    public List<Localidad> consultar(IConexion conexionDB,String... filtros) {
        List<Localidad> response = new ArrayList<>();
        
        if (conexionDB.getConexion()!=null) {
            try {
                String sql = "SELECT "
                        + "idLocalidad, "
                        + "idMunicipio, "
                        + "localidad, "
                        + "codigoPostal "
                        + "FROM Localidad";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    response.add(new Localidad(rs.getInt(1), rs.getString(3), rs.getInt(4), rs.getInt(2)));
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
    public Localidad encontrarId(IConexion conexionDB,int id) {
        Localidad response = null;
        
        if (conexionDB.getConexion()!=null) {
            try {
                String sql = "SELECT "
                        + "idLocalidad, "
                        + "idMunicipio, "
                        + "localidad, "
                        + "codigoPostal "
                        + "FROM Localidad "
                        + "WHERE idLocalidad=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs;
                rs = ps.executeQuery();
                if (rs.next()) {
                    response = new Localidad();
                    response.setIdLocalidad(rs.getInt(1));
                    response.setIdMunicipio(rs.getInt(2));
                    response.setLocalidad(rs.getString(3));
                    response.setCodigoPostal(rs.getInt(4));
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
