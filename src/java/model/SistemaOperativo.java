package model;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class SistemaOperativo {

    private int idSistemaOperativo;
    private String sistemaOperativo;
    private String version;
    private String edicion;
    private String tipo;

    public SistemaOperativo() {
    }

    public SistemaOperativo(String sistemaOperativo, String version, String edicion) {
        this.sistemaOperativo = sistemaOperativo;
        this.version = version;
        this.edicion = edicion;
    }

    public SistemaOperativo(int idSistemaOperativo, String sistemaOperativo, String version, String edicion) {
        this.idSistemaOperativo = idSistemaOperativo;
        this.sistemaOperativo = sistemaOperativo;
        this.version = version;
        this.edicion = edicion;
    }

    public SistemaOperativo(int idSistemaOperativo, String sistemaOperativo, String version, String edicion, String tipo) {
        this.idSistemaOperativo = idSistemaOperativo;
        this.sistemaOperativo = sistemaOperativo;
        this.version = version;
        this.edicion = edicion;
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public int getIdSistemaOperativo() {
        return idSistemaOperativo;
    }

    public void setIdSistemaOperativo(int idSistemaOperativo) {
        this.idSistemaOperativo = idSistemaOperativo;
    }

    @Override
    public String toString() {
        return "SistemaOperativo{" + "idSistemaOperativo=" + idSistemaOperativo + ", sistemaOperativo=" + sistemaOperativo + ", version=" + version + ", edicion=" + edicion + '}';
    }
}
