package manipula;

import config.conexion.ConexionFactory;
import config.conexion.IConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.EquipoComputacional;
import utils.GenericResponse;
import utils.Logg;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ManipulaEquipoComputacional implements Manipula<EquipoComputacional> {

    @Override
    public GenericResponse<EquipoComputacional> registrar(EquipoComputacional obj) {
        GenericResponse<EquipoComputacional> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "INSERT INTO equipocomputacional ("
                        + "idRecurso, "
                        + "nombre, "
                        + "marca, "
                        + "idSistemaOperativo, "
                        + "modelo, "
                        + "color, "
                        + "memoriaRam, "
                        + "tipoRam, "
                        + "velocidadRam, "
                        + "capacidadMaximaRam, "
                        + "nuevo "
                        + ") VALUES (?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                registro.setInt(1, obj.getIdRecursoTecnologico());
                registro.setString(2, obj.getNombre());
                registro.setString(3, obj.getMarca());
                registro.setInt(4, obj.getIdSistemaOperativo());
                registro.setString(5, obj.getModelo());
                registro.setString(6, obj.getColor());
                registro.setString(7, obj.getMemoriaRAM());
                registro.setString(8, obj.getTipoRAM());
                registro.setString(9, obj.getVelocidadRAM());
                registro.setString(10, obj.getCapacidadMaxRAM());
                registro.setBoolean(11, obj.isNuevo());
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
    public GenericResponse<EquipoComputacional> actualizar(int id) {
        GenericResponse<EquipoComputacional> response = new GenericResponse<>();
        response.setMensaje("Accion no implementada");
        response.setStatus(utils.Constantes.LOGIC_WARNING);
        response.setResponseObject(null);
        return response;
    }

    @Override
    public GenericResponse<EquipoComputacional> editar(int id, EquipoComputacional nvoObj) {
        GenericResponse<EquipoComputacional> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (encontrarId(id) != null) {
                try {
                    String sql = "UPDATE equipocomputacional SET "
                            + "idRecurso=?, "
                            + "nombre=?, "
                            + "marca=?, "
                            + "idSistemaOperativo=?, "
                            + "modelo=?, "
                            + "color=?, "
                            + "memoriaRam=?, "
                            + "tipoRam=?, "
                            + "velocidadRam=?, "
                            + "capacidadMaximaRam=?, "
                            + "nuevo=? "
                            + "WHERE idEquipoComputacional=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setInt(1, nvoObj.getIdRecursoTecnologico());
                    registro.setString(2, nvoObj.getNombre());
                    registro.setString(3, nvoObj.getMarca());
                    registro.setInt(4, nvoObj.getIdSistemaOperativo());
                    registro.setString(5, nvoObj.getModelo());
                    registro.setString(6, nvoObj.getColor());
                    registro.setString(7, nvoObj.getMemoriaRAM());
                    registro.setString(8, nvoObj.getTipoRAM());
                    registro.setString(9, nvoObj.getVelocidadRAM());
                    registro.setString(10, nvoObj.getCapacidadMaxRAM());
                    registro.setBoolean(11, nvoObj.isNuevo());
                    registro.setInt(12, id);
                    int r = registro.executeUpdate();
                    if (r > 0) {
                        nvoObj.setIdEquipoComputacional(id);
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
    public GenericResponse<EquipoComputacional> eliminar(int id) {
        GenericResponse<EquipoComputacional> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            EquipoComputacional obj = encontrarId(id);
            if (obj != null) {
                try {
                    String sql = "DELETE FROM equipocomputacional "
                            + "WHERE idEstadoComputacional=?";
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
    public List<EquipoComputacional> getData() {
        List<EquipoComputacional> response = new ArrayList<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "SELECT "
                        + "idEquipoComputacional, "
                        + "idRecurso, "
                        + "nombre, "
                        + "marca, "
                        + "idSistemaOperativo, "
                        + "modelo, "
                        + "color, "
                        + "memoriaRam, "
                        + "tipoRam, "
                        + "velocidadRam, "
                        + "capacidadMaximaRam, "
                        + "nuevo "
                        + "FROM equipocomputacional";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    EquipoComputacional eqCp = new EquipoComputacional();
                    eqCp.setIdEquipoComputacional(rs.getInt(1));
                    eqCp.setIdRecursoTecnologico(rs.getInt(2));
                    eqCp.setNombre(rs.getString(3));
                    eqCp.setMarca(rs.getString(4));
                    eqCp.setIdSistemaOperativo(rs.getInt(5));
                    eqCp.setModelo(rs.getString(6));
                    eqCp.setColor(rs.getString(7));
                    eqCp.setMemoriaRAM(rs.getString(8));
                    eqCp.setTipoRAM(rs.getString(9));
                    eqCp.setVelocidadRAM(rs.getString(10));
                    eqCp.setCapacidadMaxRAM(rs.getString(11));
                    eqCp.setNuevo(rs.getBoolean(12));
                    response.add(eqCp);
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
    public List<EquipoComputacional> consultar(String... filtros) {
        List<EquipoComputacional> response = new ArrayList<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "SELECT "
                        + "idEquipoComputacional, "
                        + "idRecurso, "
                        + "nombre, "
                        + "marca, "
                        + "idSistemaOperativo, "
                        + "modelo, "
                        + "color, "
                        + "memoriaRam, "
                        + "tipoRam, "
                        + "velocidadRam, "
                        + "capacidadMaximaRam, "
                        + "nuevo "
                        + "FROM equipocomputacional";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    EquipoComputacional eqCp = new EquipoComputacional();
                    eqCp.setIdEquipoComputacional(rs.getInt(1));
                    eqCp.setIdRecursoTecnologico(rs.getInt(2));
                    eqCp.setNombre(rs.getString(3));
                    eqCp.setMarca(rs.getString(4));
                    eqCp.setIdSistemaOperativo(rs.getInt(5));
                    eqCp.setModelo(rs.getString(6));
                    eqCp.setColor(rs.getString(7));
                    eqCp.setMemoriaRAM(rs.getString(8));
                    eqCp.setTipoRAM(rs.getString(9));
                    eqCp.setVelocidadRAM(rs.getString(10));
                    eqCp.setCapacidadMaxRAM(rs.getString(11));
                    eqCp.setNuevo(rs.getBoolean(12));
                    response.add(eqCp);
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
    public EquipoComputacional encontrarId(int id) {
        EquipoComputacional response = null;
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "SELECT "
                        + "idEquipoComputacional, "
                        + "idRecurso, "
                        + "nombre, "
                        + "marca, "
                        + "idSistemaOperativo, "
                        + "modelo, "
                        + "color, "
                        + "memoriaRam, "
                        + "tipoRam, "
                        + "velocidadRam, "
                        + "capacidadMaximaRam, "
                        + "nuevo "
                        + "FROM equipocomputacional "
                        + "WHERE idEquipoComputacional=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs;
                rs = ps.executeQuery();
                if (rs.next()) {
                    response = new EquipoComputacional();
                    response.setIdEquipoComputacional(rs.getInt(1));
                    response.setIdRecursoTecnologico(rs.getInt(2));
                    response.setNombre(rs.getString(3));
                    response.setMarca(rs.getString(4));
                    response.setIdSistemaOperativo(rs.getInt(5));
                    response.setModelo(rs.getString(6));
                    response.setColor(rs.getString(7));
                    response.setMemoriaRAM(rs.getString(8));
                    response.setTipoRAM(rs.getString(9));
                    response.setVelocidadRAM(rs.getString(10));
                    response.setCapacidadMaxRAM(rs.getString(11));
                    response.setNuevo(rs.getBoolean(12));
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
