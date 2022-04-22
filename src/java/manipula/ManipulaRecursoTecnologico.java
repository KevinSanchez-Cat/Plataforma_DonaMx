package manipula;

import config.conexion.ConexionFactory;
import config.conexion.IConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.RecursoTecnologico;
import utils.GenericResponse;
import utils.Logg;
import utils.Misc;

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
                registro.setDate(9, (Misc.transformDateTimeJavaSql(obj.getFechaPublicacion())));
                registro.setDate(10, Misc.transformDateTimeJavaSql(obj.getFechaAutorizacion()));
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
        response.setMensaje("Accion no implementada");
        response.setStatus(utils.Constantes.LOGIC_WARNING);
        response.setResponseObject(null);
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
                    registro.setDate(9, Misc.transformDateTimeJavaSql(nvoObj.getFechaPublicacion()));
                    registro.setDate(10, Misc.transformDateTimeJavaSql(nvoObj.getFechaAutorizacion()));
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
                    sol.setFechaPublicacion(Misc.transformDateTimeSqlJava(rs.getDate(10)));
                    sol.setFechaAutorizacion(Misc.transformDateTimeSqlJava(rs.getDate(11)));
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
                    sol.setFechaPublicacion(Misc.transformDateTimeSqlJava(rs.getDate(10)));
                    sol.setFechaAutorizacion(Misc.transformDateTimeSqlJava(rs.getDate(11)));
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
                    response.setFechaPublicacion(Misc.transformDateTimeSqlJava(rs.getDate(10)));
                    response.setFechaAutorizacion(Misc.transformDateTimeSqlJava(rs.getDate(11)));
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

    public GenericResponse<RecursoTecnologico> changeCantidadStock(int id, int cantidad) {
        GenericResponse<RecursoTecnologico> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            RecursoTecnologico nvoObj = encontrarId(id);
            if (encontrarId(id) != null) {
                nvoObj.setCantidadStock(cantidad);
                try {
                    String sql = "UPDATE recursotecnologico SET "
                            + "cantidadStock=?, "
                            + "WHERE idRecursoTecnologico=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setInt(1, nvoObj.getCantidadStock());
                    registro.setInt(2, id);
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

    public GenericResponse<RecursoTecnologico> changeAutorizacion(int id, String autorizado) {
        GenericResponse<RecursoTecnologico> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            RecursoTecnologico nvoObj = encontrarId(id);
            if (nvoObj != null) {
                if (nvoObj.getAutorizado().equals("--") && autorizado.equals("Si")) {
                    nvoObj.setAutorizado(autorizado);
                    nvoObj.setFechaAutorizacion(Misc.getDateTimeActualJava());
                    nvoObj.setEstadoPublicacion("Si");
                    nvoObj.setFechaPublicacion(Misc.getDateTimeActualJava());
                } else if (nvoObj.getAutorizado().equals("--") && autorizado.equals("No")) {
                    nvoObj.setAutorizado(autorizado);
                    nvoObj.setFechaAutorizacion(Misc.getDateTimeActualJava());
                    nvoObj.setEstadoPublicacion("No");
                    nvoObj.setFechaPublicacion(null);
                } else if (nvoObj.getAutorizado().equals("Si") && autorizado.equals("Si")) {
                    //Sin accion
                } else if (nvoObj.getAutorizado().equals("Si") && autorizado.equals("No")) {
                    nvoObj.setAutorizado(autorizado);
                    nvoObj.setFechaAutorizacion(Misc.getDateTimeActualJava());
                    nvoObj.setEstadoPublicacion("No");
                    nvoObj.setFechaPublicacion(null);
                } else if (nvoObj.getAutorizado().equals("No") && autorizado.equals("Si")) {
                    nvoObj.setAutorizado(autorizado);
                    nvoObj.setFechaAutorizacion(Misc.getDateTimeActualJava());
                    nvoObj.setEstadoPublicacion("Si");
                    nvoObj.setFechaPublicacion(Misc.getDateTimeActualJava());
                } else if (nvoObj.getAutorizado().equals("No") && autorizado.equals("No")) {
                    //Sin accion
                } else if (nvoObj.getAutorizado().equals("Si") && autorizado.equals("--")) {
                    nvoObj.setAutorizado(autorizado);
                    nvoObj.setFechaAutorizacion(Misc.getDateTimeActualJava());
                    nvoObj.setEstadoPublicacion("--");
                    nvoObj.setFechaPublicacion(null);
                } else if (nvoObj.getAutorizado().equals("No") && autorizado.equals("--")) {
                    nvoObj.setAutorizado(autorizado);
                    nvoObj.setFechaAutorizacion(Misc.getDateTimeActualJava());
                    nvoObj.setEstadoPublicacion("--");
                    nvoObj.setFechaPublicacion(null);
                } else {
                    nvoObj.setAutorizado("--");
                    nvoObj.setFechaAutorizacion(null);
                    nvoObj.setEstadoPublicacion("--");
                    nvoObj.setFechaPublicacion(null);
                }
                try {
                    String sql = "UPDATE recursotecnologico SET "
                            + "autorizado=?, "
                            + "fechaAutorizacion=?, "
                            + "estadoPublicacion=?, "
                            + "fechaPublicacion=? "
                            + "WHERE idRecursoTecnologico=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setString(1, nvoObj.getAutorizado());
                    registro.setDate(2, Misc.transformDateTimeJavaSql(nvoObj.getFechaAutorizacion()));
                    registro.setString(3, nvoObj.getEstadoPublicacion());
                    registro.setDate(4, Misc.transformDateTimeJavaSql(nvoObj.getFechaPublicacion()));
                    registro.setInt(5, id);
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

    public GenericResponse<RecursoTecnologico> changePublicacion(int id, String publicacion) {
        GenericResponse<RecursoTecnologico> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            RecursoTecnologico nvoObj = encontrarId(id);
            if (nvoObj != null) {
                if (nvoObj.getAutorizado().equals("--") && publicacion.equals("Si")) {
                    nvoObj.setEstadoPublicacion("--");
                    nvoObj.setFechaPublicacion(null);
                } else if (nvoObj.getAutorizado().equals("--") && publicacion.equals("No")) {
                    nvoObj.setEstadoPublicacion("--");
                    nvoObj.setFechaPublicacion(null);
                } else if (nvoObj.getAutorizado().equals("Si") && publicacion.equals("Si")) {
                    nvoObj.setEstadoPublicacion("Si");
                    nvoObj.setFechaPublicacion(Misc.getDateTimeActualJava());
                } else if (nvoObj.getAutorizado().equals("Si") && publicacion.equals("No")) {
                    nvoObj.setEstadoPublicacion("No");
                    nvoObj.setFechaPublicacion(null);
                } else if (nvoObj.getAutorizado().equals("No") && publicacion.equals("Si")) {
                    nvoObj.setEstadoPublicacion("No");
                    nvoObj.setFechaPublicacion(null);
                } else if (nvoObj.getAutorizado().equals("No") && publicacion.equals("No")) {
                    nvoObj.setEstadoPublicacion("No");
                    nvoObj.setFechaPublicacion(null);
                } else if (nvoObj.getAutorizado().equals("Si") && publicacion.equals("--")) {
                    nvoObj.setEstadoPublicacion("No");
                    nvoObj.setFechaPublicacion(null);
                } else if (nvoObj.getAutorizado().equals("No") && publicacion.equals("--")) {
                    nvoObj.setEstadoPublicacion("No");
                    nvoObj.setFechaPublicacion(null);
                } else {
                    nvoObj.setEstadoPublicacion("No");
                    nvoObj.setFechaPublicacion(null);
                }
                try {
                    String sql = "UPDATE recursotecnologico SET "
                            + "estadoPublicacion=?, "
                            + "fechaPublicacion=? "
                            + "WHERE idRecursoTecnologico=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setString(1, nvoObj.getEstadoPublicacion());
                    registro.setDate(2, Misc.transformDateTimeJavaSql(nvoObj.getFechaPublicacion()));
                    registro.setInt(3, id);
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

    public boolean changeEstadoLogico(int id, boolean estado) {
        boolean hecho = false;
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (encontrarId(id) != null) {
                try {
                    String sql = "UPDATE recursotecnologico SET "
                            + "estadoLogico=? "
                            + "WHERE idRecursoTecnologico=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setBoolean(1, estado);
                    registro.setInt(2, id);
                    int r = registro.executeUpdate();
                    if (r > 0) {
                        hecho = true;
                        Logg.error("Edición exitosa en la base de datos");
                    } else {
                        Logg.error("Edición fallido en la base de datos");
                    }
                } catch (SQLException ex) {
                    Logg.error("Error de comunicación con la base de datos " + ex.getSQLState());
                } finally {
                    conexionDB.desconectar();
                }
            } else {
                Logg.error("El registro no existe");
            }
        } else {
            Logg.error("Error de conexión a la base de datos");
        }
        return hecho;
    }

    public boolean changeEstadoLogico(int id, boolean remunerado, double precioOriginal, double precioEstimado, double precioOfertado) {
        boolean hecho = false;
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (encontrarId(id) != null) {
                try {
                    String sql = "UPDATE recursotecnologico SET "
                            + "remunerado=?, "
                            + "precioOriginal=?, "
                            + "precioEstimado=?, "
                            + "precioOfertado=? "
                            + "WHERE idRecursoTecnologico=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setBoolean(1, remunerado);
                    registro.setDouble(2, precioOriginal);
                    registro.setDouble(3, precioEstimado);
                    registro.setDouble(4, precioOfertado);
                    registro.setInt(5, id);
                    int r = registro.executeUpdate();
                    if (r > 0) {
                        hecho = true;
                        Logg.error("Edición exitosa en la base de datos");
                    } else {
                        Logg.error("Edición fallido en la base de datos");
                    }
                } catch (SQLException ex) {
                    Logg.error("Error de comunicación con la base de datos " + ex.getSQLState());
                } finally {
                    conexionDB.desconectar();
                }
            } else {
                Logg.error("El registro no existe");
            }
        } else {
            Logg.error("Error de conexión a la base de datos");
        }
        return hecho;
    }

}
