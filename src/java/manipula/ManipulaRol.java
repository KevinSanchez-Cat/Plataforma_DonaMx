package manipula;

import config.conexion.ConexionFactory;
import config.conexion.IConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Rol;
import utils.GenericResponse;
import utils.Logg;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ManipulaRol implements Manipula<Rol> {

    @Override
    public GenericResponse<Rol> registrar(Rol obj) {
        GenericResponse<Rol> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {

            try {
                String sql = "INSERT INTO rol ("
                        + "rol"
                        + ") VALUES (?)";
                PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                registro.setString(1, obj.getRol());

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
    public GenericResponse<Rol> actualizar(int id) {
        GenericResponse<Rol> response = new GenericResponse<>();
        response.setMensaje("Accion no implementada");
        response.setStatus(utils.Constantes.LOGIC_WARNING);
        response.setResponseObject(null);
        return response;
    }

    @Override
    public GenericResponse<Rol> editar(int id, Rol nvoObj) {
        GenericResponse<Rol> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {

            Rol obj = encontrarId(id);
            if (obj != null) {
                try {
                    String sql = "UPDATE rol SET "
                            + "rol=? "
                            + "WHERE idRol=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);

                    registro.setString(1, nvoObj.getRol());
                    registro.setInt(2, id);

                    int r = registro.executeUpdate();
                    if (r > 0) {
                        obj.setRol(nvoObj.getRol());
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
    public GenericResponse<Rol> eliminar(int id) {
        GenericResponse<Rol> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            Rol obj = encontrarId(id);
            if (obj != null) {
                try {
                    String sql = "DELETE FROM rol "
                            + "WHERE idRol=?";
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
    public List<Rol> getData() {
        List<Rol> response = new ArrayList<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {

            try {
                String sql = "SELECT "
                        + "idRol, "
                        + "rol "
                        + "FROM rol";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();

                while (rs.next()) {
                    response.add(new Rol(rs.getInt(1), rs.getString(2)));
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
    public List<Rol> consultar(String... filtros) {
        List<Rol> response = new ArrayList<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");

        if (conexionDB.conectar() == 1) {

            try {
                String sql = "SELECT "
                        + "idRol, "
                        + "rol "
                        + "FROM rol";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    response.add(new Rol(rs.getInt(1), rs.getString(2)));
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
    public Rol encontrarId(int id) {
        Rol response = null;
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "SELECT "
                        + "idRol, "
                        + "rol "
                        + "FROM rol "
                        + "WHERE idRol=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setInt(1, id);

                ResultSet rs;
                rs = ps.executeQuery();
                if (rs.next()) {
                    response = new Rol();
                    response.setIdRol(rs.getInt(1));
                    response.setRol(rs.getString(2));
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
