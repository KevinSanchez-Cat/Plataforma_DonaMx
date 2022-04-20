package model;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Organizacion extends UsuarioGeneral {

    private int idOrganizacion;
    private Usuario usuario;
    private boolean reciboDeducible;
    private String razonSocial;
    private String rfc;
    private int numeroTelFijo;
    private int numeroTelMovil;
    private String email;
    private String sitioWeb;
    private String tipoOrganizacion;
    private String autorizada;

    public Organizacion() {
        super();
    }

    public Organizacion(Usuario usuario, boolean reciboDeducible, String razonSocial, String rfc, int numeroTelFijo, int numeroTelMovil, String email, String tipoOrganizacion) {
        this.usuario = usuario;
        this.reciboDeducible = reciboDeducible;
        this.razonSocial = razonSocial;
        this.rfc = rfc;
        this.numeroTelFijo = numeroTelFijo;
        this.numeroTelMovil = numeroTelMovil;
        this.email = email;
        this.tipoOrganizacion = tipoOrganizacion;
    }

    /**
     * Get the value of autorizada
     *
     * @return the value of autorizada
     */
    public String getAutorizada() {
        return autorizada;
    }

    /**
     * Set the value of autorizada
     *
     * @param autorizada new value of autorizada
     */
    public void setAutorizada(String autorizada) {
        this.autorizada = autorizada;
    }

    /**
     * Get the value of tipoOrganizacion
     *
     * @return the value of tipoOrganizacion
     */
    public String getTipoOrganizacion() {
        return tipoOrganizacion;
    }

    /**
     * Set the value of tipoOrganizacion
     *
     * @param tipoOrganizacion new value of tipoOrganizacion
     */
    public void setTipoOrganizacion(String tipoOrganizacion) {
        this.tipoOrganizacion = tipoOrganizacion;
    }

    /**
     * Get the value of sitioWeb
     *
     * @return the value of sitioWeb
     */
    public String getSitioWeb() {
        return sitioWeb;
    }

    /**
     * Set the value of sitioWeb
     *
     * @param sitioWeb new value of sitioWeb
     */
    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email) {
        this.email = email;
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
     * Get the value of rfc
     *
     * @return the value of rfc
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Set the value of rfc
     *
     * @param rfc new value of rfc
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * Get the value of razonSocial
     *
     * @return the value of razonSocial
     */
    public String getRazonSocial() {
        return razonSocial;
    }

    /**
     * Set the value of razonSocial
     *
     * @param razonSocial new value of razonSocial
     */
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    /**
     * Get the value of reciboDeducible
     *
     * @return the value of reciboDeducible
     */
    public boolean isReciboDeducible() {
        return reciboDeducible;
    }

    /**
     * Set the value of reciboDeducible
     *
     * @param reciboDeducible new value of reciboDeducible
     */
    public void setReciboDeducible(boolean reciboDeducible) {
        this.reciboDeducible = reciboDeducible;
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
     * Get the value of idOrganizacion
     *
     * @return the value of idOrganizacion
     */
    public int getIdOrganizacion() {
        return idOrganizacion;
    }

    /**
     * Set the value of idOrganizacion
     *
     * @param idOrganizacion new value of idOrganizacion
     */
    public void setIdOrganizacion(int idOrganizacion) {
        this.idOrganizacion = idOrganizacion;
    }

    @Override
    public String toString() {
        return "Organizacion{" + "idOrganizacion=" + idOrganizacion + ", usuario=" + usuario + ", reciboDeducible=" + reciboDeducible + ", razonSocial=" + razonSocial + ", rfc=" + rfc + ", numeroTelFijo=" + numeroTelFijo + ", numeroTelMovil=" + numeroTelMovil + ", email=" + email + ", sitioWeb=" + sitioWeb + ", tipoOrganizacion=" + tipoOrganizacion + ", autorizada=" + autorizada + '}';
    }

}
