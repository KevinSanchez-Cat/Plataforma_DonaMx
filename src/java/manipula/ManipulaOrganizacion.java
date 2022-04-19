/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipula;

import java.util.ArrayList;
import java.util.List;
import model.Organizacion;
import utils.GenericResponse;

/**
 *
 * @author por_s
 */
public class ManipulaOrganizacion implements Manipula<Organizacion> {

    @Override
    public GenericResponse<Organizacion> registrar(Organizacion obj) {
        GenericResponse<Organizacion> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Organizacion> actualizar(String id) {
        GenericResponse<Organizacion> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Organizacion> editar(String id, Organizacion obj) {
        GenericResponse<Organizacion> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Organizacion> eliminar(String id) {
        GenericResponse<Organizacion> response = new GenericResponse<>();

        return response;
    }

    @Override
    public List<Organizacion> getData() {
        List<Organizacion> response = new ArrayList<>();

        return response;
    }

    @Override
    public List<Organizacion> consultar(String... filtros) {
        List<Organizacion> response = new ArrayList<>();

        return response;
    }

    @Override
    public Organizacion encontrarId(String id) {
        Organizacion response = new Organizacion();

        return response;
    }

}
