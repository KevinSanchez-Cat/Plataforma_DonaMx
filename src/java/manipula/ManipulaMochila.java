/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipula;

import java.util.ArrayList;
import java.util.List;
import model.Mochila;
import utils.GenericResponse;

/**
 *
 * @author por_s
 */
public class ManipulaMochila implements Manipula<Mochila> {

    @Override
    public GenericResponse<Mochila> registrar(Mochila obj) {
        GenericResponse<Mochila> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Mochila> actualizar(String id) {
        GenericResponse<Mochila> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Mochila> editar(String id, Mochila obj) {
        GenericResponse<Mochila> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Mochila> eliminar(String id) {
        GenericResponse<Mochila> response = new GenericResponse<>();
        
        return response;
    }

    @Override
    public List<Mochila> getData() {
        List<Mochila> response = new ArrayList<>();

        return response;
    }

    @Override
    public List<Mochila> consultar(String... filtros) {
        List<Mochila> response = new ArrayList<>();

        return response;
    }

    @Override
    public Mochila encontrarId(String id) {
        Mochila response = new Mochila();

        return response;
    }

}
