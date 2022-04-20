/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipula;

import java.util.ArrayList;
import java.util.List;
import model.Estado;
import utils.GenericResponse;

/**
 *
 * @author por_s
 */
public class ManipulaEstado implements Manipula<Estado> {

    @Override
    public GenericResponse<Estado> registrar(Estado obj) {
        GenericResponse<Estado> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Estado> actualizar(int id) {
        GenericResponse<Estado> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Estado> editar(int id, Estado obj) {
        GenericResponse<Estado> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Estado> eliminar(int id) {
        GenericResponse<Estado> response = new GenericResponse<>();

        return response;
    }

    @Override
    public List<Estado> getData() {
        List<Estado> response = new ArrayList<>();

        return response;
    }

    @Override
    public List<Estado> consultar(String... filtros) {
        List<Estado> response = new ArrayList<>();

        return response;
    }

    @Override
    public Estado encontrarId(int id) {
        Estado response = new Estado();

        return response;
    }

}
