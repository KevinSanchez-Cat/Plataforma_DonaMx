package manipula;

import java.util.List;
import utils.GenericResponse;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 * @param <T> objeto general
 */
public interface Manipula<T> {

    public GenericResponse<T> registrar(T obj);

    public GenericResponse<T> actualizar(int id);

    public GenericResponse<T> editar(int id, T nvoObj);

    public GenericResponse<T> eliminar(int id);

    public List<T> getData();

    public List<T> consultar(String... filtros);

    public T encontrarId(int id);

    public default GenericResponse<T> msjError(GenericResponse<T> obj) {
        obj.setMensaje("Error de comunicación con la BD");
        obj.setStatus(utils.Constantes.LOGIC_ERROR);
        return obj;
    }

    public default GenericResponse<T> msjAdvertencia(GenericResponse<T> obj) {
        obj.setMensaje("Error de comunicación con la BD");
        obj.setStatus(utils.Constantes.LOGIC_WARNING);
        return obj;
    }

    public default GenericResponse<T> msjExito(GenericResponse<T> obj) {
        obj.setMensaje("Error de comunicación con la BD");
        obj.setStatus(utils.Constantes.LOGIC_SUCCESS);
        return obj;
    }

    public default GenericResponse<T> msjInfo(GenericResponse<T> obj) {
        obj.setMensaje("Error de comunicación con la BD");
        obj.setStatus(utils.Constantes.LOGIC_DEFAULT);
        return obj;
    }

    public default GenericResponse<T> msjNoData(GenericResponse<T> obj) {
        obj.setMensaje("Error de comunicación con la BD");
        obj.setStatus(utils.Constantes.LOGIC_NO_DATA);
        return obj;
    }
}
