
package model;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class GaleriaRecurso extends Galeria{

    public GaleriaRecurso() {
    }

    public GaleriaRecurso(int usuario, String nombreImagen, double tamanio, String extension, String urlDestino) {
        super(usuario, nombreImagen, tamanio, extension, urlDestino);
    }

    public GaleriaRecurso(int idGaleria, int usuario, String nombreImagen, double tamanio, String extension, String urlDestino) {
        super(idGaleria, usuario, nombreImagen, tamanio, extension, urlDestino);
    }

    
}
