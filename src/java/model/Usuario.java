package model;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Usuario {

    private int idUsuario;
    private String nombreUsuario;
    private String contraseniia;
    private Timestamp ultimaConexion;//DATE TIME
    private String estadoCuenta;
    private boolean conectado;
    private String correoElectronico;
    private boolean correoConfirmado;
    private int numeroCelular;
    private boolean autenticacionDosPasos;
    private int conteoAccesosFallidos;
    private boolean estadoLogico;
    private Timestamp fechaCreacion;
    private int idRol;
    private String foto;
    private boolean numeroCelularConfirmado;
    private String token;

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String contraseniia, String estadoCuenta, String correoElectronico, int numeroCelular, boolean estadoLogico, Timestamp fechaCreacion, int idRol) {
        this.nombreUsuario = nombreUsuario;
        this.contraseniia = contraseniia;
        this.estadoCuenta = estadoCuenta;
        this.correoElectronico = correoElectronico;
        this.numeroCelular = numeroCelular;
        this.conteoAccesosFallidos = 0;
        this.estadoLogico = estadoLogico;
        this.fechaCreacion = fechaCreacion;
        this.idRol = idRol;
    }

    public Usuario(int idUsuario, String nombreUsuario, String contraseniia, Timestamp ultimaConexion, String estadoCuenta, boolean conectado, String correoElectronico, boolean correoConfirmado, int numeroCelular, boolean autenticacionDosPasos, int conteoAccesosFallidos, boolean estadoLogico, Timestamp fechaCreacion, int idRol, String foto, boolean numeroCelularConfirmado) {
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
        this.estadoLogico = estadoLogico;
        this.fechaCreacion = fechaCreacion;
        this.idRol = idRol;
        this.foto = foto;
        this.numeroCelularConfirmado = numeroCelularConfirmado;
    }

    public Usuario(int idUsuario, String nombreUsuario, String contraseniia, Timestamp ultimaConexion, String estadoCuenta, boolean conectado, String correoElectronico, boolean correoConfirmado, int numeroCelular, boolean autenticacionDosPasos, int conteoAccesosFallidos, boolean estadoLogico, Timestamp fechaCreacion, int idRol, String foto, boolean numeroCelularConfirmado, String token) {
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
        this.estadoLogico = estadoLogico;
        this.fechaCreacion = fechaCreacion;
        this.idRol = idRol;
        this.foto = foto;
        this.numeroCelularConfirmado = numeroCelularConfirmado;
        this.token = token;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public boolean isNumeroCelularConfirmado() {
        return numeroCelularConfirmado;
    }

    public void setNumeroCelularConfirmado(boolean numeroCelularConfirmado) {
        this.numeroCelularConfirmado = numeroCelularConfirmado;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public boolean isEstadoLogico() {
        return estadoLogico;
    }

    public void setEstadoLogico(boolean estadoLogico) {
        this.estadoLogico = estadoLogico;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getRol() {
        return idRol;
    }

    public void setRol(int idRol) {
        this.idRol = idRol;
    }

    public int getConteoAccesosFallidos() {
        return conteoAccesosFallidos;
    }

    public void setConteoAccesosFallidos(int conteoAccesosFallidos) {
        this.conteoAccesosFallidos = conteoAccesosFallidos;
    }

    public boolean isAutenticacionDosPasos() {
        return autenticacionDosPasos;
    }

    public void setAutenticacionDosPasos(boolean autenticacionDosPasos) {
        this.autenticacionDosPasos = autenticacionDosPasos;
    }

    public int getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(int numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public boolean isCorreoConfirmado() {
        return correoConfirmado;
    }

    public void setCorreoConfirmado(boolean correoConfirmado) {
        this.correoConfirmado = correoConfirmado;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public boolean isConectado() {
        return conectado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }

    public String getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(String estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    public Timestamp getUltimaConexion() {
        return ultimaConexion;
    }

    public void setUltimaConexion(Timestamp ultimaConexion) {
        this.ultimaConexion = ultimaConexion;
    }

    public String getContraseniia() {
        return contraseniia;
    }

    public void setContraseniia(String contraseniia) {
        this.contraseniia = contraseniia;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", contraseniia=" + contraseniia + ", ultimaConexion=" + ultimaConexion + ", estadoCuenta=" + estadoCuenta + ", conectado=" + conectado + ", correoElectronico=" + correoElectronico + ", correoConfirmado=" + correoConfirmado + ", numeroCelular=" + numeroCelular + ", autenticacionDosPasos=" + autenticacionDosPasos + ", conteoAccesosFallidos=" + conteoAccesosFallidos + ", estadoLogico=" + estadoLogico + ", fechaCreacion=" + fechaCreacion + ", idRol=" + idRol + ", foto=" + foto + ", numeroCelularConfirmado=" + numeroCelularConfirmado + '}';
    }
}
