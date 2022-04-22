
package model;

import java.util.Date;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Deseo {

    private int idItem;
    private int idRecurso;
    private int idEstudiante;
    private Date fecha;

    public Deseo() {
    }

    public Deseo(int idRecurso, int idEstudiante, Date fecha) {
        this.idRecurso = idRecurso;
        this.idEstudiante = idEstudiante;
        this.fecha = fecha;
    }

    public Deseo(int idItem, int idRecurso, int idEstudiante, Date fecha) {
        this.idItem = idItem;
        this.idRecurso = idRecurso;
        this.idEstudiante = idEstudiante;
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    @Override
    public String toString() {
        return "Deseo{" + "idItem=" + idItem + ", idRecurso=" + idRecurso + ", idEstudiante=" + idEstudiante + ", fecha=" + fecha + '}';
    }

}
