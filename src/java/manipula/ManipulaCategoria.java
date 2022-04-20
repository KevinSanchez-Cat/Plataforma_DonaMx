/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipula;

import java.util.ArrayList;
import java.util.List;
import model.Categoria;
import utils.GenericResponse;

/**
 *
 * @author por_s
 */
public class ManipulaCategoria implements Manipula<Categoria> {

    @Override
    public GenericResponse<Categoria> registrar(Categoria obj) {
        GenericResponse<Categoria> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Categoria> actualizar(int id) {
        GenericResponse<Categoria> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Categoria> editar(int id, Categoria obj) {
        GenericResponse<Categoria> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Categoria> eliminar(int id) {
        GenericResponse<Categoria> response = new GenericResponse<>();

        return response;
    }

    @Override
    public List<Categoria> getData() {
        List<Categoria> response = new ArrayList<>();

        return response;
    }

    @Override
    public List<Categoria> consultar(String... filtros) {
        List<Categoria> response = new ArrayList<>();

        return response;
    }

    @Override
    public Categoria encontrarId(int id) {
        Categoria response = new Categoria();

        return response;
    }
}
