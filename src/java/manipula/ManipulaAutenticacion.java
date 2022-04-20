
package manipula;

import config.conexion.*;
import model.Usuario;
import utils.GenericResponse;
/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ManipulaAutenticacion {

    public static GenericResponse<Usuario> registrarse(Usuario usuario) {
        GenericResponse<Usuario> response = new GenericResponse<>();
        IConexion conexionDB=ConexionFactory.getConexion("MYSQL");
        if(conexionDB.conectar()==1){
            
        }else{
          
        }
        return response;
    }
    
    public static GenericResponse<Usuario> iniciarSesionUsuario(Usuario usuario) {
        GenericResponse<Usuario> response = new GenericResponse<>();

        return response;
    }

    public static GenericResponse<Usuario> cerrarSesionUsuario(Usuario usuario) {
        GenericResponse<Usuario> response = new GenericResponse<>();

        return response;
    }
}
