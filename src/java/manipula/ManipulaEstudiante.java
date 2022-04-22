package manipula;

import config.conexion.ConexionFactory;
import config.conexion.IConexion;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Estudiante;
import utils.GenericResponse;
import utils.Logg;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ManipulaEstudiante implements Manipula<Estudiante> {

    @Override
    public GenericResponse<Estudiante> registrar(Estudiante obj) {
        GenericResponse<Estudiante> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            try {
                String sql = "INSERT INTO estudiante ("
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
                        + ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                registro.setInt(1, obj.getIdUsuario());
                registro.setString(2, obj.getNombres());
                registro.setString(3, obj.getApellidoPaterno());
                registro.setString(4, obj.getApellidoMaterno());
                registro.setDate(5, (Date) obj.getFechaNacimiento());
                registro.setString(6, obj.getGenero());
                registro.setString(7, obj.getPresentacion());
                registro.setInt(8, obj.getNumeroTelMovil());
                registro.setInt(9, obj.getNumeroTelFijo());
                registro.setString(10, obj.getLugarNacimiento());
                registro.setString(11, obj.getNacionalidad());
                registro.setString(12, obj.getNivelEducativo());
                registro.setString(13, obj.getOcupacion());
                registro.setString(14, obj.getTipoEscuela());
                registro.setString(15, obj.getGradoEscolar());
                registro.setDouble(16, obj.getPromedioAnterior());
                registro.setBoolean(17, obj.isEstatusEscolar());
                registro.setString(18, obj.getIntereses());
                registro.setString(19, obj.getHabilidades());
                registro.setBoolean(20, obj.isEstadoLogico());
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
    public GenericResponse<Estudiante> actualizar(int id) {
        GenericResponse<Estudiante> response = new GenericResponse<>();
        response.setMensaje("Accion no implementada");
        response.setStatus(utils.Constantes.LOGIC_WARNING);
        response.setResponseObject(null);
        return response;
    }

    public GenericResponse<Estudiante> changeSeccionEscolar(int id, Estudiante nvoObj) {
        GenericResponse<Estudiante> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (encontrarId(id) != null) {
                try {
                    String sql = "UPDATE estudiante SET "
                            + "nivelEducativo=?, "
                            + "ocupacion=?, "
                            + "tipoEscuela=?, "
                            + "gradoEscolar=?, "
                            + "promedioAnterior=?, "
                            + "estatusEscolar=?, "
                            + "intereses=?, "
                            + "habilidades=?, "
                            + "WHERE idEstudiante=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setString(12, nvoObj.getNivelEducativo());
                    registro.setString(13, nvoObj.getOcupacion());
                    registro.setString(14, nvoObj.getTipoEscuela());
                    registro.setString(15, nvoObj.getGradoEscolar());
                    registro.setDouble(16, nvoObj.getPromedioAnterior());
                    registro.setBoolean(17, nvoObj.isEstatusEscolar());
                    registro.setString(18, nvoObj.getIntereses());
                    registro.setString(19, nvoObj.getHabilidades());
                    registro.setInt(21, id);
                    int r = registro.executeUpdate();
                    if (r > 0) {
                        nvoObj.setIdEstudiante(id);
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
    public GenericResponse<Estudiante> editar(int id, Estudiante nvoObj) {
        GenericResponse<Estudiante> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (encontrarId(id) != null) {
                try {
                    String sql = "UPDATE estudiante SET "
                            + "idUsuario=?, "
                            + "nombres=?, "
                            + "apellidoPaterno=?, "
                            + "apellidoMaterno=?, "
                            + "fechaNacimiento=?, "
                            + "genero=?, "
                            + "presentacion=?, "
                            + "telefonoMovil=?, "
                            + "telefonoCasa=?, "
                            + "lugarNacimiento=?, "
                            + "nacionalidad=?, "
                            + "nivelEducativo=?, "
                            + "ocupacion=?, "
                            + "tipoEscuela=?, "
                            + "gradoEscolar=?, "
                            + "promedioAnterior=?, "
                            + "estatusEscolar=?, "
                            + "intereses=?, "
                            + "habilidades=?, "
                            + "estadoLogico=? "
                            + "WHERE idEstudiante=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setInt(1, nvoObj.getIdUsuario());
                    registro.setString(2, nvoObj.getNombres());
                    registro.setString(3, nvoObj.getApellidoPaterno());
                    registro.setString(4, nvoObj.getApellidoMaterno());
                    registro.setDate(5, (Date) nvoObj.getFechaNacimiento());
                    registro.setString(6, nvoObj.getGenero());
                    registro.setString(7, nvoObj.getPresentacion());
                    registro.setInt(8, nvoObj.getNumeroTelMovil());
                    registro.setInt(9, nvoObj.getNumeroTelFijo());
                    registro.setString(10, nvoObj.getLugarNacimiento());
                    registro.setString(11, nvoObj.getNacionalidad());
                    registro.setString(12, nvoObj.getNivelEducativo());
                    registro.setString(13, nvoObj.getOcupacion());
                    registro.setString(14, nvoObj.getTipoEscuela());
                    registro.setString(15, nvoObj.getGradoEscolar());
                    registro.setDouble(16, nvoObj.getPromedioAnterior());
                    registro.setBoolean(17, nvoObj.isEstatusEscolar());
                    registro.setString(18, nvoObj.getIntereses());
                    registro.setString(19, nvoObj.getHabilidades());
                    registro.setBoolean(20, nvoObj.isEstadoLogico());
                    registro.setInt(21, id);
                    int r = registro.executeUpdate();
                    if (r > 0) {
                        nvoObj.setIdEstudiante(id);
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
    public GenericResponse<Estudiante> eliminar(int id) {
        GenericResponse<Estudiante> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            Estudiante obj = encontrarId(id);
            if (obj != null) {
                try {
                    String sql = "DELETE FROM estudiante "
                            + "WHERE idEstudiante=?";
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
    public List<Estudiante> getData() {
        List<Estudiante> response = new ArrayList<>();
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
                        + "FROM solicitud";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    Estudiante est = new Estudiante();
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
                    response.add(est);
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
    public List<Estudiante> consultar(String... filtros) {
        List<Estudiante> response = new ArrayList<>();
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
                        + "FROM solicitud";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    Estudiante est = new Estudiante();
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
                    response.add(est);
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
    public Estudiante encontrarId(int id) {
        Estudiante response =null;
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
                        + "FROM solicitud"
                        + "WHERE idEstudiante=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs;
                rs = ps.executeQuery();
                if (rs.next()) {
                    response = new Estudiante();
                    response.setIdEstudiante(rs.getInt(1));
                    response.setIdUsuario(rs.getInt(2));
                    response.setNombres(rs.getString(3));
                    response.setApellidoPaterno(rs.getString(4));
                    response.setApellidoMaterno(rs.getString(5));
                    response.setFechaNacimiento(rs.getDate(6));
                    response.setGenero(rs.getString(7));
                    response.setPresentacion(rs.getString(8));
                    response.setNumeroTelMovil(rs.getInt(9));
                    response.setNumeroTelFijo(rs.getInt(10));
                    response.setLugarNacimiento(rs.getString(11));
                    response.setNacionalidad(rs.getString(12));
                    response.setNivelEducativo(rs.getString(13));
                    response.setOcupacion(rs.getString(14));
                    response.setTipoEscuela(rs.getString(15));
                    response.setGradoEscolar(rs.getString(16));
                    response.setPromedioAnterior(rs.getDouble(17));
                    response.setEstatusEscolar(rs.getBoolean(18));
                    response.setIntereses(rs.getString(19));
                    response.setHabilidades(rs.getString(20));
                    response.setEstadoLogico(rs.getBoolean(21));
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

    public boolean changeEstadoLogico(int id, boolean estadoLogico) {
        boolean status = false;
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (encontrarId(id) != null) {
                try {
                    String sql = "UPDATE estudiante SET "
                            + "estadoLogico=? "
                            + "WHERE idEstudiante=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setBoolean(1, estadoLogico);
                    registro.setInt(2, id);
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
            }
        } else {
            Logg.error("Error de conexión a la base de datos");
        }
        return status;
    }

    public boolean changeNumeroMovil(int id, int numeroMovil) {
        boolean status = false;
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (encontrarId(id) != null) {
                try {
                    String sql = "UPDATE estudiante SET "
                            + "telefonoMovil=? "
                            + "WHERE idEstudiante=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setInt(1, numeroMovil);
                    registro.setInt(2, id);
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
            }
        } else {
            Logg.error("Error de conexión a la base de datos");
        }
        return status;
    }

    public boolean changeNumeroFijo(int id, int numeroFijo) {
        boolean status = false;
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            if (encontrarId(id) != null) {
                try {
                    String sql = "UPDATE estudiante SET "
                            + "telefonoCasa=? "
                            + "WHERE idEstudiante=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setInt(1, numeroFijo);
                    registro.setInt(2, id);
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
            }
        } else {
            Logg.error("Error de conexión a la base de datos");
        }
        return status;
    }
}
