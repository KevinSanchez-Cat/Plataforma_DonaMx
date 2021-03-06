package model;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Donacion {

    private int idDonacion;
    private int idDonatario;
    private int idDonador;
    private int idRecursoTecnologico;
    private Timestamp fechaDonacion;  
    private String estadoDonacion;
    private String noConfirmacion;
    private int remunerado;
    private String estadoPago;
    private String estadoEnvio;
    private String estadoEntrega;
    private String noSerie;
    private String estadoPreparacion;

    public Donacion() {
    }

    public Donacion(int donatario, int donador, int recursoTecnologico, Timestamp fechaDonacion, String estadoDonacion, String noConfirmacion, int remunerado) {
        this.idDonatario = donatario;
        this.idDonador = donador;
        this.idRecursoTecnologico = recursoTecnologico;
        this.fechaDonacion = fechaDonacion;
        this.estadoDonacion = estadoDonacion;
        this.noConfirmacion = noConfirmacion;
        this.remunerado = remunerado;
    }

    public Donacion(int idDonacion, int donatario, int donador,int recursoTecnologico, Timestamp fechaDonacion, String estadoDonacion, String noConfirmacion, int remunerado) {
        this.idDonacion = idDonacion;
        this.idDonatario = donatario;
        this.idDonador = donador;
        this.idRecursoTecnologico = recursoTecnologico;
        this.fechaDonacion = fechaDonacion;
        this.estadoDonacion = estadoDonacion;
        this.noConfirmacion = noConfirmacion;
        this.remunerado = remunerado;
    }

    public Donacion(int idDonacion, int idDonatario, int idDonador, int idRecursoTecnologico, Timestamp fechaDonacion, String estadoDonacion, String noConfirmacion, int remunerado, String estadoPago, String estadoEnvio, String estadoEntrega, String noSerie, String estadoPreparacion) {
        this.idDonacion = idDonacion;
        this.idDonatario = idDonatario;
        this.idDonador = idDonador;
        this.idRecursoTecnologico = idRecursoTecnologico;
        this.fechaDonacion = fechaDonacion;
        this.estadoDonacion = estadoDonacion;
        this.noConfirmacion = noConfirmacion;
        this.remunerado = remunerado;
        this.estadoPago = estadoPago;
        this.estadoEnvio = estadoEnvio;
        this.estadoEntrega = estadoEntrega;
        this.noSerie = noSerie;
        this.estadoPreparacion = estadoPreparacion;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    public String getEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(String estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }

    public String getEstadoEntrega() {
        return estadoEntrega;
    }

    public void setEstadoEntrega(String estadoEntrega) {
        this.estadoEntrega = estadoEntrega;
    }

    public String getNoSerie() {
        return noSerie;
    }

    public void setNoSerie(String noSerie) {
        this.noSerie = noSerie;
    }

    public String getEstadoPreparacion() {
        return estadoPreparacion;
    }

    public void setEstadoPreparacion(String estadoPreparacion) {
        this.estadoPreparacion = estadoPreparacion;
    }

    public int getRemunerado() {
        return remunerado;
    }

    public void setRemunerado(int remunerado) {
        this.remunerado = remunerado;
    }

    public String getNoConfirmacion() {
        return noConfirmacion;
    }

    public void setNoConfirmacion(String noConfirmacion) {
        this.noConfirmacion = noConfirmacion;
    }

    public String getEstadoDonacion() {
        return estadoDonacion;
    }

    public void setEstadoDonacion(String estadoDonacion) {
        this.estadoDonacion = estadoDonacion;
    }

    public Timestamp getFechaDonacion() {
        return fechaDonacion;
    }

    public void setFechaDonacion(Timestamp fechaDonacion) {
        this.fechaDonacion = fechaDonacion;
    }

    public int getIdRecursoTecnologico() {
        return idRecursoTecnologico;
    }

    public void setIdRecursoTecnologico(int idRecursoTecnologico) {
        this.idRecursoTecnologico = idRecursoTecnologico;
    }


    public int getIdDonador() {
        return idDonador;
    }

    public void setIdDonador(int idDonador) {
        this.idDonador = idDonador;
    }

    public int getIdDonatario() {
        return idDonatario;
    }

    public void setIdDonatario(int idDonatario) {
        this.idDonatario = idDonatario;
    }

    public int getIdDonacion() {
        return idDonacion;
    }

    public void setIdDonacion(int idDonacion) {
        this.idDonacion = idDonacion;
    }

    @Override
    public String toString() {
        return "Donacion{" + "idDonacion=" + idDonacion + ", idDonatario=" + idDonatario + ", idDonador=" + idDonador + ", idRecursoTecnologico=" + idRecursoTecnologico + ", fechaDonacion=" + fechaDonacion + ", estadoDonacion=" + estadoDonacion + ", noConfirmacion=" + noConfirmacion + ", remunerado=" + remunerado + ", estadoPago=" + estadoPago + ", estadoEnvio=" + estadoEnvio + ", estadoEntrega=" + estadoEntrega + ", noSerie=" + noSerie + ", estadoPreparacion=" + estadoPreparacion + '}';
    }

}
