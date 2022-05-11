package manipula;

import config.conexion.ConexionFactory;
import config.conexion.IConexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Usuario;
import utils.GenericResponse;
import javax.servlet.http.HttpSession;
import utils.Misc;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ManipulaAutenticacion {

    public static GenericResponse<Usuario> registrar(Usuario usuario) {
        GenericResponse<Usuario> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            ManipulaUsuario m = new ManipulaUsuario();
            Usuario respuesta = m.encontrarCorreo(usuario.getCorreoElectronico());
            if (respuesta != null) {
                response.setStatus(utils.Constantes.STATUS_NOT_ACCEPTABLE);
                response.setResponseObject(usuario);
                response.setMensaje("El correo ya existe registrado");
            } else {
                response = m.registrar(usuario);
                conexionDB.desconectar();
            }
        } else {
            response.setStatus(utils.Constantes.STATUS_CONEXION_FALLIDA_BD);
            response.setResponseObject(null);
            response.setMensaje("Error de conexión a la base de datos");
        }
        return response;
    }

    public static GenericResponse<Usuario> iniciarSesionUsuario(String user, String contrasenia) {
        GenericResponse<Usuario> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            ManipulaUsuario m = new ManipulaUsuario();
            Usuario respuesta = m.encontrarStatus(user, contrasenia);
            if (respuesta != null) {
                if (respuesta.isConectado()) {
                    response.setStatus(utils.Constantes.STATUS_ACTUALIZACION_EXITOSA_BD);
                    response.setResponseObject(respuesta);
                    response.setMensaje("Usuario ya conectado");
                    conexionDB.desconectar();
                } else {
                    respuesta.setConectado(true);
                    respuesta.setUltimaConexion(Misc.getDateTimeActualJava());
                    try {
                        String sql = "UPDATE Usuario SET "
                                + "ultimaConexion=?, "
                                + "conectado=? "
                                + "WHERE idUsuario=?";
                        PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                        registro.setDate(1, Misc.transformDateTimeJavaSql(respuesta.getUltimaConexion()));
                        registro.setBoolean(2, respuesta.isConectado());
                        registro.setInt(3, respuesta.getIdUsuario());
                        int r = registro.executeUpdate();
                        if (r > 0) {
                            response.setStatus(utils.Constantes.STATUS_ACTUALIZACION_EXITOSA_BD);
                            response.setResponseObject(respuesta);
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
                        conexionDB.desconectar();
                    }
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

    public static GenericResponse<Usuario> cerrarSesionUsuario(Usuario usuario) {
        GenericResponse<Usuario> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (usuario != null) {
            if (conexionDB.conectar() == 1) {
                ManipulaUsuario m = new ManipulaUsuario();
                Usuario respuesta = m.encontrarStatus(usuario.getNombreUsuario());
                if (respuesta != null) {
                    if (respuesta.isConectado()) {
                        respuesta.setConectado(false);
                        respuesta.setUltimaConexion(Misc.getDateTimeActualJava());
                        try {
                            String sql = "UPDATE Usuario SET "
                                    + "ultimaConexion=?, "
                                    + "conectado=? "
                                    + "WHERE idUsuario=?";
                            PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                            registro.setDate(1, Misc.transformDateTimeJavaSql(respuesta.getUltimaConexion()));
                            registro.setBoolean(2, respuesta.isConectado());
                            registro.setInt(3, respuesta.getIdUsuario());
                            int r = registro.executeUpdate();
                            if (r > 0) {
                                response.setStatus(utils.Constantes.STATUS_ACTUALIZACION_EXITOSA_BD);
                                response.setResponseObject(respuesta);
                                response.setMensaje("Edición exitosa en la base de datos");
                            } else {
                                response.setStatus(utils.Constantes.STATUS_ACTUALIZACION_FALLIDA_BD);
                                response.setResponseObject(usuario);
                                response.setMensaje("Edición fallido en la base de datos");
                            }
                        } catch (SQLException ex) {
                            response.setStatus(utils.Constantes.STATUS_CONEXION_FALLIDA_BD);
                            response.setResponseObject(usuario);
                            response.setMensaje("Error de comunicación con la base de datos " + ex.getSQLState());
                        } finally {
                            conexionDB.desconectar();
                        }
                    } else {
                        response.setStatus(utils.Constantes.STATUS_NO_DATA);
                        response.setResponseObject(respuesta);
                        response.setMensaje("El usuario ya no esta conectado");
                        conexionDB.desconectar();
                    }
                } else {
                    response.setStatus(utils.Constantes.STATUS_NO_DATA);
                    response.setResponseObject(usuario);
                    response.setMensaje("El registro no existe");
                    conexionDB.desconectar();
                }
            } else {
                response.setStatus(utils.Constantes.STATUS_CONEXION_FALLIDA_BD);
                response.setResponseObject(usuario);
                response.setMensaje("Error de conexión a la base de datos");
            }
        } else {
            response.setStatus(utils.Constantes.STATUS_CONEXION_FALLIDA_BD);
            response.setResponseObject(usuario);
            response.setMensaje("Cerrar session por un usuario nulo?");
        }
        return response;
    }

    public static GenericResponse<Usuario> isAutenticado(HttpSession usuario) {
        GenericResponse<Usuario> response = new GenericResponse<>();
        String user = usuario.getAttribute("user").toString();
        String password = usuario.getAttribute("password").toString();
        if (user != null) {
            ManipulaUsuario m = new ManipulaUsuario();
            Usuario respuesta = m.encontrarStatus(user, password);
            if (respuesta != null) {
                response.setStatus(utils.Constantes.STATUS_ACCEPTED);
                response.setResponseObject(respuesta);
                response.setMensaje("Usuario valido");
            } else {
                response.setStatus(utils.Constantes.STATUS_NETWORK_AUTHENTICATION_REQUIRED);
                response.setResponseObject(null);
                response.setMensaje("Usuario no autenticado");
            }
        } else {
            response.setStatus(utils.Constantes.STATUS_NETWORK_AUTHENTICATION_REQUIRED);
            response.setResponseObject(null);
            response.setMensaje("Requiere autenticacion");
        }
        return null;
    }

    public static GenericResponse<Usuario> isAutorizado(HttpSession usuario, String rol) {
        GenericResponse<Usuario> response = isAutenticado(usuario);
        if (response.getStatus() == utils.Constantes.STATUS_ACCEPTED) {
            String role = usuario.getAttribute("rol").toString();
            if (role != null) {
                if (role.equals(rol)) {
                    response.setStatus(utils.Constantes.STATUS_ACCEPTED);
                    response.setResponseObject(response.getResponseObject());
                    response.setMensaje("Usuario valido");
                } else {
                    response.setStatus(utils.Constantes.STATUS_UNAUTHORIZED);
                    response.setResponseObject(null);
                    response.setMensaje("Usuario no autorizado");
                }
            } else {
                response.setStatus(utils.Constantes.STATUS_UNAUTHORIZED);
                response.setResponseObject(null);
                response.setMensaje("Requiere de permisos de usuario");
            }
        } else {
            response.setStatus(utils.Constantes.STATUS_UNAUTHORIZED);
            response.setResponseObject(null);
            response.setMensaje("Usuario no permitido, requiere de autenticacion");
        }
        return null;
    }
}
