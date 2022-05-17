package model;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ArchivoSolicitud extends Archivo {

    private int idSolicitud;

    public ArchivoSolicitud(int idSolicitud, String nombreArchivo, String extension, double tamanio, Timestamp fechaCreacion, String urlDestino, int usuario) {
        super(nombreArchivo, extension, tamanio, fechaCreacion, urlDestino, usuario);
        this.idSolicitud = idSolicitud;
    }

    public ArchivoSolicitud(int idSolicitud, int idArchivo, String nombreArchivo, String extension, double tamanio, Timestamp fechaCreacion, String urlDestino, int usuario) {
        super(idArchivo, nombreArchivo, extension, tamanio, fechaCreacion, urlDestino, usuario);
        this.idSolicitud = idSolicitud;
    }

    public ArchivoSolicitud() {
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

}
