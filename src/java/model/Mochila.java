package model;

import java.util.Date;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Mochila {

    private int idItem;
    private int idRecurso;
    private int cantidad;
    private String estatus;
    private double precio;
    private boolean remunerado;
    private Date fecha;

    public Mochila() {
    }

    public Mochila(int idRecurso, int cantidad, String estatus, double precio, boolean remunerado, Date fecha) {
        this.idRecurso = idRecurso;
        this.cantidad = cantidad;
        this.estatus = estatus;
        this.precio = precio;
        this.remunerado = remunerado;
        this.fecha = fecha;
    }

    public Mochila(int idItem, int idRecurso, int cantidad, String estatus, double precio, boolean remunerado, Date fecha) {
        this.idItem = idItem;
        this.idRecurso = idRecurso;
        this.cantidad = cantidad;
        this.estatus = estatus;
        this.precio = precio;
        this.remunerado = remunerado;
        this.fecha = fecha;
    }

    /**
     * Get the value of fecha
     *
     * @return the value of fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Set the value of fecha
     *
     * @param fecha new value of fecha
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Get the value of remunerado
     *
     * @return the value of remunerado
     */
    public boolean isRemunerado() {
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
     * Get the value of precio
     *
     * @return the value of precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Set the value of precio
     *
     * @param precio new value of precio
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Get the value of estatus
     *
     * @return the value of estatus
     */
    public String getEstatus() {
        return estatus;
    }

    /**
     * Set the value of estatus
     *
     * @param estatus new value of estatus
     */
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    /**
     * Get the value of cantidad
     *
     * @return the value of cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Set the value of cantidad
     *
     * @param cantidad new value of cantidad
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
     * Get the value of idItem
     *
     * @return the value of idItem
     */
    public int getIdItem() {
        return idItem;
    }

    /**
     * Set the value of idItem
     *
     * @param idItem new value of idItem
     */
    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    @Override
    public String toString() {
        return "Mochila{" + "idItem=" + idItem + ", idRecurso=" + idRecurso + ", cantidad=" + cantidad + ", estatus=" + estatus + ", precio=" + precio + ", remunerado=" + remunerado + ", fecha=" + fecha + '}';
    }

}
