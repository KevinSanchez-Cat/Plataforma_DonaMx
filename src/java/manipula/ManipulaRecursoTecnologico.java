package manipula;

import config.conexion.ConexionFactory;
import config.conexion.IConexion;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.RecursoTecnologico;
import utils.GenericResponse;
import utils.Logg;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ManipulaRecursoTecnologico implements Manipula<RecursoTecnologico> {

    @Override
    public GenericResponse<RecursoTecnologico> registrar(RecursoTecnologico obj) {
        GenericResponse<RecursoTecnologico> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "INSERT INTO recursotecnologico ("
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
                        + ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                registro.setInt(1, obj.getIdCategoria());
                registro.setInt(2, obj.getIdDonador());
                registro.setInt(3, obj.getIdUsuario());
                registro.setString(4, obj.getNombreRecurso());
                registro.setInt(5, obj.getCantidadStock());
                registro.setString(6, obj.getAutorizado());
                registro.setString(7, obj.getEstadoPublicacion());
                registro.setBoolean(8, obj.isEstadoLogico());
                registro.setDate(9, (Date) obj.getFechaPublicacion());
                registro.setDate(10, (Date) obj.getFechaAutorizacion());
                registro.setBoolean(11, obj.isRemunerado());
                registro.setString(12, obj.getEstadoCondicion());
                registro.setDouble(13, obj.getPrecioOriginal());
                registro.setDouble(14, obj.getPrecioEstimado());
                registro.setDouble(15, obj.getPrecioOfertado());
                registro.setString(16, obj.getOrganizacionOCivil());
                registro.setString(17, obj.getTipoSoftwarOHardware());
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
    public GenericResponse<RecursoTecnologico> actualizar(int id) {
        GenericResponse<RecursoTecnologico> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<RecursoTecnologico> editar(int id, RecursoTecnologico nvoObj) {
        GenericResponse<RecursoTecnologico> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (encontrarId(id) != null) {
                try {
                    String sql = "UPDATE recursotecnologico SET "
                            + "idCategoria=?, "
                            + "idDonador=?, "
                            + "idUsuario=?, "
                            + "nombreRecurso=?, "
                            + "cantidadStock=?, "
                            + "autorizado=?, "
                            + "estadoPublicacion=?, "
                            + "estadoLogico=?, "
                            + "fechaPublicacion=?, "
                            + "fechaAutorizacion=?, "
                            + "remunerado=?, "
                            + "estadoCondicion=?, "
                            + "precioOriginal=?, "
                            + "precioEstimado=?, "
                            + "precioOfertado=?, "
                            + "organizacionOCivil=?, "
                            + "tipoSoftHard=? "
                            + "WHERE idRecursoTecnologico=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setInt(1, nvoObj.getIdCategoria());
                    registro.setInt(2, nvoObj.getIdDonador());
                    registro.setInt(3, nvoObj.getIdUsuario());
                    registro.setString(4, nvoObj.getNombreRecurso());
                    registro.setInt(5, nvoObj.getCantidadStock());
                    registro.setString(6, nvoObj.getAutorizado());
                    registro.setString(7, nvoObj.getEstadoPublicacion());
                    registro.setBoolean(8, nvoObj.isEstadoLogico());
                    registro.setDate(9, (Date) nvoObj.getFechaPublicacion());
                    registro.setDate(10, (Date) nvoObj.getFechaAutorizacion());
                    registro.setBoolean(11, nvoObj.isRemunerado());
                    registro.setString(12, nvoObj.getEstadoCondicion());
                    registro.setDouble(13, nvoObj.getPrecioOriginal());
                    registro.setDouble(14, nvoObj.getPrecioEstimado());
                    registro.setDouble(15, nvoObj.getPrecioOfertado());
                    registro.setString(16, nvoObj.getOrganizacionOCivil());
                    registro.setString(17, nvoObj.getTipoSoftwarOHardware());
                    registro.setInt(18, id);
                    int r = registro.executeUpdate();
                    if (r > 0) {
                        nvoObj.setIdRecursoTecnologico(id);
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
    public GenericResponse<RecursoTecnologico> eliminar(int id) {
        GenericResponse<RecursoTecnologico> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            RecursoTecnologico obj = encontrarId(id);
            if (obj != null) {
                try {
                    String sql = "DELETE FROM recursotecnologico "
                            + "WHERE idRecursoTecnologico=?";
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
    public List<RecursoTecnologico> getData() {
        List<RecursoTecnologico> response = new ArrayList<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
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
                        + "FROM recursotecnologico";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    RecursoTecnologico sol = new RecursoTecnologico();
                    sol.setIdRecursoTecnologico(rs.getInt(1));
                    sol.setIdCategoria(rs.getInt(2));
                    sol.setIdDonador(rs.getInt(3));
                    sol.setIdUsuario(rs.getInt(4));
                    sol.setNombreRecurso(rs.getString(5));
                    sol.setCantidadStock(rs.getInt(6));
                    sol.setAutorizado(rs.getString(7));
                    sol.setEstadoPublicacion(rs.getString(8));
                    sol.setEstadoLogico(rs.getBoolean(9));
                    sol.setFechaPublicacion(rs.getDate(10));
                    sol.setFechaAutorizacion(rs.getDate(11));
                    sol.setRemunerado(rs.getBoolean(12));
                    sol.setEstadoCondicion(rs.getString(13));
                    sol.setPrecioOriginal(rs.getDouble(14));
                    sol.setPrecioEstimado(rs.getDouble(15));
                    sol.setPrecioOriginal(rs.getDouble(16));
                    sol.setOrganizacionOCivil(rs.getString(17));
                    sol.setTipoSoftwarOHardware(rs.getString(18));
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
    public List<RecursoTecnologico> consultar(String... filtros) {
        List<RecursoTecnologico> response = new ArrayList<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
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
                        + "FROM recursotecnologico";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    RecursoTecnologico sol = new RecursoTecnologico();
                    sol.setIdRecursoTecnologico(rs.getInt(1));
                    sol.setIdCategoria(rs.getInt(2));
                    sol.setIdDonador(rs.getInt(3));
                    sol.setIdUsuario(rs.getInt(4));
                    sol.setNombreRecurso(rs.getString(5));
                    sol.setCantidadStock(rs.getInt(6));
                    sol.setAutorizado(rs.getString(7));
                    sol.setEstadoPublicacion(rs.getString(8));
                    sol.setEstadoLogico(rs.getBoolean(9));
                    sol.setFechaPublicacion(rs.getDate(10));
                    sol.setFechaAutorizacion(rs.getDate(11));
                    sol.setRemunerado(rs.getBoolean(12));
                    sol.setEstadoCondicion(rs.getString(13));
                    sol.setPrecioOriginal(rs.getDouble(14));
                    sol.setPrecioEstimado(rs.getDouble(15));
                    sol.setPrecioOriginal(rs.getDouble(16));
                    sol.setOrganizacionOCivil(rs.getString(17));
                    sol.setTipoSoftwarOHardware(rs.getString(18));
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
    public RecursoTecnologico encontrarId(int id) {
        RecursoTecnologico response = new RecursoTecnologico();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
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
                        + "FROM recursotecnologico"
                        + "WHERE idRecursoTecnologico=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs;
                rs = ps.executeQuery();
                if (rs.next()) {
                    response = new RecursoTecnologico();
                    response.setIdRecursoTecnologico(rs.getInt(1));
                    response.setIdCategoria(rs.getInt(2));
                    response.setIdDonador(rs.getInt(3));
                    response.setIdUsuario(rs.getInt(4));
                    response.setNombreRecurso(rs.getString(5));
                    response.setCantidadStock(rs.getInt(6));
                    response.setAutorizado(rs.getString(7));
                    response.setEstadoPublicacion(rs.getString(8));
                    response.setEstadoLogico(rs.getBoolean(9));
                    response.setFechaPublicacion(rs.getDate(10));
                    response.setFechaAutorizacion(rs.getDate(11));
                    response.setRemunerado(rs.getBoolean(12));
                    response.setEstadoCondicion(rs.getString(13));
                    response.setPrecioOriginal(rs.getDouble(14));
                    response.setPrecioEstimado(rs.getDouble(15));
                    response.setPrecioOriginal(rs.getDouble(16));
                    response.setOrganizacionOCivil(rs.getString(17));
                    response.setTipoSoftwarOHardware(rs.getString(18));
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
