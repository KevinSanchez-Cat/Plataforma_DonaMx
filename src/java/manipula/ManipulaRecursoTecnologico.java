/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipula;

import java.util.ArrayList;
import java.util.List;
import model.RecursoTecnologico;
import utils.GenericResponse;

/**
 *
 * @author por_s
 */
public class ManipulaRecursoTecnologico implements Manipula<RecursoTecnologico> {

    @Override
    public GenericResponse<RecursoTecnologico> registrar(RecursoTecnologico obj) {
        GenericResponse<RecursoTecnologico> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<RecursoTecnologico> actualizar(String id) {
        GenericResponse<RecursoTecnologico> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<RecursoTecnologico> editar(String id, RecursoTecnologico obj) {
        GenericResponse<RecursoTecnologico> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<RecursoTecnologico> eliminar(String id) {
        GenericResponse<RecursoTecnologico> response = new GenericResponse<>();

        return response;
    }

    @Override
    public List<RecursoTecnologico> getData() {
        List<RecursoTecnologico> response = new ArrayList<>();

        return response;
    }

    @Override
    public List<RecursoTecnologico> consultar(String... filtros) {
        List<RecursoTecnologico> response = new ArrayList<>();

        return response;
    }

    @Override
    public RecursoTecnologico encontrarId(String id) {
        RecursoTecnologico response = new RecursoTecnologico();

        return response;
    }

}
