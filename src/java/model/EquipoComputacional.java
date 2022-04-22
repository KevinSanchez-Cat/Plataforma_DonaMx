package model;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class EquipoComputacional {

    private int idEquipoComputacional;
    private String nombre;
    private int idRecursoTecnologico;
    private String marca;
    private int idSistemaOperativo;
    private String modelo;
    private String color;
    private String memoriaRAM;
    private String tipoRAM;
    private String velocidadRAM;
    private String capacidadMaxRAM;
    private boolean nuevo;

    public EquipoComputacional() {
    }

    public EquipoComputacional(String nombre, int recursoTecnologico,
            String marca, int sistemaOperativo) {
        this.nombre = nombre;
        this.idRecursoTecnologico = recursoTecnologico;
        this.marca = marca;
        this.idSistemaOperativo = sistemaOperativo;
    }

    public EquipoComputacional(int idEquipoComputacional, String nombre,
            int recursoTecnologico, String marca, 
            int sistemaOperativo, String modelo, String color,
            String memoriaRAM, String tipoRAM, String velocidadRAM, String capacidadMaxRAM, boolean nuevo) {
        this.idEquipoComputacional = idEquipoComputacional;
        this.nombre = nombre;
        this.idRecursoTecnologico = recursoTecnologico;
        this.marca = marca;
        this.idSistemaOperativo = sistemaOperativo;
        this.modelo = modelo;
        this.color = color;
        this.memoriaRAM = memoriaRAM;
        this.tipoRAM = tipoRAM;
        this.velocidadRAM = velocidadRAM;
        this.capacidadMaxRAM = capacidadMaxRAM;
        this.nuevo = nuevo;
    }

    public boolean isNuevo() {
        return nuevo;
    }

    public void setNuevo(boolean nuevo) {
        this.nuevo = nuevo;
    }

    public String getCapacidadMaxRAM() {
        return capacidadMaxRAM;
    }

    public void setCapacidadMaxRAM(String capacidadMaxRAM) {
        this.capacidadMaxRAM = capacidadMaxRAM;
    }

    public String getVelocidadRAM() {
        return velocidadRAM;
    }

    public void setVelocidadRAM(String velocidadRAM) {
        this.velocidadRAM = velocidadRAM;
    }

    public String getTipoRAM() {
        return tipoRAM;
    }

    public void setTipoRAM(String tipoRAM) {
        this.tipoRAM = tipoRAM;
    }

    public String getMemoriaRAM() {
        return memoriaRAM;
    }

    public void setMemoriaRAM(String memoriaRAM) {
        this.memoriaRAM = memoriaRAM;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getIdSistemaOperativo() {
        return idSistemaOperativo;
    }

    public void setIdSistemaOperativo(int idSistemaOperativo) {
        this.idSistemaOperativo = idSistemaOperativo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getIdRecursoTecnologico() {
        return idRecursoTecnologico;
    }

    public void setIdRecursoTecnologico(int idRecursoTecnologico) {
        this.idRecursoTecnologico = idRecursoTecnologico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdEquipoComputacional() {
        return idEquipoComputacional;
    }

    public void setIdEquipoComputacional(int idEquipoComputacional) {
        this.idEquipoComputacional = idEquipoComputacional;
    }

    @Override
    public String toString() {
        return "EquipoComputacional{" + "idEquipoComputacional=" + idEquipoComputacional + ", nombre=" + nombre + ", idRecursoTecnologico=" + idRecursoTecnologico + ", marca=" + marca + ", idSistemaOperativo=" + idSistemaOperativo + ", modelo=" + modelo + ", color=" + color + ", memoriaRAM=" + memoriaRAM + ", tipoRAM=" + tipoRAM + ", velocidadRAM=" + velocidadRAM + ", capacidadMaxRAM=" + capacidadMaxRAM + ", nuevo=" + nuevo + '}';
    }
}
