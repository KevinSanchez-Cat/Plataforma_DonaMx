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
    private Usuario usuario;

    public Archivo() {
    }

    public Archivo(String nombreArchivo, String extension, double tamanio, Date fechaCreacion, String urlDestino, Usuario usuario) {
        this.nombreArchivo = nombreArchivo;
        this.extension = extension;
        this.tamanio = tamanio;
        this.fechaCreacion = fechaCreacion;
        this.urlDestino = urlDestino;
        this.usuario = usuario;
    }

    /**
     * Get the value of usuario
     *
     * @return the value of usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Set the value of usuario
     *
     * @param usuario new value of usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Get the value of urlDestino
     *
     * @return the value of urlDestino
     */
    public String getUrlDestino() {
        return urlDestino;
    }

    /**
     * Set the value of urlDestino
     *
     * @param urlDestino new value of urlDestino
     */
    public void setUrlDestino(String urlDestino) {
        this.urlDestino = urlDestino;
    }

    /**
     * Get the value of fechaCreacion
     *
     * @return the value of fechaCreacion
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Set the value of fechaCreacion
     *
     * @param fechaCreacion new value of fechaCreacion
     */
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * Get the value of tamanio
     *
     * @return the value of tamanio
     */
    public double getTamanio() {
        return tamanio;
    }

    /**
     * Set the value of tamanio
     *
     * @param tamanio new value of tamanio
     */
    public void setTamanio(double tamanio) {
        this.tamanio = tamanio;
    }

    /**
     * Get the value of extension
     *
     * @return the value of extension
     */
    public String getExtension() {
        return extension;
    }

    /**
     * Set the value of extension
     *
     * @param extension new value of extension
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     * Get the value of nombreArchivo
     *
     * @return the value of nombreArchivo
     */
    public String getNombreArchivo() {
        return nombreArchivo;
    }

    /**
     * Set the value of nombreArchivo
     *
     * @param nombreArchivo new value of nombreArchivo
     */
    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    /**
     * Get the value of idArchivo
     *
     * @return the value of idArchivo
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

    @Override
    public String toString() {
        return "Archivo{" + "idArchivo=" + idArchivo + ", nombreArchivo=" + nombreArchivo + ", extension=" + extension + ", tamanio=" + tamanio + ", fechaCreacion=" + fechaCreacion + ", urlDestino=" + urlDestino + ", usuario=" + usuario + '}';
    }

}
