package model;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Localidad {

    private int idLocalidad;
    private String localidad;
    private int codigoPostal;
    private int idMunicipio;
    
    public Localidad() {
    }

    public Localidad(String localidad, int codigoPostal, int idMunicipio) {
        this.localidad = localidad;
        this.codigoPostal = codigoPostal;
        this.idMunicipio = idMunicipio;
    }

    public Localidad(int idLocalidad, String localidad, int codigoPostal, int idMunicipio) {
        this.idLocalidad = idLocalidad;
        this.localidad = localidad;
        this.codigoPostal = codigoPostal;
        this.idMunicipio = idMunicipio;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(int idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    @Override
    public String toString() {
        return "Localidad{" + "idLocalidad=" + idLocalidad + ", localidad=" + localidad + ", codigoPostal=" + codigoPostal + '}';
    }

}
