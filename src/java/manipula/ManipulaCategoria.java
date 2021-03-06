package manipula;

import config.conexion.ConexionFactory;
import config.conexion.IConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Categoria;
import model.RecursoTecnologico;
import utils.GenericResponse;
import utils.Logg;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ManipulaCategoria implements Manipula<Categoria> {

    @Override
    public GenericResponse<Categoria> registrar(IConexion conexionDB,Categoria obj) {
        GenericResponse<Categoria> response = new GenericResponse<>();
        
        if (conexionDB.getConexion()!=null) {
            try {
                String sql = "INSERT INTO Categoria ("
                        + "nombreCategoria, "
                        + "descripcion "
                        + ") VALUES (?,?)";
                PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                registro.setString(1, obj.getNombreCategoria());
                registro.setString(2, obj.getDescripcion());
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
    public GenericResponse<Categoria> actualizar(IConexion conexionDB,int id) {
        GenericResponse<Categoria> response = new GenericResponse<>();
        response.setMensaje("Accion no implementada");
        response.setStatus(utils.Constantes.LOGIC_WARNING);
        response.setResponseObject(null);
        return response;
    }

    @Override
    public GenericResponse<Categoria> editar(IConexion conexionDB,int id, Categoria nvoObj) {
        GenericResponse<Categoria> response = new GenericResponse<>();
        
        if (conexionDB.getConexion()!=null) {
            if (encontrarId(conexionDB,id) != null) {
                try {
                    String sql = "UPDATE Categoria SET "
                            + "nombreCategoria=?, "
                            + "descripcion=? "
                            + "WHERE idCategoria=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setString(1, nvoObj.getNombreCategoria());
                    registro.setString(2, nvoObj.getDescripcion());
                    registro.setInt(3, id);
                    int r = registro.executeUpdate();
                    if (r > 0) {
                        nvoObj.setIdCategoria(id);
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
    public GenericResponse<Categoria> eliminar(IConexion conexionDB,int id) {
        GenericResponse<Categoria> response = new GenericResponse<>();
        
        if (conexionDB.getConexion()!=null) {
            Categoria obj = encontrarId(conexionDB,id);
            if (obj != null) {
                try {
                    String sql = "DELETE FROM Categoria "
                            + "WHERE idCategoria=?";
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
    public List<Categoria> getData(IConexion conexionDB) {
        List<Categoria> response = new ArrayList<>();
        
        if (conexionDB.getConexion()!=null) {
            try {
                String sql = "SELECT "
                        + "idCategoria, "
                        + "nombreCategoria, "
                        + "descripcion "
                        + "FROM Categoria";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    response.add(new Categoria(rs.getInt(1), rs.getString(2), rs.getString(3)));
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
    public List<Categoria> consultar(IConexion conexionDB,String... filtros) {
        List<Categoria> response = new ArrayList<>();
        
        if (conexionDB.getConexion()!=null) {
            try {
                String sql = "SELECT "
                        + "idCategoria, "
                        + "nombreCategoria, "
                        + "descripcion "
                        + "FROM Categoria";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    response.add(new Categoria(rs.getInt(1), rs.getString(2), rs.getString(3)));
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
    public Categoria encontrarId(IConexion conexionDB,int id) {
        Categoria response = null;
        
        if (conexionDB.getConexion()!=null) {
            try {
                String sql = "SELECT "
                        + "idCategoria, "
                        + "nombreCategoria, "
                        + "descripcion "
                        + "FROM Categoria "
                        + "WHERE idCategoria=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs;
                rs = ps.executeQuery();
                if (rs.next()) {
                    response = new Categoria();
                    response.setIdCategoria(rs.getInt(1));
                    response.setNombreCategoria(rs.getString(2));
                    response.setDescripcion(rs.getString(3));
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

    public List<RecursoTecnologico> getLstRecursosTecnologicos(IConexion conexionDB,int idCategoria) {
        List<RecursoTecnologico> response = new ArrayList<>();
        
        if (conexionDB.getConexion()!=null) {
            try {
                String sql = "SELECT "
                        + "idRecursoTecnologico, "
                        + "idCategoria, "
                        + "idDonador, "
                        + "idUsuario, "
                        + "nombreRecurso, "
                        + "cantidadStock, "
                        + "autorizado, "
                        + "estadoPublicacion, "
                        + "estadoLogico, "
                        + "fechaPublicacion, "
                        + "fechaAutorizacion, "
                        + "remunerado, "
                        + "estadoCondicion, "
                        + "precioOriginal, "
                        + "precioEstimado, "
                        + "precioOfertado, "
                        + "organizacionOCivil, "
                        + "tipoSoftHard "
                        + "FROM RecursoTecnologico "
                        + "WHERE idCategoria=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setInt(1, idCategoria);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    RecursoTecnologico recurso = new RecursoTecnologico();
                    recurso.setIdRecursoTecnologico(rs.getInt(1));
                    recurso.setIdCategoria(rs.getInt(2));
                    recurso.setIdDonador(rs.getInt(3));
                    recurso.setIdUsuario(rs.getInt(4));
                    recurso.setNombreRecurso(rs.getString(5));
                    recurso.setCantidadStock(rs.getInt(6));
                    recurso.setAutorizado(rs.getString(7));
                    recurso.setEstadoPublicacion(rs.getString(8));
                    recurso.setEstadoLogico(rs.getInt(9));
                    recurso.setFechaPublicacion(rs.getTimestamp(10));
                    recurso.setFechaAutorizacion(rs.getTimestamp(11));
                    recurso.setRemunerado(rs.getInt(12));
                    recurso.setEstadoCondicion(rs.getString(13));
                    recurso.setPrecioOriginal(rs.getDouble(14));
                    recurso.setPrecioEstimado(rs.getDouble(15));
                    recurso.setPrecioOriginal(rs.getDouble(16));
                    recurso.setOrganizacionOCivil(rs.getString(17));
                    recurso.setTipoSoftwarOHardware(rs.getString(18));
                    response.add(recurso);
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
