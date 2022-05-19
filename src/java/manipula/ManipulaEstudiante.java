package manipula;

import config.conexion.ConexionFactory;
import config.conexion.IConexion;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Deseo;
import model.Donacion;
import model.Estudiante;
import utils.GenericResponse;
import utils.Logg;
import utils.Misc;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ManipulaEstudiante implements Manipula<Estudiante> {

    @Override
    public GenericResponse<Estudiante> registrar(IConexion conexionDB,Estudiante obj) {
        GenericResponse<Estudiante> response = new GenericResponse<>();
        
        if (conexionDB.getConexion()!=null) {
            try {
                String sql = "INSERT INTO Estudiante ("
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
                        + ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
                registro.setDouble(15, obj.getPromedioAnterior());
                registro.setInt(16, obj.isEstatusEscolar());
                registro.setString(17, obj.getIntereses());
                registro.setString(18, obj.getHabilidades());
                registro.setInt(19, obj.isEstadoLogico());
                registro.setString(20, obj.getCurp());
                registro.setString(21, obj.getEstadoCivil());
                registro.setString(22, obj.getNombreEscuela());
                registro.setString(23, obj.getMatricula());
                registro.setInt(24, obj.isRegular());
                registro.setString(25, obj.getTipoPeriodo());
                registro.setInt(26, obj.getTotalPeriodos());
                registro.setInt(27, obj.getPeriodoActual());
                registro.setString(28, obj.getPeriodo());
                registro.setDouble(29, obj.getPromedioGeneral());
                registro.setString(30, obj.getValidado());
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
    public GenericResponse<Estudiante> actualizar(IConexion conexionDB,int id) {
        GenericResponse<Estudiante> response = new GenericResponse<>();
        response.setMensaje("Accion no implementada");
        response.setStatus(utils.Constantes.LOGIC_WARNING);
        response.setResponseObject(null);
        return response;
    }

    public GenericResponse<Estudiante> changeSeccionEscolar(IConexion conexionDB,int id, Estudiante nvoObj) {
        GenericResponse<Estudiante> response = new GenericResponse<>();
        
        if (conexionDB.getConexion()!=null) {
            if (encontrarId(conexionDB,id) != null) {
                try {
                    String sql = "UPDATE Estudiante SET "
                            + "nivelEducativo=?, "
                            + "ocupacion=?, "
                            + "tipoEscuela=?, "
                            + "promedioAnterior=?, "
                            + "estatusEscolar=?, "
                            + "intereses=?, "
                            + "habilidades=?, "
                            + "nombreEscuela=?, "
                            + "matricula=?, "
                            + "regular=?, "
                            + "tipoPeriodo=?, "
                            + "totalPeriodos=?, "
                            + "periodoActual=?, "
                            + "periodo=?, "
                            + "promedioGeneral=? "
                            + "WHERE idEstudiante=?";
                    PreparedStatement registro = conexionDB.getConexion().prepareStatement(sql);
                    registro.setString(1, nvoObj.getNivelEducativo());
                    registro.setString(2, nvoObj.getOcupacion());
                    registro.setString(3, nvoObj.getTipoEscuela());
                    registro.setDouble(4, nvoObj.getPromedioAnterior());
                    registro.setInt(5, nvoObj.isEstatusEscolar());
                    registro.setString(6, nvoObj.getIntereses());
                    registro.setString(7, nvoObj.getHabilidades());
                    registro.setString(8, nvoObj.getNombreEscuela());
                    registro.setString(9, nvoObj.getMatricula());
                    registro.setInt(10, nvoObj.isRegular());
                    registro.setString(11, nvoObj.getTipoPeriodo());
                    registro.setInt(12, nvoObj.getTotalPeriodos());
                    registro.setInt(13, nvoObj.getPeriodoActual());
                    registro.setDouble(14, nvoObj.getPromedioGeneral());
                    registro.setInt(15, id);
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
    public GenericResponse<Estudiante> editar(IConexion conexionDB,int id, Estudiante nvoObj) {
        GenericResponse<Estudiante> response = new GenericResponse<>();
        
        if (conexionDB.getConexion()!=null) {
            if (encontrarId(conexionDB,id) != null) {
                try {
                    String sql = "UPDATE Estudiante SET "
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
                            + "promedioAnterior=?, "
                            + "estatusEscolar=?, "
                            + "intereses=?, "
                            + "habilidades=?, "
                            + "estadoLogico=?, "
                            + "curp=?, "
                            + "estadoCivil=?, "
                            + "nombreEscuela=?, "
                            + "matricula=?, "
                            + "regular=?, "
                            + "tipoPeriodo=?, "
                            + "totalPeriodos=?, "
                            + "periodoActual=?, "
                            + "periodo=?, "
                            + "promedioGeneral=?, "
                            + "validado=? "
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
                    registro.setDouble(15, nvoObj.getPromedioAnterior());
                    registro.setInt(16, nvoObj.isEstatusEscolar());
                    registro.setString(17, nvoObj.getIntereses());
                    registro.setString(18, nvoObj.getHabilidades());
                    registro.setInt(19, nvoObj.isEstadoLogico());
                    registro.setString(20, nvoObj.getCurp());
                    registro.setString(21, nvoObj.getEstadoCivil());
                    registro.setString(22, nvoObj.getNombreEscuela());
                    registro.setString(23, nvoObj.getMatricula());
                    registro.setInt(24, nvoObj.isRegular());
                    registro.setString(25, nvoObj.getTipoPeriodo());
                    registro.setInt(26, nvoObj.getTotalPeriodos());
                    registro.setInt(27, nvoObj.getPeriodoActual());
                    registro.setString(28, nvoObj.getPeriodo());
                    registro.setDouble(29, nvoObj.getPromedioGeneral());
                    registro.setString(30, nvoObj.getValidado());
                    registro.setInt(31, id);
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
    public GenericResponse<Estudiante> eliminar(IConexion conexionDB,int id) {
        GenericResponse<Estudiante> response = new GenericResponse<>();
        
        if (conexionDB.getConexion()!=null) {
            Estudiante obj = encontrarId(conexionDB,id);
            if (obj != null) {
                try {
                    String sql = "DELETE FROM Estudiante "
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
    public List<Estudiante> getData(IConexion conexionDB) {
        List<Estudiante> response = new ArrayList<>();
        
        if (conexionDB.getConexion()!=null) {
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
                        + "FROM Estudiante";
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
                    response.add(est);
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
    public List<Estudiante> consultar(IConexion conexionDB,String... filtros) {
        List<Estudiante> response = new ArrayList<>();
        
        if (conexionDB.getConexion()!=null) {
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
                        + "FROM Estudiante";
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
                    response.add(est);
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
    public Estudiante encontrarId(IConexion conexionDB,int id) {
        Estudiante response = null;
        
        if (conexionDB.getConexion()!=null) {
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
                        + "FROM Estudiante"
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
                    response.setPromedioAnterior(rs.getDouble(16));
                    response.setEstatusEscolar(rs.getInt(17));
                    response.setIntereses(rs.getString(18));
                    response.setHabilidades(rs.getString(19));
                    response.setEstadoLogico(rs.getInt(20));
                    response.setCurp(rs.getString(21));
                    response.setEstadoCivil(rs.getString(22));
                    response.setNombreEscuela(rs.getString(23));
                    response.setMatricula(rs.getString(24));
                    response.setRegular(rs.getInt(25));
                    response.setTipoPeriodo(rs.getString(26));
                    response.setTotalPeriodos(rs.getInt(27));
                    response.setPeriodoActual(rs.getInt(28));
                    response.setPeriodo(rs.getString(29));
                    response.setPromedioGeneral(rs.getDouble(30));
                    response.setValidado(rs.getString(31));
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

    public boolean changeEstadoLogico(IConexion conexionDB,int id, boolean estadoLogico) {
        boolean status = false;
        
        if (conexionDB.getConexion()!=null) {
            if (encontrarId(conexionDB,id) != null) {
                try {
                    String sql = "UPDATE Estudiante SET "
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
                     
                }
            } else {
                Logg.error("El registro no existe");
                 
            }
        } else {
            Logg.error("Error de conexión a la base de datos");
        }
        return status;
    }

    public boolean changeNumeroMovil(IConexion conexionDB,int id, int numeroMovil) {
        boolean status = false;
        
        if (conexionDB.getConexion()!=null) {
            if (encontrarId(conexionDB,id) != null) {
                try {
                    String sql = "UPDATE Estudiante SET "
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
                     
                }
            } else {
                Logg.error("El registro no existe");
                 
            }
        } else {
            Logg.error("Error de conexión a la base de datos");
        }
        return status;
    }

    public boolean changeNumeroFijo(IConexion conexionDB,int id, int numeroFijo) {
        boolean status = false;
        
        if (conexionDB.getConexion()!=null) {
            if (encontrarId(conexionDB,id) != null) {
                try {
                    String sql = "UPDATE Estudiante SET "
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
                     
                }
            } else {
                Logg.error("El registro no existe");
                 
            }
        } else {
            Logg.error("Error de conexión a la base de datos");
        }
        return status;
    }

    public List<Deseo> getListaDeseos(IConexion conexionDB,int id) {
        List<Deseo> response = new ArrayList<>();
        
        if (conexionDB.getConexion()!=null) {
            try {
                String sql = "SELECT "
                        + "idItem, "
                        + "idRecurso, "
                        + "idEstudiante, "
                        + "fecha "
                        + "FROM Deseo "
                        + "WHERE idEstudiante=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    Deseo sol = new Deseo();
                    sol.setIdItem(rs.getInt(1));
                    sol.setIdRecurso(rs.getInt(2));
                    sol.setIdEstudiante(rs.getInt(3));
                    sol.setFecha(Misc.transformDateTimeSqlJava(rs.getDate(4)));
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
}
