package manipula;

import java.util.ArrayList;
import java.util.List;
import model.Estudiante;
import utils.GenericResponse;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ManipulaEstudiante implements Manipula<Estudiante> {

    @Override
    public GenericResponse<Estudiante> registrar(Estudiante obj) {
        GenericResponse<Estudiante> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Estudiante> actualizar(int id) {
        GenericResponse<Estudiante> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Estudiante> editar(int id, Estudiante obj) {
        GenericResponse<Estudiante> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Estudiante> eliminar(int id) {
        GenericResponse<Estudiante> response = new GenericResponse<>();

        return response;
    }

    @Override
    public List<Estudiante> getData() {
        List<Estudiante> response = new ArrayList<>();

        return response;
    }

    @Override
    public List<Estudiante> consultar(String... filtros) {
        List<Estudiante> response = new ArrayList<>();

        return response;
    }

    @Override
    public Estudiante encontrarId(int id) {
        Estudiante response = new Estudiante();

        return response;
    }

}
