package config.conexion;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ConexionPostgreSQL extends IConexion {

    public ConexionPostgreSQL() {
        super();
        init();
    }

    @Override
    public final void init() {
        super.init();
        setHost("localhost");
        setPort("5433");
        setUser("postgres");
        setPassword("password");
    }

    @Override
    public int conectar() {
        System.out.println("Se conecto a POSTGRESQL");
        return 1;
    }

    @Override
    public int desconectar() {
        System.out.println("Se desconecto de POSTGRESQL");
        return 1;
    }

}
