package manipula;

import java.util.List;
import model.*;
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
        role.setRol("Programador");
        GenericResponse<Rol> respuesta = m.editar(role.getIdRol(),role);
        System.out.println(respuesta.getMensaje());

        List<Rol> lst = m.getData();
        lst.forEach(System.out::println);
    }
}
