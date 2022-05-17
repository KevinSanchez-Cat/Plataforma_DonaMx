package model;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Solicitud {

    private int idSolicitud;
    private int idUsuarioDonatario;
    private int idUsuarioDonador;
    private int idRecursoTecnologico;
    private String estadoSolicitud;
    private Timestamp fechaSolicitud;
    private Timestamp fechaRespuesta;

    public Solicitud() {
    }

    public Solicitud(int idUsuario, int idRecursoTecnologico, int idArchivo, String estadoSolicitud, Timestamp fechaSolicitud) {
        this.idUsuarioDonatario = idUsuario;
        this.idRecursoTecnologico = idRecursoTecnologico;
        this.estadoSolicitud = estadoSolicitud;
        this.fechaSolicitud = fechaSolicitud;
    }

    public Solicitud(int idSolicitud, int idUsuario, int idRecursoTecnologico, int idArchivo, String estadoSolicitud, Timestamp fechaSolicitud, Timestamp fechaRespuesta) {
        this.idSolicitud = idSolicitud;
        this.idUsuarioDonatario = idUsuario;
        this.idRecursoTecnologico = idRecursoTecnologico;
        this.estadoSolicitud = estadoSolicitud;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaRespuesta = fechaRespuesta;
    }

    public int getIdUsuarioDonador() {
        return idUsuarioDonador;
    }

    public void setIdUsuarioDonador(int idUsuarioDonador) {
        this.idUsuarioDonador = idUsuarioDonador;
    }

    public Timestamp getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(Timestamp fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    public Timestamp getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Timestamp fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(String estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }


    public int getIdRecursoTecnologico() {
        return idRecursoTecnologico;
    }

    public void setIdRecursoTecnologico(int idRecursoTecnologico) {
        this.idRecursoTecnologico = idRecursoTecnologico;
    }

    public int getIdUsuarioDonatario() {
        return idUsuarioDonatario;
    }

    public void setIdUsuarioDonatario(int idUsuarioDonatario) {
        this.idUsuarioDonatario = idUsuarioDonatario;
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

}
