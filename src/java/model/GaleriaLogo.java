
package model;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class GaleriaLogo extends Galeria{

    private int idOrganizacion;

    public GaleriaLogo() {
    }

    public GaleriaLogo(int idOrganizacion, int usuario, String nombreImagen, double tamanio, String extension, String urlDestino) {
        super(usuario, nombreImagen, tamanio, extension, urlDestino);
        this.idOrganizacion = idOrganizacion;
    }

    public GaleriaLogo(int idOrganizacion, int idGaleria, int usuario, String nombreImagen, double tamanio, String extension, String urlDestino) {
        super(idGaleria, usuario, nombreImagen, tamanio, extension, urlDestino);
        this.idOrganizacion = idOrganizacion;
    }

    public int getIdOrganizacion() {
        return idOrganizacion;
    }

    public void setIdOrganizacion(int idOrganizacion) {
        this.idOrganizacion = idOrganizacion;
    }
    
}
