package model;

import java.util.Date;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Donacion {

    private int idDonacion;
    private int idDonatario;
    private int idDonador; //PUEDE SER ORGANIZACION O USUARIO CIVIL EL DONADOR ***usar el instance of   
    private int idArchivo;
    private int idRecursoTecnologico;
    private Date fechaDonacion;//DATE TIME    
    private String estadoDonacion;
    private String noConfirmacion;
    private boolean remunerado;

    public Donacion() {
    }

    public Donacion(int donatario, int donador, int archivo, int recursoTecnologico, Date fechaDonacion, String estadoDonacion, String noConfirmacion, boolean remunerado) {
        this.idDonatario = donatario;
        this.idDonador = donador;
        this.idArchivo = archivo;
        this.idRecursoTecnologico = recursoTecnologico;
        this.fechaDonacion = fechaDonacion;
        this.estadoDonacion = estadoDonacion;
        this.noConfirmacion = noConfirmacion;
        this.remunerado = remunerado;
    }

    public Donacion(int idDonacion, int donatario, int donador, int archivo, int recursoTecnologico, Date fechaDonacion, String estadoDonacion, String noConfirmacion, boolean remunerado) {
        this.idDonacion = idDonacion;
        this.idDonatario = donatario;
        this.idDonador = donador;
        this.idArchivo = archivo;
        this.idRecursoTecnologico = recursoTecnologico;
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

    /**
     * Get the value of idArchivo
     *
     * @return the value of idArchivo
     */
    public int getIdArchivo() {
        return idArchivo;
    }

    public void setIdArchivo(int idArchivo) {
        this.idArchivo = idArchivo;
    }

    /**
     * Set the value of idArchivo
     *
     * @param archivo new value of idArchivo
     */
    public void setLstArchivos(int archivo) {
        this.idArchivo = archivo;
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
     * Get the value of idDonatario
     *
     * @return the value of idDonatario
     */
    public int getIdDonatario() {
        return idDonatario;
    }

    /**
     * Set the value of idDonatario
     *
     * @param idDonatario new value of idDonatario
     */
    public void setIdDonatario(int idDonatario) {
        this.idDonatario = idDonatario;
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
        return "Donacion{" + "idDonacion=" + idDonacion + ", donatario=" + idDonatario + ", donador=" + idDonador + ", archivo=" + idArchivo + ", recursoTecnologico=" + idRecursoTecnologico + ", fechaDonacion=" + fechaDonacion + ", estadoDonacion=" + estadoDonacion + ", noConfirmacion=" + noConfirmacion + ", remunerado=" + remunerado + '}';
    }

}
