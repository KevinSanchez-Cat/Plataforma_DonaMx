package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class UsuarioGeneral {

    private Direccion direccion;
    private List<Donacion> lstDonaciones;
    private List<Solicitud> lstSolicitudes;
    private List<Notificacion> lstNotificaciones;
    private boolean estadoLogico;
    private String fechaCreacion;
    private String fotoUsuario;

    public UsuarioGeneral() {
        this.lstDonaciones = new ArrayList<>();
        this.lstSolicitudes = new ArrayList<>();
        this.lstNotificaciones = new ArrayList<>();
        this.estadoLogico = true;
        this.direccion = new Direccion();
    }

    public UsuarioGeneral(Direccion direccion, List<Donacion> lstDonaciones, List<Solicitud> lstSolicitudes, List<Notificacion> lstNotificaciones, boolean estadoLogico, String fechaCreacion, String fotoUsuario) {
        this.direccion = direccion;
        this.lstDonaciones = lstDonaciones;
        this.lstSolicitudes = lstSolicitudes;
        this.lstNotificaciones = lstNotificaciones;
        this.estadoLogico = estadoLogico;
        this.fechaCreacion = fechaCreacion;
        this.fotoUsuario = fotoUsuario;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public List<Donacion> getLstDonaciones() {
        return lstDonaciones;
    }

    public void setLstDonaciones(List<Donacion> lstDonaciones) {
        this.lstDonaciones = lstDonaciones;
    }

    public List<Solicitud> getLstSolicitudes() {
        return lstSolicitudes;
    }

    public void setLstSolicitudes(List<Solicitud> lstSolicitudes) {
        this.lstSolicitudes = lstSolicitudes;
    }

    public List<Notificacion> getLstNotificaciones() {
        return lstNotificaciones;
    }

    public void setLstNotificaciones(List<Notificacion> lstNotificaciones) {
        this.lstNotificaciones = lstNotificaciones;
    }

    public boolean isEstadoLogico() {
        return estadoLogico;
    }

    public void setEstadoLogico(boolean estadoLogico) {
        this.estadoLogico = estadoLogico;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFotoUsuario() {
        return fotoUsuario;
    }

    public void setFotoUsuario(String fotoUsuario) {
        this.fotoUsuario = fotoUsuario;
    }
}
