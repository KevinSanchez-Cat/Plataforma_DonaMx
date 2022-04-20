package manipula;

import java.util.ArrayList;
import java.util.List;
import model.Direccion;
import utils.GenericResponse;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ManipulaDireccion implements Manipula<Direccion> {

    @Override
    public GenericResponse<Direccion> registrar(Direccion obj) {
        GenericResponse<Direccion> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Direccion> actualizar(int id) {
        GenericResponse<Direccion> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Direccion> editar(int id, Direccion obj) {
        GenericResponse<Direccion> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Direccion> eliminar(int id) {
        GenericResponse<Direccion> response = new GenericResponse<>();

        return response;
    }

    @Override
    public List<Direccion> getData() {
        List<Direccion> response = new ArrayList<>();

        return response;
    }

    @Override
    public List<Direccion> consultar(String... filtros) {
        List<Direccion> response = new ArrayList<>();

        return response;
    }

    @Override
    public Direccion encontrarId(int id) {
        Direccion response = new Direccion();

        return response;
    }

}
