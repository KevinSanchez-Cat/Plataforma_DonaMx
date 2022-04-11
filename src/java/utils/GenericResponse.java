/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 * @param <T> El objeto que se retornará en la respuesta.
 */
public class GenericResponse<T> {

    private int status;
    private String mensaje;
    private T responseObject;

    //Constantes para controlar el estatus.
    public static final int STATUS_EXITO = 0;
    public static final int STATUS_ERROR_GENERAL = -300;

    public GenericResponse() {
        this.status = STATUS_EXITO;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public T getResponseObject() {
        return responseObject;
    }

    public void setResponseObject(T responseObject) {
        this.responseObject = responseObject;
    }

}
