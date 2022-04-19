/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipula;

import java.util.ArrayList;
import java.util.List;
import model.Solicitud;
import utils.GenericResponse;

/**
 *
 * @author por_s
 */
public class ManipulaSolicitud implements Manipula<Solicitud> {

    @Override
    public GenericResponse<Solicitud> registrar(Solicitud obj) {
        GenericResponse<Solicitud> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Solicitud> actualizar(String id) {
        GenericResponse<Solicitud> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Solicitud> editar(String id, Solicitud obj) {
        GenericResponse<Solicitud> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Solicitud> eliminar(String id) {
        GenericResponse<Solicitud> response = new GenericResponse<>();

        return response;
    }

    @Override
    public List<Solicitud> getData() {
        List<Solicitud> response = new ArrayList<>();

        return response;
    }

    @Override
    public List<Solicitud> consultar(String... filtros) {
        List<Solicitud> response = new ArrayList<>();

        return response;
    }

    @Override
    public Solicitud encontrarId(String id) {
        Solicitud response = new Solicitud();

        return response;
    }

}
