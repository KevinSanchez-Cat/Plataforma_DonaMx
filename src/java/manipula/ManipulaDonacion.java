package manipula;

import config.conexion.ConexionFactory;
import config.conexion.IConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Donacion;
import utils.GenericResponse;
import utils.Logg;
import utils.Misc;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ManipulaDonacion implements Manipula<Donacion> {

    @Override
    public GenericResponse<Donacion> registrar(IConexion conexionDB,Donacion obj) {
        GenericResponse<Donacion> response = new GenericResponse<>();
        
        if (conexionDB.getConexion()!=null) {
            try {
                String sql = "INSERT INTO Donacion ("
                        + "idDonador, "
                        + "idDonatario, "
                        + "idRecurso, "
                        + "fechaDonacion, "
                        + "estadoDonacion, "
                        + "noConfirmacion, "
                        + "remunerado, "
                        + "estadoPago, "
                        + "estadoEnvio, "
                        + "estadoEntrega, "
                        + "noSerie, "
                        + "estadoPreparacion "
                        + ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                registro.setInt(1, obj.getIdDonador());
                registro.setInt(2, obj.getIdDonatario());
                registro.setInt(3, obj.getIdRecursoTecnologico());
                registro.setTimestamp(4, obj.getFechaDonacion());
                registro.setString(5, obj.getEstadoDonacion());
                registro.setString(6, obj.getNoConfirmacion());
                registro.setInt(7, obj.getRemunerado());
                registro.setString(8, obj.getEstadoPago());
                registro.setString(9, obj.getEstadoEnvio());
                registro.setString(10, obj.getEstadoEntrega());
                registro.setString(11, obj.getNoSerie());
                registro.setString(12, obj.getEstadoPreparacion());
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
    public GenericResponse<Donacion> actualizar(IConexion conexionDB,int id) {
        GenericResponse<Donacion> response = new GenericResponse<>();
        
        if (conexionDB.getConexion()!=null) {
            Donacion don = encontrarId(conexionDB,id);
            if (don != null) {
                switch (don.getEstadoDonacion()) {
                    case "Pe"://Pendiente
                        don.setEstadoDonacion("Ev");
                        break;
                    case "Ev"://Enviado
                        don.setEstadoDonacion("Ec");
                        break;
                    case "Ec"://En camino
                        don.setEstadoDonacion("Et");
                        break;
                    case "Et"://Entregado
                        break;
                    case "Re"://Rechazado
                        break;
                    default://Esperando respuesta de confirmacion
                        if (don.getNoConfirmacion().equals("Si")) {
                            don.setEstadoDonacion("Pe");//Preparacion. Pendiente
                        } else if (don.getNoConfirmacion().equals("No")) {
                            don.setEstadoDonacion("Re"); //Rechazado
                        }
                        break;
                }
                try {
                    String sql = "UPDATE Donacion SET "
                            + "estadoDonacion=? "
                            + "WHERE idDonacion=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setString(1, don.getEstadoDonacion());
                    registro.setInt(2, id);
                    int r = registro.executeUpdate();
                    if (r > 0) {

                        response.setStatus(utils.Constantes.STATUS_ACTUALIZACION_EXITOSA_BD);
                        response.setResponseObject(don);
                        response.setMensaje("Edición exitosa en la base de datos");
                    } else {
                        response.setStatus(utils.Constantes.STATUS_ACTUALIZACION_FALLIDA_BD);
                        response.setResponseObject(null);
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

    public GenericResponse<Donacion> actualizar(IConexion conexionDB,int id, String noConfirmacion) {
        GenericResponse<Donacion> response = new GenericResponse<>();
        
        if (conexionDB.getConexion()!=null) {
            Donacion don = encontrarId(conexionDB,id);
            if (don != null) {
                if (!don.getNoConfirmacion().equals("")) {
                    if (noConfirmacion.equals("Si")) {
                        don.setNoConfirmacion("Si");
                        don.setEstadoDonacion("Pe");//Preparacion. Pendiente
                    } else if (noConfirmacion.equals("No")) {
                        don.setNoConfirmacion("No");
                        don.setEstadoDonacion("Re"); //Rechazado
                    }
                } else {
                    if (noConfirmacion.equals("Si") && don.getNoConfirmacion().equals("Si")) {
                        don.setNoConfirmacion("Si");
                    } else if (noConfirmacion.equals("Si") && don.getNoConfirmacion().equals("No")) {
                        don.setNoConfirmacion("No");
                    } else if (noConfirmacion.equals("No") && don.getNoConfirmacion().equals("Si")) {//accion de cancelar
                        don.setNoConfirmacion("No");
                        don.setEstadoDonacion("Re"); //Rechazado
                    } else if (noConfirmacion.equals("No") && don.getNoConfirmacion().equals("No")) {
                        don.setNoConfirmacion("No");
                        don.setEstadoDonacion("Re"); //Rechazado
                    }
                }

                try {
                    String sql = "UPDATE Donacion SET "
                            + "noConfirmacion=? "
                            + "WHERE idDonacion=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setString(1, don.getNoConfirmacion());
                    registro.setInt(2, id);
                    int r = registro.executeUpdate();
                    if (r > 0) {
                        response.setStatus(utils.Constantes.STATUS_ACTUALIZACION_EXITOSA_BD);
                        response.setResponseObject(don);
                        response.setMensaje("Edición exitosa en la base de datos");
                    } else {
                        response.setStatus(utils.Constantes.STATUS_ACTUALIZACION_FALLIDA_BD);
                        response.setResponseObject(null);
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
    public GenericResponse<Donacion> editar(IConexion conexionDB,int id, Donacion nvoObj) {
        GenericResponse<Donacion> response = new GenericResponse<>();
        
        if (conexionDB.getConexion()!=null) {
            if (encontrarId(conexionDB,id) != null) {
                try {
                    String sql = "UPDATE Donacion SET "
                            + "idDonador=?, "
                            + "idDonatario=?, "
                            + "idArchivo=?, "
                            + "fechaDonacion=?, "
                            + "estadoDonacion=?, "
                            + "noConfirmacion=?, "
                            + "remunerado=? "
                            + "estadoPago, "
                            + "estadoEnvio, "
                            + "estadoEntrega, "
                            + "noSerie, "
                            + "estadoPreparacion "
                            + "WHERE idDonacion=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setInt(1, nvoObj.getIdDonador());
                    registro.setInt(2, nvoObj.getIdDonatario());
                    registro.setInt(3, nvoObj.getIdRecursoTecnologico());
                    registro.setTimestamp(4, nvoObj.getFechaDonacion());
                    registro.setString(5, nvoObj.getEstadoDonacion());
                    registro.setString(6, nvoObj.getNoConfirmacion());
                    registro.setInt(7, nvoObj.getRemunerado());
                    registro.setString(8, nvoObj.getEstadoPago());
                    registro.setString(9, nvoObj.getEstadoEnvio());
                    registro.setString(10, nvoObj.getEstadoEntrega());
                    registro.setString(11, nvoObj.getNoSerie());
                    registro.setString(12, nvoObj.getEstadoPreparacion());
                    registro.setInt(13, id);
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
    public GenericResponse<Donacion> eliminar(IConexion conexionDB,int id) {
        GenericResponse<Donacion> response = new GenericResponse<>();
        
        if (conexionDB.getConexion()!=null) {
            Donacion obj = encontrarId(conexionDB,id);
            if (obj != null) {
                try {
                    String sql = "DELETE FROM Donacion "
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
    public List<Donacion> getData(IConexion conexionDB) {
        List<Donacion> response = new ArrayList<>();
        
        if (conexionDB.getConexion()!=null) {
            try {
                String sql = "SELECT "
                        + "idDonacion, "
                        + "idDonador, "
                        + "idDonatario, "
                        + "idRecurso, "
                        + "fechaDonacion, "
                        + "estadoDonacion, "
                        + "noConfirmacion, "
                        + "remunerado, "
                        + "estadoPago, "
                        + "estadoEnvio, "
                        + "estadoEntrega, "
                        + "noSerie, "
                        + "estadoPreparacion "
                        + "FROM Donacion";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    Donacion sol = new Donacion();
                    sol.setIdDonacion(rs.getInt(1));
                    sol.setIdDonador(rs.getInt(2));
                    sol.setIdDonatario(rs.getInt(3));
                    sol.setIdRecursoTecnologico(rs.getInt(4));
                    sol.setFechaDonacion(rs.getTimestamp(5));
                    sol.setEstadoDonacion(rs.getString(6));
                    sol.setNoConfirmacion(rs.getString(7));
                    sol.setRemunerado(rs.getInt(8));
                    sol.setEstadoPago(rs.getString(9));
                    sol.setEstadoEnvio(rs.getString(10));
                    sol.setEstadoEntrega(rs.getString(11));
                    sol.setNoSerie(rs.getString(12));
                    sol.setEstadoPreparacion(rs.getString(13));
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
    public List<Donacion> consultar(IConexion conexionDB,String... filtros) {
        List<Donacion> response = new ArrayList<>();
        
        if (conexionDB.getConexion()!=null) {
            try {
                String sql = "SELECT "
                        + "idDonacion, "
                        + "idDonador, "
                        + "idDonatario, "
                        + "idRecurso, "
                        + "fechaDonacion, "
                        + "estadoDonacion, "
                        + "noConfirmacion, "
                        + "remunerado, "
                        + "estadoPago, "
                        + "estadoEnvio, "
                        + "estadoEntrega, "
                        + "noSerie, "
                        + "estadoPreparacion "
                        + "FROM Donacion";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    Donacion sol = new Donacion();
                    sol.setIdDonacion(rs.getInt(1));
                    sol.setIdDonador(rs.getInt(2));
                    sol.setIdDonatario(rs.getInt(3));
                    sol.setIdRecursoTecnologico(rs.getInt(4));
                    sol.setFechaDonacion(rs.getTimestamp(5));
                    sol.setEstadoDonacion(rs.getString(6));
                    sol.setNoConfirmacion(rs.getString(7));
                    sol.setRemunerado(rs.getInt(8));
                    sol.setEstadoPago(rs.getString(9));
                    sol.setEstadoEnvio(rs.getString(10));
                    sol.setEstadoEntrega(rs.getString(11));
                    sol.setNoSerie(rs.getString(12));
                    sol.setEstadoPreparacion(rs.getString(13));
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
    public Donacion encontrarId(IConexion conexionDB,int id) {
        Donacion response = null;
        
        if (conexionDB.getConexion()!=null) {
            try {
                String sql = "SELECT "
                        + "idDonacion, "
                        + "idDonador, "
                        + "idDonatario, "
                        + "idArchivo, "
                        + "idRecurso, "
                        + "fechaDonacion, "
                        + "estadoDonacion, "
                        + "noConfirmacion, "
                        + "remunerado, "
                        + "estadoPago, "
                        + "estadoEnvio, "
                        + "estadoEntrega, "
                        + "noSerie, "
                        + "estadoPreparacion "
                        + "FROM Donacion "
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
                    response.setIdRecursoTecnologico(rs.getInt(4));
                    response.setFechaDonacion(rs.getTimestamp(5));
                    response.setEstadoDonacion(rs.getString(6));
                    response.setNoConfirmacion(rs.getString(7));
                    response.setRemunerado(rs.getInt(8));
                    response.setEstadoPago(rs.getString(9));
                    response.setEstadoEnvio(rs.getString(10));
                    response.setEstadoEntrega(rs.getString(11));
                    response.setNoSerie(rs.getString(12));
                    response.setEstadoPreparacion(rs.getString(13));
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
