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
    private String nombre;
    private String apellido;
    private String contraseniia;
    private Timestamp ultimaConexion;//DATE TIME
    private String estadoCuenta;
    private int conectado;
    private String correoElectronico;
    private int correoConfirmado;
    private int numeroCelular;
    private int autenticacionDosPasos;
    private int conteoAccesosFallidos;
    private int estadoLogico;
    private Timestamp fechaCreacion;
    private int idRol;
    private String foto;
    private int numeroCelularConfirmado;
    private String token;

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String contraseniia, String estadoCuenta, String correoElectronico, int numeroCelular, int estadoLogico, Timestamp fechaCreacion, int idRol) {
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

    public Usuario(int idUsuario, String nombreUsuario, String contraseniia, Timestamp ultimaConexion, String estadoCuenta, int conectado, String correoElectronico, int correoConfirmado, int numeroCelular, int autenticacionDosPasos, int conteoAccesosFallidos, int estadoLogico, Timestamp fechaCreacion, int idRol, String foto, int numeroCelularConfirmado) {
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

    public Usuario(int idUsuario, String nombreUsuario, String contraseniia, Timestamp ultimaConexion, String estadoCuenta, int conectado, String correoElectronico, int correoConfirmado, int numeroCelular, int autenticacionDosPasos, int conteoAccesosFallidos, int estadoLogico, Timestamp fechaCreacion, int idRol, String foto, int numeroCelularConfirmado, String token) {
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public int isNumeroCelularConfirmado() {
        return numeroCelularConfirmado;
    }

    public void setNumeroCelularConfirmado(int numeroCelularConfirmado) {
        this.numeroCelularConfirmado = numeroCelularConfirmado;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int isEstadoLogico() {
        return estadoLogico;
    }

    public void setEstadoLogico(int estadoLogico) {
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

    public int isAutenticacionDosPasos() {
        return autenticacionDosPasos;
    }

    public void setAutenticacionDosPasos(int autenticacionDosPasos) {
        this.autenticacionDosPasos = autenticacionDosPasos;
    }

    public int getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(int numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public int isCorreoConfirmado() {
        return correoConfirmado;
    }

    public void setCorreoConfirmado(int correoConfirmado) {
        this.correoConfirmado = correoConfirmado;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public int isConectado() {
        return conectado;
    }

    public void setConectado(int conectado) {
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
