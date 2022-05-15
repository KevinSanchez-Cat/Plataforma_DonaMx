
package model;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Documento extends Archivo{

    private String seccion;
    private String motivo;

    public Documento() {
    }

    public Documento(String seccion, String motivo, String nombreArchivo, String extension, double tamanio, Timestamp fechaCreacion, String urlDestino, int usuario) {
        super(nombreArchivo, extension, tamanio, fechaCreacion, urlDestino, usuario);
        this.seccion = seccion;
        this.motivo = motivo;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    
}
