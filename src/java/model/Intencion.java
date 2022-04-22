
package model;

import java.util.Date;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Intencion {

    private int idIntencion;
    private int idUsuario;
    private String tituloIntencion;
    private String descripcion;
    private Date fechaIntencion;
    private String estadoIntencion;
    private String respuestaIntencion;
    private Date fechaRespuesta;

    public Intencion() {
    }

    public Intencion(int idUsuario, String tituloIntencion, String descripcion, Date fechaIntencion, String estadoIntencion) {
        this.idUsuario = idUsuario;
        this.tituloIntencion = tituloIntencion;
        this.descripcion = descripcion;
        this.fechaIntencion = fechaIntencion;
        this.estadoIntencion = estadoIntencion;
    }

    public Intencion(int idIntencion, int idUsuario, String tituloIntencion, String descripcion, Date fechaIntencion, String estadoIntencion, String respuestaIntencion, Date fechaRespuesta) {
        this.idIntencion = idIntencion;
        this.idUsuario = idUsuario;
        this.tituloIntencion = tituloIntencion;
        this.descripcion = descripcion;
        this.fechaIntencion = fechaIntencion;
        this.estadoIntencion = estadoIntencion;
        this.respuestaIntencion = respuestaIntencion;
        this.fechaRespuesta = fechaRespuesta;
    }

    public Date getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(Date fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    public String getRespuestaIntencion() {
        return respuestaIntencion;
    }

    public void setRespuestaIntencion(String respuestaIntencion) {
        this.respuestaIntencion = respuestaIntencion;
    }

    public String getEstadoIntencion() {
        return estadoIntencion;
    }

    public void setEstadoIntencion(String estadoIntencion) {
        this.estadoIntencion = estadoIntencion;
    }

    public Date getFechaIntencion() {
        return fechaIntencion;
    }

    public void setFechaIntencion(Date fechaIntencion) {
        this.fechaIntencion = fechaIntencion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTituloIntencion() {
        return tituloIntencion;
    }

    public void setTituloIntencion(String tituloIntencion) {
        this.tituloIntencion = tituloIntencion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdIntencion() {
        return idIntencion;
    }

    public void setIdIntencion(int idIntencion) {
        this.idIntencion = idIntencion;
    }

    @Override
    public String toString() {
        return "Intencion{" + "idIntencion=" + idIntencion + ", idUsuario=" + idUsuario + ", tituloIntencion=" + tituloIntencion + ", descripcion=" + descripcion + ", fechaIntencion=" + fechaIntencion + ", estadoIntencion=" + estadoIntencion + ", respuestaIntencion=" + respuestaIntencion + ", fechaRespuesta=" + fechaRespuesta + '}';
    }

}
