/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author por_s
 */
public class Donacion {

    private int idDonacion;
    private Usuario donatario;
    private Object donador; //PUEDE SER ORGANIZACION O USUARIO CIVIL EL DONADOR ***usar el instance of   
    private List<Archivo> lstArchivos;
    private RecursoTecnologico recursoTecnologico;
    private String fechaDonacion;//DATE TIME    
    private String estadoDonacion;
    private String noConfirmacion;
    private char remunerado;

    public Donacion() {
    }

    public Donacion(int idDonacion, Usuario donatario, Object donador, List<Archivo> lstArchivos, RecursoTecnologico recursoTecnologico, String fechaDonacion, String estadoDonacion, String noConfirmacion, char remunerado) {
        this.idDonacion = idDonacion;
        this.donatario = donatario;
        this.donador = donador;
        this.lstArchivos = lstArchivos;
        this.recursoTecnologico = recursoTecnologico;
        this.fechaDonacion = fechaDonacion;
        this.estadoDonacion = estadoDonacion;
        this.noConfirmacion = noConfirmacion;
        this.remunerado = remunerado;
    }

    /**
     * Get the value of remunerado
     *
     * @return the value of remunerado
     */
    public char getRemunerado() {
        return remunerado;
    }

    /**
     * Set the value of remunerado
     *
     * @param remunerado new value of remunerado
     */
    public void setRemunerado(char remunerado) {
        this.remunerado = remunerado;
    }

    /**
     * Get the value of noConfirmacion
     *
     * @return the value of noConfirmacion
     */
    public String getNoConfirmacion() {
        return noConfirmacion;
    }

    /**
     * Set the value of noConfirmacion
     *
     * @param noConfirmacion new value of noConfirmacion
     */
    public void setNoConfirmacion(String noConfirmacion) {
        this.noConfirmacion = noConfirmacion;
    }

    /**
     * Get the value of estadoDonacion
     *
     * @return the value of estadoDonacion
     */
    public String getEstadoDonacion() {
        return estadoDonacion;
    }

    /**
     * Set the value of estadoDonacion
     *
     * @param estadoDonacion new value of estadoDonacion
     */
    public void setEstadoDonacion(String estadoDonacion) {
        this.estadoDonacion = estadoDonacion;
    }

    /**
     * Get the value of fechaDonacion
     *
     * @return the value of fechaDonacion
     */
    public String getFechaDonacion() {
        return fechaDonacion;
    }

    /**
     * Set the value of fechaDonacion
     *
     * @param fechaDonacion new value of fechaDonacion
     */
    public void setFechaDonacion(String fechaDonacion) {
        this.fechaDonacion = fechaDonacion;
    }

    /**
     * Get the value of recursoTecnologico
     *
     * @return the value of recursoTecnologico
     */
    public RecursoTecnologico getRecursoTecnologico() {
        return recursoTecnologico;
    }

    /**
     * Set the value of recursoTecnologico
     *
     * @param recursoTecnologico new value of recursoTecnologico
     */
    public void setRecursoTecnologico(RecursoTecnologico recursoTecnologico) {
        this.recursoTecnologico = recursoTecnologico;
    }

    /**
     * Get the value of lstArchivos
     *
     * @return the value of lstArchivos
     */
    public List<Archivo> getLstArchivos() {
        return lstArchivos;
    }

    /**
     * Set the value of lstArchivos
     *
     * @param lstArchivos new value of lstArchivos
     */
    public void setLstArchivos(List<Archivo> lstArchivos) {
        this.lstArchivos = lstArchivos;
    }

    /**
     * Get the value of donador
     *
     * @return the value of donador
     */
    public Object getDonador() {
        return donador;
    }

    /**
     * Set the value of donador
     *
     * @param donador new value of donador
     */
    public void setDonador(Object donador) {
        this.donador = donador;
    }

    /**
     * Get the value of donatario
     *
     * @return the value of donatario
     */
    public Usuario getDonatario() {
        return donatario;
    }

    /**
     * Set the value of donatario
     *
     * @param donatario new value of donatario
     */
    public void setDonatario(Usuario donatario) {
        this.donatario = donatario;
    }

    /**
     * Get the value of idDonacion
     *
     * @return the value of idDonacion
     */
    public int getIdDonacion() {
        return idDonacion;
    }

    /**
     * Set the value of idDonacion
     *
     * @param idDonacion new value of idDonacion
     */
    public void setIdDonacion(int idDonacion) {
        this.idDonacion = idDonacion;
    }

    @Override
    public String toString() {
        return "Donacion{" + "idDonacion=" + idDonacion + ", donatario=" + donatario + ", donador=" + donador + ", lstArchivos=" + lstArchivos + ", recursoTecnologico=" + recursoTecnologico + ", fechaDonacion=" + fechaDonacion + ", estadoDonacion=" + estadoDonacion + ", noConfirmacion=" + noConfirmacion + ", remunerado=" + remunerado + '}';
    }

}
