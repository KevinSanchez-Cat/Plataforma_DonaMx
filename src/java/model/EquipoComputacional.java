package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class EquipoComputacional {

    private int idEquipoComputacional;
    private String nombre;
    private RecursoTecnologico recursoTecnologico;
    private String marca;
    private SistemaOperativo sistemaOperativo;
    private String modelo;
    private String color;
    private String memoriaRAM;
    private String tipoRAM;
    private String velocidadRAM;
    private String capacidadMaxRAM;
    private boolean nuevo;
    private List<Galeria> galeria;

    public EquipoComputacional() {
        this.galeria = new ArrayList<>();
    }

    public EquipoComputacional(String nombre, RecursoTecnologico recursoTecnologico, String marca, SistemaOperativo sistemaOperativo, List<Galeria> galeria) {
        this.nombre = nombre;
        this.recursoTecnologico = recursoTecnologico;
        this.marca = marca;
        this.sistemaOperativo = sistemaOperativo;
        this.galeria = galeria;
    }

    public EquipoComputacional(int idEquipoComputacional, String nombre, RecursoTecnologico recursoTecnologico, String marca, SistemaOperativo sistemaOperativo, String modelo, String color, String memoriaRAM, String tipoRAM, String velocidadRAM, String capacidadMaxRAM, boolean nuevo, List<Galeria> galeria) {
        this.idEquipoComputacional = idEquipoComputacional;
        this.nombre = nombre;
        this.recursoTecnologico = recursoTecnologico;
        this.marca = marca;
        this.sistemaOperativo = sistemaOperativo;
        this.modelo = modelo;
        this.color = color;
        this.memoriaRAM = memoriaRAM;
        this.tipoRAM = tipoRAM;
        this.velocidadRAM = velocidadRAM;
        this.capacidadMaxRAM = capacidadMaxRAM;
        this.nuevo = nuevo;
        this.galeria = galeria;
    }

    /**
     * Get the value of galeria
     *
     * @return the value of galeria
     */
    public List<Galeria> getGaleria() {
        return galeria;
    }

    /**
     * Set the value of galeria
     *
     * @param galeria new value of galeria
     */
    public void setGaleria(List<Galeria> galeria) {
        this.galeria = galeria;
    }

    /**
     * Get the value of nuevo
     *
     * @return the value of nuevo
     */
    public boolean isNuevo() {
        return nuevo;
    }

    /**
     * Set the value of nuevo
     *
     * @param nuevo new value of nuevo
     */
    public void setNuevo(boolean nuevo) {
        this.nuevo = nuevo;
    }

    /**
     * Get the value of capacidadMaxRAM
     *
     * @return the value of capacidadMaxRAM
     */
    public String getCapacidadMaxRAM() {
        return capacidadMaxRAM;
    }

    /**
     * Set the value of capacidadMaxRAM
     *
     * @param capacidadMaxRAM new value of capacidadMaxRAM
     */
    public void setCapacidadMaxRAM(String capacidadMaxRAM) {
        this.capacidadMaxRAM = capacidadMaxRAM;
    }

    /**
     * Get the value of velocidadRAM
     *
     * @return the value of velocidadRAM
     */
    public String getVelocidadRAM() {
        return velocidadRAM;
    }

    /**
     * Set the value of velocidadRAM
     *
     * @param velocidadRAM new value of velocidadRAM
     */
    public void setVelocidadRAM(String velocidadRAM) {
        this.velocidadRAM = velocidadRAM;
    }

    /**
     * Get the value of tipoRAM
     *
     * @return the value of tipoRAM
     */
    public String getTipoRAM() {
        return tipoRAM;
    }

    /**
     * Set the value of tipoRAM
     *
     * @param tipoRAM new value of tipoRAM
     */
    public void setTipoRAM(String tipoRAM) {
        this.tipoRAM = tipoRAM;
    }

    /**
     * Get the value of memoriaRAM
     *
     * @return the value of memoriaRAM
     */
    public String getMemoriaRAM() {
        return memoriaRAM;
    }

    /**
     * Set the value of memoriaRAM
     *
     * @param memoriaRAM new value of memoriaRAM
     */
    public void setMemoriaRAM(String memoriaRAM) {
        this.memoriaRAM = memoriaRAM;
    }

    /**
     * Get the value of color
     *
     * @return the value of color
     */
    public String getColor() {
        return color;
    }

    /**
     * Set the value of color
     *
     * @param color new value of color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Get the value of modelo
     *
     * @return the value of modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Set the value of modelo
     *
     * @param modelo new value of modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Get the value of sistemaOperativo
     *
     * @return the value of sistemaOperativo
     */
    public SistemaOperativo getSistemaOperativo() {
        return sistemaOperativo;
    }

    /**
     * Set the value of sistemaOperativo
     *
     * @param sistemaOperativo new value of sistemaOperativo
     */
    public void setSistemaOperativo(SistemaOperativo sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    /**
     * Get the value of marca
     *
     * @return the value of marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Set the value of marca
     *
     * @param marca new value of marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Get the value of recursoTecnologico
     *
     * @return the value of recursoTecnologico
     */
    public RecursoTecnologico getRecursoTecnologico() {
        return recursoTecnologico;
    }

    /**
     * Set the value of recursoTecnologico
     *
     * @param recursoTecnologico new value of recursoTecnologico
     */
    public void setRecursoTecnologico(RecursoTecnologico recursoTecnologico) {
        this.recursoTecnologico = recursoTecnologico;
    }

    /**
     * Get the value of nombre
     *
     * @return the value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Set the value of nombre
     *
     * @param nombre new value of nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Get the value of idEquipoComputacional
     *
     * @return the value of idEquipoComputacional
     */
    public int getIdEquipoComputacional() {
        return idEquipoComputacional;
    }

    /**
     * Set the value of idEquipoComputacional
     *
     * @param idEquipoComputacional new value of idEquipoComputacional
     */
    public void setIdEquipoComputacional(int idEquipoComputacional) {
        this.idEquipoComputacional = idEquipoComputacional;
    }

}
