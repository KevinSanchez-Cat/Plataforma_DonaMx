package model;

import java.util.Date;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class RecursoTecnologico { //-->> SE TRATA COMO ALMACEN

    private int idRecursoTecnologico;
    private int idCategoria;
    private String organizacionOCivil;
    private int idDonador; //EN CASO DE QUE SEA UNA ORGANIZACION
    private int idUsuario; //CONTACTO QUE DA DE ALTA EL RECURSO.
    private int cantidadStock;
    private int idRecurso; //PUEDE SER EQUIPO COMPUTACIONAL, IMPRESORA, CAMARA, LICENCIA ...
    private String autorizado; //Pendiente, Autorizado, No autorizado
    private String estadoPublicacion;
    private boolean estadoLogico;
    private Date fechaPublicacion;//DATE TIME
    private Date fechaAutorizacion;//DATE TIME    
    private boolean remunerado;
    private String estadoCondicion;
    private double precioOriginal;
    private double precioEstimado;
    private double precioOfertado;
    private String tipoSoftwarOHardware;

    public RecursoTecnologico() {
    }

    public RecursoTecnologico(int categoria, String organizacionOCivil, int donador, int usuario, int cantidadStock, int recurso, boolean estadoLogico, Date fechaPublicacion, Date fechaAutorizacion, String tipoSoftwarOHardware) {
        this.idCategoria = categoria;
        this.organizacionOCivil = organizacionOCivil;
        this.idDonador = donador;
        this.idUsuario = usuario;
        this.cantidadStock = cantidadStock;
        this.idRecurso = recurso;
        this.estadoLogico = estadoLogico;
        this.fechaPublicacion = fechaPublicacion;
        this.fechaAutorizacion = fechaAutorizacion;
        this.tipoSoftwarOHardware = tipoSoftwarOHardware;
    }

    public RecursoTecnologico(int idRecursoTecnologico, int categoria, String organizacionOCivil, int donador, int usuario, int cantidadStock, int recurso, String autorizado, String estadoPublicacion, boolean estadoLogico, Date fechaPublicacion, Date fechaAutorizacion, boolean remunerado, String estadoCondicion, double precioOriginal, double precioEstimado, double precioOfertado, String tipoSoftwarOHardware) {
        this.idRecursoTecnologico = idRecursoTecnologico;
        this.idCategoria = categoria;
        this.organizacionOCivil = organizacionOCivil;
        this.idDonador = donador;
        this.idUsuario = usuario;
        this.cantidadStock = cantidadStock;
        this.idRecurso = recurso;
        this.autorizado = autorizado;
        this.estadoPublicacion = estadoPublicacion;
        this.estadoLogico = estadoLogico;
        this.fechaPublicacion = fechaPublicacion;
        this.fechaAutorizacion = fechaAutorizacion;
        this.remunerado = remunerado;
        this.estadoCondicion = estadoCondicion;
        this.precioOriginal = precioOriginal;
        this.precioEstimado = precioEstimado;
        this.precioOfertado = precioOfertado;
        this.tipoSoftwarOHardware = tipoSoftwarOHardware;
    }

    /**
     * Get the value of tipoSoftwarOHardware
     *
     * @return the value of tipoSoftwarOHardware
     */
    public String getTipoSoftwarOHardware() {
        return tipoSoftwarOHardware;
    }

    /**
     * Set the value of tipoSoftwarOHardware
     *
     * @param tipoSoftwarOHardware new value of tipoSoftwarOHardware
     */
    public void setTipoSoftwarOHardware(String tipoSoftwarOHardware) {
        this.tipoSoftwarOHardware = tipoSoftwarOHardware;
    }

    /**
     * Get the value of precioOfertado
     *
     * @return the value of precioOfertado
     */
    public double getPrecioOfertado() {
        return precioOfertado;
    }

    /**
     * Set the value of precioOfertado
     *
     * @param precioOfertado new value of precioOfertado
     */
    public void setPrecioOfertado(double precioOfertado) {
        this.precioOfertado = precioOfertado;
    }

    /**
     * Get the value of precioEstimado
     *
     * @return the value of precioEstimado
     */
    public double getPrecioEstimado() {
        return precioEstimado;
    }

    /**
     * Set the value of precioEstimado
     *
     * @param precioEstimado new value of precioEstimado
     */
    public void setPrecioEstimado(double precioEstimado) {
        this.precioEstimado = precioEstimado;
    }

    /**
     * Get the value of precioOriginal
     *
     * @return the value of precioOriginal
     */
    public double getPrecioOriginal() {
        return precioOriginal;
    }

    /**
     * Set the value of precioOriginal
     *
     * @param precioOriginal new value of precioOriginal
     */
    public void setPrecioOriginal(double precioOriginal) {
        this.precioOriginal = precioOriginal;
    }

    /**
     * Get the value of estadoCondicion
     *
     * @return the value of estadoCondicion
     */
    public String getEstadoCondicion() {
        return estadoCondicion;
    }

    /**
     * Set the value of estadoCondicion
     *
     * @param estadoCondicion new value of estadoCondicion
     */
    public void setEstadoCondicion(String estadoCondicion) {
        this.estadoCondicion = estadoCondicion;
    }

    /**
     * Get the value of remunerado
     *
     * @return the value of remunerado
     */
    public boolean getRemunerado() {
        return remunerado;
    }

    /**
     * Set the value of remunerado
     *
     * @param remunerado new value of remunerado
     */
    public void setRemunerado(boolean remunerado) {
        this.remunerado = remunerado;
    }

    /**
     * Get the value of fechaAutorizacion
     *
     * @return the value of fechaAutorizacion
     */
    public Date getFechaAutorizacion() {
        return fechaAutorizacion;
    }

    /**
     * Set the value of fechaAutorizacion
     *
     * @param fechaAutorizacion new value of fechaAutorizacion
     */
    public void setFechaAutorizacion(Date fechaAutorizacion) {
        this.fechaAutorizacion = fechaAutorizacion;
    }

    /**
     * Get the value of fechaPublicacion
     *
     * @return the value of fechaPublicacion
     */
    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    /**
     * Set the value of fechaPublicacion
     *
     * @param fechaPublicacion new value of fechaPublicacion
     */
    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    /**
     * Get the value of estadoLogico
     *
     * @return the value of estadoLogico
     */
    public boolean isEstadoLogico() {
        return estadoLogico;
    }

    /**
     * Set the value of estadoLogico
     *
     * @param estadoLogico new value of estadoLogico
     */
    public void setEstadoLogico(boolean estadoLogico) {
        this.estadoLogico = estadoLogico;
    }

    /**
     * Get the value of estadoPublicacion
     *
     * @return the value of estadoPublicacion
     */
    public String getEstadoPublicacion() {
        return estadoPublicacion;
    }

    /**
     * Set the value of estadoPublicacion
     *
     * @param estadoPublicacion new value of estadoPublicacion
     */
    public void setEstadoPublicacion(String estadoPublicacion) {
        this.estadoPublicacion = estadoPublicacion;
    }

    /**
     * Get the value of autorizado
     *
     * @return the value of autorizado
     */
    public String getAutorizado() {
        return autorizado;
    }

    /**
     * Set the value of autorizado
     *
     * @param autorizado new value of autorizado
     */
    public void setAutorizado(String autorizado) {
        this.autorizado = autorizado;
    }

    /**
     * Get the value of idRecurso
     *
     * @return the value of idRecurso
     */
    public int getIdRecurso() {
        return idRecurso;
    }

    /**
     * Set the value of idRecurso
     *
     * @param idRecurso new value of idRecurso
     */
    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }

    /**
     * Get the value of cantidadStock
     *
     * @return the value of cantidadStock
     */
    public int getCantidadStock() {
        return cantidadStock;
    }

    /**
     * Set the value of cantidadStock
     *
     * @param cantidadStock new value of cantidadStock
     */
    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    /**
     * Get the value of organizacionOCivil
     *
     * @return the value of organizacionOCivil
     */
    public String getOrganizacionOCivil() {
        return organizacionOCivil;
    }

    /**
     * Set the value of organizacionOCivil
     *
     * @param organizacionOCivil new value of organizacionOCivil
     */
    public void setOrganizacionOCivil(String organizacionOCivil) {
        this.organizacionOCivil = organizacionOCivil;
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
     * Get the value of idDonador
     *
     * @return the value of idDonador
     */
    public int getIdDonador() {
        return idDonador;
    }

    /**
     * Set the value of idDonador
     *
     * @param idDonador new value of idDonador
     */
    public void setIdDonador(int idDonador) {
        this.idDonador = idDonador;
    }

    /**
     * Get the value of idCategoria
     *
     * @return the value of idCategoria
     */
    public int getIdCategoria() {
        return idCategoria;
    }

    /**
     * Set the value of idCategoria
     *
     * @param idCategoria new value of idCategoria
     */
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    /**
     * Get the value of idRecursoTecnologico
     *
     * @return the value of idRecursoTecnologico
     */
    public int getIdRecursoTecnologico() {
        return idRecursoTecnologico;
    }

    /**
     * Set the value of idRecursoTecnologico
     *
     * @param idRecursoTecnologico new value of idRecursoTecnologico
     */
    public void setIdRecursoTecnologico(int idRecursoTecnologico) {
        this.idRecursoTecnologico = idRecursoTecnologico;
    }

    @Override
    public String toString() {
        return "RecursoTecnologico{" + "idRecursoTecnologico=" + idRecursoTecnologico + ", categoria=" + idCategoria + ", organizacionOCivil=" + organizacionOCivil + ", donador=" + idDonador + ", usuario=" + idUsuario + ", cantidadStock=" + cantidadStock + ", recurso=" + idRecurso + ", autorizado=" + autorizado + ", estadoPublicacion=" + estadoPublicacion + ", estadoLogico=" + estadoLogico + ", fechaPublicacion=" + fechaPublicacion + ", fechaAutorizacion=" + fechaAutorizacion + ", remunerado=" + remunerado + ", estadoCondicion=" + estadoCondicion + ", precioOriginal=" + precioOriginal + ", precioEstimado=" + precioEstimado + ", precioOfertado=" + precioOfertado + ", tipoSoftwarOHardware=" + tipoSoftwarOHardware + '}';
    }

}
