package model;

import java.util.Date;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Notificacion {

    private int idNotificacion;
    private int idUsuarioDestino;
    private Date fechaNotificacion;//DATE TIME
    private String estadoVisualizacion;
    private String prioridad;

    public Notificacion() {
    }

    public Notificacion(int idUsuarioDestino, Date fechaNotificacion, String estadoVisualizacion, String prioridad) {
        this.idUsuarioDestino = idUsuarioDestino;
        this.fechaNotificacion = fechaNotificacion;
        this.estadoVisualizacion = estadoVisualizacion;
        this.prioridad = prioridad;
    }

    /**
     * Get the value of prioridad
     *
     * @return the value of prioridad
     */
    public String getPrioridad() {
        return prioridad;
    }

    /**
     * Set the value of prioridad
     *
     * @param prioridad new value of prioridad
     */
    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    /**
     * Get the value of estadoVisualizacion
     *
     * @return the value of estadoVisualizacion
     */
    public String getEstadoVisualizacion() {
        return estadoVisualizacion;
    }

    /**
     * Set the value of estadoVisualizacion
     *
     * @param estadoVisualizacion new value of estadoVisualizacion
     */
    public void setEstadoVisualizacion(String estadoVisualizacion) {
        this.estadoVisualizacion = estadoVisualizacion;
    }

    /**
     * Get the value of fechaNotificacion
     *
     * @return the value of fechaNotificacion
     */
    public Date getFechaNotificacion() {
        return fechaNotificacion;
    }

    /**
     * Set the value of fechaNotificacion
     *
     * @param fechaNotificacion new value of fechaNotificacion
     */
    public void setFechaNotificacion(Date fechaNotificacion) {
        this.fechaNotificacion = fechaNotificacion;
    }

    /**
     * Get the value of idUsuarioDestino
     *
     * @return the value of idUsuarioDestino
     */
    public int getIdUsuarioDestino() {
        return idUsuarioDestino;
    }

    /**
     * Set the value of idUsuarioDestino
     *
     * @param idUsuarioDestino new value of idUsuarioDestino
     */
    public void setIdUsuarioDestino(int idUsuarioDestino) {
        this.idUsuarioDestino = idUsuarioDestino;
    }

    /**
     * Get the value of idNotificacion
     *
     * @return the value of idNotificacion
     */
    public int getIdNotificacion() {
        return idNotificacion;
    }

    /**
     * Set the value of idNotificacion
     *
     * @param idNotificacion new value of idNotificacion
     */
    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    @Override
    public String toString() {
        return "Notificacion{" + "idNotificacion=" + idNotificacion + ", idUsuarioDestino=" + idUsuarioDestino + ", fechaNotificacion=" + fechaNotificacion + ", estadoVisualizacion=" + estadoVisualizacion + ", prioridad=" + prioridad + '}';
    }

}
