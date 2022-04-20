/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipula;

import java.util.ArrayList;
import java.util.List;
import model.Localidad;
import utils.GenericResponse;

/**
 *
 * @author por_s
 */
public class ManipulaLocalidad implements Manipula<Localidad> {

    @Override
    public GenericResponse<Localidad> registrar(Localidad obj) {
        GenericResponse<Localidad> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Localidad> actualizar(int id) {
        GenericResponse<Localidad> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Localidad> editar(int id, Localidad obj) {
        GenericResponse<Localidad> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Localidad> eliminar(int id) {
        GenericResponse<Localidad> response = new GenericResponse<>();

        return response;
    }

    @Override
    public List<Localidad> getData() {
        List<Localidad> response = new ArrayList<>();

        return response;
    }

    @Override
    public List<Localidad> consultar(String... filtros) {
        List<Localidad> response = new ArrayList<>();

        return response;
    }

    @Override
    public Localidad encontrarId(int id) {
        Localidad response = new Localidad();

        return response;
    }

}
