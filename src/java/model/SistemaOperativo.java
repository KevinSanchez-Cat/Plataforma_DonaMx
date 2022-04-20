/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author por_s
 */
public class SistemaOperativo {

    private int idSistemaOperativo;
    private String sistemaOperativo;
    private String version;
    private String edicion;

    public SistemaOperativo() {
    }

    public SistemaOperativo(String sistemaOperativo, String version, String edicion) {
        this.sistemaOperativo = sistemaOperativo;
        this.version = version;
        this.edicion = edicion;
    }

    /**
     * Get the value of edicion
     *
     * @return the value of edicion
     */
    public String getEdicion() {
        return edicion;
    }

    /**
     * Set the value of edicion
     *
     * @param edicion new value of edicion
     */
    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    /**
     * Get the value of version
     *
     * @return the value of version
     */
    public String getVersion() {
        return version;
    }

    /**
     * Set the value of version
     *
     * @param version new value of version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * Get the value of sistemaOperativo
     *
     * @return the value of sistemaOperativo
     */
    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    /**
     * Set the value of sistemaOperativo
     *
     * @param sistemaOperativo new value of sistemaOperativo
     */
    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    /**
     * Get the value of idSistemaOperativo
     *
     * @return the value of idSistemaOperativo
     */
    public int getIdSistemaOperativo() {
        return idSistemaOperativo;
    }

    /**
     * Set the value of idSistemaOperativo
     *
     * @param idSistemaOperativo new value of idSistemaOperativo
     */
    public void setIdSistemaOperativo(int idSistemaOperativo) {
        this.idSistemaOperativo = idSistemaOperativo;
    }

    @Override
    public String toString() {
        return "SistemaOperativo{" + "idSistemaOperativo=" + idSistemaOperativo + ", sistemaOperativo=" + sistemaOperativo + ", version=" + version + ", edicion=" + edicion + '}';
    }

}
