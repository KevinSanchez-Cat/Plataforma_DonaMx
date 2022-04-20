package manipula;

import java.util.ArrayList;
import java.util.List;
import model.EquipoComputacional;
import utils.GenericResponse;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ManipulaEquipoComputacional implements Manipula<EquipoComputacional> {

    @Override
    public GenericResponse<EquipoComputacional> registrar(EquipoComputacional obj) {
        GenericResponse<EquipoComputacional> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<EquipoComputacional> actualizar(int id) {
        GenericResponse<EquipoComputacional> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<EquipoComputacional> editar(int id, EquipoComputacional obj) {
        GenericResponse<EquipoComputacional> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<EquipoComputacional> eliminar(int id) {
        GenericResponse<EquipoComputacional> response = new GenericResponse<>();

        return response;
    }

    @Override
    public List<EquipoComputacional> getData() {
        List<EquipoComputacional> response = new ArrayList<>();

        return response;
    }

    @Override
    public List<EquipoComputacional> consultar(String... filtros) {
        List<EquipoComputacional> response = new ArrayList<>();

        return response;
    }

    @Override
    public EquipoComputacional encontrarId(int id) {
        EquipoComputacional response = new EquipoComputacional();

        return response;
    }

}
