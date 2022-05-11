package manipula;

import config.conexion.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Direccion;
import model.Donacion;
import model.Estudiante;
import model.Galeria;
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
    public GenericResponse<Usuario> registrar(Usuario obj) {
        GenericResponse<Usuario> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "INSERT INTO Usuario ("
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
                        + "idRol "
                        + ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                registro.setString(1, obj.getNombreUsuario());
                registro.setString(2, obj.getContraseniia());
                registro.setDate(3, Misc.transformDateTimeJavaSql(obj.getFechaCreacion()));
                registro.setDate(4, Misc.transformDateTimeJavaSql(obj.getUltimaConexion()));
                registro.setString(5, obj.getEstadoCuenta());
                registro.setBoolean(6, obj.isEstadoLogico());
                registro.setBoolean(7, obj.isConectado());
                registro.setString(8, obj.getCorreoElectronico());
                registro.setBoolean(9, obj.isCorreoConfirmado());
                registro.setInt(10, obj.getNumeroCelular());
                registro.setBoolean(11, obj.isNumeroCelularConfirmado());
                registro.setBoolean(12, obj.isAutenticacionDosPasos());
                registro.setInt(13, obj.getConteoAccesosFallidos());
                registro.setString(14, obj.getFoto());
                registro.setInt(15, obj.getIdRol());
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
    public GenericResponse<Usuario> actualizar(int id) {
        GenericResponse<Usuario> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            Usuario obj = encontrarId(id);
            if (obj != null) {
                if (obj.isConectado()) {
                    obj.setConectado(false);
                } else {
                    obj.setConectado(true);
                }
                obj.setUltimaConexion(Misc.getDateTimeActualJava());
                try {
                    String sql = "UPDATE Usuario SET "
                            + "ultimaConexion=?, "
                            + "conectado=? "
                            + "WHERE idUsuario=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setDate(1, Misc.transformDateTimeJavaSql(obj.getUltimaConexion()));
                    registro.setBoolean(2, obj.isConectado());
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
    public GenericResponse<Usuario> editar(int id, Usuario nvoObj) {
        GenericResponse<Usuario> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            Usuario obj = encontrarId(id);
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
                            + "idRol=? "
                            + "WHERE idUsuario=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setString(1, nvoObj.getNombreUsuario());
                    registro.setString(2, nvoObj.getEstadoCuenta());
                    registro.setBoolean(3, nvoObj.isEstadoLogico());
                    registro.setString(4, nvoObj.getCorreoElectronico());
                    registro.setBoolean(5, nvoObj.isCorreoConfirmado());
                    registro.setInt(6, nvoObj.getNumeroCelular());
                    registro.setBoolean(7, nvoObj.isNumeroCelularConfirmado());
                    registro.setBoolean(8, nvoObj.isAutenticacionDosPasos());
                    registro.setInt(9, nvoObj.getConteoAccesosFallidos());
                    registro.setString(10, nvoObj.getFoto());
                    registro.setInt(11, nvoObj.getIdRol());
                    registro.setInt(12, id);
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
    public GenericResponse<Usuario> eliminar(int id) {
        GenericResponse<Usuario> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            Usuario obj = encontrarId(id);
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
    public List<Usuario> getData() {
        List<Usuario> response = new ArrayList<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
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
                        + "idRol "
                        + "FROM Usuario";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    Usuario user = new Usuario();
                    user.setIdUsuario(rs.getInt(1));
                    user.setNombreUsuario(rs.getString(2));
                    user.setFechaCreacion(rs.getDate(3));
                    user.setUltimaConexion(rs.getDate(4));
                    user.setEstadoCuenta(rs.getString(5));
                    user.setEstadoLogico(rs.getBoolean(6));
                    user.setConectado(rs.getBoolean(7));
                    user.setCorreoElectronico(rs.getString(8));
                    user.setCorreoConfirmado(rs.getBoolean(9));
                    user.setNumeroCelular(rs.getInt(10));
                    user.setNumeroCelularConfirmado(rs.getBoolean(11));
                    user.setAutenticacionDosPasos(rs.getBoolean(12));
                    user.setConteoAccesosFallidos(rs.getInt(13));
                    user.setFoto(rs.getString(14));
                    user.setIdRol(rs.getInt(15));
                    response.add(user);
                }
            } catch (SQLException ex) {
                Logg.error("Comunicación fallida con la base de datos " + ex.getMessage());
            } finally {
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return response;
    }

    @Override
    public List<Usuario> consultar(String... filtros) {
        List<Usuario> response = new ArrayList<>();
        response.stream().filter(user -> user.getIdUsuario() > 20).forEach(
                //System.out::println
                //user->{System.out.println("Nombre: "+user.getNombreUsuario());}
                user -> System.out.println("Nombre: " + user.getNombreUsuario())
        );
        return response;
    }

    @Override
    public Usuario encontrarId(int id) {
        Usuario response = null;
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
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
                        + "idRol "
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
                    response.setFechaCreacion(rs.getDate(3));
                    response.setUltimaConexion(rs.getDate(4));
                    response.setEstadoCuenta(rs.getString(5));
                    response.setEstadoLogico(rs.getBoolean(6));
                    response.setConectado(rs.getBoolean(7));
                    response.setCorreoElectronico(rs.getString(8));
                    response.setCorreoConfirmado(rs.getBoolean(9));
                    response.setNumeroCelular(rs.getInt(10));
                    response.setNumeroCelularConfirmado(rs.getBoolean(11));
                    response.setAutenticacionDosPasos(rs.getBoolean(12));
                    response.setConteoAccesosFallidos(rs.getInt(13));
                    response.setFoto(rs.getString(14));
                    response.setIdRol(rs.getInt(15));
                } else {
                    Logg.error("No se encontro ningun registro");
                }
            } catch (SQLException ex) {
                Logg.error("Comunicación fallida con la base de datos "+ ex.getMessage());
            } finally {
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return response;
    }

    public Usuario encontrarCorreo(String correo) {
        Usuario response = null;
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
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
                        + "idRol "
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
                    response.setFechaCreacion(rs.getDate(3));
                    response.setUltimaConexion(rs.getDate(4));
                    response.setEstadoCuenta(rs.getString(5));
                    response.setEstadoLogico(rs.getBoolean(6));
                    response.setConectado(rs.getBoolean(7));
                    response.setCorreoElectronico(rs.getString(8));
                    response.setCorreoConfirmado(rs.getBoolean(9));
                    response.setNumeroCelular(rs.getInt(10));
                    response.setNumeroCelularConfirmado(rs.getBoolean(11));
                    response.setAutenticacionDosPasos(rs.getBoolean(12));
                    response.setConteoAccesosFallidos(rs.getInt(13));
                    response.setFoto(rs.getString(14));
                    response.setIdRol(rs.getInt(15));
                } else {
                    Logg.error("No se encontro ningun registro");
                }
            } catch (SQLException ex) {
                Logg.error("Comunicación fallida con la base de datos " + ex.getMessage());
            } finally {
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return response;
    }

    public Usuario encontrarStatus(String nombre, String contrasenia) {
        Usuario response = null;
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
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
                        + "idRol "
                        + "FROM Usuario "
                        + "WHERE nombreUsuario=? AND contrasenia=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setString(1, nombre);
                ps.setString(2, contrasenia);
                ResultSet rs;
                rs = ps.executeQuery();
                if (rs.next()) {
                    response = new Usuario();
                    response.setIdUsuario(rs.getInt(1));
                    response.setNombreUsuario(rs.getString(2));
                    response.setFechaCreacion(rs.getDate(3));
                    response.setUltimaConexion(rs.getDate(4));
                    response.setEstadoCuenta(rs.getString(5));
                    response.setEstadoLogico(rs.getBoolean(6));
                    response.setConectado(rs.getBoolean(7));
                    response.setCorreoElectronico(rs.getString(8));
                    response.setCorreoConfirmado(rs.getBoolean(9));
                    response.setNumeroCelular(rs.getInt(10));
                    response.setNumeroCelularConfirmado(rs.getBoolean(11));
                    response.setAutenticacionDosPasos(rs.getBoolean(12));
                    response.setConteoAccesosFallidos(rs.getInt(13));
                    response.setFoto(rs.getString(14));
                    response.setIdRol(rs.getInt(15));
                } else {
                    Logg.error("No se encontro ningun registro");
                }
            } catch (SQLException ex) {
                Logg.error("Comunicación fallida con la base de datos "+ ex.getMessage());
            } finally {
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return response;
    }

    public Usuario encontrarStatus(String nombre) {
        Usuario response = null;
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
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
                        + "idRol "
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
                    response.setFechaCreacion(rs.getDate(3));
                    response.setUltimaConexion(rs.getDate(4));
                    response.setEstadoCuenta(rs.getString(5));
                    response.setEstadoLogico(rs.getBoolean(6));
                    response.setConectado(rs.getBoolean(7));
                    response.setCorreoElectronico(rs.getString(8));
                    response.setCorreoConfirmado(rs.getBoolean(9));
                    response.setNumeroCelular(rs.getInt(10));
                    response.setNumeroCelularConfirmado(rs.getBoolean(11));
                    response.setAutenticacionDosPasos(rs.getBoolean(12));
                    response.setConteoAccesosFallidos(rs.getInt(13));
                    response.setFoto(rs.getString(14));
                    response.setIdRol(rs.getInt(15));
                } else {
                    Logg.error("No se encontro ningun registro");
                }
            } catch (SQLException ex) {
                Logg.error("Comunicación fallida con la base de datos " + ex.getMessage());
            } finally {
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return response;
    }

    public List<Solicitud> getSolicitudes(int idUsuario) {
        List<Solicitud> lstSolicitud = new ArrayList<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "SELECT "
                        + "idSolicitud, "
                        + "idUsuario, "
                        + "idRecurso, "
                        + "idArchivo, "
                        + "estadoSolicitud, "
                        + "fechaSolicitud, "
                        + "fechaRespuesta "
                        + "FROM Solicitud "
                        + "WHERE idUsuario=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setInt(1, idUsuario);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    Solicitud sol = new Solicitud();
                    sol.setIdSolicitud(rs.getInt(1));
                    sol.setIdUsuario(rs.getInt(2));
                    sol.setIdRecursoTecnologico(rs.getInt(3));
                    sol.setIdArchivo(rs.getInt(4));
                    sol.setEstadoSolicitud(rs.getString(5));
                    sol.setFechaSolicitud(Misc.transformDateTimeSqlJava(rs.getDate(6)));
                    sol.setFechaRespuesta(Misc.transformDateTimeSqlJava(rs.getDate(7)));
                    lstSolicitud.add(sol);
                }
            } catch (SQLException ex) {
                Logg.error("Comunicación fallida con la base de datos "+ ex.getMessage());
            } finally {
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return lstSolicitud;
    }

    public List<Donacion> getDonacionRecibidas(int idUsuario) {
        List<Donacion> lstDonacion = new ArrayList<>();
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
                    sol.setIdArchivo(rs.getInt(4));
                    sol.setIdRecursoTecnologico(rs.getInt(5));
                    sol.setFechaDonacion(rs.getDate(6));
                    sol.setEstadoDonacion(rs.getString(7));
                    sol.setNoConfirmacion(rs.getString(8));
                    sol.setRemunerado(rs.getBoolean(9));
                    lstDonacion.add(sol);
                }
            } catch (SQLException ex) {
                Logg.error("Comunicación fallida con la base de datos "+ ex.getMessage());
            } finally {
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return lstDonacion;
    }

    public List<Donacion> getDonacionDadas(int idUsuario) {
        List<Donacion> lstDonacion = new ArrayList<>();
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
                    sol.setIdArchivo(rs.getInt(4));
                    sol.setIdRecursoTecnologico(rs.getInt(5));
                    sol.setFechaDonacion(rs.getDate(6));
                    sol.setEstadoDonacion(rs.getString(7));
                    sol.setNoConfirmacion(rs.getString(8));
                    sol.setRemunerado(rs.getBoolean(9));
                    lstDonacion.add(sol);
                }
            } catch (SQLException ex) {
                Logg.error("Comunicación fallida con la base de datos "+ ex.getMessage());
            } finally {
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return lstDonacion;
    }

    public List<Galeria> getGaleria(int idUsuario) {
        List<Galeria> lstGaleria = new ArrayList<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "SELECT "
                        + "idGaleria, "
                        + "idUsuario, "
                        + "nombreImagen, "
                        + "tamanio, "
                        + "extension, "
                        + "urlDestino "
                        + "FROM Galeria "
                        + "WHERE idUsuario=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setInt(1, idUsuario);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    lstGaleria.add(new Galeria(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6)));
                }
            } catch (SQLException ex) {
                Logg.error("Comunicación fallida con la base de datos "+ ex.getMessage());
            } finally {
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return lstGaleria;
    }

    public List<Intencion> getIntenciones(int idUsuario) {
        List<Intencion> lstIntencion = new ArrayList<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
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
                    sol.setFechaIntencion(Misc.transformDateTimeSqlJava(rs.getDate(5)));
                    sol.setEstadoIntencion(rs.getString(6));
                    sol.setRespuestaIntencion(rs.getString(6));
                    sol.setFechaRespuesta(Misc.transformDateTimeSqlJava(rs.getDate(6)));
                    lstIntencion.add(sol);
                }
            } catch (SQLException ex) {
                Logg.error("Comunicación fallida con la base de datos "+ ex.getMessage());
            } finally {
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return lstIntencion;
    }

    public Direccion getDireccion(int idUsuario) {
        Direccion dir = null;
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
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
                        + "idUsuario "
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
                    dir.setIdUsuario(rs.getInt(rs.getString(14)));
                } else {
                    Logg.error("No se encontro ningun registro");
                }
            } catch (SQLException ex) {
                Logg.error("Comunicación fallida con la base de datos "+ ex.getMessage());
            } finally {
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return dir;
    }

    public List<Notificacion> getNotificacion(int idUsuario) {
        List<Notificacion> lstNotificacion = new ArrayList<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
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
                    lstNotificacion.add(new Notificacion(rs.getInt(1), rs.getInt(2), Misc.transformDateTimeSqlJava(rs.getDate(3)), rs.getString(4), rs.getString(5), rs.getString(6)));
                }
            } catch (SQLException ex) {
                Logg.error("Comunicación fallida con la base de datos "+ex.getMessage());
            } finally {
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return lstNotificacion;
    }

    public String getTipoAcceso(int idUsuario) {
        String tipoAcceso = "";
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
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
                        Logg.error("Fallo la asignacion de IdRol "+e.getMessage());
                    }
                } else {
                    tipoAcceso = "Default";
                    Logg.error("No se encontro ningun registro");
                }
            } catch (SQLException ex) {
                tipoAcceso = "Default";
                Logg.error("Comunicación fallida con la base de datos "+ex.getMessage());
            } finally {
                conexionDB.desconectar();
            }
        } else {
            tipoAcceso = "Default";
            Logg.error("Conexión fallida con la base de datos ");
        }
        return tipoAcceso;
    }

    public Organizacion getOrganizacion(int idUsuario) {
        Organizacion org = null;
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
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
                        + "autorizada "
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
                    org.setReciboDeducible(rs.getBoolean(3));
                    org.setRazonSocial(rs.getString(4));
                    org.setNumeroTelFijo(rs.getInt(5));
                    org.setNumeroTelMovil(rs.getInt(6));
                    org.setEmail(rs.getString(7));
                    org.setSitioWeb(rs.getString(8));
                    org.setEstadoLogico(rs.getBoolean(9));
                    org.setRfc(rs.getString(10));
                    org.setTipoOrganizacion(rs.getString(11));
                    org.setAutorizada(rs.getString(12));
                } else {
                    Logg.error("No se encontro ningun registro");
                }
            } catch (SQLException ex) {
                Logg.error("Comunicación fallida con la base de datos "+ ex.getMessage());
            } finally {
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }
        return org;
    }

    public Estudiante getEstudiante(int idUsuario) {
        Estudiante est = null;
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
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
                        + "gradoEscolar, "
                        + "promedioAnterior, "
                        + "estatusEscolar, "
                        + "intereses, "
                        + "habilidades, "
                        + "estadoLogico "
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
                    est.setGradoEscolar(rs.getString(16));
                    est.setPromedioAnterior(rs.getDouble(17));
                    est.setEstatusEscolar(rs.getBoolean(18));
                    est.setIntereses(rs.getString(19));
                    est.setHabilidades(rs.getString(20));
                    est.setEstadoLogico(rs.getBoolean(21));
                } else {
                    Logg.error("No se encontro ningun registro");
                }
            } catch (SQLException ex) {
                Logg.error("Comunicación fallida con la base de datos "+ ex.getMessage());
            } finally {
                conexionDB.desconectar();
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
     * @param idUsuario
     * @return
     */
    public Object getTipoUsuarioAsociado(int idUsuario) {
        Object obj = null;
        Estudiante est = getEstudiante(idUsuario);
        Organizacion org = getOrganizacion(idUsuario);
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

    public String getConstasenia(int idUsuario) {
        String constrasenia = "";
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            Usuario obj = encontrarId(idUsuario);
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
                    conexionDB.desconectar();
                }
            } else {
                Logg.error("El registro no existe");
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Error de conexión a la base de datos");
        }
        return constrasenia;
    }

    public boolean changeNombreUsuario(int idUsuario, String nombre) {
        boolean status = false;
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            Usuario obj = encontrarId(idUsuario);
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
                    conexionDB.desconectar();
                }
            } else {
                Logg.error("El registro no existe");
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Error de conexión a la base de datos");
        }
        return status;
    }

    public boolean changeConstasenia(int idUsuario, String constrasenia) {
        boolean status = false;
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            Usuario obj = encontrarId(idUsuario);
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
                    Logg.error("Error de comunicación con la base de datos "+ ex.getMessage());
                } finally {
                    conexionDB.desconectar();
                }
            } else {
                Logg.error("El registro no existe");
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Error de conexión a la base de datos");
        }
        return status;
    }

    public boolean changeCorreoElectronico(int idUsuario, String correoElectronico) {
        boolean status = false;
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            Usuario obj = encontrarId(idUsuario);
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
                    conexionDB.desconectar();
                }
            } else {
                Logg.error("El registro no existe");
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Error de conexión a la base de datos");
        }
        return status;
    }

    public boolean changeCelular(int idUsuario, int celular) {
        boolean status = false;
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            Usuario obj = encontrarId(idUsuario);
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
                    conexionDB.desconectar();
                }
            } else {
                Logg.error("El registro no existe");
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Error de conexión a la base de datos");
        }
        return status;
    }

    public boolean changeConfirmarCorreo(int idUsuario, boolean confirmacion) {
        boolean status = false;
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            Usuario obj = encontrarId(idUsuario);
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
                    conexionDB.desconectar();
                }
            } else {
                Logg.error("El registro no existe");
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Error de conexión a la base de datos");
        }
        return status;
    }

    public boolean changeConfirmarCelular(int idUsuario, boolean confirmacion) {
        boolean status = false;
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            Usuario obj = encontrarId(idUsuario);
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
                    conexionDB.desconectar();
                }
            } else {
                Logg.error("El registro no existe");
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Error de conexión a la base de datos");
        }
        return status;
    }

    public boolean changeAutenticarDosPasos(int idUsuario, boolean confirmacion) {
        boolean status = false;
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            Usuario obj = encontrarId(idUsuario);
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
                    conexionDB.desconectar();
                }
            } else {
                Logg.error("El registro no existe");
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Error de conexión a la base de datos");
        }
        return status;
    }

    /**
     * Bloquear cuenta...
     *
     * @param idUsuario
     * @param accesos
     * @return
     */
    public boolean changeAccesosFallidos(int idUsuario, int accesos) {
        boolean status = false;
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            Usuario obj = encontrarId(idUsuario);
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
                    conexionDB.desconectar();
                }
            } else {
                Logg.error("El registro no existe");
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Error de conexión a la base de datos");
        }
        return status;
    }

    public boolean changeFoto(int idUsuario, String foto) {
        boolean status = false;
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            Usuario obj = encontrarId(idUsuario);
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
                    conexionDB.desconectar();
                }
            } else {
                Logg.error("El registro no existe");
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Error de conexión a la base de datos");
        }
        return status;
    }

    public boolean changeRol(int idUsuario, int idRol) {
        boolean status = false;
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            Usuario obj = encontrarId(idUsuario);
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
                    conexionDB.desconectar();
                }
            } else {
                Logg.error("El registro no existe");
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Error de conexión a la base de datos");
        }
        return status;
    }
}
