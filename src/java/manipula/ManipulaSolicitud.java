
package manipula;

import java.util.ArrayList;
import java.util.List;
import model.Solicitud;
import utils.GenericResponse;
/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ManipulaSolicitud implements Manipula<Solicitud> {

    @Override
    public GenericResponse<Solicitud> registrar(Solicitud obj) {
        GenericResponse<Solicitud> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Solicitud> actualizar(int id) {
        GenericResponse<Solicitud> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Solicitud> editar(int id, Solicitud obj) {
        GenericResponse<Solicitud> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Solicitud> eliminar(int id) {
        GenericResponse<Solicitud> response = new GenericResponse<>();

        return response;
    }

    @Override
    public List<Solicitud> getData() {
        List<Solicitud> response = new ArrayList<>();

        return response;
    }

    @Override
    public List<Solicitud> consultar(String... filtros) {
        List<Solicitud> response = new ArrayList<>();

        return response;
    }

    @Override
    public Solicitud encontrarId(int id) {
        Solicitud response = new Solicitud();

        return response;
    }

}
