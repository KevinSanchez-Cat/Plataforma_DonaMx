/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author por_s
 */
public class Notificacion {

    private int idNotificacion;
    private String idUsuarioOrigen;
    private String idUsuarioDestino;
    private String fechaNotificacion;//DATE TIME
    private char estadoVisualizacion;
    private char prioridad;

    public Notificacion() {
    }

    public Notificacion(int idNotificacion, String idUsuarioOrigen, String idUsuarioDestino, String fechaNotificacion, char estadoVisualizacion, char prioridad) {
        this.idNotificacion = idNotificacion;
        this.idUsuarioOrigen = idUsuarioOrigen;
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
    public char getPrioridad() {
        return prioridad;
    }

    /**
     * Set the value of prioridad
     *
     * @param prioridad new value of prioridad
     */
    public void setPrioridad(char prioridad) {
        this.prioridad = prioridad;
    }

    /**
     * Get the value of estadoVisualizacion
     *
     * @return the value of estadoVisualizacion
     */
    public char getEstadoVisualizacion() {
        return estadoVisualizacion;
    }

    /**
     * Set the value of estadoVisualizacion
     *
     * @param estadoVisualizacion new value of estadoVisualizacion
     */
    public void setEstadoVisualizacion(char estadoVisualizacion) {
        this.estadoVisualizacion = estadoVisualizacion;
    }

    /**
     * Get the value of fechaNotificacion
     *
     * @return the value of fechaNotificacion
     */
    public String getFechaNotificacion() {
        return fechaNotificacion;
    }

    /**
     * Set the value of fechaNotificacion
     *
     * @param fechaNotificacion new value of fechaNotificacion
     */
    public void setFechaNotificacion(String fechaNotificacion) {
        this.fechaNotificacion = fechaNotificacion;
    }

    /**
     * Get the value of idUsuarioDestino
     *
     * @return the value of idUsuarioDestino
     */
    public String getIdUsuarioDestino() {
        return idUsuarioDestino;
    }

    /**
     * Set the value of idUsuarioDestino
     *
     * @param idUsuarioDestino new value of idUsuarioDestino
     */
    public void setIdUsuarioDestino(String idUsuarioDestino) {
        this.idUsuarioDestino = idUsuarioDestino;
    }

    /**
     * Get the value of idUsuarioOrigen
     *
     * @return the value of idUsuarioOrigen
     */
    public String getIdUsuarioOrigen() {
        return idUsuarioOrigen;
    }

    /**
     * Set the value of idUsuarioOrigen
     *
     * @param idUsuarioOrigen new value of idUsuarioOrigen
     */
    public void setIdUsuarioOrigen(String idUsuarioOrigen) {
        this.idUsuarioOrigen = idUsuarioOrigen;
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
        return "Notificacion{" + "idNotificacion=" + idNotificacion + ", idUsuarioOrigen=" + idUsuarioOrigen + ", idUsuarioDestino=" + idUsuarioDestino + ", fechaNotificacion=" + fechaNotificacion + ", estadoVisualizacion=" + estadoVisualizacion + ", prioridad=" + prioridad + '}';
    }

}
