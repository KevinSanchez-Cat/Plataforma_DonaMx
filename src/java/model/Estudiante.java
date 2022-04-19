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
public class Estudiante extends UsuarioGeneral {

    private int idEstudiante;
    private Usuario usuario;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String fechaNacimiento;//DATE
    private String genero;
    private String presentacion;
    private int numeroTelMovil;
    private int numeroTelFijo;
    private String lugarNacimiento; //LOCALIDAD
    private String nacionalidad;//PAIS
    private String nivelEducativo;
    private String ocupacion;
    private String tipoEscuela; //OTRA TABLA DE LAS ESCUELAS Y TIPOS DE ESCUELAS
    private String gradoEscolar;
    private double promedioAnterior;
    private String estatusEscolar;
    private String intereses;
    private String habilidades;

    public Estudiante() {
        super();
    }

    public Estudiante(int idEstudiante, Usuario usuario, String nombres, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento, String genero, String presentacion, int numeroTelMovil, int numeroTelFijo, String lugarNacimiento, String nacionalidad, String nivelEducativo, String ocupacion, String tipoEscuela, String gradoEscolar, double promedioAnterior, String estatusEscolar, String intereses, String habilidades) {
        super();
        this.idEstudiante = idEstudiante;
        this.usuario = usuario;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.presentacion = presentacion;
        this.numeroTelMovil = numeroTelMovil;
        this.numeroTelFijo = numeroTelFijo;
        this.lugarNacimiento = lugarNacimiento;
        this.nacionalidad = nacionalidad;
        this.nivelEducativo = nivelEducativo;
        this.ocupacion = ocupacion;
        this.tipoEscuela = tipoEscuela;
        this.gradoEscolar = gradoEscolar;
        this.promedioAnterior = promedioAnterior;
        this.estatusEscolar = estatusEscolar;
        this.intereses = intereses;
        this.habilidades = habilidades;
    }

    /**
     * Get the value of habilidades
     *
     * @return the value of habilidades
     */
    public String getHabilidades() {
        return habilidades;
    }

    /**
     * Set the value of habilidades
     *
     * @param habilidades new value of habilidades
     */
    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    /**
     * Get the value of intereses
     *
     * @return the value of intereses
     */
    public String getIntereses() {
        return intereses;
    }

    /**
     * Set the value of intereses
     *
     * @param intereses new value of intereses
     */
    public void setIntereses(String intereses) {
        this.intereses = intereses;
    }

    /**
     * Get the value of estatusEscolar
     *
     * @return the value of estatusEscolar
     */
    public String getEstatusEscolar() {
        return estatusEscolar;
    }

    /**
     * Set the value of estatusEscolar
     *
     * @param estatusEscolar new value of estatusEscolar
     */
    public void setEstatusEscolar(String estatusEscolar) {
        this.estatusEscolar = estatusEscolar;
    }

    /**
     * Get the value of promedioAnterior
     *
     * @return the value of promedioAnterior
     */
    public double getPromedioAnterior() {
        return promedioAnterior;
    }

    /**
     * Set the value of promedioAnterior
     *
     * @param promedioAnterior new value of promedioAnterior
     */
    public void setPromedioAnterior(double promedioAnterior) {
        this.promedioAnterior = promedioAnterior;
    }

    /**
     * Get the value of gradoEscolar
     *
     * @return the value of gradoEscolar
     */
    public String getGradoEscolar() {
        return gradoEscolar;
    }

    /**
     * Set the value of gradoEscolar
     *
     * @param gradoEscolar new value of gradoEscolar
     */
    public void setGradoEscolar(String gradoEscolar) {
        this.gradoEscolar = gradoEscolar;
    }

    /**
     * Get the value of tipoEscuela
     *
     * @return the value of tipoEscuela
     */
    public String getTipoEscuela() {
        return tipoEscuela;
    }

    /**
     * Set the value of tipoEscuela
     *
     * @param tipoEscuela new value of tipoEscuela
     */
    public void setTipoEscuela(String tipoEscuela) {
        this.tipoEscuela = tipoEscuela;
    }

