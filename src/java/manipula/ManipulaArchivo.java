package manipula;

import java.util.ArrayList;
import java.util.List;
import model.Archivo;
import utils.GenericResponse;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ManipulaArchivo implements Manipula<Archivo> {

    @Override
    public GenericResponse<Archivo> registrar(Archivo obj) {
        GenericResponse<Archivo> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Archivo> actualizar(int id) {
        GenericResponse<Archivo> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Archivo> editar(int id, Archivo obj) {
        GenericResponse<Archivo> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Archivo> eliminar(int id) {
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
    public Archivo encontrarId(int id) {
        Archivo response = new Archivo();

        return response;
    }
}
