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
     * Get the value of idLocalidad
     *
     * @return the value of idLocalidad
     */
    public int getIdLocalidad() {
        return idLocalidad;
    }

    /**
     * Set the value of idLocalidad
     *
     * @param idLocalidad new value of idLocalidad
     */
    public void setIdLocalidad(int idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    /**
     * Get the value of idMunicipio
     *
     * @return the value of idMunicipio
     */
    public int getIdMunicipio() {
        return idMunicipio;
    }

    /**
     * Set the value of idMunicipio
     *
     * @param idMunicipio new value of idMunicipio
     */
    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
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
        return "Direccion{" + "idDireccion=" + idDireccion + ", estado=" + idEstado + ", municipio=" + idMunicipio + ", Localidad=" + idLocalidad + ", referencias=" + referencias + ", calleInteriorYNumero=" + calleInteriorYNumero + ", calleExteriorYNumero=" + calleExteriorYNumero + ", calleFrontal=" + calleFrontal + ", calleTrasera=" + calleTrasera + ", calleIzquierda=" + calleIzquierda + ", calleDerecha=" + calleDerecha + ", tipoAsentamiento=" + tipoAsentamiento + ", nombreAsentamiento=" + nombreAsentamiento + '}';
    }

}
