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

    public String getUrlDestino() {
        return urlDestino;
    }

    public void setUrlDestino(String urlDestino) {
        this.urlDestino = urlDestino;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public double getTamanio() {
        return tamanio;
    }

    public void setTamanio(double tamanio) {
        this.tamanio = tamanio;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdGaleria() {
        return idGaleria;
    }

    public void setIdGaleria(int idGaleria) {
        this.idGaleria = idGaleria;
    }

    @Override
    public String toString() {
        return "Galeria{" + "idGaleria=" + idGaleria + ", usuario=" + idUsuario + ", nombreImagen=" + nombreImagen + ", tamanio=" + tamanio + ", extension=" + extension + ", urlDestino=" + urlDestino + '}';
    }

}
