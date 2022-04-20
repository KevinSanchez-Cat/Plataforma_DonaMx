package model;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Localidad {

    private int idLocalidad;
    private String localidad;
    private int codigoPostal;

    public Localidad() {
    }

    public Localidad(String localidad, int codigoPostal) {
        this.localidad = localidad;
        this.codigoPostal = codigoPostal;
    }

    public Localidad(int idLocalidad, String localidad, int codigoPostal) {
        this.idLocalidad = idLocalidad;
        this.localidad = localidad;
        this.codigoPostal = codigoPostal;
    }

    /**
     * Get the value of codigoPostal
     *
     * @return the value of codigoPostal
     */
    public int getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Set the value of codigoPostal
     *
     * @param codigoPostal new value of codigoPostal
     */
    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * Get the value of localidad
     *
     * @return the value of localidad
     */
    public String getLocalidad() {
        return localidad;
    }

    /**
     * Set the value of localidad
     *
     * @param localidad new value of localidad
     */
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    /**
     * Get the value of idLocalidad
     *
     * @return the value of idLocalidad
     */
    public int getIdLocalidad() {
        return idLocalidad;
    }

    /**
     * Set the value of idLocalidad
     *
     * @param idLocalidad new value of idLocalidad
     */
    public void setIdLocalidad(int idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    @Override
    public String toString() {
        return "Localidad{" + "idLocalidad=" + idLocalidad + ", localidad=" + localidad + ", codigoPostal=" + codigoPostal + '}';
    }

}
