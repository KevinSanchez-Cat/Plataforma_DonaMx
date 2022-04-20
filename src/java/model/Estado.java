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
public class Estado {

    private int idEstado;
    private String estado;
    private List<Municipio> lstMunicipios;

    public Estado() {
        lstMunicipios=new ArrayList<>();
    }

    public Estado( String estado) {
        this.estado = estado;
        lstMunicipios=new ArrayList<>();
    }

    /**
     * Get the value of lstMunicipios
     *
     * @return the value of lstMunicipios
     */
    public List<Municipio> getLstMunicipios() {
        return lstMunicipios;
    }

    /**
     * Set the value of lstMunicipios
     *
     * @param lstMunicipios new value of lstMunicipios
     */
    public void setLstMunicipios(List<Municipio> lstMunicipios) {
        this.lstMunicipios = lstMunicipios;
    }

    /**
     * Get the value of estado
     *
     * @return the value of estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Set the value of estado
     *
     * @param estado new value of estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
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

    @Override
    public String toString() {
        return "Estado{" + "idEstado=" + idEstado + ", estado=" + estado + ", lstMunicipios=" + lstMunicipios + '}';
    }

}
