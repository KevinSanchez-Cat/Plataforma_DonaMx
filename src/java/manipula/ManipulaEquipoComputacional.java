/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipula;

import java.util.ArrayList;
import java.util.List;
import model.EquipoComputacional;
import utils.GenericResponse;

/**
 *
 * @author por_s
 */
public class ManipulaEquipoComputacional implements Manipula<EquipoComputacional> {

    @Override
    public GenericResponse<EquipoComputacional> registrar(EquipoComputacional obj) {
        GenericResponse<EquipoComputacional> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<EquipoComputacional> actualizar(String id) {
        GenericResponse<EquipoComputacional> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<EquipoComputacional> editar(String id, EquipoComputacional obj) {
        GenericResponse<EquipoComputacional> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<EquipoComputacional> eliminar(String id) {
        GenericResponse<EquipoComputacional> response = new GenericResponse<>();

        return response;
    }

    @Override
    public List<EquipoComputacional> getData() {
        List<EquipoComputacional> response = new ArrayList<>();

        return response;
    }

    @Override
    public List<EquipoComputacional> consultar(String... filtros) {
        List<EquipoComputacional> response = new ArrayList<>();

        return response;
    }

    @Override
    public EquipoComputacional encontrarId(String id) {
        EquipoComputacional response = new EquipoComputacional();

        return response;
    }

}
