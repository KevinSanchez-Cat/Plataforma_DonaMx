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
    private int idEstado;

    public Municipio() {
    }

    public Municipio(String municipio, int idEstado) {
        this.municipio = municipio;
        this.idEstado = idEstado;
    }

    public Municipio(int idMunicipio, String municipio, int idEstado) {
        this.idMunicipio = idMunicipio;
        this.municipio = municipio;
        this.idEstado = idEstado;
    }

    /**
     * Get the value of idEstado
     *
     * @return the value of idEstado
     */
    public int getIdEstado() {
        return idEstado;
    }

    /**
     * Set the value of idEstado
     *
     * @param idEstado new value of idEstado
     */
    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
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
        return "Municipio{" + "idMunicipio=" + idMunicipio + ", municipio=" + municipio + ", idEstado=" + idEstado + '}';
    }

}
