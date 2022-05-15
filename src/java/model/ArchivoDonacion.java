package model;

import java.util.Date;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ArchivoDonacion extends Archivo {

    private int idDonacion;

    public ArchivoDonacion() {
    }

    public ArchivoDonacion(int idDonacion, String nombreArchivo, String extension, double tamanio, Date fechaCreacion, String urlDestino, int usuario) {
        super(nombreArchivo, extension, tamanio, fechaCreacion, urlDestino, usuario);
        this.idDonacion = idDonacion;
    }

    public ArchivoDonacion(int idDonacion, int idArchivo, String nombreArchivo, String extension, double tamanio, Date fechaCreacion, String urlDestino, int usuario) {
        super(idArchivo, nombreArchivo, extension, tamanio, fechaCreacion, urlDestino, usuario);
        this.idDonacion = idDonacion;
    }

    public int getIdDonacion() {
        return idDonacion;
    }

    public void setIdDonacion(int idDonacion) {
        this.idDonacion = idDonacion;
    }

}
