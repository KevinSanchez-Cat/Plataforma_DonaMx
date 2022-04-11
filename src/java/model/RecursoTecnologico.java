/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author por_s
 */
public class RecursoTecnologico { //-->> SE TRATA COMO ALMACEN

    private int idRecursoTecnologico;
    private Categoria categoria;
    private char organizacionOCivil;
    private Organizacion donador; //EN CASO DE QUE SEA UNA ORGANIZACION
    private Usuario usuario; //CONTACTO QUE DA DE ALTA EL RECURSO.
    private int cantidadStock;
    private Object recurso; //PUEDE SER EQUIPO COMPUTACIONAL, IMPRESORA, CAMARA, LICENCIA ...
    private char autorizado; //Pendiente, Autorizado, No autorizado
    private char estadoPublicacion;
    private boolean estadoLogico;
    private String fechaPublicacion;//DATE TIME
    private String fechaAutorizacion;//DATE TIME    
    private char remunerado;
    private char estadoCondicion;
    private double precioOriginal;
    private double precioEstimado;
    private double precioOfertado;
    private char tipoSoftwarOHardware;

    public RecursoTecnologico() {
    }

    public RecursoTecnologico(int idRecursoTecnologico, Categoria categoria, char organizacionOCivil, Organizacion donador, Usuario usuario, int cantidadStock, Object recurso, char autorizado, char estadoPublicacion, boolean estadoLogico, String fechaPublicacion, String fechaAutorizacion, char remunerado, char estadoCondicion, double precioOriginal, double precioEstimado, double precioOfertado, char tipoSoftwarOHardware) {
        this.idRecursoTecnologico = idRecursoTecnologico;
        this.categoria = categoria;
        this.organizacionOCivil = organizacionOCivil;
        this.donador = donador;
        this.usuario = usuario;
        this.cantidadStock = cantidadStock;
        this.recurso = recurso;
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
    public char getTipoSoftwarOHardware() {
        return tipoSoftwarOHardware;
    }

    /**
     * Set the value of tipoSoftwarOHardware
     *
     * @param tipoSoftwarOHardware new value of tipoSoftwarOHardware
     */
    public void setTipoSoftwarOHardware(char tipoSoftwarOHardware) {
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
    public char getEstadoCondicion() {
        return estadoCondicion;
    }

    /**
     * Set the value of estadoCondicion
     *
     * @param estadoCondicion new value of estadoCondicion
     */
    public void setEstadoCondicion(char estadoCondicion) {
        this.estadoCondicion = estadoCondicion;
    }

    /**
     * Get the value of remunerado
     *
     * @return the value of remunerado
     */
    public char getRemunerado() {
        return remunerado;
    }

    /**
     * Set the value of remunerado
     *
     * @param remunerado new value of remunerado
     */
    public void setRemunerado(char remunerado) {
        this.remunerado = remunerado;
    }

    /**
     * Get the value of fechaAutorizacion
     *
     * @return the value of fechaAutorizacion
     */
    public String getFechaAutorizacion() {
        return fechaAutorizacion;
    }

    /**
     * Set the value of fechaAutorizacion
     *
     * @param fechaAutorizacion new value of fechaAutorizacion
     */
    public void setFechaAutorizacion(String fechaAutorizacion) {
        this.fechaAutorizacion = fechaAutorizacion;
    }

    /**
     * Get the value of fechaPublicacion
     *
     * @return the value of fechaPublicacion
     */
    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    /**
     * Set the value of fechaPublicacion
     *
     * @param fechaPublicacion new value of fechaPublicacion
     */
    public void setFechaPublicacion(String fechaPublicacion) {
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
    public char getEstadoPublicacion() {
        return estadoPublicacion;
    }

    /**
     * Set the value of estadoPublicacion
     *
     * @param estadoPublicacion new value of estadoPublicacion
     */
    public void setEstadoPublicacion(char estadoPublicacion) {
        this.estadoPublicacion = estadoPublicacion;
    }

    /**
     * Get the value of autorizado
     *
     * @return the value of autorizado
     */
    public char getAutorizado() {
        return autorizado;
    }

    /**
     * Set the value of autorizado
     *
     * @param autorizado new value of autorizado
     */
    public void setAutorizado(char autorizado) {
        this.autorizado = autorizado;
    }

    /**
     * Get the value of recurso
     *
     * @return the value of recurso
     */
    public Object getRecurso() {
        return recurso;
    }

    /**
     * Set the value of recurso
     *
     * @param recurso new value of recurso
     */
    public void setRecurso(Object recurso) {
        this.recurso = recurso;
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
    public char getOrganizacionOCivil() {
        return organizacionOCivil;
    }

    /**
     * Set the value of organizacionOCivil
     *
     * @param organizacionOCivil new value of organizacionOCivil
     */
    public void setOrganizacionOCivil(char organizacionOCivil) {
        this.organizacionOCivil = organizacionOCivil;
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
     * Get the value of donador
     *
     * @return the value of donador
     */
    public Organizacion getDonador() {
        return donador;
    }

    /**
     * Set the value of donador
     *
     * @param donador new value of donador
     */
    public void setDonador(Organizacion donador) {
        this.donador = donador;
    }

    /**
     * Get the value of categoria
     *
     * @return the value of categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * Set the value of categoria
     *
     * @param categoria new value of categoria
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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
        return "RecursoTecnologico{" + "idRecursoTecnologico=" + idRecursoTecnologico + ", categoria=" + categoria + ", organizacionOCivil=" + organizacionOCivil + ", donador=" + donador + ", usuario=" + usuario + ", cantidadStock=" + cantidadStock + ", recurso=" + recurso + ", autorizado=" + autorizado + ", estadoPublicacion=" + estadoPublicacion + ", estadoLogico=" + estadoLogico + ", fechaPublicacion=" + fechaPublicacion + ", fechaAutorizacion=" + fechaAutorizacion + ", remunerado=" + remunerado + ", estadoCondicion=" + estadoCondicion + ", precioOriginal=" + precioOriginal + ", precioEstimado=" + precioEstimado + ", precioOfertado=" + precioOfertado + ", tipoSoftwarOHardware=" + tipoSoftwarOHardware + '}';
    }

}
