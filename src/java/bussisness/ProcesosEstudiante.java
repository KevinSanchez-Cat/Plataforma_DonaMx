package bussisness;

import config.conexion.ConexionFactory;
import config.conexion.IConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import manipula.ManipulaEstudiante;
import model.Deseo;
import model.Donacion;
import model.Estudiante;
import model.Notificacion;
import model.Solicitud;
import utils.Logg;
import utils.Misc;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ProcesosEstudiante {

    public static Object[] infoPrincipal(int idUser) {
        Object[] info = new Object[4];
        List<Deseo> lstDeseos = null;
        List<Donacion> lstDonaciones = new ArrayList<>();
        List<Notificacion> lstNotificaciones = new ArrayList<>();
        Estudiante estudiante = null;

        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
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
                ps.setInt(1, idUser);
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
                    lstDonaciones.add(sol);
                }
            } catch (SQLException ex) {
                Logg.error("Comunicación fallida con la base de datos " + ex.getMessage());
            }
        } else {
            Logg.error("Conexión fallida con la base de datos");
        }

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
            ps.setInt(1, idUser);
            ResultSet rs;
            rs = ps.executeQuery();
            if (rs.next()) {
                estudiante = new Estudiante();
                estudiante.setIdEstudiante(rs.getInt(1));
                estudiante.setIdUsuario(rs.getInt(2));
                estudiante.setNombres(rs.getString(3));
                estudiante.setApellidoPaterno(rs.getString(4));
                estudiante.setApellidoMaterno(rs.getString(5));
                estudiante.setFechaNacimiento(rs.getDate(6));
                estudiante.setGenero(rs.getString(7));
                estudiante.setPresentacion(rs.getString(8));
                estudiante.setNumeroTelMovil(rs.getInt(9));
                estudiante.setNumeroTelFijo(rs.getInt(10));
                estudiante.setLugarNacimiento(rs.getString(11));
                estudiante.setNacionalidad(rs.getString(12));
                estudiante.setNivelEducativo(rs.getString(13));
                estudiante.setOcupacion(rs.getString(14));
                estudiante.setTipoEscuela(rs.getString(15));
                estudiante.setPromedioAnterior(rs.getDouble(16));
                estudiante.setEstatusEscolar(rs.getInt(17));
                estudiante.setIntereses(rs.getString(18));
                estudiante.setHabilidades(rs.getString(19));
                estudiante.setEstadoLogico(rs.getInt(20));
                estudiante.setCurp(rs.getString(21));
                estudiante.setEstadoCivil(rs.getString(22));
                estudiante.setNombreEscuela(rs.getString(23));
                estudiante.setMatricula(rs.getString(24));
                estudiante.setRegular(rs.getInt(25));
                estudiante.setTipoPeriodo(rs.getString(26));
                estudiante.setTotalPeriodos(rs.getInt(27));
                estudiante.setPeriodoActual(rs.getInt(28));
                estudiante.setPeriodo(rs.getString(29));
                estudiante.setPromedioGeneral(rs.getDouble(30));
                estudiante.setValidado(rs.getString(31));
            } else {
                Logg.error("No se encontro ningun registro: ESTUDIANTE");
            }
        } catch (SQLException ex) {
            Logg.error("Comunicación fallida con la base de datos " + ex.getMessage());
        }
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
            ps.setInt(1, idUser);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                lstNotificaciones.add(new Notificacion(rs.getInt(1),
                        rs.getInt(2),
                        rs.getTimestamp(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (SQLException ex) {
            Logg.error("Comunicación fallida con la base de datos " + ex.getMessage());
        }
        if (estudiante != null) {
            lstDeseos=new ArrayList<>();
            try {
                String sql = "SELECT "
                        + "idItem, "
                        + "idRecurso, "
                        + "idEstudiante, "
                        + "fecha "
                        + "FROM Deseo "
                        + "WHERE idEstudiante=?";
                PreparedStatement ps = conexionDB.getConexion().prepareStatement(sql);
                ps.setInt(1, estudiante.getIdEstudiante());
                ResultSet rs;
                rs = ps.executeQuery();
                while (rs.next()) {
                    Deseo sol = new Deseo();
                    sol.setIdItem(rs.getInt(1));
                    sol.setIdRecurso(rs.getInt(2));
                    sol.setIdEstudiante(rs.getInt(3));
                    sol.setFecha(rs.getTimestamp(4));
                    lstDeseos.add(sol);
                }
            } catch (SQLException ex) {
                Logg.error("Comunicación fallida con la base de datos");
            }
        }
        conexionDB.desconectar();
        return null;
    }
}
