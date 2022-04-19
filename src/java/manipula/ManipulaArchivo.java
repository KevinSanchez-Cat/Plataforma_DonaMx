/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipula;

import java.util.ArrayList;
import java.util.List;
import model.Archivo;
import utils.GenericResponse;

/**
 *
 * @author por_s
 */
public class ManipulaArchivo implements Manipula<Archivo> {

    @Override
    public GenericResponse<Archivo> registrar(Archivo obj) {
        GenericResponse<Archivo> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Archivo> actualizar(String id) {
        GenericResponse<Archivo> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Archivo> editar(String id, Archivo obj) {
        GenericResponse<Archivo> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Archivo> eliminar(String id) {
        GenericResponse<Archivo> response = new GenericResponse<>();

        return response;
    }

    @Override
    public List<Archivo> getData() {
        List<Archivo> response = new ArrayList<>();

        return response;
    }

    @Override
    public List<Archivo> consultar(String... filtros) {
        List<Archivo> response = new ArrayList<>();

        return response;
    }

    @Override
    public Archivo encontrarId(String id) {
        Archivo response = new Archivo();

        return response;
    }
}
