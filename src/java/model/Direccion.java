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
public class Direccion {

    private int idDireccion;
    private Estado estado;
    private Municipio municipio;
    private Localidad Localidad;
    private String referencias;
    private String calleInteriorYNumero;
    private String calleExteriorYNumero;
    private String calleFrontal;
    private String calleTrasera;
    private String calleIzquierda;
    private String calleDerecha;
    private String tipoAsentamiento;
    private String nombreAsentamiento;

    public Direccion() {
    }

    public Direccion(Estado estado, Municipio municipio, Localidad Localidad, String referencias, String calleInteriorYNumero, String calleExteriorYNumero, String nombreAsentamiento) {
        this.estado = estado;
        this.municipio = municipio;
        this.Localidad = Localidad;
        this.referencias = referencias;
        this.calleInteriorYNumero = calleInteriorYNumero;
        this.calleExteriorYNumero = calleExteriorYNumero;
        this.nombreAsentamiento = nombreAsentamiento;
    }


    /**
     * Get the value of nombreAsentamiento
     *
     * @return the value of nombreAsentamiento
     */
    public String getNombreAsentamiento() {
        return nombreAsentamiento;
    }

    /**
     * Set the value of nombreAsentamiento
     *
     * @param nombreAsentamiento new value of nombreAsentamiento
     */
    public void setNombreAsentamiento(String nombreAsentamiento) {
        this.nombreAsentamiento = nombreAsentamiento;
    }

    /**
     * Get the value of tipoAsentamiento
     *
     * @return the value of tipoAsentamiento
     */
    public String getTipoAsentamiento() {
        return tipoAsentamiento;
    }

    /**
     * Set the value of tipoAsentamiento
     *
     * @param tipoAsentamiento new value of tipoAsentamiento
     */
    public void setTipoAsentamiento(String tipoAsentamiento) {
        this.tipoAsentamiento = tipoAsentamiento;
    }

    /**
     * Get the value of calleDerecha
     *
     * @return the value of calleDerecha
     */
    public String getCalleDerecha() {
        return calleDerecha;
    }

    /**
     * Set the value of calleDerecha
     *
     * @param calleDerecha new value of calleDerecha
     */
    public void setCalleDerecha(String calleDerecha) {
        this.calleDerecha = calleDerecha;
    }

    /**
     * Get the value of calleIzquierda
     *
     * @return the value of calleIzquierda
     */
    public String getCalleIzquierda() {
        return calleIzquierda;
    }

    /**
     * Set the value of calleIzquierda
     *
     * @param calleIzquierda new value of calleIzquierda
     */
    public void setCalleIzquierda(String calleIzquierda) {
        this.calleIzquierda = calleIzquierda;
    }

    /**
     * Get the value of calleTrasera
     *
     * @return the value of calleTrasera
     */
    public String getCalleTrasera() {
        return calleTrasera;
    }

    /**
     * Set the value of calleTrasera
     *
     * @param calleTrasera new value of calleTrasera
     */
    public void setCalleTrasera(String calleTrasera) {
        this.calleTrasera = calleTrasera;
    }

    /**
     * Get the value of calleFrontal
     *
     * @return the value of calleFrontal
     */
    public String getCalleFrontal() {
        return calleFrontal;
    }

    /**
     * Set the value of calleFrontal
     *
     * @param calleFrontal new value of calleFrontal
     */
    public void setCalleFrontal(String calleFrontal) {
        this.calleFrontal = calleFrontal;
    }

    /**
     * Get the value of calleExteriorYNumero
     *
     * @return the value of calleExteriorYNumero
     */
    public String getCalleExteriorYNumero() {
        return calleExteriorYNumero;
    }

    /**
     * Set the value of calleExteriorYNumero
     *
     * @param calleExteriorYNumero new value of calleExteriorYNumero
     */
    public void setCalleExteriorYNumero(String calleExteriorYNumero) {
        this.calleExteriorYNumero = calleExteriorYNumero;
    }

    /**
     * Get the value of calleInteriorYNumero
     *
     * @return the value of calleInteriorYNumero
     */
    public String getCalleInteriorYNumero() {
        return calleInteriorYNumero;
    }

    /**
     * Set the value of calleInteriorYNumero
     *
     * @param calleInteriorYNumero new value of calleInteriorYNumero
     */
    public void setCalleInteriorYNumero(String calleInteriorYNumero) {
        this.calleInteriorYNumero = calleInteriorYNumero;
    }

    /**
     * Get the value of referencias
     *
     * @return the value of referencias
     */
    public String getReferencias() {
        return referencias;
    }

    /**
     * Set the value of referencias
     *
     * @param referencias new value of referencias
     */
    public void setReferencias(String referencias) {
        this.referencias = referencias;
    }

    /**
     * Get the value of Localidad
     *
     * @return the value of Localidad
     */
    public Localidad getLocalidad() {
        return Localidad;
    }

    /**
     * Set the value of Localidad
     *
     * @param Localidad new value of Localidad
     */
    public void setLocalidad(Localidad Localidad) {
        this.Localidad = Localidad;
    }

    /**
     * Get the value of municipio
     *
     * @return the value of municipio
     */
    public Municipio getMunicipio() {
        return municipio;
    }

    /**
     * Set the value of municipio
     *
     * @param municipio new value of municipio
     */
    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    /**
     * Get the value of estado
     *
     * @return the value of estado
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * Set the value of estado
     *
     * @param estado new value of estado
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * Get the value of idDireccion
     *
     * @return the value of idDireccion
     */
    public int getIdDireccion() {
        return idDireccion;
    }

    /**
     * Set the value of idDireccion
     *
     * @param idDireccion new value of idDireccion
     */
    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    @Override
    public String toString() {
        return "Direccion{" + "idDireccion=" + idDireccion + ", estado=" + estado + ", municipio=" + municipio + ", Localidad=" + Localidad + ", referencias=" + referencias + ", calleInteriorYNumero=" + calleInteriorYNumero + ", calleExteriorYNumero=" + calleExteriorYNumero + ", calleFrontal=" + calleFrontal + ", calleTrasera=" + calleTrasera + ", calleIzquierda=" + calleIzquierda + ", calleDerecha=" + calleDerecha + ", tipoAsentamiento=" + tipoAsentamiento + ", nombreAsentamiento=" + nombreAsentamiento + '}';
    }

}
