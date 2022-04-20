package manipula;

import java.util.ArrayList;
import java.util.List;
import model.Galeria;
import utils.GenericResponse;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
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
