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
public class Solicitud {

    private int idSolicitud;
    private Usuario usuario;
    private RecursoTecnologico recursoTecnologico;
    private List<Archivo> lstArchivos;
    private String estadoSolicitud;
    private String fechaSolicitud;//DATE TIME
    private String fechaRespuesta;//DATE TIME

    public Solicitud() {
    }

    public Solicitud(int idSolicitud, Usuario usuario, RecursoTecnologico recursoTecnologico, String estadoSolicitud, String fechaSolicitud, String fechaRespuesta) {
        this.idSolicitud = idSolicitud;
        this.usuario = usuario;
        this.recursoTecnologico = recursoTecnologico;
        this.estadoSolicitud = estadoSolicitud;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaRespuesta = fechaRespuesta;
    }

    /**
     * Get the value of fechaRespuesta
     *
     * @return the value of fechaRespuesta
     */
    public String getFechaRespuesta() {
        return fechaRespuesta;
    }

    /**
     * Set the value of fechaRespuesta
     *
     * @param fechaRespuesta new value of fechaRespuesta
     */
    public void setFechaRespuesta(String fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    /**
     * Get the value of fechaSolicitud
     *
     * @return the value of fechaSolicitud
     */
    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    /**
     * Set the value of fechaSolicitud
     *
     * @param fechaSolicitud new value of fechaSolicitud
     */
    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    /**
     * Get the value of estadoSolicitud
     *
     * @return the value of estadoSolicitud
     */
    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }

    /**
     * Set the value of estadoSolicitud
     *
     * @param estadoSolicitud new value of estadoSolicitud
     */
    public void setEstadoSolicitud(String estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    /**
     * Get the value of lstArchivos
     *
     * @return the value of lstArchivos
     */
    public List<Archivo> getLstArchivos() {
        return lstArchivos;
    }

    /**
     * Set the value of lstArchivos
     *
     * @param lstArchivos new value of lstArchivos
     */
    public void setLstArchivos(List<Archivo> lstArchivos) {
        this.lstArchivos = lstArchivos;
    }

    /**
     * Get the value of recursoTecnologico
     *
     * @return the value of recursoTecnologico
     */
    public RecursoTecnologico getRecursoTecnologico() {
        return recursoTecnologico;
    }

    /**
     * Set the value of recursoTecnologico
     *
     * @param recursoTecnologico new value of recursoTecnologico
     */
    public void setRecursoTecnologico(RecursoTecnologico recursoTecnologico) {
        this.recursoTecnologico = recursoTecnologico;
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
     * Get the value of idSolicitud
     *
     * @return the value of idSolicitud
     */
    public int getIdSolicitud() {
        return idSolicitud;
    }

    /**
     * Set the value of idSolicitud
     *
     * @param idSolicitud new value of idSolicitud
     */
    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    @Override
    public String toString() {
        return "Solicitud{" + "idSolicitud=" + idSolicitud + ", usuario=" + usuario + ", recursoTecnologico=" + recursoTecnologico + ", lstArchivos=" + lstArchivos + ", estadoSolicitud=" + estadoSolicitud + ", fechaSolicitud=" + fechaSolicitud + ", fechaRespuesta=" + fechaRespuesta + '}';
    }

}
