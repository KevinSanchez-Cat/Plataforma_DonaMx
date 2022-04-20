
package manipula;

import java.util.ArrayList;
import java.util.List;
import model.Donacion;
import utils.GenericResponse;
/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ManipulaDonacion implements Manipula<Donacion> {

    @Override
    public GenericResponse<Donacion> registrar(Donacion obj) {
        GenericResponse<Donacion> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Donacion> actualizar(int id) {
        GenericResponse<Donacion> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Donacion> editar(int id, Donacion obj) {
        GenericResponse<Donacion> response = new GenericResponse<>();

        return response;
    }

    @Override
    public GenericResponse<Donacion> eliminar(int id) {
        GenericResponse<Donacion> response = new GenericResponse<>();

        return response;
    }

    @Override
    public List<Donacion> getData() {
        List<Donacion> response = new ArrayList<>();

        return response;
    }

    @Override
    public List<Donacion> consultar(String... filtros) {
        List<Donacion> response = new ArrayList<>();

        return response;
    }

    @Override
    public Donacion encontrarId(int id) {
        Donacion response = new Donacion();

        return response;
    }

}
