package manipula;

import java.util.ArrayList;
import java.util.List;
import model.Notificacion;
import utils.GenericResponse;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ManipulaNotificacion implements Manipula<Notificacion> {

    @Override
    public GenericResponse<Notificacion> registrar(Notificacion obj) {
        GenericResponse<Notificacion> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Notificacion> actualizar(int id) {
        GenericResponse<Notificacion> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Notificacion> editar(int id, Notificacion obj) {
        GenericResponse<Notificacion> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Notificacion> eliminar(int id) {
        GenericResponse<Notificacion> response = new GenericResponse<>();

        return response;
    }

    @Override
    public List<Notificacion> getData() {
        List<Notificacion> response = new ArrayList<>();

        return response;
    }

    @Override
    public List<Notificacion> consultar(String... filtros) {
        List<Notificacion> response = new ArrayList<>();

        return response;
    }

    @Override
    public Notificacion encontrarId(int id) {
        Notificacion response = new Notificacion();

        return response;
    }

}
