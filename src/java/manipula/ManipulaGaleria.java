/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipula;

import java.util.ArrayList;
import java.util.List;
import model.Galeria;
import utils.GenericResponse;

/**
 *
 * @author por_s
 */
public class ManipulaGaleria implements Manipula<Galeria> {

    @Override
    public GenericResponse<Galeria> registrar(Galeria obj) {
        GenericResponse<Galeria> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Galeria> actualizar(int id) {
        GenericResponse<Galeria> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Galeria> editar(int id, Galeria obj) {
        GenericResponse<Galeria> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Galeria> eliminar(int id) {
        GenericResponse<Galeria> response = new GenericResponse<>();

        return response;
    }

    @Override
    public List<Galeria> getData() {
        List<Galeria> response = new ArrayList<>();

        return response;
    }

    @Override
    public List<Galeria> consultar(String... filtros) {
        List<Galeria> response = new ArrayList<>();

        return response;
    }

    @Override
    public Galeria encontrarId(int id) {
        Galeria response = new Galeria();

        return response;
    }

}
