package config.conexion;

import java.sql.DriverManager;
import java.sql.SQLException;
import utils.Logg;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ConexionMySQL extends IConexion {

    public ConexionMySQL() {
        super();
        init();
    }
//CREAR EL USUARIO EN phpMyAdmin

    @Override
    public final void init() {
        super.init();
        
        setHost("etacarinae.e-novanet.mx");
        setPort("3306");
        setUser("donamx_KevinIvan");
        setPassword("zhQg4dJB.Kgc_ksM");
        setBd("donamx_bd_donamx");
        setUrl("jdbc:mysql");
        
       
        
    }
    /*
        setHost("localhost");
        setPort("3306");
        setUser("KevinIvan");
        setPassword("zhQg4dJB.Kgc_ksM");
        setBd("bd_donamx");
        setUrl("jdbc:mysql");  
    */

    @Override
    public int conectar() {
        super.conectar();
        if (getConexion() != null) {
            Logg.info("Conexion ya establecida a la base de datos: " + getBd() + "");
            return 1;
        } else {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                setConexion(DriverManager.getConnection(getUrl() + "://" + getHost() + ":" + getPort() + "/" + getBd(), getUser(), getPassword()));
                if (getConexion() != null) {
                    Logg.exito("Conexion a la base de datos: " + getBd() + " exitosa...");
                    return 1;
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logg.error("Error al abrir base de datos: " + getBd() + "\nCause:" + ex.getMessage());
            }
        }

        return 0;
    }

    @Override
    public int desconectar() {
        super.desconectar();
        if (getConexion() != null) {
            try {
                getConexion().close();
                Logg.exito("Desconexion exitosa de la base de datos: " + getBd());
                return 1;
            } catch (SQLException ex) {
                Logg.error("Error al cerrar la base de datos: " + getBd());
            }
        } else {
            Logg.advertencia("Sin conexion a la base de datos: " + getBd());
        }
        return 0;
    }
}
