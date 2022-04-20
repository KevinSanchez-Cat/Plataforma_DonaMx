package config.conexion;

import java.sql.Connection;
import utils.Logg;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class IConexion {

    private Connection conexion;
    private String host;
    private String port;
    private String user;
    private String password;
    private String url;
    private String bd;

    public IConexion() {
    }

    public IConexion(String host, String port, String user, String password) {
        this.host = host;
        this.port = port;
        this.user = user;
        this.password = password;
    }

    public String getBd() {
        return bd;
    }

    public void setBd(String bd) {
        this.bd = bd;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public void init() {
        Logg.info("Inicializar parametros... ");
    }

    public int conectar() {
        Logg.info("Conectando a la base de datos " + getBd() + "...");
        return 0;
    }

    public int desconectar() {
        Logg.info("Desconectando de la base de datos " + getBd() + "...");
        return 0;
    }

}
