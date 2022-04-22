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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    @Override
    public String toString() {
        return "Estado{" + "idEstado=" + idEstado + ", estado=" + estado + '}';
    }

}
