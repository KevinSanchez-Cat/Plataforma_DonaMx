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
public class Usuario {

    private int idUsuario;
    private String nombreUsuario;
    private String contraseniia;
    private String ultimaConexion;//DATE TIME
    private char estadoCuenta;
    private boolean conectado;
    private String correoElectronico;
    private boolean correoConfirmado;
    private int numeroCelular;
    private boolean autenticacionDosPasos;
    private int conteoAccesosFallidos;

    private Rol rol;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombreUsuario, String contraseniia, String fechaCreacion, String ultimaConexion, char estadoCuenta, boolean estadoLogico, boolean conectado, String correoElectronico, boolean correoConfirmado, int numeroCelular, boolean autenticacionDosPasos, int conteoAccesosFallidos, String fotoUsuario, Rol rol, List<Notificacion> lstNotificaciones, boolean celularConfirmado) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contraseniia = contraseniia;
        this.ultimaConexion = ultimaConexion;
        this.estadoCuenta = estadoCuenta;
        this.conectado = conectado;
        this.correoElectronico = correoElectronico;
        this.correoConfirmado = correoConfirmado;
        this.numeroCelular = numeroCelular;
        this.autenticacionDosPasos = autenticacionDosPasos;
        this.conteoAccesosFallidos = conteoAccesosFallidos;
        this.rol = rol;
        this.celularConfirmado = celularConfirmado;
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

    private boolean celularConfirmado;

    /**
     * Get the value of celularConfirmado
     *
     * @return the value of celularConfirmado
     */
    public boolean isCelularConfirmado() {
        return celularConfirmado;
    }

    /**
     * Set the value of celularConfirmado
     *
     * @param celularConfirmado new value of celularConfirmado
     */
    public void setCelularConfirmado(boolean celularConfirmado) {
        this.celularConfirmado = celularConfirmado;
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
    public char getEstadoCuenta() {
        return estadoCuenta;
    }

    /**
     * Set the value of estadoCuenta
     *
     * @param estadoCuenta new value of estadoCuenta
     */
    public void setEstadoCuenta(char estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    /**
     * Get the value of ultimaConexion
     *
     * @return the value of ultimaConexion
     */
    public String getUltimaConexion() {
        return ultimaConexion;
    }

    /**
     * Set the value of ultimaConexion
     *
     * @param ultimaConexion new value of ultimaConexion
     */
    public void setUltimaConexion(String ultimaConexion) {
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
