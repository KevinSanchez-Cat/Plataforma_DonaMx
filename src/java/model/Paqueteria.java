
package model;

import java.sql.Timestamp;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Paqueteria {

    private int idPaqueteria;
    private int idDonacion;
    private int idVoluntario;
    private String direccionOrigen;
    private String direccionDestino;
    private Timestamp fechaOrigen;
    private Timestamp fechaDestino;
    private String estadoPaquete;

    public Paqueteria() {
    }

    public Paqueteria(int idDonacion, int idVoluntario, String direccionOrigen, String direccionDestino, Timestamp fechaOrigen, Timestamp fechaDestino, String estadoPaquete) {
        this.idDonacion = idDonacion;
        this.idVoluntario = idVoluntario;
        this.direccionOrigen = direccionOrigen;
        this.direccionDestino = direccionDestino;
        this.fechaOrigen = fechaOrigen;
        this.fechaDestino = fechaDestino;
        this.estadoPaquete = estadoPaquete;
    }

    public Paqueteria(int idPaqueteria, int idDonacion, int idVoluntario, String direccionOrigen, String direccionDestino, Timestamp fechaOrigen, Timestamp fechaDestino, String estadoPaquete) {
        this.idPaqueteria = idPaqueteria;
        this.idDonacion = idDonacion;
        this.idVoluntario = idVoluntario;
        this.direccionOrigen = direccionOrigen;
        this.direccionDestino = direccionDestino;
        this.fechaOrigen = fechaOrigen;
        this.fechaDestino = fechaDestino;
        this.estadoPaquete = estadoPaquete;
    }

    public int getIdPaqueteria() {
        return idPaqueteria;
    }

    public void setIdPaqueteria(int idPaqueteria) {
        this.idPaqueteria = idPaqueteria;
    }

    public int getIdDonacion() {
        return idDonacion;
    }

    public void setIdDonacion(int idDonacion) {
        this.idDonacion = idDonacion;
    }

    public int getIdVoluntario() {
        return idVoluntario;
    }

    public void setIdVoluntario(int idVoluntario) {
        this.idVoluntario = idVoluntario;
    }

    public String getDireccionOrigen() {
        return direccionOrigen;
    }

    public void setDireccionOrigen(String direccionOrigen) {
        this.direccionOrigen = direccionOrigen;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }

    public void setDireccionDestino(String direccionDestino) {
        this.direccionDestino = direccionDestino;
    }

    public Timestamp getFechaOrigen() {
        return fechaOrigen;
    }

    public void setFechaOrigen(Timestamp fechaOrigen) {
        this.fechaOrigen = fechaOrigen;
    }

    public Timestamp getFechaDestino() {
        return fechaDestino;
    }

    public void setFechaDestino(Timestamp fechaDestino) {
        this.fechaDestino = fechaDestino;
    }

    public String getEstadoPaquete() {
        return estadoPaquete;
    }

    public void setEstadoPaquete(String estadoPaquete) {
        this.estadoPaquete = estadoPaquete;
    }
    
    
}
