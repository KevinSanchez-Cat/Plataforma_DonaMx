package manipula;

import java.util.ArrayList;
import java.util.List;
import model.Localidad;
import utils.GenericResponse;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
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
