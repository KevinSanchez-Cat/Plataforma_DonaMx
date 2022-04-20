/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author por_s
 */
public class Municipio {

    private int idMunicipio;
    private String municipio;
    private List<Localidad> lstLocalidades;

    public Municipio() {
        lstLocalidades=new ArrayList<>();
    }

    public Municipio(String municipio) {
        this.municipio = municipio;
        lstLocalidades=new ArrayList<>();
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
