package model;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Municipio {

    private int idMunicipio;
    private String municipio;
    private int idEstado;

    public Municipio() {
    }

    public Municipio(String municipio, int idEstado) {
        this.municipio = municipio;
        this.idEstado = idEstado;
    }

    public Municipio(int idMunicipio, String municipio, int idEstado) {
        this.idMunicipio = idMunicipio;
        this.municipio = municipio;
        this.idEstado = idEstado;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    @Override
    public String toString() {
        return "Municipio{" + "idMunicipio=" + idMunicipio + ", municipio=" + municipio + ", idEstado=" + idEstado + '}';
    }

}
