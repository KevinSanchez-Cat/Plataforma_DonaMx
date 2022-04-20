package model;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Galeria {

    private int idGaleria;
    private int idUsuario;
    private String nombreImagen;
    private double tamanio;
    private String extension;
    private String urlDestino;

    public Galeria() {
    }

    public Galeria(int usuario, String nombreImagen, double tamanio, String extension, String urlDestino) {
        this.idUsuario = usuario;
        this.nombreImagen = nombreImagen;
        this.tamanio = tamanio;
        this.extension = extension;
        this.urlDestino = urlDestino;
    }

    public Galeria(int idGaleria, int usuario, String nombreImagen, double tamanio, String extension, String urlDestino) {
        this.idGaleria = idGaleria;
        this.idUsuario = usuario;
        this.nombreImagen = nombreImagen;
        this.tamanio = tamanio;
        this.extension = extension;
        this.urlDestino = urlDestino;
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
     * Get the value of nombreImagen
     *
     * @return the value of nombreImagen
     */
    public String getNombreImagen() {
        return nombreImagen;
    }

    /**
     * Set the value of nombreImagen
     *
     * @param nombreImagen new value of nombreImagen
     */
    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
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
     * Get the value of idGaleria
     *
     * @return the value of idGaleria
     */
    public int getIdGaleria() {
        return idGaleria;
    }

    /**
     * Set the value of idGaleria
     *
     * @param idGaleria new value of idGaleria
     */
    public void setIdGaleria(int idGaleria) {
        this.idGaleria = idGaleria;
    }

    @Override
    public String toString() {
        return "Galeria{" + "idGaleria=" + idGaleria + ", usuario=" + idUsuario + ", nombreImagen=" + nombreImagen + ", tamanio=" + tamanio + ", extension=" + extension + ", urlDestino=" + urlDestino + '}';
    }

}
