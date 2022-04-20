package model;

import java.util.List;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Estado {

    private int idEstado;
    private String estado;

    public Estado() {
    }

    public Estado(String estado) {
        this.estado = estado;
    }

    public Estado(int idEstado, String estado) {
        this.idEstado = idEstado;
        this.estado = estado;
    }


    /**
     * Get the value of estado
     *
     * @return the value of estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Set the value of estado
     *
     * @param estado new value of estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Get the value of idEstado
     *
     * @return the value of idEstado
     */
    public int getIdEstado() {
        return idEstado;
    }

    /**
     * Set the value of idEstado
     *
     * @param idEstado new value of idEstado
     */
    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    @Override
    public String toString() {
        return "Estado{" + "idEstado=" + idEstado + ", estado=" + estado + '}';
    }

}
