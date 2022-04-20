package model;

import java.util.Date;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Solicitud {

    private int idSolicitud;
    private Usuario usuario;
    private RecursoTecnologico recursoTecnologico;
    private Archivo archivo;
    private String estadoSolicitud;
    private Date fechaSolicitud;//DATE TIME
    private Date fechaRespuesta;//DATE TIME

    public Solicitud() {
    }

    public Solicitud(Usuario usuario, RecursoTecnologico recursoTecnologico, Archivo archivo, String estadoSolicitud, Date fechaSolicitud) {
        this.usuario = usuario;
        this.recursoTecnologico = recursoTecnologico;
        this.archivo = archivo;
        this.estadoSolicitud = estadoSolicitud;
        this.fechaSolicitud = fechaSolicitud;
    }

    public Solicitud(int idSolicitud, Usuario usuario, RecursoTecnologico recursoTecnologico, Archivo archivo, String estadoSolicitud, Date fechaSolicitud, Date fechaRespuesta) {
        this.idSolicitud = idSolicitud;
        this.usuario = usuario;
        this.recursoTecnologico = recursoTecnologico;
        this.archivo = archivo;
        this.estadoSolicitud = estadoSolicitud;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaRespuesta = fechaRespuesta;
    }

    /**
     * Get the value of fechaRespuesta
     *
     * @return the value of fechaRespuesta
     */
    public Date getFechaRespuesta() {
        return fechaRespuesta;
    }

    /**
     * Set the value of fechaRespuesta
     *
     * @param fechaRespuesta new value of fechaRespuesta
     */
    public void setFechaRespuesta(Date fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    /**
     * Get the value of fechaSolicitud
     *
     * @return the value of fechaSolicitud
     */
    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    /**
     * Set the value of fechaSolicitud
     *
     * @param fechaSolicitud new value of fechaSolicitud
     */
    public void setFechaSolicitud(Date fechaSolicitud) {
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
     * Get the value of archivo
     *
     * @return the value of archivo
     */
    public Archivo getArchivo() {
        return archivo;
    }

    /**
     * Set the value of archivo
     *
     * @param archivo new value of archivo
     */
    public void setArchivo(Archivo archivo) {
        this.archivo = archivo;
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
        return "Solicitud{" + "idSolicitud=" + idSolicitud + ", usuario=" + usuario + ", recursoTecnologico=" + recursoTecnologico + ", archivo=" + archivo + ", estadoSolicitud=" + estadoSolicitud + ", fechaSolicitud=" + fechaSolicitud + ", fechaRespuesta=" + fechaRespuesta + '}';
    }

}
