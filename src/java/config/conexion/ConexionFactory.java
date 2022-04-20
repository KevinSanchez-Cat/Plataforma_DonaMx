package config.conexion;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ConexionFactory {

    public static final IConexion getConexion(String motor) {
        if (motor == null) {
            return new ConexionMySQL();
        } else if (motor.equalsIgnoreCase("MYSQL")) {
            return new ConexionMySQL();
        } else if (motor.equalsIgnoreCase("ORACLE")) {
            return new ConexionOracle();
        } else if (motor.equalsIgnoreCase("POSTGRES")) {
            return new ConexionPostgreSQL();
        } else {
            return new ConexionMySQL();
        }
    }
}
