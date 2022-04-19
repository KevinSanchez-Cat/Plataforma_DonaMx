/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipula;

import java.util.ArrayList;
import java.util.List;
import model.SistemaOperativo;
import utils.GenericResponse;

/**
 *
 * @author por_s
 */
public class ManipulaSistemaOperativo implements Manipula<SistemaOperativo> {

    @Override
    public GenericResponse<SistemaOperativo> registrar(SistemaOperativo obj) {
        GenericResponse<SistemaOperativo> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<SistemaOperativo> actualizar(String id) {
        GenericResponse<SistemaOperativo> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<SistemaOperativo> editar(String id, SistemaOperativo obj) {
        GenericResponse<SistemaOperativo> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<SistemaOperativo> eliminar(String id) {
        GenericResponse<SistemaOperativo> response = new GenericResponse<>();

        return response;
    }

    @Override
    public List<SistemaOperativo> getData() {
        List<SistemaOperativo> response = new ArrayList<>();

        return response;
    }

    @Override
    public List<SistemaOperativo> consultar(String... filtros) {
        List<SistemaOperativo> response = new ArrayList<>();

        return response;
    }

    @Override
    public SistemaOperativo encontrarId(String id) {
        SistemaOperativo response = new SistemaOperativo();

        return response;
    }

}
