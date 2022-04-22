package model;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Rol {

    private int idRol;
    private String rol;

    public Rol() {
    }

    public Rol(int idRol, String rol) {
        this.idRol = idRol;
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    @Override
    public String toString() {
        return "Rol{" + "idRol=" + idRol + ", rol=" + rol + '}';
    }
}
