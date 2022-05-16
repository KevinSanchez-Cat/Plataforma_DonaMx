
package model;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class GaleriaRecurso {
 private int idGaleriaRecursos;
    private int idRecurso;
    private String nombreImagen;
    private double tamanio;
    private String extension;
    private String urlDestino;

    public GaleriaRecurso() {
    }

    public GaleriaRecurso(int idGaleriaRecursos, int idRecurso, String nombreImagen, double tamanio, String extension, String urlDestino) {
        this.idGaleriaRecursos = idGaleriaRecursos;
        this.idRecurso = idRecurso;
        this.nombreImagen = nombreImagen;
        this.tamanio = tamanio;
        this.extension = extension;
        this.urlDestino = urlDestino;
    }

    public int getIdGaleriaRecursos() {
        return idGaleriaRecursos;
    }

    public void setIdGaleriaRecursos(int idGaleriaRecursos) {
        this.idGaleriaRecursos = idGaleriaRecursos;
    }

    public int getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
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
