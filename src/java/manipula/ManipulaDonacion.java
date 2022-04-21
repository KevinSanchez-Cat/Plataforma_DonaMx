package manipula;

import config.conexion.ConexionFactory;
import config.conexion.IConexion;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Donacion;
import utils.GenericResponse;
import utils.Logg;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ManipulaDonacion implements Manipula<Donacion> {

    @Override
    public GenericResponse<Donacion> registrar(Donacion obj) {
        GenericResponse<Donacion> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "INSERT INTO donacion ("
                        + "idDonador, "
                        + "idDonatario, "
                        + "idArchivo, "
                        + "idRecurso, "
                        + "fechaDonacion, "
                        + "estadoDonacion, "
                        + "noConfirmacion, "
                        + "remunerado "
                        + ") VALUES (?,?,?,?,?,?,?,?)";
                PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                registro.setInt(1, obj.getIdDonador());
                registro.setInt(2, obj.getIdDonatario());
                registro.setInt(3, obj.getIdArchivo());
                registro.setInt(4, obj.getIdRecursoTecnologico());
                registro.setDate(5, (Date) obj.getFechaDonacion());
                registro.setString(6, obj.getEstadoDonacion());
                registro.setString(7, obj.getNoConfirmacion());
                registro.setBoolean(8, obj.getRemunerado());
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
    public GenericResponse<Donacion> actualizar(int id) {
        GenericResponse<Donacion> response = new GenericResponse<>();
        //NoConfirmacion,EstadoDonacion,IDArchivo
        return response;
    }

    @Override
    public GenericResponse<Donacion> editar(int id, Donacion nvoObj) {
        GenericResponse<Donacion> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (encontrarId(id) != null) {
                try {
                    String sql = "UPDATE solicitud SET "
                            + "idDonador=?, "
                            + "idDonatario=?, "
                            + "idArchivo=?, "
                            + "idRecurso=?, "
                            + "fechaDonacion=?, "
                            + "estadoDonacion=? "
                            + "noConfirmacion=? "
                            + "remunerado=? "
                            + "WHERE idDonacion=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setInt(1, nvoObj.getIdDonador());
                    registro.setInt(2, nvoObj.getIdDonatario());
                    registro.setInt(3, nvoObj.getIdArchivo());
                    registro.setInt(4, nvoObj.getIdRecursoTecnologico());
                    registro.setDate(5, (Date) nvoObj.getFechaDonacion());
                    registro.setString(6, nvoObj.getEstadoDonacion());
                    registro.setString(7, nvoObj.getNoConfirmacion());
                    registro.setBoolean(8, nvoObj.getRemunerado());
                    registro.setInt(9, id);
                    int r = registro.executeUpdate();
                    if (r > 0) {
                        nvoObj.setIdDonacion(id);
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
    public GenericResponse<Donacion> eliminar(int id) {
        GenericResponse<Donacion> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            Donacion obj = encontrarId(id);
            if (obj != null) {
                try {
                    String sql = "DELETE FROM donacion "
                            + "WHERE idDonacion=?";
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
    public List<Donacion> getData() {
        List<Donacion> response = new ArrayList<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "SELECT "
                        + "idDonacion, "
                        + "idDonador, "
                        + "idDonatario, "
                        + "idArchivo, "
                        + "idRecurso, "
                        + "fechaDonacion, "
                        + "estadoDonacion, "
                        + "noConfirmacion "
                        + "remunerado "
                        + "FROM donacion";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    Donacion sol = new Donacion();
                    sol.setIdDonacion(rs.getInt(1));
                    sol.setIdDonador(rs.getInt(2));
                    sol.setIdDonatario(rs.getInt(3));
                    sol.setIdArchivo(rs.getInt(4));
                    sol.setIdRecursoTecnologico(rs.getInt(5));
                    sol.setFechaDonacion(rs.getDate(6));
                    sol.setEstadoDonacion(rs.getString(7));
                    sol.setNoConfirmacion(rs.getString(8));
                    sol.setRemunerado(rs.getBoolean(9));
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
    public List<Donacion> consultar(String... filtros) {
        List<Donacion> response = new ArrayList<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "SELECT "
                        + "idDonacion, "
                        + "idDonador, "
                        + "idDonatario, "
                        + "idArchivo, "
                        + "idRecurso, "
                        + "fechaDonacion, "
                        + "estadoDonacion, "
                        + "noConfirmacion "
                        + "remunerado "
                        + "FROM donacion";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    Donacion sol = new Donacion();
                    sol.setIdDonacion(rs.getInt(1));
                    sol.setIdDonador(rs.getInt(2));
                    sol.setIdDonatario(rs.getInt(3));
                    sol.setIdArchivo(rs.getInt(4));
                    sol.setIdRecursoTecnologico(rs.getInt(5));
                    sol.setFechaDonacion(rs.getDate(6));
                    sol.setEstadoDonacion(rs.getString(7));
                    sol.setNoConfirmacion(rs.getString(8));
                    sol.setRemunerado(rs.getBoolean(9));
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
    public Donacion encontrarId(int id) {
        Donacion response = null;
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "SELECT "
                        + "idDonacion, "
                        + "idDonador, "
                        + "idDonatario, "
                        + "idArchivo, "
                        + "idRecurso, "
                        + "fechaDonacion, "
                        + "estadoDonacion, "
                        + "noConfirmacion "
                        + "remunerado "
                        + "FROM donacion"
                        + "WHERE idDonacion=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs;
                rs = ps.executeQuery();
                if (rs.next()) {
                    response = new Donacion();
                    response.setIdDonacion(rs.getInt(1));
                    response.setIdDonador(rs.getInt(2));
                    response.setIdDonatario(rs.getInt(3));
                    response.setIdArchivo(rs.getInt(4));
                    response.setIdRecursoTecnologico(rs.getInt(5));
                    response.setFechaDonacion(rs.getDate(6));
                    response.setEstadoDonacion(rs.getString(7));
                    response.setNoConfirmacion(rs.getString(8));
                    response.setRemunerado(rs.getBoolean(9));
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