    /**
     * Get the value of ocupacion
     *
     * @return the value of ocupacion
     */
    public String getOcupacion() {
        return ocupacion;
    }

    /**
     * Set the value of ocupacion
     *
     * @param ocupacion new value of ocupacion
     */
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    /**
     * Get the value of nivelEducativo
     *
     * @return the value of nivelEducativo
     */
    public String getNivelEducativo() {
        return nivelEducativo;
    }

    /**
     * Set the value of nivelEducativo
     *
     * @param nivelEducativo new value of nivelEducativo
     */
    public void setNivelEducativo(String nivelEducativo) {
        this.nivelEducativo = nivelEducativo;
    }

    /**
     * Get the value of nacionalidad
     *
     * @return the value of nacionalidad
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * Set the value of nacionalidad
     *
     * @param nacionalidad new value of nacionalidad
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /**
     * Get the value of lugarNacimiento
     *
     * @return the value of lugarNacimiento
     */
    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    /**
     * Set the value of lugarNacimiento
     *
     * @param lugarNacimiento new value of lugarNacimiento
     */
    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    /**
     * Get the value of numeroTelFijo
     *
     * @return the value of numeroTelFijo
     */
    public int getNumeroTelFijo() {
        return numeroTelFijo;
    }

    /**
     * Set the value of numeroTelFijo
     *
     * @param numeroTelFijo new value of numeroTelFijo
     */
    public void setNumeroTelFijo(int numeroTelFijo) {
        this.numeroTelFijo = numeroTelFijo;
    }

    /**
     * Get the value of numeroTelMovil
     *
     * @return the value of numeroTelMovil
     */
    public int getNumeroTelMovil() {
        return numeroTelMovil;
    }

    /**
     * Set the value of numeroTelMovil
     *
     * @param numeroTelMovil new value of numeroTelMovil
     */
    public void setNumeroTelMovil(int numeroTelMovil) {
        this.numeroTelMovil = numeroTelMovil;
    }

    /**
     * Get the value of presentacion
     *
     * @return the value of presentacion
     */
    public String getPresentacion() {
        return presentacion;
    }

    /**
     * Set the value of presentacion
     *
     * @param presentacion new value of presentacion
     */
    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    /**
     * Get the value of genero
     *
     * @return the value of genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Set the value of genero
     *
     * @param genero new value of genero
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Get the value of fechaNacimiento
     *
     * @return the value of fechaNacimiento
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Set the value of fechaNacimiento
     *
     * @param fechaNacimiento new value of fechaNacimiento
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Get the value of apellidoMaterno
     *
     * @return the value of apellidoMaterno
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Set the value of apellidoMaterno
     *
     * @param apellidoMaterno new value of apellidoMaterno
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Get the value of apellidoPaterno
     *
     * @return the value of apellidoPaterno
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Set the value of apellidoPaterno
     *
     * @param apellidoPaterno new value of apellidoPaterno
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Get the value of nombres
     *
     * @return the value of nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Set the value of nombres
     *
     * @param nombres new value of nombres
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Get the value of usuario
     *
     * @return the value of usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Set the value of usuario
     *
     * @param usuario new value of usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Get the value of idEstudiante
     *
     * @return the value of idEstudiante
     */
    public int getIdEstudiante() {
        return idEstudiante;
    }

    /**
     * Set the value of idEstudiante
     *
     * @param idEstudiante new value of idEstudiante
     */
    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "idEstudiante=" + idEstudiante + ", usuario=" + usuario + ", nombres=" + nombres + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", fechaNacimiento=" + fechaNacimiento + ", genero=" + genero + ", presentacion=" + presentacion + ", numeroTelMovil=" + numeroTelMovil + ", numeroTelFijo=" + numeroTelFijo + ", lugarNacimiento=" + lugarNacimiento + ", nacionalidad=" + nacionalidad + ", nivelEducativo=" + nivelEducativo + ", ocupacion=" + ocupacion + ", tipoEscuela=" + tipoEscuela + ", gradoEscolar=" + gradoEscolar + ", promedioAnterior=" + promedioAnterior + ", estatusEscolar=" + estatusEscolar + ", intereses=" + intereses + ", habilidades=" + habilidades + '}';
    }

}
