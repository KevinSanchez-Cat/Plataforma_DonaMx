package manipula;

import java.util.ArrayList;
import java.util.List;
import model.Municipio;
import utils.GenericResponse;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ManipulaMunicipio implements Manipula<Municipio> {

    @Override
    public GenericResponse<Municipio> registrar(Municipio obj) {
        GenericResponse<Municipio> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Municipio> actualizar(int id) {
        GenericResponse<Municipio> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Municipio> editar(int id, Municipio obj) {
        GenericResponse<Municipio> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Municipio> eliminar(int id) {
        GenericResponse<Municipio> response = new GenericResponse<>();

        return response;
    }

    @Override
    public List<Municipio> getData() {
        List<Municipio> response = new ArrayList<>();

        return response;
    }

    @Override
    public List<Municipio> consultar(String... filtros) {
        List<Municipio> response = new ArrayList<>();

        return response;
    }

    @Override
    public Municipio encontrarId(int id) {
        Municipio response = new Municipio();

        return response;
    }

}
