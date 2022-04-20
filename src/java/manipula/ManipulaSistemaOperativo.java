
package manipula;

import java.util.ArrayList;
import java.util.List;
import model.SistemaOperativo;
import utils.GenericResponse;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ManipulaSistemaOperativo implements Manipula<SistemaOperativo> {

    @Override
    public GenericResponse<SistemaOperativo> registrar(SistemaOperativo obj) {
        GenericResponse<SistemaOperativo> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<SistemaOperativo> actualizar(int id) {
        GenericResponse<SistemaOperativo> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<SistemaOperativo> editar(int id, SistemaOperativo obj) {
        GenericResponse<SistemaOperativo> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<SistemaOperativo> eliminar(int id) {
        GenericResponse<SistemaOperativo> response = new GenericResponse<>();

        return response;
    }

    @Override
    public List<SistemaOperativo> getData() {
        List<SistemaOperativo> response = new ArrayList<>();

        return response;
    }

    @Override
    public List<SistemaOperativo> consultar(String... filtros) {
        List<SistemaOperativo> response = new ArrayList<>();

        return response;
    }

    @Override
    public SistemaOperativo encontrarId(int id) {
        SistemaOperativo response = new SistemaOperativo();

        return response;
    }

}
