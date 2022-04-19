/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipula;

import java.util.ArrayList;
import java.util.List;
import model.Estudiante;
import utils.GenericResponse;

/**
 *
 * @author por_s
 */
public class ManipulaEstudiante implements Manipula<Estudiante> {

    @Override
    public GenericResponse<Estudiante> registrar(Estudiante obj) {
        GenericResponse<Estudiante> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Estudiante> actualizar(String id) {
        GenericResponse<Estudiante> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Estudiante> editar(String id, Estudiante obj) {
        GenericResponse<Estudiante> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Estudiante> eliminar(String id) {
        GenericResponse<Estudiante> response = new GenericResponse<>();

        return response;
    }

    @Override
    public List<Estudiante> getData() {
        List<Estudiante> response = new ArrayList<>();

        return response;
    }

    @Override
    public List<Estudiante> consultar(String... filtros) {
        List<Estudiante> response = new ArrayList<>();

        return response;
    }

    @Override
    public Estudiante encontrarId(String id) {
        Estudiante response = new Estudiante();

        return response;
    }

}
