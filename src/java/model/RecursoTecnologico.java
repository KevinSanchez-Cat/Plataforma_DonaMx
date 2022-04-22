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
    private String autorizado; //Pendiente, Autorizado, No autorizado
    private String estadoPublicacion;
    private boolean estadoLogico;
    private Date fechaPublicacion;
    private Date fechaAutorizacion;   
    private boolean remunerado;
    private String estadoCondicion;
    private double precioOriginal;
    private double precioEstimado;
    private double precioOfertado;
    private String tipoSoftwarOHardware;
    private String nombreRecurso;

    public RecursoTecnologico() {
    }

    public RecursoTecnologico(int idCategoria, String organizacionOCivil, int idUsuario, int cantidadStock, String estadoPublicacion, boolean estadoLogico, boolean remunerado, String tipoSoftwarOHardware, String nombreRecurso) {
        this.idCategoria = idCategoria;
        this.organizacionOCivil = organizacionOCivil;
        this.idUsuario = idUsuario;
        this.cantidadStock = cantidadStock;
        this.estadoPublicacion = estadoPublicacion;
        this.estadoLogico = estadoLogico;
        this.remunerado = remunerado;
        this.tipoSoftwarOHardware = tipoSoftwarOHardware;
        this.nombreRecurso = nombreRecurso;
    }

    public RecursoTecnologico(int idRecursoTecnologico, int idCategoria, String organizacionOCivil, int idDonador, int idUsuario, int cantidadStock, String autorizado, String estadoPublicacion, boolean estadoLogico, Date fechaPublicacion, Date fechaAutorizacion, boolean remunerado, String estadoCondicion, double precioOriginal, double precioEstimado, double precioOfertado, String tipoSoftwarOHardware, String nombreRecurso) {
        this.idRecursoTecnologico = idRecursoTecnologico;
        this.idCategoria = idCategoria;
        this.organizacionOCivil = organizacionOCivil;
        this.idDonador = idDonador;
        this.idUsuario = idUsuario;
        this.cantidadStock = cantidadStock;
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
        this.nombreRecurso = nombreRecurso;
    }

    public String getNombreRecurso() {
        return nombreRecurso;
    }

    public void setNombreRecurso(String nombreRecurso) {
        this.nombreRecurso = nombreRecurso;
    }

    public String getTipoSoftwarOHardware() {
        return tipoSoftwarOHardware;
    }

    public void setTipoSoftwarOHardware(String tipoSoftwarOHardware) {
        this.tipoSoftwarOHardware = tipoSoftwarOHardware;
    }

    public double getPrecioOfertado() {
        return precioOfertado;
    }

    public void setPrecioOfertado(double precioOfertado) {
        this.precioOfertado = precioOfertado;
    }

    public double getPrecioEstimado() {
        return precioEstimado;
    }

    public void setPrecioEstimado(double precioEstimado) {
        this.precioEstimado = precioEstimado;
    }

    public double getPrecioOriginal() {
        return precioOriginal;
    }

    public void setPrecioOriginal(double precioOriginal) {
        this.precioOriginal = precioOriginal;
    }

    public String getEstadoCondicion() {
        return estadoCondicion;
    }

    public void setEstadoCondicion(String estadoCondicion) {
        this.estadoCondicion = estadoCondicion;
    }

    public boolean isRemunerado() {
        return remunerado;
    }

    public void setRemunerado(boolean remunerado) {
        this.remunerado = remunerado;
    }

    public Date getFechaAutorizacion() {
        return fechaAutorizacion;
    }

    public void setFechaAutorizacion(Date fechaAutorizacion) {
        this.fechaAutorizacion = fechaAutorizacion;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public boolean isEstadoLogico() {
        return estadoLogico;
    }

    public void setEstadoLogico(boolean estadoLogico) {
        this.estadoLogico = estadoLogico;
    }

    public String getEstadoPublicacion() {
        return estadoPublicacion;
    }

    public void setEstadoPublicacion(String estadoPublicacion) {
        this.estadoPublicacion = estadoPublicacion;
    }

    public String getAutorizado() {
        return autorizado;
    }

    public void setAutorizado(String autorizado) {
        this.autorizado = autorizado;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public String getOrganizacionOCivil() {
        return organizacionOCivil;
    }

    public void setOrganizacionOCivil(String organizacionOCivil) {
        this.organizacionOCivil = organizacionOCivil;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdDonador() {
        return idDonador;
    }

    public void setIdDonador(int idDonador) {
        this.idDonador = idDonador;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdRecursoTecnologico() {
        return idRecursoTecnologico;
    }

    public void setIdRecursoTecnologico(int idRecursoTecnologico) {
        this.idRecursoTecnologico = idRecursoTecnologico;
    }

    @Override
    public String toString() {
        return "RecursoTecnologico{" + "idRecursoTecnologico=" + idRecursoTecnologico + ", idCategoria=" + idCategoria + ", organizacionOCivil=" + organizacionOCivil + ", idDonador=" + idDonador + ", idUsuario=" + idUsuario + ", cantidadStock=" + cantidadStock + ", autorizado=" + autorizado + ", estadoPublicacion=" + estadoPublicacion + ", estadoLogico=" + estadoLogico + ", fechaPublicacion=" + fechaPublicacion + ", fechaAutorizacion=" + fechaAutorizacion + ", remunerado=" + remunerado + ", estadoCondicion=" + estadoCondicion + ", precioOriginal=" + precioOriginal + ", precioEstimado=" + precioEstimado + ", precioOfertado=" + precioOfertado + ", tipoSoftwarOHardware=" + tipoSoftwarOHardware + ", nombreRecurso=" + nombreRecurso + '}';
    }
}
