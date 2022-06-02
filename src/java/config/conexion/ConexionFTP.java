
package config.conexion;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class ConexionFTP {
    
    private String usuario;
    private String host;
    private String ip;
    private String url;
    private int puerto;
    private String contrasenia;

    public ConexionFTP(String usuario, String host, int puerto, String contrasenia) {
        this.usuario = usuario;
        this.host = host;
        this.puerto = puerto;
        this.contrasenia = contrasenia;
    }

    public ConexionFTP(String usuario, String host, String ip, String url, int puerto, String contrasenia) {
        this.usuario = usuario;
        this.host = host;
        this.ip = ip;
        this.url = url;
        this.puerto = puerto;
        this.contrasenia = contrasenia;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
}
