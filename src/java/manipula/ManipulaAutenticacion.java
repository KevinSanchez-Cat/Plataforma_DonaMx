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

    public static GenericResponse<Usuario> registrar(IConexion conexionDB, Usuario usuario) {
        GenericResponse<Usuario> response = new GenericResponse<>();

        if (conexionDB.getConexion() != null) {
            ManipulaUsuario m = new ManipulaUsuario();
            Usuario respuesta = m.encontrarCorreo(conexionDB, usuario.getCorreoElectronico());
            if (respuesta != null) {
                response.setStatus(utils.Constantes.STATUS_NOT_ACCEPTABLE);
                response.setResponseObject(usuario);
                response.setMensaje("El correo ya existe registrado");
            } else {
                response = m.registrar(conexionDB, usuario);

            }
        } else {
            response.setStatus(utils.Constantes.STATUS_CONEXION_FALLIDA_BD);
            response.setResponseObject(null);
            response.setMensaje("Error de conexión a la base de datos");
        }
        return response;
    }

    public static GenericResponse<Usuario> iniciarSesionUsuario(IConexion conexionDB, String email, String contrasenia) {
        GenericResponse<Usuario> response = new GenericResponse<>();

        if (conexionDB.getConexion() != null) {
            ManipulaUsuario m = new ManipulaUsuario();
            Usuario respuesta = m.encontrarStatus(conexionDB, email, contrasenia);
            if (respuesta != null) {
                if (respuesta.isConectado() == 1) {
                    response.setStatus(utils.Constantes.STATUS_ACTUALIZACION_EXITOSA_BD);
                    response.setResponseObject(respuesta);
                    response.setMensaje("Usuario ya conectado");

                } else {
                    respuesta.setConectado(1);
                    respuesta.setUltimaConexion(Misc.getDateTimeActualSQL());
                    try {
                        String sql = "UPDATE Usuario SET "
                                + "ultimaConexion=?, "
                                + "conectado=? "
                                + "WHERE idUsuario=?";
                        PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                        registro.setTimestamp(1, respuesta.getUltimaConexion());
                        registro.setInt(2, respuesta.isConectado());
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

    public static GenericResponse<Usuario> cerrarSesionUsuario(IConexion conexionDB, Usuario usuario) {
        GenericResponse<Usuario> response = new GenericResponse<>();

        if (usuario != null) {
            if (conexionDB.getConexion() != null) {
                ManipulaUsuario m = new ManipulaUsuario();
                Usuario respuesta = m.encontrarStatus(conexionDB, usuario.getNombreUsuario());
                if (respuesta != null) {
                    if (respuesta.isConectado() == 1) {
                        respuesta.setConectado(0);
                        respuesta.setUltimaConexion(Misc.getDateTimeActualSQL());
                        try {
                            String sql = "UPDATE Usuario SET "
                                    + "ultimaConexion=?, "
                                    + "conectado=? "
                                    + "WHERE idUsuario=?";
                            PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                            registro.setTimestamp(1, respuesta.getUltimaConexion());
                            registro.setInt(2, respuesta.isConectado());
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

                        }
                    } else {
                        response.setStatus(utils.Constantes.STATUS_NO_DATA);
                        response.setResponseObject(respuesta);
                        response.setMensaje("El usuario ya no esta conectado");

                    }
                } else {
                    response.setStatus(utils.Constantes.STATUS_NO_DATA);
                    response.setResponseObject(usuario);
                    response.setMensaje("El registro no existe");

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

    public static GenericResponse<Usuario> isAutenticado(IConexion conexionDB, HttpSession usuario) {
        GenericResponse<Usuario> response = new GenericResponse<>();
        String user = usuario.getAttribute("user").toString();
        String password = usuario.getAttribute("password").toString();
        if (user != null) {
            ManipulaUsuario m = new ManipulaUsuario();
            Usuario respuesta = m.encontrarStatus(conexionDB, user, password);
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

    public static GenericResponse<Usuario> isAutorizado(IConexion conexionDB, HttpSession usuario, String rol) {
        GenericResponse<Usuario> response = isAutenticado(conexionDB, usuario);
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
