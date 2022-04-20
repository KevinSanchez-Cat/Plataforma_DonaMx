package manipula;

import java.util.ArrayList;
import java.util.List;
import model.RecursoTecnologico;
import utils.GenericResponse;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ManipulaRecursoTecnologico implements Manipula<RecursoTecnologico> {

    @Override
    public GenericResponse<RecursoTecnologico> registrar(RecursoTecnologico obj) {
        GenericResponse<RecursoTecnologico> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<RecursoTecnologico> actualizar(int id) {
        GenericResponse<RecursoTecnologico> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<RecursoTecnologico> editar(int id, RecursoTecnologico obj) {
        GenericResponse<RecursoTecnologico> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<RecursoTecnologico> eliminar(int id) {
        GenericResponse<RecursoTecnologico> response = new GenericResponse<>();

        return response;
    }

    @Override
    public List<RecursoTecnologico> getData() {
        List<RecursoTecnologico> response = new ArrayList<>();

        return response;
    }

    @Override
    public List<RecursoTecnologico> consultar(String... filtros) {
        List<RecursoTecnologico> response = new ArrayList<>();

        return response;
    }

    @Override
    public RecursoTecnologico encontrarId(int id) {
        RecursoTecnologico response = new RecursoTecnologico();

        return response;
    }

}
