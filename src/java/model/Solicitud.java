package model;

import java.util.Date;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Solicitud {

    private int idSolicitud;
    private int idUsuario;
    private int idRecursoTecnologico;
    private int idArchivo;
    private String estadoSolicitud;
    private Date fechaSolicitud;
    private Date fechaRespuesta;

    public Solicitud() {
    }

    public Solicitud(int idUsuario, int idRecursoTecnologico, int idArchivo, String estadoSolicitud, Date fechaSolicitud) {
        this.idUsuario = idUsuario;
        this.idRecursoTecnologico = idRecursoTecnologico;
        this.idArchivo = idArchivo;
        this.estadoSolicitud = estadoSolicitud;
        this.fechaSolicitud = fechaSolicitud;
    }

    public Solicitud(int idSolicitud, int idUsuario, int idRecursoTecnologico, int idArchivo, String estadoSolicitud, Date fechaSolicitud, Date fechaRespuesta) {
        this.idSolicitud = idSolicitud;
        this.idUsuario = idUsuario;
        this.idRecursoTecnologico = idRecursoTecnologico;
        this.idArchivo = idArchivo;
        this.estadoSolicitud = estadoSolicitud;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaRespuesta = fechaRespuesta;
    }

    public Date getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(Date fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(String estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    public int getIdArchivo() {
        return idArchivo;
    }

    public void setIdArchivo(int idArchivo) {
        this.idArchivo = idArchivo;
    }

    public int getIdRecursoTecnologico() {
        return idRecursoTecnologico;
    }

    public void setIdRecursoTecnologico(int idRecursoTecnologico) {
        this.idRecursoTecnologico = idRecursoTecnologico;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    @Override
    public String toString() {
        return "Solicitud{" + "idSolicitud=" + idSolicitud + ", idUsuario=" + idUsuario + ", idRecursoTecnologico=" + idRecursoTecnologico + ", idArchivo=" + idArchivo + ", estadoSolicitud=" + estadoSolicitud + ", fechaSolicitud=" + fechaSolicitud + ", fechaRespuesta=" + fechaRespuesta + '}';
    }
}
