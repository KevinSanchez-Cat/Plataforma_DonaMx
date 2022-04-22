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
    private String mensaje;

    public Notificacion() {
    }

    public Notificacion(int idUsuarioDestino, Date fechaNotificacion, String estadoVisualizacion, String prioridad) {
        this.idUsuarioDestino = idUsuarioDestino;
        this.fechaNotificacion = fechaNotificacion;
        this.estadoVisualizacion = estadoVisualizacion;
        this.prioridad = prioridad;
    }

    public Notificacion(int idNotificacion, int idUsuarioDestino, Date fechaNotificacion, String estadoVisualizacion, String prioridad, String mensaje) {
        this.idNotificacion = idNotificacion;
        this.idUsuarioDestino = idUsuarioDestino;
        this.fechaNotificacion = fechaNotificacion;
        this.estadoVisualizacion = estadoVisualizacion;
        this.prioridad = prioridad;
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getEstadoVisualizacion() {
        return estadoVisualizacion;
    }

    public void setEstadoVisualizacion(String estadoVisualizacion) {
        this.estadoVisualizacion = estadoVisualizacion;
    }

    public Date getFechaNotificacion() {
        return fechaNotificacion;
    }

    public void setFechaNotificacion(Date fechaNotificacion) {
        this.fechaNotificacion = fechaNotificacion;
    }

    public int getIdUsuarioDestino() {
        return idUsuarioDestino;
    }

    public void setIdUsuarioDestino(int idUsuarioDestino) {
        this.idUsuarioDestino = idUsuarioDestino;
    }

    public int getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    @Override
    public String toString() {
        return "Notificacion{" + "idNotificacion=" + idNotificacion + ", idUsuarioDestino=" + idUsuarioDestino + ", fechaNotificacion=" + fechaNotificacion + ", estadoVisualizacion=" + estadoVisualizacion + ", prioridad=" + prioridad + ", mensaje=" + mensaje + '}';
    }
}
