/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipula;

import java.util.ArrayList;
import java.util.List;
import model.Donacion;
import utils.GenericResponse;

/**
 *
 * @author por_s
 */
public class ManipulaDonacion implements Manipula<Donacion> {

    @Override
    public GenericResponse<Donacion> registrar(Donacion obj) {
        GenericResponse<Donacion> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Donacion> actualizar(String id) {
        GenericResponse<Donacion> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Donacion> editar(String id, Donacion obj) {
        GenericResponse<Donacion> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Donacion> eliminar(String id) {
        GenericResponse<Donacion> response = new GenericResponse<>();

        return response;
    }

    @Override
    public List<Donacion> getData() {
        List<Donacion> response = new ArrayList<>();

        return response;
    }

    @Override
    public List<Donacion> consultar(String... filtros) {
        List<Donacion> response = new ArrayList<>();

        return response;
    }

    @Override
    public Donacion encontrarId(String id) {
        Donacion response = new Donacion();

        return response;
    }

}
