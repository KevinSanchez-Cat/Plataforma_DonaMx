package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Municipio {

    private int idMunicipio;
    private String municipio;
    private List<Localidad> lstLocalidades;

    public Municipio() {
        lstLocalidades = new ArrayList<>();
    }

    public Municipio(String municipio) {
        this.municipio = municipio;
        lstLocalidades = new ArrayList<>();
    }

    public Municipio(int idMunicipio, String municipio, List<Localidad> lstLocalidades) {
        this.idMunicipio = idMunicipio;
        this.municipio = municipio;
        this.lstLocalidades = lstLocalidades;
    }

    /**
     * Get the value of lstLocalidades
     *
     * @return the value of lstLocalidades
     */
    public List<Localidad> getLstMunicipios() {
        return lstLocalidades;
    }

    /**
     * Set the value of lstLocalidades
     *
     * @param lstLocalidades new value of lstLocalidades
     */
    public void setLstMunicipios(List<Localidad> lstLocalidades) {
        this.lstLocalidades = lstLocalidades;
    }

    /**
     * Get the value of municipio
     *
     * @return the value of municipio
     */
    public String getMunicipio() {
        return municipio;
    }

    /**
     * Set the value of municipio
     *
     * @param municipio new value of municipio
     */
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    /**
     * Get the value of idMunicipio
     *
     * @return the value of idMunicipio
     */
    public int getIdMunicipio() {
        return idMunicipio;
    }

    /**
     * Set the value of idMunicipio
     *
     * @param idMunicipio new value of idMunicipio
     */
    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    @Override
    public String toString() {
        return "Municipio{" + "idMunicipio=" + idMunicipio + ", municipio=" + municipio + ", lstLocalidades=" + lstLocalidades + '}';
    }

}
