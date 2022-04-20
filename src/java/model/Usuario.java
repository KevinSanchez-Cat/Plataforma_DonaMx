/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author por_s
 */

public class Usuario {

    private int idUsuario;
    private String nombreUsuario;
    private String contraseniia;
    private Date ultimaConexion;//DATE TIME
    private String estadoCuenta;
    private boolean conectado;
    private String correoElectronico;
    private boolean correoConfirmado;
    private int numeroCelular;
    private boolean autenticacionDosPasos;
    private int conteoAccesosFallidos;
    private boolean estadoLogico;
    private Date fechaCreacion;
    private Rol rol;
    private String foto;
    private boolean numeroCelularConfirmado;

    public Usuario() {
    }

    //para crear en la bd
    public Usuario(String nombreUsuario, String contraseniia, String estadoCuenta, String correoElectronico, int numeroCelular, boolean estadoLogico, Date fechaCreacion, Rol rol) {
        this.nombreUsuario = nombreUsuario;
        this.contraseniia = contraseniia;
        this.estadoCuenta = estadoCuenta;
        this.correoElectronico = correoElectronico;
        this.numeroCelular = numeroCelular;
        this.conteoAccesosFallidos = 0;
        this.estadoLogico = estadoLogico;
        this.fechaCreacion = fechaCreacion;
        this.rol = rol;
    }

    /**
     * Get the value of numeroCelularConfirmado
     *
     * @return the value of numeroCelularConfirmado
     */
    public boolean isNumeroCelularConfirmado() {
        return numeroCelularConfirmado;
    }

    /**
     * Set the value of numeroCelularConfirmado
     *
     * @param numeroCelularConfirmado new value of numeroCelularConfirmado
     */
    public void setNumeroCelularConfirmado(boolean numeroCelularConfirmado) {
        this.numeroCelularConfirmado = numeroCelularConfirmado;
    }

    /**
     * Get the value of foto
     *
     * @return the value of foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * Set the value of foto
     *
     * @param foto new value of foto
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * Get the value of estadoLogico
     *
     * @return the value of estadoLogico
     */
    public boolean isEstadoLogico() {
        return estadoLogico;
    }

    /**
     * Set the value of estadoLogico
     *
     * @param estadoLogico new value of estadoLogico
     */
    public void setEstadoLogico(boolean estadoLogico) {
        this.estadoLogico = estadoLogico;
    }

    /**
     * Get the value of fechaCreacion
     *
     * @return the value of fechaCreacion
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Set the value of fechaCreacion
     *
     * @param fechaCreacion new value of fechaCreacion
     */
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * Get the value of rol
     *
     * @return the value of rol
     */
    public Rol getRol() {
        return rol;
    }

    /**
     * Set the value of rol
     *
     * @param rol new value of rol
     */
    public void setRol(Rol rol) {
        this.rol = rol;
    }

    /**
     * Get the value of conteoAccesosFallidos
     *
     * @return the value of conteoAccesosFallidos
     */
    public int getConteoAccesosFallidos() {
        return conteoAccesosFallidos;
    }

    /**
     * Set the value of conteoAccesosFallidos
     *
     * @param conteoAccesosFallidos new value of conteoAccesosFallidos
     */
    public void setConteoAccesosFallidos(int conteoAccesosFallidos) {
        this.conteoAccesosFallidos = conteoAccesosFallidos;
    }

    /**
     * Get the value of autenticacionDosPasos
     *
     * @return the value of autenticacionDosPasos
     */
    public boolean isAutenticacionDosPasos() {
        return autenticacionDosPasos;
    }

    /**
     * Set the value of autenticacionDosPasos
     *
     * @param autenticacionDosPasos new value of autenticacionDosPasos
     */
    public void setAutenticacionDosPasos(boolean autenticacionDosPasos) {
        this.autenticacionDosPasos = autenticacionDosPasos;
    }

    /**
     * Get the value of numeroCelular
     *
     * @return the value of numeroCelular
     */
    public int getNumeroCelular() {
        return numeroCelular;
    }

    /**
     * Set the value of numeroCelular
     *
     * @param numeroCelular new value of numeroCelular
     */
    public void setNumeroCelular(int numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    /**
     * Get the value of correoConfirmado
     *
     * @return the value of correoConfirmado
     */
    public boolean isCorreoConfirmado() {
        return correoConfirmado;
    }

    /**
     * Set the value of correoConfirmado
     *
     * @param correoConfirmado new value of correoConfirmado
     */
    public void setCorreoConfirmado(boolean correoConfirmado) {
        this.correoConfirmado = correoConfirmado;
    }

    /**
     * Get the value of correoElectronico
     *
     * @return the value of correoElectronico
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * Set the value of correoElectronico
     *
     * @param correoElectronico new value of correoElectronico
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * Get the value of conectado
     *
     * @return the value of conectado
     */
    public boolean isConectado() {
        return conectado;
    }

    /**
     * Set the value of conectado
     *
     * @param conectado new value of conectado
     */
    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }

    /**
     * Get the value of estadoCuenta
     *
     * @return the value of estadoCuenta
     */
    public String getEstadoCuenta() {
        return estadoCuenta;
    }

    /**
     * Set the value of estadoCuenta
     *
     * @param estadoCuenta new value of estadoCuenta
     */
    public void setEstadoCuenta(String estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    /**
     * Get the value of ultimaConexion
     *
     * @return the value of ultimaConexion
     */
    public Date getUltimaConexion() {
        return ultimaConexion;
    }

    /**
     * Set the value of ultimaConexion
     *
     * @param ultimaConexion new value of ultimaConexion
     */
    public void setUltimaConexion(Date ultimaConexion) {
        this.ultimaConexion = ultimaConexion;
    }

    /**
     * Get the value of contraseniia
     *
     * @return the value of contraseniia
     */
    public String getContraseniia() {
        return contraseniia;
    }

    /**
     * Set the value of contraseniia
     *
     * @param contraseniia new value of contraseniia
     */
    public void setContraseniia(String contraseniia) {
        this.contraseniia = contraseniia;
    }

    /**
     * Get the value of nombreUsuario
     *
     * @return the value of nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Set the value of nombreUsuario
     *
     * @param nombreUsuario new value of nombreUsuario
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Get the value of idUsuario
     *
     * @return the value of idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Set the value of idUsuario
     *
     * @param idUsuario new value of idUsuario
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

}
