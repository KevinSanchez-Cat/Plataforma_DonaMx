package model;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Direccion {

    private int idDireccion;
    private int idEstado;
    private int idMunicipio;
    private int idLocalidad;
    private String referencias;
    private String calleInteriorYNumero;
    private String calleExteriorYNumero;
    private String calleFrontal;
    private String calleTrasera;
    private String calleIzquierda;
    private String calleDerecha;
    private String tipoAsentamiento;
    private String nombreAsentamiento;
    private String codigoPostal;
    private int idUsuario;

    public Direccion() {
    }

    public Direccion(int estado, int municipio, int Localidad, String referencias, String calleInteriorYNumero, String calleExteriorYNumero, String nombreAsentamiento, int idUsuario) {
        this.idEstado = estado;
        this.idMunicipio = municipio;
        this.idLocalidad = Localidad;
        this.referencias = referencias;
        this.calleInteriorYNumero = calleInteriorYNumero;
        this.calleExteriorYNumero = calleExteriorYNumero;
        this.nombreAsentamiento = nombreAsentamiento;
        this.idUsuario = idUsuario;
    }

    public Direccion(int idDireccion, int idEstado, int idMunicipio, int idLocalidad, String referencias, String calleInteriorYNumero, String calleExteriorYNumero, String calleFrontal, String calleTrasera, String calleIzquierda, String calleDerecha, String tipoAsentamiento, String nombreAsentamiento, int idUsuario) {
        this.idDireccion = idDireccion;
        this.idEstado = idEstado;
        this.idMunicipio = idMunicipio;
        this.idLocalidad = idLocalidad;
        this.referencias = referencias;
        this.calleInteriorYNumero = calleInteriorYNumero;
        this.calleExteriorYNumero = calleExteriorYNumero;
        this.calleFrontal = calleFrontal;
        this.calleTrasera = calleTrasera;
        this.calleIzquierda = calleIzquierda;
        this.calleDerecha = calleDerecha;
        this.tipoAsentamiento = tipoAsentamiento;
        this.nombreAsentamiento = nombreAsentamiento;
        this.idUsuario = idUsuario;
    }

    public Direccion(int idDireccion, int idEstado, int idMunicipio, int idLocalidad, String referencias, String calleInteriorYNumero, String calleExteriorYNumero, String calleFrontal, String calleTrasera, String calleIzquierda, String calleDerecha, String tipoAsentamiento, String nombreAsentamiento, String codigoPostal, int idUsuario) {
        this.idDireccion = idDireccion;
        this.idEstado = idEstado;
        this.idMunicipio = idMunicipio;
        this.idLocalidad = idLocalidad;
        this.referencias = referencias;
        this.calleInteriorYNumero = calleInteriorYNumero;
        this.calleExteriorYNumero = calleExteriorYNumero;
        this.calleFrontal = calleFrontal;
        this.calleTrasera = calleTrasera;
        this.calleIzquierda = calleIzquierda;
        this.calleDerecha = calleDerecha;
        this.tipoAsentamiento = tipoAsentamiento;
        this.nombreAsentamiento = nombreAsentamiento;
        this.codigoPostal = codigoPostal;
        this.idUsuario = idUsuario;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreAsentamiento() {
        return nombreAsentamiento;
    }

    public void setNombreAsentamiento(String nombreAsentamiento) {
        this.nombreAsentamiento = nombreAsentamiento;
    }

    public String getTipoAsentamiento() {
        return tipoAsentamiento;
    }

    public void setTipoAsentamiento(String tipoAsentamiento) {
        this.tipoAsentamiento = tipoAsentamiento;
    }

    public String getCalleDerecha() {
        return calleDerecha;
    }

    public void setCalleDerecha(String calleDerecha) {
        this.calleDerecha = calleDerecha;
    }

    public String getCalleIzquierda() {
        return calleIzquierda;
    }

    public void setCalleIzquierda(String calleIzquierda) {
        this.calleIzquierda = calleIzquierda;
    }

    public String getCalleTrasera() {
        return calleTrasera;
    }

    public void setCalleTrasera(String calleTrasera) {
        this.calleTrasera = calleTrasera;
    }

    public String getCalleFrontal() {
        return calleFrontal;
    }

    public void setCalleFrontal(String calleFrontal) {
        this.calleFrontal = calleFrontal;
    }

    public String getCalleExteriorYNumero() {
        return calleExteriorYNumero;
    }

    public void setCalleExteriorYNumero(String calleExteriorYNumero) {
        this.calleExteriorYNumero = calleExteriorYNumero;
    }

    public String getCalleInteriorYNumero() {
        return calleInteriorYNumero;
    }

    public void setCalleInteriorYNumero(String calleInteriorYNumero) {
        this.calleInteriorYNumero = calleInteriorYNumero;
    }

    public String getReferencias() {
        return referencias;
    }

    public void setReferencias(String referencias) {
        this.referencias = referencias;
    }

    public int getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(int idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    @Override
    public String toString() {
        return "Direccion{" + "idDireccion=" + idDireccion + ", estado=" + idEstado + ", municipio=" + idMunicipio + ", Localidad=" + idLocalidad + ", referencias=" + referencias + ", calleInteriorYNumero=" + calleInteriorYNumero + ", calleExteriorYNumero=" + calleExteriorYNumero + ", calleFrontal=" + calleFrontal + ", calleTrasera=" + calleTrasera + ", calleIzquierda=" + calleIzquierda + ", calleDerecha=" + calleDerecha + ", tipoAsentamiento=" + tipoAsentamiento + ", nombreAsentamiento=" + nombreAsentamiento + '}';
    }

}
