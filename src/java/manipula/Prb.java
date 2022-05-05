package manipula;

import java.util.List;
import model.Rol;
import utils.GenericResponse;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Prb {

    public static void main(String[] args) {
        ManipulaRol m = new ManipulaRol();
        Rol role = new Rol();
        role.setIdRol(1);
        role.setRol("ADMINISTRADOR");
        GenericResponse<Rol> respuesta = m.registrar(role);
        System.out.println(respuesta.getMensaje());

        List<Rol> lst = m.getData();
        lst.forEach(System.out::println);
    }
}
