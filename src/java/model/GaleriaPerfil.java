
package model;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class GaleriaPerfil extends Galeria{

    public GaleriaPerfil() {
    }

    public GaleriaPerfil(int usuario, String nombreImagen, double tamanio, String extension, String urlDestino) {
        super(usuario, nombreImagen, tamanio, extension, urlDestino);
    }

    public GaleriaPerfil(int idGaleria, int usuario, String nombreImagen, double tamanio, String extension, String urlDestino) {
        super(idGaleria, usuario, nombreImagen, tamanio, extension, urlDestino);
    }

    
}
