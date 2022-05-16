package manipula;

import config.conexion.ConexionFactory;
import config.conexion.IConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Organizacion;
import utils.GenericResponse;
import utils.Logg;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ManipulaOrganizacion implements Manipula<Organizacion> {

    @Override
    public GenericResponse<Organizacion> registrar(Organizacion obj) {
        GenericResponse<Organizacion> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "INSERT INTO Organizacion ("
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
                        + ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                registro.setInt(1, obj.getIdUsuario());
                registro.setInt(2, obj.isReciboDeducible());
                registro.setString(3, obj.getRazonSocial());
                registro.setInt(4, obj.getNumeroTelFijo());
                registro.setInt(5, obj.getNumeroTelMovil());
                registro.setString(6, obj.getEmail());
                registro.setString(7, obj.getSitioWeb());
                registro.setInt(8, obj.isEstadoLogico());
                registro.setString(9, obj.getRfc());
                registro.setString(10, obj.getTipoOrganizacion());
                registro.setString(11, obj.getAutorizada());
                registro.setString(12, obj.getLinkFacebook());
                registro.setString(13, obj.getLinkInstragram());
                registro.setString(14, obj.getLinkLinkedin());
                registro.setString(15, obj.getLinkTwiteer());
                registro.setString(16, obj.getNombreContacto());
                registro.setString(17, obj.getApellidosContacto());
                registro.setString(18, obj.getCargo());
                registro.setString(19, obj.getDonatariaAutorizada());
                registro.setTimestamp(20, obj.getFechaDonatariaAutorizada());
                registro.setString(21, obj.getCluni());
                registro.setString(22, obj.getNoNotariaPublica());
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
    public GenericResponse<Organizacion> actualizar(int id) {
        GenericResponse<Organizacion> response = new GenericResponse<>();
        response.setMensaje("Accion no implementada");
        response.setStatus(utils.Constantes.LOGIC_WARNING);
        response.setResponseObject(null);
        return response;
    }

    public GenericResponse<Organizacion> actualizar(int id, String autorizar) {
        GenericResponse<Organizacion> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            Organizacion org = encontrarId(id);
            if (org != null) {
                org.setAutorizada(autorizar);
                try {
                    String sql = "UPDATE Organizacion SET "
                            + "autorizada=? "
                            + "WHERE idOrganizacion=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setString(1, org.getAutorizada());
                    registro.setInt(2, id);
                    int r = registro.executeUpdate();
                    if (r > 0) {
                        response.setStatus(utils.Constantes.STATUS_ACTUALIZACION_EXITOSA_BD);
                        response.setResponseObject(org);
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
    public GenericResponse<Organizacion> editar(int id, Organizacion nvoObj) {
        GenericResponse<Organizacion> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (encontrarId(id) != null) {
                try {
                    String sql = "UPDATE Organizacion SET "
                            + "idUsuario=?, "
                            + "reciboDeducible=?, "
                            + "razonSocial=?, "
                            + "telefonoFijo=?, "
                            + "telefonoMovil=?, "
                            + "email=?, "
                            + "sitioWeb=?, "
                            + "estadoLogico=?, "
                            + "rfc=?, "
                            + "tipooOrg=?, "
                            + "autorizada=?, "
                            + "linkFacebook=?, "
                            + "linkInstagram=?, "
                            + "linkLinkedin=?, "
                            + "linkTwiteer=?, "
                            + "nombreContacto=?, "
                            + "apellidosContacto=?, "
                            + "cargo=?, "
                            + "donatariaAutorizada=?, "
                            + "fechaDonatariaAutorizada=?, "
                            + "cluni=?, "
                            + "noNotariaPublica=? "
                            + "WHERE idOrganizacion=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setInt(1, nvoObj.getIdUsuario());
                    registro.setInt(2, nvoObj.isReciboDeducible());
                    registro.setString(3, nvoObj.getRazonSocial());
                    registro.setInt(4, nvoObj.getNumeroTelFijo());
                    registro.setInt(5, nvoObj.getNumeroTelMovil());
                    registro.setString(6, nvoObj.getEmail());
                    registro.setString(7, nvoObj.getSitioWeb());
                    registro.setInt(8, nvoObj.isEstadoLogico());
                    registro.setString(9, nvoObj.getRfc());
                    registro.setString(10, nvoObj.getTipoOrganizacion());
                    registro.setString(11, nvoObj.getAutorizada());
                    registro.setString(12, nvoObj.getLinkFacebook());
                    registro.setString(13, nvoObj.getLinkInstragram());
                    registro.setString(14, nvoObj.getLinkLinkedin());
                    registro.setString(15, nvoObj.getLinkTwiteer());
                    registro.setString(16, nvoObj.getNombreContacto());
                    registro.setString(17, nvoObj.getApellidosContacto());
                    registro.setString(18, nvoObj.getCargo());
                    registro.setString(19, nvoObj.getDonatariaAutorizada());
                    registro.setTimestamp(20, nvoObj.getFechaDonatariaAutorizada());
                    registro.setString(21, nvoObj.getCluni());
                    registro.setString(22, nvoObj.getNoNotariaPublica());
                    registro.setInt(23, id);
                    int r = registro.executeUpdate();
                    if (r > 0) {
                        nvoObj.setIdOrganizacion(id);
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
    public GenericResponse<Organizacion> eliminar(int id) {
        GenericResponse<Organizacion> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            Organizacion obj = encontrarId(id);
            if (obj != null) {
                try {
                    String sql = "DELETE FROM Organizacion "
                            + "WHERE idOrganizacion=?";
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
    public List<Organizacion> getData() {
        List<Organizacion> response = new ArrayList<>();
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
                        + "FROM Organizacion";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    Organizacion sol = new Organizacion();
                    sol.setIdOrganizacion(rs.getInt(1));
                    sol.setIdUsuario(rs.getInt(2));
                    sol.setReciboDeducible(rs.getInt(3));
                    sol.setRazonSocial(rs.getString(4));
                    sol.setNumeroTelFijo(rs.getInt(5));
                    sol.setNumeroTelMovil(rs.getInt(6));
                    sol.setEmail(rs.getString(7));
                    sol.setSitioWeb(rs.getString(8));
                    sol.setEstadoLogico(rs.getInt(9));
                    sol.setRfc(rs.getString(10));
                    sol.setTipoOrganizacion(rs.getString(11));
                    sol.setAutorizada(rs.getString(12));
                    sol.setLinkFacebook(rs.getString(13));
                    sol.setLinkInstragram(rs.getString(14));
                    sol.setLinkLinkedin(rs.getString(15));
                    sol.setLinkTwiteer(rs.getString(16));
                    sol.setNombreContacto(rs.getString(17));
                    sol.setApellidosContacto(rs.getString(18));
                    sol.setCargo(rs.getString(19));
                    sol.setDonatariaAutorizada(rs.getString(20));
                    sol.setFechaDonatariaAutorizada(rs.getTimestamp(21));
                    sol.setCluni(rs.getString(22));
                    sol.setNoNotariaPublica(rs.getString(23));

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
    public List<Organizacion> consultar(String... filtros) {
        List<Organizacion> response = new ArrayList<>();
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
                        + "FROM Organizacion";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    Organizacion sol = new Organizacion();
                    sol.setIdOrganizacion(rs.getInt(1));
                    sol.setIdUsuario(rs.getInt(2));
                    sol.setReciboDeducible(rs.getInt(3));
                    sol.setRazonSocial(rs.getString(4));
                    sol.setNumeroTelFijo(rs.getInt(5));
                    sol.setNumeroTelMovil(rs.getInt(6));
                    sol.setEmail(rs.getString(7));
                    sol.setSitioWeb(rs.getString(8));
                    sol.setEstadoLogico(rs.getInt(9));
                    sol.setRfc(rs.getString(10));
                    sol.setTipoOrganizacion(rs.getString(11));
                    sol.setAutorizada(rs.getString(12));
                    sol.setLinkFacebook(rs.getString(13));
                    sol.setLinkInstragram(rs.getString(14));
                    sol.setLinkLinkedin(rs.getString(15));
                    sol.setLinkTwiteer(rs.getString(16));
                    sol.setNombreContacto(rs.getString(17));
                    sol.setApellidosContacto(rs.getString(18));
                    sol.setCargo(rs.getString(19));
                    sol.setDonatariaAutorizada(rs.getString(20));
                    sol.setFechaDonatariaAutorizada(rs.getTimestamp(21));
                    sol.setCluni(rs.getString(22));
                    sol.setNoNotariaPublica(rs.getString(23));
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
    public Organizacion encontrarId(int id) {
        Organizacion response = null;
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
                        + "FROM Organizacion"
                        + "WHERE idSolicitud=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs;
                rs = ps.executeQuery();
                if (rs.next()) {
                    response = new Organizacion();
                    response.setIdOrganizacion(rs.getInt(1));
                    response.setIdUsuario(rs.getInt(2));
                    response.setReciboDeducible(rs.getInt(3));
                    response.setRazonSocial(rs.getString(4));
                    response.setNumeroTelFijo(rs.getInt(5));
                    response.setNumeroTelMovil(rs.getInt(6));
                    response.setEmail(rs.getString(7));
                    response.setSitioWeb(rs.getString(8));
                    response.setEstadoLogico(rs.getInt(9));
                    response.setRfc(rs.getString(10));
                    response.setTipoOrganizacion(rs.getString(11));
                    response.setAutorizada(rs.getString(12));
                    response.setLinkFacebook(rs.getString(13));
                    response.setLinkInstragram(rs.getString(14));
                    response.setLinkLinkedin(rs.getString(15));
                    response.setLinkTwiteer(rs.getString(16));
                    response.setNombreContacto(rs.getString(17));
                    response.setApellidosContacto(rs.getString(18));
                    response.setCargo(rs.getString(19));
                    response.setDonatariaAutorizada(rs.getString(20));
                    response.setFechaDonatariaAutorizada(rs.getTimestamp(21));
                    response.setCluni(rs.getString(22));
                    response.setNoNotariaPublica(rs.getString(23));
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

    public boolean changeEstadoLogico(int id, boolean estado) {
        boolean hecho = false;
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (encontrarId(id) != null) {
                try {
                    String sql = "UPDATE Organizacion SET "
                            + "estadoLogico=? "
                            + "WHERE idOrganizacion=?";
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
                conexionDB.desconectar();
            }
        } else {
            Logg.error("Error de conexión a la base de datos");
        }
        return hecho;
    }
}
