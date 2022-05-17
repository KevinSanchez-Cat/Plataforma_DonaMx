package model;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class GaleriaLogo {

    private int idOrganizacion;
    private int idGaleria;
    private String nombreImagen;
    private double tamanio;
    private String extension;
    private String urlDestino;

    public GaleriaLogo() {
    }

    public GaleriaLogo(int idGaleria, int idOrganizacion, String nombreImagen, double tamanio, String extension, String urlDestino) {
        this.idOrganizacion = idOrganizacion;
        this.idGaleria = idGaleria;
        this.nombreImagen = nombreImagen;
        this.tamanio = tamanio;
        this.extension = extension;
        this.urlDestino = urlDestino;
    }

    public int getIdOrganizacion() {
        return idOrganizacion;
    }

    public void setIdOrganizacion(int idOrganizacion) {
        this.idOrganizacion = idOrganizacion;
    }

    public int getIdGaleria() {
        return idGaleria;
    }

    public void setIdGaleria(int idGaleria) {
        this.idGaleria = idGaleria;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
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

    public String getUrlDestino() {
        return urlDestino;
    }

    public void setUrlDestino(String urlDestino) {
        this.urlDestino = urlDestino;
    }

}
