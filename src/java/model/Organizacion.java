package model;

import java.util.List;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Organizacion extends UsuarioGeneral {

    private int idOrganizacion;
    private int idUsuario;
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

    public Organizacion(int usuario, boolean reciboDeducible, String razonSocial, String rfc, int numeroTelFijo, int numeroTelMovil, String email, String tipoOrganizacion) {
        this.idUsuario = usuario;
        this.reciboDeducible = reciboDeducible;
        this.razonSocial = razonSocial;
        this.rfc = rfc;
        this.numeroTelFijo = numeroTelFijo;
        this.numeroTelMovil = numeroTelMovil;
        this.email = email;
        this.tipoOrganizacion = tipoOrganizacion;
    }

    public Organizacion(int idOrganizacion, int usuario, boolean reciboDeducible, String razonSocial, String rfc, int numeroTelFijo, int numeroTelMovil, String email, String sitioWeb, String tipoOrganizacion, String autorizada, Direccion direccion, List<Donacion> lstDonaciones, List<Solicitud> lstSolicitudes, List<Notificacion> lstNotificaciones, boolean estadoLogico, String fechaCreacion, String fotoUsuario) {
        super(direccion, lstDonaciones, lstSolicitudes, lstNotificaciones, estadoLogico, fechaCreacion, fotoUsuario);
        this.idOrganizacion = idOrganizacion;
        this.idUsuario = usuario;
        this.reciboDeducible = reciboDeducible;
        this.razonSocial = razonSocial;
        this.rfc = rfc;
        this.numeroTelFijo = numeroTelFijo;
        this.numeroTelMovil = numeroTelMovil;
        this.email = email;
        this.sitioWeb = sitioWeb;
        this.tipoOrganizacion = tipoOrganizacion;
        this.autorizada = autorizada;
    }

    public String getAutorizada() {
        return autorizada;
    }

    public void setAutorizada(String autorizada) {
        this.autorizada = autorizada;
    }

    public String getTipoOrganizacion() {
        return tipoOrganizacion;
    }

    public void setTipoOrganizacion(String tipoOrganizacion) {
        this.tipoOrganizacion = tipoOrganizacion;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumeroTelMovil() {
        return numeroTelMovil;
    }

    public void setNumeroTelMovil(int numeroTelMovil) {
        this.numeroTelMovil = numeroTelMovil;
    }

    public int getNumeroTelFijo() {
        return numeroTelFijo;
    }

    public void setNumeroTelFijo(int numeroTelFijo) {
        this.numeroTelFijo = numeroTelFijo;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public boolean isReciboDeducible() {
        return reciboDeducible;
    }

    public void setReciboDeducible(boolean reciboDeducible) {
        this.reciboDeducible = reciboDeducible;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdOrganizacion() {
        return idOrganizacion;
    }

    public void setIdOrganizacion(int idOrganizacion) {
        this.idOrganizacion = idOrganizacion;
    }

    @Override
    public String toString() {
        return "Organizacion{" + "idOrganizacion=" + idOrganizacion + ", usuario=" + idUsuario + ", reciboDeducible=" + reciboDeducible + ", razonSocial=" + razonSocial + ", rfc=" + rfc + ", numeroTelFijo=" + numeroTelFijo + ", numeroTelMovil=" + numeroTelMovil + ", email=" + email + ", sitioWeb=" + sitioWeb + ", tipoOrganizacion=" + tipoOrganizacion + ", autorizada=" + autorizada + '}';
    }
}
