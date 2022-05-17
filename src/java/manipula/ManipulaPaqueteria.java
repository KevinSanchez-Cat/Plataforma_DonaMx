package manipula;

import config.conexion.ConexionFactory;
import config.conexion.IConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Noticia;
import model.Paqueteria;
import utils.GenericResponse;
import utils.Logg;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ManipulaPaqueteria implements Manipula<Paqueteria> {

    @Override
    public GenericResponse<Paqueteria> registrar(Paqueteria obj) {
        GenericResponse<Paqueteria> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "INSERT INTO Paqueteria ("
                        + "idDonacion, "
                        + "idVoluntario, "
                        + "direccionOrigen, "
                        + "direccionDestino, "
                        + "fechaOrigen, "
                        + "fechaDestino, "
                        + "estadoPaquete "
                        + ") VALUES (?,?,?,?,?,?,?)";
                PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                registro.setInt(1, obj.getIdDonacion());
                registro.setInt(2, obj.getIdVoluntario());
                registro.setString(3, obj.getDireccionOrigen());
                registro.setString(4, obj.getDireccionDestino());
                registro.setTimestamp(5, obj.getFechaOrigen());
                registro.setTimestamp(6, obj.getFechaDestino());

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
    public GenericResponse<Paqueteria> actualizar(int id) {
        GenericResponse<Paqueteria> response = new GenericResponse<>();
        response.setMensaje("Accion no implementada");
        response.setStatus(utils.Constantes.LOGIC_WARNING);
        response.setResponseObject(null);
        return response;
    }

    @Override
    public GenericResponse<Paqueteria> editar(int id, Paqueteria nvoObj) {
        GenericResponse<Paqueteria> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {

            if (encontrarId(id) != null) {
                try {
                    String sql = "UPDATE Categoria SET "
                            + "idDonacion=?, "
                            + "idVoluntario=?, "
                            + "direccionOrigen=?, "
                            + "direccionDestino=?, "
                            + "fechaOrigen=?, "
                            + "fechaDestino=?, "
                            + "estadoPaquete=? "
                            + "WHERE idPatequeteria=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setInt(1, nvoObj.getIdDonacion());
                    registro.setInt(2, nvoObj.getIdVoluntario());
                    registro.setString(3, nvoObj.getDireccionOrigen());
                    registro.setString(4, nvoObj.getDireccionDestino());
                    registro.setTimestamp(5, nvoObj.getFechaOrigen());
                    registro.setTimestamp(6, nvoObj.getFechaDestino());
                    registro.setInt(7, id);
                    int r = registro.executeUpdate();
                    if (r > 0) {
                        response.setStatus(utils.Constantes.STATUS_REGISTRO_EXITOSO_BD);
                        response.setResponseObject(nvoObj);
                        response.setMensaje("Registro exitoso en la base de datos");
                    } else {
                        response.setStatus(utils.Constantes.STATUS_REGISTRO_FALLIDO_BD);
                        response.setResponseObject(nvoObj);
                        response.setMensaje("Registro fallido en la base de datos");
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
    public GenericResponse<Paqueteria> eliminar(int id) {
        GenericResponse<Paqueteria> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            Paqueteria obj = encontrarId(id);
            if (obj != null) {
                try {
                    String sql = "DELETE FROM Paqueteria "
                            + "WHERE idPaqueteria=?";
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
    public List<Paqueteria> getData() {
        List<Paqueteria> response = new ArrayList<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "SELECT "
                        + "idPaqueteria, "
                        + "idDonacion, "
                        + "idVoluntario, "
                        + "direccionOrigen, "
                        + "direccionDestino, "
                        + "fechaOrigen, "
                        + "fechaDestino, "
                        + "estadoPaquete "
                        + "FROM Paqueteria";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    Paqueteria sol = new Paqueteria();
                    sol.setIdPaqueteria(rs.getInt(1));
                    sol.setIdDonacion(rs.getInt(2));
                    sol.setIdVoluntario(rs.getInt(3));
                    sol.setDireccionOrigen(rs.getString(4));
                    sol.setDireccionDestino(rs.getString(5));
                    sol.setFechaOrigen(rs.getTimestamp(6));
                    sol.setFechaDestino(rs.getTimestamp(7));
                    sol.setEstadoPaquete(rs.getString(8));
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
    public List<Paqueteria> consultar(String... filtros) {
        List<Paqueteria> response = new ArrayList<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "SELECT "
                        + "idPaqueteria, "
                        + "idDonacion, "
                        + "idVoluntario, "
                        + "direccionOrigen, "
                        + "direccionDestino, "
                        + "fechaOrigen, "
                        + "fechaDestino, "
                        + "estadoPaquete "
                        + "FROM Paqueteria";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    Paqueteria sol = new Paqueteria();
                    sol.setIdPaqueteria(rs.getInt(1));
                    sol.setIdDonacion(rs.getInt(2));
                    sol.setIdVoluntario(rs.getInt(3));
                    sol.setDireccionOrigen(rs.getString(4));
                    sol.setDireccionDestino(rs.getString(5));
                    sol.setFechaOrigen(rs.getTimestamp(6));
                    sol.setFechaDestino(rs.getTimestamp(7));
                    sol.setEstadoPaquete(rs.getString(8));
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
    public Paqueteria encontrarId(int id) {
        Paqueteria response = null;
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "SELECT "
                        + "idPaqueteria, "
                        + "idDonacion, "
                        + "idVoluntario, "
                        + "direccionOrigen, "
                        + "direccionDestino, "
                        + "fechaOrigen, "
                        + "fechaDestino, "
                        + "estadoPaquete "
                        + "FROM Paqueteria "
                        + "WHERE idPaqueteria=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs;
                rs = ps.executeQuery();
                if (rs.next()) {

                    response = new Paqueteria();
                    response.setIdPaqueteria(rs.getInt(1));
                    response.setIdDonacion(rs.getInt(2));
                    response.setIdVoluntario(rs.getInt(3));
                    response.setDireccionOrigen(rs.getString(4));
                    response.setDireccionDestino(rs.getString(5));
                    response.setFechaOrigen(rs.getTimestamp(6));
                    response.setFechaDestino(rs.getTimestamp(7));
                    response.setEstadoPaquete(rs.getString(8));

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
