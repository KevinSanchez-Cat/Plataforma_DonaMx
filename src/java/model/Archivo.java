package model;

import java.util.Date;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Archivo {

    private int idArchivo;
    private String nombreArchivo;
    private String extension;
    private double tamanio;
    private Date fechaCreacion;//DATE TIME   
    private String urlDestino;
    private int idUsuario;

    public Archivo() {
    }

    public Archivo(String nombreArchivo, String extension, double tamanio, Date fechaCreacion, String urlDestino, int usuario) {
        this.nombreArchivo = nombreArchivo;
        this.extension = extension;
        this.tamanio = tamanio;
        this.fechaCreacion = fechaCreacion;
        this.urlDestino = urlDestino;
        this.idUsuario = usuario;
    }

    public Archivo(int idArchivo, String nombreArchivo, String extension, double tamanio, Date fechaCreacion, String urlDestino, int usuario) {
        this.idArchivo = idArchivo;
        this.nombreArchivo = nombreArchivo;
        this.extension = extension;
        this.tamanio = tamanio;
        this.fechaCreacion = fechaCreacion;
        this.urlDestino = urlDestino;
        this.idUsuario = usuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUrlDestino() {
        return urlDestino;
    }

    public void setUrlDestino(String urlDestino) {
        this.urlDestino = urlDestino;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public double getTamanio() {
        return tamanio;
    }

    public void setTamanio(double tamanio) {
        this.tamanio = tamanio;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public int getIdArchivo() {
        return idArchivo;
    }

    public void setIdArchivo(int idArchivo) {
        this.idArchivo = idArchivo;
    }

    @Override
    public String toString() {
        return "Archivo{" + "idArchivo=" + idArchivo + ", nombreArchivo=" + nombreArchivo + ", extension=" + extension + ", tamanio=" + tamanio + ", fechaCreacion=" + fechaCreacion + ", urlDestino=" + urlDestino + ", usuario=" + idUsuario + '}';
    }

}
