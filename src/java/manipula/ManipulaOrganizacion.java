package manipula;

import java.util.ArrayList;
import java.util.List;
import model.Organizacion;
import utils.GenericResponse;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ManipulaOrganizacion implements Manipula<Organizacion> {

    @Override
    public GenericResponse<Organizacion> registrar(Organizacion obj) {
        GenericResponse<Organizacion> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Organizacion> actualizar(int id) {
        GenericResponse<Organizacion> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Organizacion> editar(int id, Organizacion obj) {
        GenericResponse<Organizacion> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Organizacion> eliminar(int id) {
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
    public Organizacion encontrarId(int id) {
        Organizacion response = new Organizacion();

        return response;
    }

}
