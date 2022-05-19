package manipula;

import config.conexion.ConexionFactory;
import config.conexion.IConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Noticia;
import utils.GenericResponse;
import utils.Logg;
import utils.Misc;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ManipulaNoticia implements Manipula<Noticia> {

    @Override
    public GenericResponse<Noticia> registrar(IConexion conexionDB,Noticia obj) {
        GenericResponse<Noticia> response = new GenericResponse<>();
        
        if (conexionDB.getConexion()!=null) {
            try {
                String sql = "INSERT INTO Noticias ("
                        + "idUsusario, "
                        + "titulo, "
                        + "autor, "
                        + "detalle, "
                        + "fecha, "
                        + "imagen "
                        + ") VALUES (?,?,?,?,?,?)";
                PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                registro.setInt(1, obj.getIdUsuario());
                registro.setString(2, obj.getTitulo());
                registro.setString(3, obj.getAutor());
                registro.setString(4, obj.getDetalle());
                registro.setTimestamp(5, obj.getFecha());
                registro.setString(6, obj.getImagen());
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
    public GenericResponse<Noticia> actualizar(IConexion conexionDB,int id) {
        GenericResponse<Noticia> response = new GenericResponse<>();
        response.setMensaje("Accion no implementada");
        response.setStatus(utils.Constantes.LOGIC_WARNING);
        response.setResponseObject(null);
        return response;
    }

    @Override
    public GenericResponse<Noticia> editar(IConexion conexionDB,int id, Noticia obj) {
        GenericResponse<Noticia> response = new GenericResponse<>();
        response.setMensaje("Accion no implementada");
        response.setStatus(utils.Constantes.LOGIC_WARNING);
        response.setResponseObject(null);
        return response;
    }

    @Override
    public GenericResponse<Noticia> eliminar(IConexion conexionDB,int id) {
        GenericResponse<Noticia> response = new GenericResponse<>();
        
        if (conexionDB.getConexion()!=null) {
            Noticia obj = encontrarId(conexionDB,id);
            if (obj != null) {
                try {
                    String sql = "DELETE FROM Noticias "
                            + "WHERE idNoticias=?";
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
    public List<Noticia> getData(IConexion conexionDB) {
        List<Noticia> response = new ArrayList<>();
        
        if (conexionDB.getConexion()!=null) {
            try {
                String sql = "SELECT "
                        + "idNoticias, "
                        + "idUsusario, "
                        + "titulo, "
                        + "autor, "
                        + "detalle, "
                        + "fecha, "
                        + "imagen "
                        + "FROM Noticias";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    Noticia sol = new Noticia();
                    sol.setIdNoticia(rs.getInt(1));
                    sol.setIdUsuario(rs.getInt(2));
                    sol.setTitulo(rs.getString(3));
                    sol.setAutor(rs.getString(4));
                    sol.setDetalle(rs.getString(5));
                    sol.setFecha(rs.getTimestamp(6));
                    sol.setImagen(rs.getString(7));
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
    public List<Noticia> consultar(IConexion conexionDB,String... filtros) {
        List<Noticia> response = new ArrayList<>();

        return response;
    }

    @Override
    public Noticia encontrarId(IConexion conexionDB,int id) {
        Noticia response = null;
        
        if (conexionDB.getConexion()!=null) {
            try {
                String sql = "SELECT "
                        + "idNoticias, "
                        + "idUsusario, "
                        + "titulo, "
                        + "autor, "
                        + "detalle, "
                        + "fecha, "
                        + "imagen "
                        + "FROM Noticias "
                        + "WHERE idNoticias=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs;
                rs = ps.executeQuery();
                if (rs.next()) {

                    response = new Noticia();
                    response.setIdNoticia(rs.getInt(1));
                    response.setIdUsuario(rs.getInt(2));
                    response.setTitulo(rs.getString(3));
                    response.setAutor(rs.getString(4));
                    response.setDetalle(rs.getString(5));
                    response.setFecha(rs.getTimestamp(6));
                    response.setImagen(rs.getString(7));

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
