package model;

import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Organizacion extends UsuarioGeneral {

    private int idOrganizacion;
    private int idUsuario;
    private int reciboDeducible;
    private String razonSocial;
    private String rfc;
    private int numeroTelFijo;
    private int numeroTelMovil;
    private String email;
    private String sitioWeb;
    private String tipoOrganizacion;
    private String autorizada;
    private String linkFacebook;
    private String linkInstragram;
    private String linkLinkedin;
    private String linkTwiteer;
    private String nombreContacto;
    private String apellidosContacto;
    private String cargo;
    private String donatariaAutorizada;
    private Timestamp fechaDonatariaAutorizada;
    private String cluni;
    private String noNotariaPublica;
    
    public Organizacion() {
        super();
    }

    public Organizacion(int usuario, int reciboDeducible, String razonSocial, String rfc, int numeroTelFijo, int numeroTelMovil, String email, String tipoOrganizacion) {
        this.idUsuario = usuario;
        this.reciboDeducible = reciboDeducible;
        this.razonSocial = razonSocial;
        this.rfc = rfc;
        this.numeroTelFijo = numeroTelFijo;
        this.numeroTelMovil = numeroTelMovil;
        this.email = email;
        this.tipoOrganizacion = tipoOrganizacion;
    }

    public Organizacion(int idOrganizacion, int usuario, int reciboDeducible, String razonSocial, String rfc, int numeroTelFijo, int numeroTelMovil, String email, String sitioWeb, String tipoOrganizacion, String autorizada, Direccion direccion, List<Donacion> lstDonaciones, List<Solicitud> lstSolicitudes, List<Notificacion> lstNotificaciones, int estadoLogico, String fechaCreacion, String fotoUsuario) {
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

    public int isReciboDeducible() {
        return reciboDeducible;
    }

    public void setReciboDeducible(int reciboDeducible) {
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

    public String getLinkFacebook() {
        return linkFacebook;
    }

    public void setLinkFacebook(String linkFacebook) {
        this.linkFacebook = linkFacebook;
    }

    public String getLinkInstragram() {
        return linkInstragram;
    }

    public void setLinkInstragram(String linkInstragram) {
        this.linkInstragram = linkInstragram;
    }

    public String getLinkLinkedin() {
        return linkLinkedin;
    }

    public void setLinkLinkedin(String linkLinkedin) {
        this.linkLinkedin = linkLinkedin;
    }

    public String getLinkTwiteer() {
        return linkTwiteer;
    }

    public void setLinkTwiteer(String linkTwiteer) {
        this.linkTwiteer = linkTwiteer;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getApellidosContacto() {
        return apellidosContacto;
    }

    public void setApellidosContacto(String apellidosContacto) {
        this.apellidosContacto = apellidosContacto;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDonatariaAutorizada() {
        return donatariaAutorizada;
    }

    public void setDonatariaAutorizada(String donatariaAutorizada) {
        this.donatariaAutorizada = donatariaAutorizada;
    }

    public Timestamp getFechaDonatariaAutorizada() {
        return fechaDonatariaAutorizada;
    }

    public void setFechaDonatariaAutorizada(Timestamp fechaDonatariaAutorizada) {
        this.fechaDonatariaAutorizada = fechaDonatariaAutorizada;
    }

    public String getCluni() {
        return cluni;
    }

    public void setCluni(String cluni) {
        this.cluni = cluni;
    }

    public String getNoNotariaPublica() {
        return noNotariaPublica;
    }

    public void setNoNotariaPublica(String noNotariaPublica) {
        this.noNotariaPublica = noNotariaPublica;
    }

    @Override
    public String toString() {
        return "Organizacion{" + "idOrganizacion=" + idOrganizacion + ", usuario=" + idUsuario + ", reciboDeducible=" + reciboDeducible + ", razonSocial=" + razonSocial + ", rfc=" + rfc + ", numeroTelFijo=" + numeroTelFijo + ", numeroTelMovil=" + numeroTelMovil + ", email=" + email + ", sitioWeb=" + sitioWeb + ", tipoOrganizacion=" + tipoOrganizacion + ", autorizada=" + autorizada + '}';
    }
}
