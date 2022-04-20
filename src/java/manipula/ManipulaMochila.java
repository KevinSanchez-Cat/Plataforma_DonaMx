package manipula;

import java.util.ArrayList;
import java.util.List;
import model.Mochila;
import utils.GenericResponse;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ManipulaMochila implements Manipula<Mochila> {

    @Override
    public GenericResponse<Mochila> registrar(Mochila obj) {
        GenericResponse<Mochila> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Mochila> actualizar(int id) {
        GenericResponse<Mochila> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Mochila> editar(int id, Mochila obj) {
        GenericResponse<Mochila> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Mochila> eliminar(int id) {
        GenericResponse<Mochila> response = new GenericResponse<>();

        return response;
    }

    @Override
    public List<Mochila> getData() {
        List<Mochila> response = new ArrayList<>();

        return response;
    }

    @Override
    public List<Mochila> consultar(String... filtros) {
        List<Mochila> response = new ArrayList<>();

        return response;
    }

    @Override
    public Mochila encontrarId(int id) {
        Mochila response = new Mochila();

        return response;
    }

}
