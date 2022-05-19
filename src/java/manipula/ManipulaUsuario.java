package manipula;

import config.conexion.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Direccion;
import model.Donacion;
import model.Estudiante;
import model.Galeria;
import model.GaleriaPerfil;
import model.Intencion;
import model.Notificacion;
import model.Organizacion;
import model.Solicitud;
import model.Usuario;
import utils.GenericResponse;
import utils.Logg;
import utils.Misc;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ManipulaUsuario implements Manipula<Usuario> {

    @Override
    public GenericResponse<Usuario> registrar(IConexion conexionDB, Usuario obj) {
        GenericResponse<Usuario> response = new GenericResponse<>();
        if (conexionDB.getConexion() != null) {
            try {
                String sql = "INSERT INTO Usuario ("
                        + "nombre, "
                        + "apellido, "
                        + "nombreUsuario, "
                        + "contrasenia, "
                        + "fechaCreacion, "
                        + "ultimaConexion, "
                        + "estadoCuenta, "
                        + "estadoLogico, "
                        + "conectado, "
                        + "correoElectronico, "
                        + "correoConfirmado, "
                        + "numeroCelular, "
                        + "numeroCelularConfirmado, "
                        + "autenticacionDosPasos, "
                        + "conteoAccesosFallidos, "
                        + "foto, "
                        + "idRol, "
                        + "token "
                        + ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                registro.setString(1, obj.getNombre());
                registro.setString(2, obj.getApellido());
                registro.setString(3, obj.getNombreUsuario());
                registro.setString(4, obj.getContraseniia());
                registro.setTimestamp(5, obj.getFechaCreacion());
                registro.setTimestamp(6, obj.getUltimaConexion());
                registro.setString(7, obj.getEstadoCuenta());
                registro.setInt(8, obj.isEstadoLogico());
                registro.setInt(9, obj.isConectado());
                registro.setString(10, obj.getCorreoElectronico());
                registro.setInt(11, obj.isCorreoConfirmado());
                registro.setInt(12, obj.getNumeroCelular());
                registro.setInt(13, obj.isNumeroCelularConfirmado());
                registro.setInt(14, obj.isAutenticacionDosPasos());
                registro.setInt(15, obj.getConteoAccesosFallidos());
                registro.setString(16, obj.getFoto());
                registro.setInt(17, obj.getIdRol());
                registro.setString(18, obj.getToken());
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
    public GenericResponse<Usuario> actualizar(IConexion conexionDB, int id) {
        GenericResponse<Usuario> response = new GenericResponse<>();
        if (conexionDB.getConexion() != null) {

            Usuario obj = encontrarId(conexionDB, id);
            if (obj != null) {
                if (obj.isConectado() == 1) {
                    obj.setConectado(0);
                } else {
                    obj.setConectado(1);
                }
                obj.setUltimaConexion(Misc.getDateTimeActualSQL());
                try {
                    String sql = "UPDATE Usuario SET "
                            + "ultimaConexion=?, "
                            + "conectado=? "
                            + "WHERE idUsuario=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setTimestamp(1, obj.getUltimaConexion());
                    registro.setInt(2, obj.isConectado());
                    registro.setInt(3, id);
                    int r = registro.executeUpdate();
                    if (r > 0) {
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
                    response.setMensaje("Error de comunicación con la base de datos " + ex.getMessage());
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
    public GenericResponse<Usuario> editar(IConexion conexionDB, int id, Usuario nvoObj) {
        GenericResponse<Usuario> response = new GenericResponse<>();
        if (conexionDB.getConexion() != null) {
            Usuario obj = encontrarId(conexionDB, id);
            if (obj != null) {
                try {
                    String sql = "UPDATE Usuario SET "
                            + "nombreUsuario=?, "
                            + "estadoCuenta=?, "
                            + "estadoLogico=?, "
                            + "correoElectronico=?, "
                            + "correoConfirmado=?, "
                            + "numeroCelular=?, "
                            + "numeroCelularConfirmado=?, "
                            + "autenticacionDosPasos=?, "
                            + "conteoAccesosFallidos=?, "
                            + "foto=?, "
                            + "idRol=?, "
                            + "token=? "
                            + "WHERE idUsuario=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setString(1, nvoObj.getNombreUsuario());
                    registro.setString(2, nvoObj.getEstadoCuenta());
                    registro.setInt(3, nvoObj.isEstadoLogico());
                    registro.setString(4, nvoObj.getCorreoElectronico());
                    registro.setInt(5, nvoObj.isCorreoConfirmado());
                    registro.setInt(6, nvoObj.getNumeroCelular());
                    registro.setInt(7, nvoObj.isNumeroCelularConfirmado());
                    registro.setInt(8, nvoObj.isAutenticacionDosPasos());
                    registro.setInt(9, nvoObj.getConteoAccesosFallidos());
                    registro.setString(10, nvoObj.getFoto());
                    registro.setInt(11, nvoObj.getIdRol());
                    registro.setInt(12, id);
                    registro.setString(12, nvoObj.getToken());
                    int r = registro.executeUpdate();
                    if (r > 0) {
                        nvoObj.setIdUsuario(id);
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
                    response.setMensaje("Error de comunicación con la base de datos " + ex.getMessage());
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
    public GenericResponse<Usuario> eliminar(IConexion conexionDB, int id) {
        GenericResponse<Usuario> response = new GenericResponse<>();
        if (conexionDB.getConexion() != null) {
            Usuario obj = encontrarId(conexionDB, id);
            if (obj != null) {
                try {
                    String sql = "DELETE FROM Usuario "
                            + "WHERE idUsuario=?";
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
                    response.setMensaje("Error de comunicación con la base de datos " + ex.getMessage());
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
    public List<Usuario> getData(IConexion conexionDB) {
        List<Usuario> response = new ArrayList<>();

        if (conexionDB.getConexion() != null) {
            try {
                String sql = "SELECT "
                        + "idUsuario, "
                        + "nombreUsuario, "
                        + "fechaCreacion, "
                        + "ultimaConexion, "
                        + "estadoCuenta, "
                        + "estadoLogico, "
                        + "conectado, "
                        + "correoElectronico, "
                        + "correoConfirmado, "
                        + "numeroCelular, "
                        + "numeroCelularConfirmado, "
                        + "autenticacionDosPasos, "
                        + "conteoAccesosFallidos, "
                        + "foto, "
                        + "idRol, "
                        + "token "
                        + "FROM Usuario";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    Usuario user = new Usuario();
                    user.setIdUsuario(rs.getInt(1));
                    user.setNombreUsuario(rs.getString(2));
                    user.setFechaCreacion(rs.getTimestamp(3));
                    user.setUltimaConexion(rs.getTimestamp(4));
                    user.setEstadoCuenta(rs.getString(5));
                    user.setEstadoLogico(rs.getInt(6));
                    user.setConectado(rs.getInt(7));
                    user.setCorreoElectronico(rs.getString(8));
                    user.setCorreoConfirmado(rs.getInt(9));
                    user.setNumeroCelular(rs.getInt(10));
                    user.setNumeroCelularConfirmado(rs.getInt(11));
                    user.setAutenticacionDosPasos(rs.getInt(12));
                    user.setConteoAccesosFallidos(rs.getInt(13));
                    user.setFoto(rs.getString(14));
                    user.setIdRol(rs.getInt(15));
                    user.setToken(rs.getString(16));
                    response.add(user);
                }
            } catch (SQLException ex) {
                Logg.error("Comunicación fallida con la base de datos " + ex.getMessage());
            } finally {

            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return response;
    }

    @Override
    public List<Usuario> consultar(IConexion conexionDB, String... filtros) {
        List<Usuario> response = new ArrayList<>();
        response.stream().filter(user -> user.getIdUsuario() > 20).forEach(
                //System.out::println
                //user->{System.out.println("Nombre: "+user.getNombreUsuario());}
                user -> System.out.println("Nombre: " + user.getNombreUsuario())
        );
        return response;
    }

    @Override
    public Usuario encontrarId(IConexion conexionDB, int id) {
        Usuario response = null;

        if (conexionDB.getConexion() != null) {
            try {
                String sql = "SELECT "
                        + "idUsuario, "
                        + "nombreUsuario, "
                        + "fechaCreacion, "
                        + "ultimaConexion, "
                        + "estadoCuenta, "
                        + "estadoLogico, "
                        + "conectado, "
                        + "correoElectronico, "
                        + "correoConfirmado, "
                        + "numeroCelular, "
                        + "numeroCelularConfirmado, "
                        + "autenticacionDosPasos, "
                        + "conteoAccesosFallidos, "
                        + "foto, "
                        + "idRol, "
                        + "token "
                        + "FROM Usuario "
                        + "WHERE idUsuario=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs;
                rs = ps.executeQuery();
                if (rs.next()) {
                    response = new Usuario();
                    response.setIdUsuario(rs.getInt(1));
                    response.setNombreUsuario(rs.getString(2));
                    response.setFechaCreacion(rs.getTimestamp(3));
                    response.setUltimaConexion(rs.getTimestamp(4));
                    response.setEstadoCuenta(rs.getString(5));
                    response.setEstadoLogico(rs.getInt(6));
                    response.setConectado(rs.getInt(7));
                    response.setCorreoElectronico(rs.getString(8));
                    response.setCorreoConfirmado(rs.getInt(9));
                    response.setNumeroCelular(rs.getInt(10));
                    response.setNumeroCelularConfirmado(rs.getInt(11));
                    response.setAutenticacionDosPasos(rs.getInt(12));
                    response.setConteoAccesosFallidos(rs.getInt(13));
                    response.setFoto(rs.getString(14));
                    response.setIdRol(rs.getInt(15));
                    response.setToken(rs.getString(16));
                } else {
                    Logg.error("No se encontro ningun registro");
                }
            } catch (SQLException ex) {
                Logg.error("Comunicación fallida con la base de datos " + ex.getMessage());
            } finally {

            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return response;
    }

    public Usuario encontrarCorreo(IConexion conexionDB, String correo) {
        Usuario response = null;

        if (conexionDB.getConexion() != null) {
            try {
                String sql = "SELECT "
                        + "idUsuario, "
                        + "nombreUsuario, "
                        + "fechaCreacion, "
                        + "ultimaConexion, "
                        + "estadoCuenta, "
                        + "estadoLogico, "
                        + "conectado, "
                        + "correoElectronico, "
                        + "correoConfirmado, "
                        + "numeroCelular, "
                        + "numeroCelularConfirmado, "
                        + "autenticacionDosPasos, "
                        + "conteoAccesosFallidos, "
                        + "foto, "
                        + "idRol, "
                        + "token "
                        + "FROM Usuario "
                        + "WHERE correoElectronico=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setString(1, correo);
                ResultSet rs;
                rs = ps.executeQuery();
                if (rs.next()) {
                    response = new Usuario();
                    response.setIdUsuario(rs.getInt(1));
                    response.setNombreUsuario(rs.getString(2));
                    response.setFechaCreacion(rs.getTimestamp(3));
                    response.setUltimaConexion(rs.getTimestamp(4));
                    response.setEstadoCuenta(rs.getString(5));
                    response.setEstadoLogico(rs.getInt(6));
                    response.setConectado(rs.getInt(7));
                    response.setCorreoElectronico(rs.getString(8));
                    response.setCorreoConfirmado(rs.getInt(9));
                    response.setNumeroCelular(rs.getInt(10));
                    response.setNumeroCelularConfirmado(rs.getInt(11));
                    response.setAutenticacionDosPasos(rs.getInt(12));
                    response.setConteoAccesosFallidos(rs.getInt(13));
                    response.setFoto(rs.getString(14));
                    response.setIdRol(rs.getInt(15));
                    response.setToken(rs.getString(16));
                } else {
                    Logg.error("No se encontro ningun registro");
                }
            } catch (SQLException ex) {
                Logg.error("Comunicación fallida con la base de datos " + ex.getMessage());
            } finally {

            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return response;
    }

    public Usuario encontrarStatus(IConexion conexionDB, String nombre, String contrasenia) {
        Usuario response = null;

        if (conexionDB.getConexion() != null) {
            try {
                String sql = "SELECT "
                        + "idUsuario, "
                        + "nombreUsuario, "
                        + "fechaCreacion, "
                        + "ultimaConexion, "
                        + "estadoCuenta, "
                        + "estadoLogico, "
                        + "conectado, "
                        + "correoElectronico, "
                        + "correoConfirmado, "
                        + "numeroCelular, "
                        + "numeroCelularConfirmado, "
                        + "autenticacionDosPasos, "
                        + "conteoAccesosFallidos, "
                        + "foto, "
                        + "idRol, "
                        + "token, "
                        + "nombre, "
                        + "apellido "
                        + "FROM Usuario "
                        + "WHERE correoElectronico=? AND contrasenia=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setString(1, nombre);
                ps.setString(2, contrasenia);
                ResultSet rs;
                rs = ps.executeQuery();
                if (rs.next()) {
                    response = new Usuario();
                    response.setIdUsuario(rs.getInt(1));
                    response.setNombreUsuario(rs.getString(2));
                    response.setFechaCreacion(rs.getTimestamp(3));
                    response.setUltimaConexion(rs.getTimestamp(4));
                    response.setEstadoCuenta(rs.getString(5));
                    response.setEstadoLogico(rs.getInt(6));
                    response.setConectado(rs.getInt(7));
                    response.setCorreoElectronico(rs.getString(8));
                    response.setCorreoConfirmado(rs.getInt(9));
                    response.setNumeroCelular(rs.getInt(10));
                    response.setNumeroCelularConfirmado(rs.getInt(11));
                    response.setAutenticacionDosPasos(rs.getInt(12));
                    response.setConteoAccesosFallidos(rs.getInt(13));
                    response.setFoto(rs.getString(14));
                    response.setIdRol(rs.getInt(15));
                    response.setToken(rs.getString(16));
                    response.setNombre(rs.getString(17));
                    response.setApellido(rs.getString(18));
                } else {
                    Logg.error("No se encontro ningun registro");
                }
            } catch (SQLException ex) {
                Logg.error("Comunicación fallida con la base de datos " + ex.getMessage());
            } finally {

            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return response;
    }

    public Usuario encontrarStatus(IConexion conexionDB, String nombre) {
        Usuario response = null;

        if (conexionDB.getConexion() != null) {
            try {
                String sql = "SELECT "
                        + "idUsuario, "
                        + "nombreUsuario, "
                        + "fechaCreacion, "
                        + "ultimaConexion, "
                        + "estadoCuenta, "
                        + "estadoLogico, "
                        + "conectado, "
                        + "correoElectronico, "
                        + "correoConfirmado, "
                        + "numeroCelular, "
                        + "numeroCelularConfirmado, "
                        + "autenticacionDosPasos, "
                        + "conteoAccesosFallidos, "
                        + "foto, "
                        + "idRol, "
                        + "token "
                        + "FROM Usuario "
                        + "WHERE nombreUsuario=? ";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setString(1, nombre);
                ResultSet rs;
                rs = ps.executeQuery();
                if (rs.next()) {
                    response = new Usuario();
                    response.setIdUsuario(rs.getInt(1));
                    response.setNombreUsuario(rs.getString(2));
                    response.setFechaCreacion(rs.getTimestamp(3));
                    response.setUltimaConexion(rs.getTimestamp(4));
                    response.setEstadoCuenta(rs.getString(5));
                    response.setEstadoLogico(rs.getInt(6));
                    response.setConectado(rs.getInt(7));
                    response.setCorreoElectronico(rs.getString(8));
                    response.setCorreoConfirmado(rs.getInt(9));
                    response.setNumeroCelular(rs.getInt(10));
                    response.setNumeroCelularConfirmado(rs.getInt(11));
                    response.setAutenticacionDosPasos(rs.getInt(12));
                    response.setConteoAccesosFallidos(rs.getInt(13));
                    response.setFoto(rs.getString(14));
                    response.setIdRol(rs.getInt(15));
                    response.setToken(rs.getString(16));
                } else {
                    Logg.error("No se encontro ningun registro");
                }
            } catch (SQLException ex) {
                Logg.error("Comunicación fallida con la base de datos " + ex.getMessage());
            } finally {

            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return response;
    }

    public List<Solicitud> getSolicitudesEnviadas(IConexion conexionDB, int idUsuario) {
        List<Solicitud> lstSolicitud = new ArrayList<>();

        if (conexionDB.getConexion() != null) {
            try {
                String sql = "SELECT "
                        + "idSolicitud, "
                        + "idUsuarioDonatario, "
                        + "idRecurso, "
                        + "estadoSolicitud, "
                        + "fechaSolicitud, "
                        + "fechaRespuesta, "
                        + "idUsuarioDonador "
                        + "FROM Solicitud "
                        + "WHERE idUsuarioDonatario=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setInt(1, idUsuario);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    Solicitud sol = new Solicitud();
                    sol.setIdSolicitud(rs.getInt(1));
                    sol.setIdUsuarioDonatario(rs.getInt(2));
                    sol.setIdRecursoTecnologico(rs.getInt(3));
                    sol.setEstadoSolicitud(rs.getString(4));
                    sol.setFechaSolicitud(rs.getTimestamp(5));
                    sol.setFechaRespuesta(rs.getTimestamp(6));
                    sol.setIdUsuarioDonador(rs.getInt(7));
                    lstSolicitud.add(sol);
                }
            } catch (SQLException ex) {
                Logg.error("Comunicación fallida con la base de datos " + ex.getMessage());
            } finally {

            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return lstSolicitud;
    }

    public List<Donacion> getDonacionRecibidas(IConexion conexionDB, int idUsuario) {
        List<Donacion> lstDonacion = new ArrayList<>();

        if (conexionDB.getConexion() != null) {
            try {
                String sql = "SELECT "
                        + "idDonacion, "
                        + "idDonador, "
                        + "idDonatario, "
                        + "idRecurso, "
                        + "fechaDonacion, "
                        + "estadoDonacion, "
                        + "noConfirmacion "
                        + "remunerado "
                        + "FROM Donacion "
                        + "WHERE idDonatario=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setInt(1, idUsuario);
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
                    lstDonacion.add(sol);
                }
            } catch (SQLException ex) {
                Logg.error("Comunicación fallida con la base de datos " + ex.getMessage());
            } finally {

            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return lstDonacion;
    }

    public List<Donacion> getDonacionDadas(IConexion conexionDB, int idUsuario) {
        List<Donacion> lstDonacion = new ArrayList<>();

        if (conexionDB.getConexion() != null) {
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
                        + "FROM Donacion "
                        + "WHERE idDonador=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setInt(1, idUsuario);
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
                    lstDonacion.add(sol);
                }
            } catch (SQLException ex) {
                Logg.error("Comunicación fallida con la base de datos " + ex.getMessage());
            } finally {

            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return lstDonacion;
    }

    public List<GaleriaPerfil> getFotoPerfil(IConexion conexionDB, int idUsuario) {
        List<GaleriaPerfil> lstGaleria = new ArrayList<>();

        if (conexionDB.getConexion() != null) {
            try {
                String sql = "SELECT "
                        + "idGaleria, "
                        + "idUsuario, "
                        + "nombreImagen, "
                        + "tamanio, "
                        + "extension, "
                        + "urlDestino "
                        + "FROM GaleriaPerfil "
                        + "WHERE idUsuario=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setInt(1, idUsuario);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    lstGaleria.add(new GaleriaPerfil(rs.getInt(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getDouble(4),
                            rs.getString(5),
                            rs.getString(6)));
                }
            } catch (SQLException ex) {
                Logg.error("Comunicación fallida con la base de datos " + ex.getMessage());
            } finally {

            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return lstGaleria;
    }

    public List<Intencion> getIntenciones(IConexion conexionDB, int idUsuario) {
        List<Intencion> lstIntencion = new ArrayList<>();

        if (conexionDB.getConexion() != null) {
            try {
                String sql = "SELECT "
                        + "idIntencion, "
                        + "idUsuario, "
                        + "tituloIntencion, "
                        + "descripcion, "
                        + "fechaIntencion, "
                        + "estadoIntencion, "
                        + "respuestaIntencion, "
                        + "fechaRespuesta "
                        + "FROM Intencion "
                        + "WHERE idUsuario=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setInt(1, idUsuario);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    Intencion sol = new Intencion();
                    sol.setIdIntencion(rs.getInt(1));
                    sol.setIdUsuario(rs.getInt(2));
                    sol.setTituloIntencion(rs.getString(3));
                    sol.setDescripcion(rs.getString(4));
                    sol.setFechaIntencion(rs.getTimestamp(5));
                    sol.setEstadoIntencion(rs.getString(6));
                    sol.setRespuestaIntencion(rs.getString(6));
                    sol.setFechaRespuesta(rs.getTimestamp(6));
                    lstIntencion.add(sol);
                }
            } catch (SQLException ex) {
                Logg.error("Comunicación fallida con la base de datos " + ex.getMessage());
            } finally {

            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return lstIntencion;
    }

    public Direccion getDireccion(IConexion conexionDB, int idUsuario) {
        Direccion dir = null;

        if (conexionDB.getConexion() != null) {
            try {
                String sql = "SELECT "
                        + "idDireccion, "
                        + "idEstado, "
                        + "idMunicipio, "
                        + "idLocalidad, "
                        + "referencias, "
                        + "calleInteriorYNumero, "
                        + "calleExteriorYNumero, "
                        + "calleFrontal, "
                        + "calleTrasera, "
                        + "calleDerecha, "
                        + "calleIzquierda, "
                        + "tipoAsentamiento, "
                        + "nombreAsentamiento, "
                        + "idUsuario, "
                        + "codigo_postal "
                        + "FROM Direccion "
                        + "WHERE idUsuario=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setInt(1, idUsuario);
                ResultSet rs;
                rs = ps.executeQuery();
                if (rs.next()) {
                    dir = new Direccion();
                    dir.setIdDireccion(rs.getInt(1));
                    dir.setIdEstado(rs.getInt(2));
                    dir.setIdMunicipio(rs.getInt(3));
                    dir.setIdLocalidad(rs.getInt(4));
                    dir.setReferencias(rs.getString(5));
                    dir.setCalleInteriorYNumero(rs.getString(6));
                    dir.setCalleExteriorYNumero(rs.getString(7));
                    dir.setCalleFrontal(rs.getString(8));
                    dir.setCalleTrasera(rs.getString(9));
                    dir.setCalleDerecha(rs.getString(10));
                    dir.setCalleIzquierda(rs.getString(11));
                    dir.setTipoAsentamiento(rs.getString(12));
                    dir.setNombreAsentamiento(rs.getString(13));
                    dir.setIdUsuario(rs.getInt(14));
                    dir.setCodigoPostal(rs.getString(15));
                } else {
                    Logg.error("No se encontro ningun registro");
                }
            } catch (SQLException ex) {
                Logg.error("Comunicación fallida con la base de datos " + ex.getMessage());
            } finally {

            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return dir;
    }

    public List<Notificacion> getNotificacion(IConexion conexionDB, int idUsuario) {
        List<Notificacion> lstNotificacion = new ArrayList<>();

        if (conexionDB.getConexion() != null) {
            try {
                String sql = "SELECT "
                        + "idNotificacion, "
                        + "idUsuarioDestino, "
                        + "fechaNotificacion, "
                        + "estadoVisualizacion, "
                        + "prioridad, "
                        + "mensaje "
                        + "FROM Notificacion "
                        + "WHERE idUsuarioDestino=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setInt(1, idUsuario);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    lstNotificacion.add(new Notificacion(rs.getInt(1),
                            rs.getInt(2),
                            rs.getTimestamp(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6)));
                }
            } catch (SQLException ex) {
                Logg.error("Comunicación fallida con la base de datos " + ex.getMessage());
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return lstNotificacion;
    }

    public String getTipoAcceso(IConexion conexionDB, int idUsuario) {
        String tipoAcceso = "";

        if (conexionDB.getConexion() != null) {
            try {
                String sql = "SELECT "
                        + "idRol "
                        + "FROM Usuario "
                        + "WHERE idUsuario=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setInt(1, idUsuario);
                ResultSet rs;
                rs = ps.executeQuery();
                if (rs.next()) {
                    try {
                        int idRol = rs.getInt(1);
                        String sqlRol = "SELECT "
                                + "rol "
                                + "FROM Rol "
                                + "WHERE idRol=?";
                        PreparedStatement ps2 = conexionDB.getConexion().prepareStatement(sqlRol);
                        ps2.setInt(1, idRol);
                        ResultSet rs2;
                        rs2 = ps2.executeQuery();
                        if (rs2.next()) {
                            tipoAcceso = rs2.getString(1);
                        } else {
                            tipoAcceso = "Default";
                            Logg.error("ROL del usuario corrupto");
                        }
                    } catch (SQLException e) {
                        tipoAcceso = "Default";
                        Logg.error("Fallo la asignacion de IdRol " + e.getMessage());
                    }
                } else {
                    tipoAcceso = "Default";
                    Logg.error("No se encontro ningun registro");
                }
            } catch (SQLException ex) {
                tipoAcceso = "Default";
                Logg.error("Comunicación fallida con la base de datos " + ex.getMessage());
            } finally {

            }
        } else {
            tipoAcceso = "Default";
            Logg.error("Conexión fallida con la base de datos ");
        }
        return tipoAcceso;
    }

    public Organizacion getOrganizacion(IConexion conexionDB, int idUsuario) {
        Organizacion org = null;

        if (conexionDB.getConexion() != null) {
            try {
                String sql = "SELECT "
                        + "idOrganizacion, "
                        + "idUsuario, "
                        + "reciboDeducible, "
                        + "razonSocial, "
                        + "telefonoFijo, "
                        + "telefonoMovil, "
                        + "email, "
                        + "sitioWeb, "
                        + "estadoLogico, "
                        + "rfc, "
                        + "tipooOrg, "
                        + "autorizada, "
                        + "linkFacebook, "
                        + "linkInstagram, "
                        + "linkLinkedin, "
                        + "linkTwiteer, "
                        + "nombreContacto, "
                        + "apellidosContacto, "
                        + "cargo, "
                        + "donatariaAutorizada, "
                        + "fechaDonatariaAutorizada, "
                        + "cluni, "
                        + "noNotariaPublica "
                        + "FROM Organizacion "
                        + "WHERE idUsuario=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setInt(1, idUsuario);
                ResultSet rs;
                rs = ps.executeQuery();
                if (rs.next()) {
                    org = new Organizacion();
                    org.setIdOrganizacion(rs.getInt(1));
                    org.setIdUsuario(rs.getInt(2));
                    org.setReciboDeducible(rs.getInt(3));
                    org.setRazonSocial(rs.getString(4));
                    org.setNumeroTelFijo(rs.getInt(5));
                    org.setNumeroTelMovil(rs.getInt(6));
                    org.setEmail(rs.getString(7));
                    org.setSitioWeb(rs.getString(8));
                    org.setEstadoLogico(rs.getInt(9));
                    org.setRfc(rs.getString(10));
                    org.setTipoOrganizacion(rs.getString(11));
                    org.setAutorizada(rs.getString(12));
                    org.setLinkFacebook(rs.getString(13));
                    org.setLinkInstragram(rs.getString(14));
                    org.setLinkLinkedin(rs.getString(15));
                    org.setLinkTwiteer(rs.getString(16));
                    org.setNombreContacto(rs.getString(17));
                    org.setAutorizada(rs.getString(18));
                    org.setCargo(rs.getString(19));
                    org.setDonatariaAutorizada(rs.getString(20));
                    org.setFechaDonatariaAutorizada(rs.getTimestamp(21));
                    org.setCluni(rs.getString(22));
                    org.setNoNotariaPublica(rs.getString(23));
                } else {
                    Logg.error("No se encontro ningun registro");
                }
            } catch (SQLException ex) {
                Logg.error("Comunicación fallida con la base de datos " + ex.getMessage());
            } finally {

            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return org;
    }

    public Estudiante getEstudiante(IConexion conexionDB, int idUsuario) {
        Estudiante est = null;

        if (conexionDB.getConexion() != null) {
            try {
                String sql = "SELECT "
                        + "idEstudiante, "
                        + "idUsuario, "
                        + "nombres, "
                        + "apellidoPaterno, "
                        + "apellidoMaterno, "
                        + "fechaNacimiento, "
                        + "genero, "
                        + "presentacion, "
                        + "telefonoMovil, "
                        + "telefonoCasa, "
                        + "lugarNacimiento, "
                        + "nacionalidad, "
                        + "nivelEducativo, "
                        + "ocupacion, "
                        + "tipoEscuela, "
                        + "promedioAnterior, "
                        + "estatusEscolar, "
                        + "intereses, "
                        + "habilidades, "
                        + "estadoLogico, "
                        + "curp, "
                        + "estadoCivil, "
                        + "nombreEscuela, "
                        + "matricula, "
                        + "regular, "
                        + "tipoPeriodo, "
                        + "totalPeriodos, "
                        + "periodoActual, "
                        + "periodo, "
                        + "promedioGeneral, "
                        + "validado "
                        + "FROM Estudiante "
                        + "WHERE idUsuario=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setInt(1, idUsuario);
                ResultSet rs;
                rs = ps.executeQuery();
                if (rs.next()) {
                    est = new Estudiante();
                    est.setIdEstudiante(rs.getInt(1));
                    est.setIdUsuario(rs.getInt(2));
                    est.setNombres(rs.getString(3));
                    est.setApellidoPaterno(rs.getString(4));
                    est.setApellidoMaterno(rs.getString(5));
                    est.setFechaNacimiento(rs.getDate(6));
                    est.setGenero(rs.getString(7));
                    est.setPresentacion(rs.getString(8));
                    est.setNumeroTelMovil(rs.getInt(9));
                    est.setNumeroTelFijo(rs.getInt(10));
                    est.setLugarNacimiento(rs.getString(11));
                    est.setNacionalidad(rs.getString(12));
                    est.setNivelEducativo(rs.getString(13));
                    est.setOcupacion(rs.getString(14));
                    est.setTipoEscuela(rs.getString(15));
                    est.setPromedioAnterior(rs.getDouble(16));
                    est.setEstatusEscolar(rs.getInt(17));
                    est.setIntereses(rs.getString(18));
                    est.setHabilidades(rs.getString(19));
                    est.setEstadoLogico(rs.getInt(20));
                    est.setCurp(rs.getString(21));
                    est.setEstadoCivil(rs.getString(22));
                    est.setNombreEscuela(rs.getString(23));
                    est.setMatricula(rs.getString(24));
                    est.setRegular(rs.getInt(25));
                    est.setTipoPeriodo(rs.getString(26));
                    est.setTotalPeriodos(rs.getInt(27));
                    est.setPeriodoActual(rs.getInt(28));
                    est.setPeriodo(rs.getString(29));
                    est.setPromedioGeneral(rs.getDouble(30));
                    est.setValidado(rs.getString(31));
                } else {
                    Logg.error("No se encontro ningun registro");
                }
            } catch (SQLException ex) {
                Logg.error("Comunicación fallida con la base de datos " + ex.getMessage());
            } finally {

            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return est;
    }

    /**
     * En donde se encuentra el usuario, con el perfil de estudiante o
     * organizacion o en ninguna de las dos, si es el caso, checar el rol y tipo
     * de acceso dentro de la plataforma puede ser el administrador o manager...
     *
     * @param conexionDB
     * @param idUsuario
     * @return
     */
    public Object getTipoUsuarioAsociado(IConexion conexionDB, int idUsuario) {
        Object obj = null;
        Estudiante est = getEstudiante(conexionDB, idUsuario);
        Organizacion org = getOrganizacion(conexionDB, idUsuario);
        if (est != null && org != null) {
            GenericResponse<Object> response = new GenericResponse<>();
            Object[] obj2 = new Object[2];
            obj2[0] = est;
            obj2[1] = org;
            response.setMensaje("Hay una ambiguedad de usuarios");
            response.setResponseObject(obj2);
            response.setStatus(utils.Constantes.LOGIC_WARNING);
            return response;
        } else if (est != null) {
            return est;
        } else if (org != null) {
            return org;
        }
        return obj;
    }

    public String getConstasenia(IConexion conexionDB, int idUsuario) {
        String constrasenia = "";

        if (conexionDB.getConexion() != null) {
            Usuario obj = encontrarId(conexionDB, idUsuario);
            if (obj != null) {
                try {
                    String sql = "SELECT "
                            + "contrasenia "
                            + "FROM Usuario"
                            + "WHERE idUsuario=?";
                    PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                    ps.setInt(1, idUsuario);
                    ResultSet rs;
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        constrasenia = rs.getString(1);
                    } else {
                        Logg.error("No se encontro ningun registro");
                    }
                } catch (SQLException ex) {
                    Logg.error("Error de comunicación con la base de datos " + ex.getMessage());
                } finally {

                }
            } else {
                Logg.error("El registro no existe");

            }
        } else {
            Logg.error("Error de conexión a la base de datos");
        }
        return constrasenia;
    }

    public boolean changeNombreUsuario(IConexion conexionDB, int idUsuario, String nombre) {
        boolean status = false;

        if (conexionDB.getConexion() != null) {
            Usuario obj = encontrarId(conexionDB, idUsuario);
            if (obj != null) {
                try {
                    String sql = "UPDATE Usuario SET "
                            + "nombreUsuario=? "
                            + "WHERE idUsuario=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setString(1, nombre);
                    registro.setInt(2, idUsuario);
                    int r = registro.executeUpdate();
                    if (r > 0) {
                        status = true;
                        Logg.exito("Edición exitosa en la base de datos");
                    } else {
                        Logg.error("Edición fallido en la base de datos");
                    }
                } catch (SQLException ex) {
                    Logg.error("Error de comunicación con la base de datos " + ex.getMessage());
                } finally {

                }
            } else {
                Logg.error("El registro no existe");

            }
        } else {
            Logg.error("Error de conexión a la base de datos");
        }
        return status;
    }

    public boolean changeConstasenia(IConexion conexionDB, int idUsuario, String constrasenia) {
        boolean status = false;

        if (conexionDB.getConexion() != null) {
            Usuario obj = encontrarId(conexionDB, idUsuario);
            if (obj != null) {
                try {
                    String sql = "UPDATE Usuario SET "
                            + "contrasenia=? "
                            + "WHERE idUsuario=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setString(1, constrasenia);
                    registro.setInt(2, idUsuario);
                    int r = registro.executeUpdate();
                    if (r > 0) {
                        status = true;
                        Logg.exito("Edición exitosa en la base de datos");
                    } else {
                        Logg.error("Edición fallido en la base de datos");
                    }
                } catch (SQLException ex) {
                    Logg.error("Error de comunicación con la base de datos " + ex.getMessage());
                } finally {

                }
            } else {
                Logg.error("El registro no existe");

            }
        } else {
            Logg.error("Error de conexión a la base de datos");
        }
        return status;
    }

    public boolean changeCorreoElectronico(IConexion conexionDB, int idUsuario, String correoElectronico) {
        boolean status = false;

        if (conexionDB.getConexion() != null) {
            Usuario obj = encontrarId(conexionDB, idUsuario);
            if (obj != null) {
                try {
                    String sql = "UPDATE Usuario SET "
                            + "correoElectronico=? "
                            + "WHERE idUsuario=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setString(1, correoElectronico);
                    registro.setInt(2, idUsuario);
                    int r = registro.executeUpdate();
                    if (r > 0) {
                        status = true;
                        Logg.exito("Edición exitosa en la base de datos");
                    } else {
                        Logg.error("Edición fallido en la base de datos");
                    }
                } catch (SQLException ex) {
                    Logg.error("Error de comunicación con la base de datos " + ex.getMessage());
                } finally {

                }
            } else {
                Logg.error("El registro no existe");

            }
        } else {
            Logg.error("Error de conexión a la base de datos");
        }
        return status;
    }

    public boolean changeCelular(IConexion conexionDB, int idUsuario, int celular) {
        boolean status = false;

        if (conexionDB.getConexion() != null) {
            Usuario obj = encontrarId(conexionDB, idUsuario);
            if (obj != null) {
                try {
                    String sql = "UPDATE Usuario SET "
                            + "numeroCelular=? "
                            + "WHERE idUsuario=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setInt(1, celular);
                    registro.setInt(2, idUsuario);
                    int r = registro.executeUpdate();
                    if (r > 0) {
                        status = true;
                        Logg.exito("Edición exitosa en la base de datos");
                    } else {
                        Logg.error("Edición fallido en la base de datos");
                    }
                } catch (SQLException ex) {
                    Logg.error("Error de comunicación con la base de datos " + ex.getMessage());
                } finally {

                }
            } else {
                Logg.error("El registro no existe");

            }
        } else {
            Logg.error("Error de conexión a la base de datos");
        }
        return status;
    }

    public boolean changeConfirmarCorreo(IConexion conexionDB, int idUsuario, boolean confirmacion) {
        boolean status = false;

        if (conexionDB.getConexion() != null) {
            Usuario obj = encontrarId(conexionDB, idUsuario);
            if (obj != null) {
                try {
                    String sql = "UPDATE Usuario SET "
                            + "correoConfirmado=? "
                            + "WHERE idUsuario=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setBoolean(1, confirmacion);
                    registro.setInt(2, idUsuario);
                    int r = registro.executeUpdate();
                    if (r > 0) {
                        status = true;
                        Logg.exito("Edición exitosa en la base de datos");
                    } else {
                        Logg.error("Edición fallido en la base de datos");
                    }
                } catch (SQLException ex) {
                    Logg.error("Error de comunicación con la base de datos " + ex.getMessage());
                } finally {

                }
            } else {
                Logg.error("El registro no existe");

            }
        } else {
            Logg.error("Error de conexión a la base de datos");
        }
        return status;
    }

    public boolean changeConfirmarCelular(IConexion conexionDB, int idUsuario, boolean confirmacion) {
        boolean status = false;

        if (conexionDB.getConexion() != null) {
            Usuario obj = encontrarId(conexionDB, idUsuario);
            if (obj != null) {
                try {
                    String sql = "UPDATE Usuario SET "
                            + "numeroCelularConfirmado=? "
                            + "WHERE idUsuario=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setBoolean(1, confirmacion);
                    registro.setInt(2, idUsuario);
                    int r = registro.executeUpdate();
                    if (r > 0) {
                        status = true;
                        Logg.exito("Edición exitosa en la base de datos");
                    } else {
                        Logg.error("Edición fallido en la base de datos");
                    }
                } catch (SQLException ex) {
                    Logg.error("Error de comunicación con la base de datos " + ex.getMessage());
                } finally {

                }
            } else {
                Logg.error("El registro no existe");

            }
        } else {
            Logg.error("Error de conexión a la base de datos");
        }
        return status;
    }

    public boolean changeAutenticarDosPasos(IConexion conexionDB, int idUsuario, boolean confirmacion) {
        boolean status = false;

        if (conexionDB.getConexion() != null) {
            Usuario obj = encontrarId(conexionDB, idUsuario);
            if (obj != null) {
                try {
                    String sql = "UPDATE Usuario SET "
                            + "autenticacionDosPasos=? "
                            + "WHERE idUsuario=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setBoolean(1, confirmacion);
                    registro.setInt(2, idUsuario);
                    int r = registro.executeUpdate();
                    if (r > 0) {
                        status = true;
                        Logg.exito("Edición exitosa en la base de datos");
                    } else {
                        Logg.error("Edición fallido en la base de datos");
                    }
                } catch (SQLException ex) {
                    Logg.error("Error de comunicación con la base de datos " + ex.getSQLState());
                } finally {

                }
            } else {
                Logg.error("El registro no existe");

            }
        } else {
            Logg.error("Error de conexión a la base de datos");
        }
        return status;
    }

    /**
     * Bloquear cuenta...
     *
     * @param conexionDB
     * @param idUsuario
     * @param accesos
     * @return
     */
    public boolean changeAccesosFallidos(IConexion conexionDB, int idUsuario, int accesos) {
        boolean status = false;

        if (conexionDB.getConexion() != null) {
            Usuario obj = encontrarId(conexionDB, idUsuario);
            if (obj != null) {
                if (accesos >= 3) {
                    obj.setEstadoCuenta("Bl");
                }
                try {
                    String sql = "UPDATE Usuario SET "
                            + "conteoAccesosFallidos=?, "
                            + "estadoCuenta=? "
                            + "WHERE idUsuario=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setInt(1, accesos);
                    registro.setString(2, obj.getEstadoCuenta());
                    registro.setInt(3, idUsuario);
                    int r = registro.executeUpdate();
                    if (r > 0) {
                        status = true;
                        Logg.exito("Edición exitosa en la base de datos");
                    } else {
                        Logg.error("Edición fallido en la base de datos");
                    }
                } catch (SQLException ex) {
                    Logg.error("Error de comunicación con la base de datos " + ex.getSQLState());
                } finally {

                }
            } else {
                Logg.error("El registro no existe");

            }
        } else {
            Logg.error("Error de conexión a la base de datos");
        }
        return status;
    }

    public boolean changeFoto(IConexion conexionDB, int idUsuario, String foto) {
        boolean status = false;
        if (conexionDB.getConexion() != null) {
            Usuario obj = encontrarId(conexionDB, idUsuario);
            if (obj != null) {
                try {
                    String sql = "UPDATE Usuario SET "
                            + "foto=? "
                            + "WHERE idUsuario=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setString(1, foto);
                    registro.setInt(2, idUsuario);
                    int r = registro.executeUpdate();
                    if (r > 0) {
                        status = true;
                        Logg.exito("Edición exitosa en la base de datos");
                    } else {
                        Logg.error("Edición fallido en la base de datos");
                    }
                } catch (SQLException ex) {
                    Logg.error("Error de comunicación con la base de datos " + ex.getSQLState());
                } finally {

                }
            } else {
                Logg.error("El registro no existe");
            }
        } else {
            Logg.error("Error de conexión a la base de datos");
        }
        return status;
    }

    public boolean changeRol(IConexion conexionDB, int idUsuario, int idRol) {
        boolean status = false;
        if (conexionDB.getConexion() != null) {
            Usuario obj = encontrarId(conexionDB, idUsuario);
            if (obj != null) {
                try {
                    String sql = "UPDATE Usuario SET "
                            + "idRol=? "
                            + "WHERE idUsuario=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setInt(1, idRol);
                    registro.setInt(2, idUsuario);
                    int r = registro.executeUpdate();
                    if (r > 0) {
                        status = true;
                        Logg.exito("Edición exitosa en la base de datos");
                    } else {
                        Logg.error("Edición fallido en la base de datos");
                    }
                } catch (SQLException ex) {
                    Logg.error("Error de comunicación con la base de datos " + ex.getSQLState());
                } finally {

                }
            } else {
                Logg.error("El registro no existe");
            }
        } else {
            Logg.error("Error de conexión a la base de datos");
        }
        return status;
    }

    public boolean changePerfil(IConexion conexionDB, int idUsuario, String perNombre, String perApellido) {
        boolean status = false;
        if (conexionDB.getConexion() != null) {
            Usuario obj = encontrarId(conexionDB, idUsuario);
            if (obj != null) {
                try {
                    String sql = "UPDATE Usuario SET "
                            + "nombre=?, "
                            + "apellido=? "
                            + "WHERE idUsuario=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setString(1, perNombre);
                    registro.setString(2, perApellido);
                    registro.setInt(3, idUsuario);
                    int r = registro.executeUpdate();
                    if (r > 0) {
                        status = true;
                        Logg.exito("Edición exitosa en la base de datos");
                    } else {
                        Logg.error("Edición fallido en la base de datos");
                    }
                } catch (SQLException ex) {
                    Logg.error("Error de comunicación con la base de datos " + ex.getSQLState());
                } finally {

                }
            } else {
                Logg.error("El registro no existe");
            }
        } else {
            Logg.error("Error de conexión a la base de datos");
        }
        return status;

    }
}
