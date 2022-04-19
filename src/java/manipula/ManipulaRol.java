/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipula;

import java.util.ArrayList;
import java.util.List;
import model.Rol;
import utils.GenericResponse;

/**
 *
 * @author por_s
 */
public class ManipulaRol implements Manipula<Rol> {

    @Override
    public GenericResponse<Rol> registrar(Rol obj) {
        GenericResponse<Rol> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Rol> actualizar(String id) {
        GenericResponse<Rol> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Rol> editar(String id, Rol obj) {
        GenericResponse<Rol> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Rol> eliminar(String id) {
        GenericResponse<Rol> response = new GenericResponse<>();

        return response;
    }

    @Override
    public List<Rol> getData() {
        List<Rol> response = new ArrayList<>();

        return response;
    }

    @Override
    public List<Rol> consultar(String... filtros) {
        List<Rol> response = new ArrayList<>();

        return response;
    }

    @Override
    public Rol encontrarId(String id) {
        Rol response = new Rol();

        return response;
    }

}
