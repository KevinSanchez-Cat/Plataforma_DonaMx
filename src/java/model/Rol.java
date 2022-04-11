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
public class Rol {

    private int idRol;
    private String rol;

    public Rol() {
    }

    public Rol(int idRol, String rol) {
        this.idRol = idRol;
        this.rol = rol;
    }

    /**
     * Get the value of rol
     *
     * @return the value of rol
     */
    public String getRol() {
        return rol;
    }

    /**
     * Set the value of rol
     *
     * @param rol new value of rol
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

    /**
     * Get the value of idRol
     *
     * @return the value of idRol
     */
    public int getIdRol() {
        return idRol;
    }

    /**
     * Set the value of idRol
     *
     * @param idRol new value of idRol
     */
    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    @Override
    public String toString() {
        return "Rol{" + "idRol=" + idRol + ", rol=" + rol + '}';
    }

}
