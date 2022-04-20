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
    private Date fechaSolicitud;//DATE TIME
    private Date fechaRespuesta;//DATE TIME

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

    /**
     * Get the value of fechaRespuesta
     *
     * @return the value of fechaRespuesta
     */
    public Date getFechaRespuesta() {
        return fechaRespuesta;
    }

    /**
     * Set the value of fechaRespuesta
     *
     * @param fechaRespuesta new value of fechaRespuesta
     */
    public void setFechaRespuesta(Date fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    /**
     * Get the value of fechaSolicitud
     *
     * @return the value of fechaSolicitud
     */
    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    /**
     * Set the value of fechaSolicitud
     *
     * @param fechaSolicitud new value of fechaSolicitud
     */
    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    /**
     * Get the value of estadoSolicitud
     *
     * @return the value of estadoSolicitud
     */
    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }

    /**
     * Set the value of estadoSolicitud
     *
     * @param estadoSolicitud new value of estadoSolicitud
     */
    public void setEstadoSolicitud(String estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    /**
     * Get the value of archivo
     *
     * @return the value of archivo
     */
    public int getIdArchivo() {
        return idArchivo;
    }

    /**
     * Set the value of idArchivo
     *
     * @param idArchivo new value of idArchivo
     */
    public void setIdArchivo(int idArchivo) {
        this.idArchivo = idArchivo;
    }

    /**
     * Get the value of idRecursoTecnologico
     *
     * @return the value of idRecursoTecnologico
     */
    public int getIdRecursoTecnologico() {
        return idRecursoTecnologico;
    }

    /**
     * Set the value of idRecursoTecnologico
     *
     * @param idRecursoTecnologico new value of idRecursoTecnologico
     */
    public void setIdRecursoTecnologico(int idRecursoTecnologico) {
        this.idRecursoTecnologico = idRecursoTecnologico;
    }

    /**
     * Get the value of idUsuario
     *
     * @return the value of idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Set the value of idUsuario
     *
     * @param idUsuario new value of idUsuario
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Get the value of idSolicitud
     *
     * @return the value of idSolicitud
     */
    public int getIdSolicitud() {
        return idSolicitud;
    }

    /**
     * Set the value of idSolicitud
     *
     * @param idSolicitud new value of idSolicitud
     */
    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    @Override
    public String toString() {
        return "Solicitud{" + "idSolicitud=" + idSolicitud + ", idUsuario=" + idUsuario + ", idRecursoTecnologico=" + idRecursoTecnologico + ", idArchivo=" + idArchivo + ", estadoSolicitud=" + estadoSolicitud + ", fechaSolicitud=" + fechaSolicitud + ", fechaRespuesta=" + fechaRespuesta + '}';
    }

    

}
