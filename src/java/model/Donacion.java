package model;

import java.util.Date;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Donacion {

    private int idDonacion;
    private Usuario donatario;
    private Object donador; //PUEDE SER ORGANIZACION O USUARIO CIVIL EL DONADOR ***usar el instance of   
    private Archivo archivo;
    private RecursoTecnologico recursoTecnologico;
    private Date fechaDonacion;//DATE TIME    
    private String estadoDonacion;
    private String noConfirmacion;
    private boolean remunerado;

    public Donacion() {
    }

    public Donacion(Usuario donatario, Object donador, Archivo archivo, RecursoTecnologico recursoTecnologico, Date fechaDonacion, String estadoDonacion, String noConfirmacion, boolean remunerado) {
        this.donatario = donatario;
        this.donador = donador;
        this.archivo = archivo;
        this.recursoTecnologico = recursoTecnologico;
        this.fechaDonacion = fechaDonacion;
        this.estadoDonacion = estadoDonacion;
        this.noConfirmacion = noConfirmacion;
        this.remunerado = remunerado;
    }

    public Donacion(int idDonacion, Usuario donatario, Object donador, Archivo archivo, RecursoTecnologico recursoTecnologico, Date fechaDonacion, String estadoDonacion, String noConfirmacion, boolean remunerado) {
        this.idDonacion = idDonacion;
        this.donatario = donatario;
        this.donador = donador;
        this.archivo = archivo;
        this.recursoTecnologico = recursoTecnologico;
        this.fechaDonacion = fechaDonacion;
        this.estadoDonacion = estadoDonacion;
        this.noConfirmacion = noConfirmacion;
        this.remunerado = remunerado;
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
     * Get the value of noConfirmacion
     *
     * @return the value of noConfirmacion
     */
    public String getNoConfirmacion() {
        return noConfirmacion;
    }

    /**
     * Set the value of noConfirmacion
     *
     * @param noConfirmacion new value of noConfirmacion
     */
    public void setNoConfirmacion(String noConfirmacion) {
        this.noConfirmacion = noConfirmacion;
    }

    /**
     * Get the value of estadoDonacion
     *
     * @return the value of estadoDonacion
     */
    public String getEstadoDonacion() {
        return estadoDonacion;
    }

    /**
     * Set the value of estadoDonacion
     *
     * @param estadoDonacion new value of estadoDonacion
     */
    public void setEstadoDonacion(String estadoDonacion) {
        this.estadoDonacion = estadoDonacion;
    }

    /**
     * Get the value of fechaDonacion
     *
     * @return the value of fechaDonacion
     */
    public Date getFechaDonacion() {
        return fechaDonacion;
    }

    /**
     * Set the value of fechaDonacion
     *
     * @param fechaDonacion new value of fechaDonacion
     */
    public void setFechaDonacion(Date fechaDonacion) {
        this.fechaDonacion = fechaDonacion;
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
    public void setLstArchivos(Archivo archivo) {
        this.archivo = archivo;
    }

    /**
     * Get the value of donador
     *
     * @return the value of donador
     */
    public Object getDonador() {
        return donador;
    }

    /**
     * Set the value of donador
     *
     * @param donador new value of donador
     */
    public void setDonador(Object donador) {
        this.donador = donador;
    }

    /**
     * Get the value of donatario
     *
     * @return the value of donatario
     */
    public Usuario getDonatario() {
        return donatario;
    }

    /**
     * Set the value of donatario
     *
     * @param donatario new value of donatario
     */
    public void setDonatario(Usuario donatario) {
        this.donatario = donatario;
    }

    /**
     * Get the value of idDonacion
     *
     * @return the value of idDonacion
     */
    public int getIdDonacion() {
        return idDonacion;
    }

    /**
     * Set the value of idDonacion
     *
     * @param idDonacion new value of idDonacion
     */
    public void setIdDonacion(int idDonacion) {
        this.idDonacion = idDonacion;
    }

    @Override
    public String toString() {
        return "Donacion{" + "idDonacion=" + idDonacion + ", donatario=" + donatario + ", donador=" + donador + ", archivo=" + archivo + ", recursoTecnologico=" + recursoTecnologico + ", fechaDonacion=" + fechaDonacion + ", estadoDonacion=" + estadoDonacion + ", noConfirmacion=" + noConfirmacion + ", remunerado=" + remunerado + '}';
    }

}
