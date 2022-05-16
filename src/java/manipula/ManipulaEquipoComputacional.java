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
                String sql = "INSERT INTO EquipoComputacional ("
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
                        + "estadoEquipo, "
                        + "capDiscoDuro, "
                        + "interfaceDiscoDuro, "
                        + "resolucionPantalla, "
                        + "tipoResolucion, "
                        + "tamanioPantalla, "
                        + "relacionAspecto, "
                        + "tipoPantalla, "
                        + "conAntireflejo, "
                        + "tarjetaGrafica, "
                        + "marcaProcesador, "
                        + "cantidadNucleos, "
                        + "velocidadProcesador, "
                        + "tipoBateria, "
                        + "duracionBateria, "
                        + "puertosVideo, "
                        + "puertosUSB, "
                        + "cantidadRanurasRAM, "
                        + "cantidadTotalPuertosUSB, "
                        + "conUSB, "
                        + "conWifi, "
                        + "conHDMI, "
                        + "conBluetooth, "
                        + "conSalidaAudifonos, "
                        + "conPuertoEthernet, "
                        + "conLectorTarjetaMemoriaSD, "
                        + "conVGA, "
                        + "peso, "
                        + "ancho, "
                        + "profundidad, "
                        + "altura, "
                        + "modoSonido, "
                        + "cantidadParlantes, "
                        + "conMicrofono, "
                        + "conCamaraWeb, "
                        + "fechaCreacion "
                        + ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
                registro.setString(11, obj.getEstadoEquipo());
                registro.setString(12, obj.getCapDiscoDuro());
                registro.setString(13, obj.getInterfaceDiscoDuro());
                registro.setString(14, obj.getResolucionPantalla());
                registro.setString(15, obj.getTipoResolucion());
                registro.setString(16, obj.getTamanioPantalla());
                registro.setString(17, obj.getRelacionAspecto());
                registro.setString(18, obj.getTipoPantalla());
                registro.setString(19, obj.getConAntireflejo());
                registro.setString(20, obj.getTarjetaGrafica());
                registro.setString(21, obj.getMarcaProcesador());
                registro.setInt(22, obj.getCantidadNucleos());
                registro.setString(23, obj.getVelocidadProcesador());
                registro.setString(24, obj.getTipoBateria());
                registro.setInt(25, obj.getDuracionBateria());
                registro.setString(26, obj.getPuertosVideo());
                registro.setString(27, obj.getPuertosUSB());
                registro.setInt(28, obj.getCantidadRanurasRAM());
                registro.setInt(29, obj.getCantidadPuertosUSB());
                registro.setString(30, obj.getConUSB());
                registro.setString(31, obj.getConWifi());
                registro.setString(32, obj.getConHDMI());
                registro.setString(33, obj.getConBluetooth());
                registro.setString(34, obj.getConSalidaAudifinos());
                registro.setString(35, obj.getConPuertoEthernet());
                registro.setString(36, obj.getConLectorTarjetaMemoriaSD());
                registro.setString(37, obj.getConVGA());
                registro.setDouble(38, obj.getPeso());
                registro.setDouble(39, obj.getAncho());
                registro.setDouble(40, obj.getProfundidad());
                registro.setDouble(41, obj.getAltura());
                registro.setString(42, obj.getModoSonido());
                registro.setInt(43, obj.getCantidadParlantes());
                registro.setString(44, obj.getConMicrofono());
                registro.setString(45, obj.getConCamaraWeb());
                registro.setTimestamp(46, obj.getFechaCreacion());
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
                    String sql = "UPDATE EquipoComputacional SET "
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
                            + "estadoEquipo=?, "
                            + "capDiscoDuro=?, "
                            + "interfaceDiscoDuro=?, "
                            + "resolucionPantalla=?, "
                            + "tipoResolucion=?, "
                            + "tamanioPantalla=?, "
                            + "relacionAspecto=?, "
                            + "tipoPantalla=?, "
                            + "conAntireflejo=?, "
                            + "tarjetaGrafica=?, "
                            + "marcaProcesador=?, "
                            + "cantidadNucleos=?, "
                            + "velocidadProcesador=?, "
                            + "tipoBateria=?, "
                            + "duracionBateria=?, "
                            + "puertosVideo=?, "
                            + "puertosUSB=?, "
                            + "cantidadRanurasRAM=?, "
                            + "cantidadTotalPuertosUSB=?, "
                            + "conUSB=?, "
                            + "conWifi=?, "
                            + "conHDMI=?, "
                            + "conBluetooth=?, "
                            + "conSalidaAudifonos=?, "
                            + "conPuertoEthernet=?, "
                            + "conLectorTarjetaMemoriaSD=?, "
                            + "conVGA=?, "
                            + "peso=?, "
                            + "ancho=?, "
                            + "profundidad=?, "
                            + "altura=?, "
                            + "modoSonido=?, "
                            + "cantidadParlantes=?, "
                            + "conMicrofono=?, "
                            + "conCamaraWeb=?, "
                            + "fechaCreacion=? "
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
                    registro.setString(11, nvoObj.getEstadoEquipo());
                    registro.setString(12, nvoObj.getCapDiscoDuro());
                    registro.setString(13, nvoObj.getInterfaceDiscoDuro());
                    registro.setString(14, nvoObj.getResolucionPantalla());
                    registro.setString(15, nvoObj.getTipoResolucion());
                    registro.setString(16, nvoObj.getTamanioPantalla());
                    registro.setString(17, nvoObj.getRelacionAspecto());
                    registro.setString(18, nvoObj.getTipoPantalla());
                    registro.setString(19, nvoObj.getConAntireflejo());
                    registro.setString(20, nvoObj.getTarjetaGrafica());
                    registro.setString(21, nvoObj.getMarcaProcesador());
                    registro.setInt(22, nvoObj.getCantidadNucleos());
                    registro.setString(23, nvoObj.getVelocidadProcesador());
                    registro.setString(24, nvoObj.getTipoBateria());
                    registro.setInt(25, nvoObj.getDuracionBateria());
                    registro.setString(26, nvoObj.getPuertosVideo());
                    registro.setString(27, nvoObj.getPuertosUSB());
                    registro.setInt(28, nvoObj.getCantidadRanurasRAM());
                    registro.setInt(29, nvoObj.getCantidadPuertosUSB());
                    registro.setString(30, nvoObj.getConUSB());
                    registro.setString(31, nvoObj.getConWifi());
                    registro.setString(32, nvoObj.getConHDMI());
                    registro.setString(33, nvoObj.getConBluetooth());
                    registro.setString(34, nvoObj.getConSalidaAudifinos());
                    registro.setString(35, nvoObj.getConPuertoEthernet());
                    registro.setString(36, nvoObj.getConLectorTarjetaMemoriaSD());
                    registro.setString(37, nvoObj.getConVGA());
                    registro.setDouble(38, nvoObj.getPeso());
                    registro.setDouble(39, nvoObj.getAncho());
                    registro.setDouble(40, nvoObj.getProfundidad());
                    registro.setDouble(41, nvoObj.getAltura());
                    registro.setString(42, nvoObj.getModoSonido());
                    registro.setInt(43, nvoObj.getCantidadParlantes());
                    registro.setString(44, nvoObj.getConMicrofono());
                    registro.setString(45, nvoObj.getConCamaraWeb());
                    registro.setTimestamp(46, nvoObj.getFechaCreacion());
                    registro.setInt(47, id);
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
    public GenericResponse<EquipoComputacional> eliminar(int id) {
        GenericResponse<EquipoComputacional> response = new GenericResponse<>();
        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            EquipoComputacional obj = encontrarId(id);
            if (obj != null) {
                try {
                    String sql = "DELETE FROM EquipoComputacional "
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
                        + "estadoEquipo, "
                        + "capDiscoDuro, "
                        + "interfaceDiscoDuro, "
                        + "resolucionPantalla, "
                        + "tipoResolucion, "
                        + "tamanioPantalla, "
                        + "relacionAspecto, "
                        + "tipoPantalla, "
                        + "conAntireflejo, "
                        + "tarjetaGrafica, "
                        + "marcaProcesador, "
                        + "cantidadNucleos, "
                        + "velocidadProcesador, "
                        + "tipoBateria, "
                        + "duracionBateria, "
                        + "puertosVideo, "
                        + "puertosUSB, "
                        + "cantidadRanurasRAM, "
                        + "cantidadTotalPuertosUSB, "
                        + "conUSB, "
                        + "conWifi, "
                        + "conHDMI, "
                        + "conBluetooth, "
                        + "conSalidaAudifonos, "
                        + "conPuertoEthernet, "
                        + "conLectorTarjetaMemoriaSD, "
                        + "conVGA, "
                        + "peso, "
                        + "ancho, "
                        + "profundidad, "
                        + "altura, "
                        + "modoSonido, "
                        + "cantidadParlantes, "
                        + "conMicrofono, "
                        + "conCamaraWeb, "
                        + "fechaCreacion "
                        + "FROM EquipoComputacional";
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
                    eqCp.setEstadoEquipo(rs.getString(12));
                    eqCp.setCapDiscoDuro(rs.getString(13));
                    eqCp.setInterfaceDiscoDuro(rs.getString(14));
                    eqCp.setResolucionPantalla(rs.getString(15));
                    eqCp.setTipoResolucion(rs.getString(16));
                    eqCp.setTamanioPantalla(rs.getString(17));
                    eqCp.setRelacionAspecto(rs.getString(18));
                    eqCp.setTipoPantalla(rs.getString(19));
                    eqCp.setConAntireflejo(rs.getString(20));
                    eqCp.setTarjetaGrafica(rs.getString(21));
                    eqCp.setMarcaProcesador(rs.getString(22));
                    eqCp.setCantidadNucleos(rs.getInt(23));
                    eqCp.setVelocidadProcesador(rs.getString(24));
                    eqCp.setTipoBateria(rs.getString(25));
                    eqCp.setDuracionBateria(rs.getInt(26));
                    eqCp.setPuertosVideo(rs.getString(27));
                    eqCp.setPuertosUSB(rs.getString(28));
                    eqCp.setCantidadRanurasRAM(rs.getInt(29));
                    eqCp.setCantidadPuertosUSB(rs.getInt(30));
                    eqCp.setConUSB(rs.getString(31));
                    eqCp.setConWifi(rs.getString(32));
                    eqCp.setConHDMI(rs.getString(33));
                    eqCp.setConBluetooth(rs.getString(34));
                    eqCp.setConSalidaAudifinos(rs.getString(35));
                    eqCp.setConPuertoEthernet(rs.getString(36));
                    eqCp.setConLectorTarjetaMemoriaSD(rs.getString(37));
                    eqCp.setConVGA(rs.getString(38));
                    eqCp.setPeso(rs.getDouble(39));
                    eqCp.setAncho(rs.getDouble(40));
                    eqCp.setProfundidad(rs.getDouble(41));
                    eqCp.setAltura(rs.getDouble(42));
                    eqCp.setModoSonido(rs.getString(43));
                    eqCp.setCantidadParlantes(rs.getInt(44));
                    eqCp.setConMicrofono(rs.getString(45));
                    eqCp.setConCamaraWeb(rs.getString(46));
                    eqCp.setFechaCreacion(rs.getTimestamp(47));
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
                        + "estadoEquipo, "
                        + "capDiscoDuro, "
                        + "interfaceDiscoDuro, "
                        + "resolucionPantalla, "
                        + "tipoResolucion, "
                        + "tamanioPantalla, "
                        + "relacionAspecto, "
                        + "tipoPantalla, "
                        + "conAntireflejo, "
                        + "tarjetaGrafica, "
                        + "marcaProcesador, "
                        + "cantidadNucleos, "
                        + "velocidadProcesador, "
                        + "tipoBateria, "
                        + "duracionBateria, "
                        + "puertosVideo, "
                        + "puertosUSB, "
                        + "cantidadRanurasRAM, "
                        + "cantidadTotalPuertosUSB, "
                        + "conUSB, "
                        + "conWifi, "
                        + "conHDMI, "
                        + "conBluetooth, "
                        + "conSalidaAudifonos, "
                        + "conPuertoEthernet, "
                        + "conLectorTarjetaMemoriaSD, "
                        + "conVGA, "
                        + "peso, "
                        + "ancho, "
                        + "profundidad, "
                        + "altura, "
                        + "modoSonido, "
                        + "cantidadParlantes, "
                        + "conMicrofono, "
                        + "conCamaraWeb, "
                        + "fechaCreacion "
                        + "FROM EquipoComputacional";
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
                    eqCp.setEstadoEquipo(rs.getString(12));
                    eqCp.setCapDiscoDuro(rs.getString(13));
                    eqCp.setInterfaceDiscoDuro(rs.getString(14));
                    eqCp.setResolucionPantalla(rs.getString(15));
                    eqCp.setTipoResolucion(rs.getString(16));
                    eqCp.setTamanioPantalla(rs.getString(17));
                    eqCp.setRelacionAspecto(rs.getString(18));
                    eqCp.setTipoPantalla(rs.getString(19));
                    eqCp.setConAntireflejo(rs.getString(20));
                    eqCp.setTarjetaGrafica(rs.getString(21));
                    eqCp.setMarcaProcesador(rs.getString(22));
                    eqCp.setCantidadNucleos(rs.getInt(23));
                    eqCp.setVelocidadProcesador(rs.getString(24));
                    eqCp.setTipoBateria(rs.getString(25));
                    eqCp.setDuracionBateria(rs.getInt(26));
                    eqCp.setPuertosVideo(rs.getString(27));
                    eqCp.setPuertosUSB(rs.getString(28));
                    eqCp.setCantidadRanurasRAM(rs.getInt(29));
                    eqCp.setCantidadPuertosUSB(rs.getInt(30));
                    eqCp.setConUSB(rs.getString(31));
                    eqCp.setConWifi(rs.getString(32));
                    eqCp.setConHDMI(rs.getString(33));
                    eqCp.setConBluetooth(rs.getString(34));
                    eqCp.setConSalidaAudifinos(rs.getString(35));
                    eqCp.setConPuertoEthernet(rs.getString(36));
                    eqCp.setConLectorTarjetaMemoriaSD(rs.getString(37));
                    eqCp.setConVGA(rs.getString(38));
                    eqCp.setPeso(rs.getDouble(39));
                    eqCp.setAncho(rs.getDouble(40));
                    eqCp.setProfundidad(rs.getDouble(41));
                    eqCp.setAltura(rs.getDouble(42));
                    eqCp.setModoSonido(rs.getString(43));
                    eqCp.setCantidadParlantes(rs.getInt(44));
                    eqCp.setConMicrofono(rs.getString(45));
                    eqCp.setConCamaraWeb(rs.getString(46));
                    eqCp.setFechaCreacion(rs.getTimestamp(47));
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
                        + "estadoEquipo, "
                        + "capDiscoDuro, "
                        + "interfaceDiscoDuro, "
                        + "resolucionPantalla, "
                        + "tipoResolucion, "
                        + "tamanioPantalla, "
                        + "relacionAspecto, "
                        + "tipoPantalla, "
                        + "conAntireflejo, "
                        + "tarjetaGrafica, "
                        + "marcaProcesador, "
                        + "cantidadNucleos, "
                        + "velocidadProcesador, "
                        + "tipoBateria, "
                        + "duracionBateria, "
                        + "puertosVideo, "
                        + "puertosUSB, "
                        + "cantidadRanurasRAM, "
                        + "cantidadTotalPuertosUSB, "
                        + "conUSB, "
                        + "conWifi, "
                        + "conHDMI, "
                        + "conBluetooth, "
                        + "conSalidaAudifonos, "
                        + "conPuertoEthernet, "
                        + "conLectorTarjetaMemoriaSD, "
                        + "conVGA, "
                        + "peso, "
                        + "ancho, "
                        + "profundidad, "
                        + "altura, "
                        + "modoSonido, "
                        + "cantidadParlantes, "
                        + "conMicrofono, "
                        + "conCamaraWeb, "
                        + "fechaCreacion "
                        + "FROM EquipoComputacional "
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
                    response.setEstadoEquipo(rs.getString(12));
                    response.setCapDiscoDuro(rs.getString(13));
                    response.setInterfaceDiscoDuro(rs.getString(14));
                    response.setResolucionPantalla(rs.getString(15));
                    response.setTipoResolucion(rs.getString(16));
                    response.setTamanioPantalla(rs.getString(17));
                    response.setRelacionAspecto(rs.getString(18));
                    response.setTipoPantalla(rs.getString(19));
                    response.setConAntireflejo(rs.getString(20));
                    response.setTarjetaGrafica(rs.getString(21));
                    response.setMarcaProcesador(rs.getString(22));
                    response.setCantidadNucleos(rs.getInt(23));
                    response.setVelocidadProcesador(rs.getString(24));
                    response.setTipoBateria(rs.getString(25));
                    response.setDuracionBateria(rs.getInt(26));
                    response.setPuertosVideo(rs.getString(27));
                    response.setPuertosUSB(rs.getString(28));
                    response.setCantidadRanurasRAM(rs.getInt(29));
                    response.setCantidadPuertosUSB(rs.getInt(30));
                    response.setConUSB(rs.getString(31));
                    response.setConWifi(rs.getString(32));
                    response.setConHDMI(rs.getString(33));
                    response.setConBluetooth(rs.getString(34));
                    response.setConSalidaAudifinos(rs.getString(35));
                    response.setConPuertoEthernet(rs.getString(36));
                    response.setConLectorTarjetaMemoriaSD(rs.getString(37));
                    response.setConVGA(rs.getString(38));
                    response.setPeso(rs.getDouble(39));
                    response.setAncho(rs.getDouble(40));
                    response.setProfundidad(rs.getDouble(41));
                    response.setAltura(rs.getDouble(42));
                    response.setModoSonido(rs.getString(43));
                    response.setCantidadParlantes(rs.getInt(44));
                    response.setConMicrofono(rs.getString(45));
                    response.setConCamaraWeb(rs.getString(46));
                    response.setFechaCreacion(rs.getTimestamp(47));
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

    public EquipoComputacional encontrarIdRecurso(int idRecursoTecnologico) {
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
                        + "estadoEquipo, "
                        + "capDiscoDuro, "
                        + "interfaceDiscoDuro, "
                        + "resolucionPantalla, "
                        + "tipoResolucion, "
                        + "tamanioPantalla, "
                        + "relacionAspecto, "
                        + "tipoPantalla, "
                        + "conAntireflejo, "
                        + "tarjetaGrafica, "
                        + "marcaProcesador, "
                        + "cantidadNucleos, "
                        + "velocidadProcesador, "
                        + "tipoBateria, "
                        + "duracionBateria, "
                        + "puertosVideo, "
                        + "puertosUSB, "
                        + "cantidadRanurasRAM, "
                        + "cantidadTotalPuertosUSB, "
                        + "conUSB, "
                        + "conWifi, "
                        + "conHDMI, "
                        + "conBluetooth, "
                        + "conSalidaAudifonos, "
                        + "conPuertoEthernet, "
                        + "conLectorTarjetaMemoriaSD, "
                        + "conVGA, "
                        + "peso, "
                        + "ancho, "
                        + "profundidad, "
                        + "altura, "
                        + "modoSonido, "
                        + "cantidadParlantes, "
                        + "conMicrofono, "
                        + "conCamaraWeb, "
                        + "fechaCreacion "
                        + "FROM EquipoComputacional "
                        + "WHERE idRecurso=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setInt(1, idRecursoTecnologico);
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
