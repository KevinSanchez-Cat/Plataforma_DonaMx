package model;

import java.sql.Timestamp;
import java.util.Date;

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
    private String estadoEquipo;
    private String capDiscoDuro;
    private String interfaceDiscoDuro;
    private String resolucionPantalla;
    private String tipoResolucion;
    private String relacionAspecto;
    private String tamanioPantalla;
    private String conAntireflejo;
    private String tarjetaGrafica;
    private String marcaProcesador;
    private String lineaProcesador;
    private int cantidadNucleos;
    private String velocidadProcesador;
    private String tipoBateria;
    private int duracionBateria;
    private String puertosVideo;
    private String puertosUSB;
    private int cantidadRanurasRAM;
    private int cantidadPuertosUSB;
    private String conUSB;
    private String conWifi;
    private String conHDMI;
    private String conBluetooth;
    private String conSalidaAudifinos;
    private String conPuertoEthernet;
    private String conLectorTarjetaMemoriaSD;
    private String conVGA;
    private double peso;
    private double ancho;
    private double profundidad;
    private double altura;
    private String modoSonido;
    private int cantidadParlantes;
    private String conMicrofono;
    private String conCamaraWeb;
    private Timestamp fechaCreacion;
    private String tipoPantalla;

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
            String memoriaRAM, String tipoRAM, String velocidadRAM, String capacidadMaxRAM, String estadoEquipo) {
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
        this.estadoEquipo = estadoEquipo;
    }

    public EquipoComputacional(int idEquipoComputacional, String nombre, int idRecursoTecnologico, String marca, int idSistemaOperativo, String modelo, String color, String memoriaRAM, String tipoRAM, String velocidadRAM, String capacidadMaxRAM, String estadoEquipo, String capDiscoDuro, String interfaceDiscoDuro, String resolucionPantalla, String tipoResolucion, String relacionAspecto, String tamanioPantalla, String conAntireflejo, String tarjetaGrafica, String marcaProcesador, String lineaProcesador, int cantidadNucleos, String velocidadProcesador, String tipoBateria, int duracionBateria, String puertosVideo, String puertosUSB, int cantidadRanurasRAM, int cantidadPuertosUSB, String conUSB, String conWifi, String conHDMI, String conBluetooth, String conSalidaAudifinos, String conPuertoEthernet, String conLectorTarjetaMemoriaSD, String conVGA, double peso, double ancho, double profundidad, double altura, String modoSonido, int cantidadParlantes, String conMicrofono, String conCamaraWeb, Timestamp fechaCreacion, String tipoPantalla) {
        this.idEquipoComputacional = idEquipoComputacional;
        this.nombre = nombre;
        this.idRecursoTecnologico = idRecursoTecnologico;
        this.marca = marca;
        this.idSistemaOperativo = idSistemaOperativo;
        this.modelo = modelo;
        this.color = color;
        this.memoriaRAM = memoriaRAM;
        this.tipoRAM = tipoRAM;
        this.velocidadRAM = velocidadRAM;
        this.capacidadMaxRAM = capacidadMaxRAM;
        this.estadoEquipo = estadoEquipo;
        this.capDiscoDuro = capDiscoDuro;
        this.interfaceDiscoDuro = interfaceDiscoDuro;
        this.resolucionPantalla = resolucionPantalla;
        this.tipoResolucion = tipoResolucion;
        this.relacionAspecto = relacionAspecto;
        this.tamanioPantalla = tamanioPantalla;
        this.conAntireflejo = conAntireflejo;
        this.tarjetaGrafica = tarjetaGrafica;
        this.marcaProcesador = marcaProcesador;
        this.lineaProcesador = lineaProcesador;
        this.cantidadNucleos = cantidadNucleos;
        this.velocidadProcesador = velocidadProcesador;
        this.tipoBateria = tipoBateria;
        this.duracionBateria = duracionBateria;
        this.puertosVideo = puertosVideo;
        this.puertosUSB = puertosUSB;
        this.cantidadRanurasRAM = cantidadRanurasRAM;
        this.cantidadPuertosUSB = cantidadPuertosUSB;
        this.conUSB = conUSB;
        this.conWifi = conWifi;
        this.conHDMI = conHDMI;
        this.conBluetooth = conBluetooth;
        this.conSalidaAudifinos = conSalidaAudifinos;
        this.conPuertoEthernet = conPuertoEthernet;
        this.conLectorTarjetaMemoriaSD = conLectorTarjetaMemoriaSD;
        this.conVGA = conVGA;
        this.peso = peso;
        this.ancho = ancho;
        this.profundidad = profundidad;
        this.altura = altura;
        this.modoSonido = modoSonido;
        this.cantidadParlantes = cantidadParlantes;
        this.conMicrofono = conMicrofono;
        this.conCamaraWeb = conCamaraWeb;
        this.fechaCreacion = fechaCreacion;
        this.tipoPantalla = tipoPantalla;
    }

    public String getTipoPantalla() {
        return tipoPantalla;
    }

    public void setTipoPantalla(String tipoPantalla) {
        this.tipoPantalla = tipoPantalla;
    }

    public String getEstadoEquipo() {
        return estadoEquipo;
    }

    public void setEstadoEquipo(String estadoEquipo) {
        this.estadoEquipo = estadoEquipo;
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

    public String getCapDiscoDuro() {
        return capDiscoDuro;
    }

    public void setCapDiscoDuro(String capDiscoDuro) {
        this.capDiscoDuro = capDiscoDuro;
    }

    public String getInterfaceDiscoDuro() {
        return interfaceDiscoDuro;
    }

    public void setInterfaceDiscoDuro(String interfaceDiscoDuro) {
        this.interfaceDiscoDuro = interfaceDiscoDuro;
    }

    public String getResolucionPantalla() {
        return resolucionPantalla;
    }

    public void setResolucionPantalla(String resolucionPantalla) {
        this.resolucionPantalla = resolucionPantalla;
    }

    public String getTipoResolucion() {
        return tipoResolucion;
    }

    public void setTipoResolucion(String tipoResolucion) {
        this.tipoResolucion = tipoResolucion;
    }

    public String getRelacionAspecto() {
        return relacionAspecto;
    }

    public void setRelacionAspecto(String relacionAspecto) {
        this.relacionAspecto = relacionAspecto;
    }

    public String getTamanioPantalla() {
        return tamanioPantalla;
    }

    public void setTamanioPantalla(String tamanioPantalla) {
        this.tamanioPantalla = tamanioPantalla;
    }

    public String getConAntireflejo() {
        return conAntireflejo;
    }

    public void setConAntireflejo(String conAntireflejo) {
        this.conAntireflejo = conAntireflejo;
    }

    public String getTarjetaGrafica() {
        return tarjetaGrafica;
    }

    public void setTarjetaGrafica(String tarjetaGrafica) {
        this.tarjetaGrafica = tarjetaGrafica;
    }

    public String getMarcaProcesador() {
        return marcaProcesador;
    }

    public void setMarcaProcesador(String marcaProcesador) {
        this.marcaProcesador = marcaProcesador;
    }

    public String getLineaProcesador() {
        return lineaProcesador;
    }

    public void setLineaProcesador(String lineaProcesador) {
        this.lineaProcesador = lineaProcesador;
    }

    public int getCantidadNucleos() {
        return cantidadNucleos;
    }

    public void setCantidadNucleos(int cantidadNucleos) {
        this.cantidadNucleos = cantidadNucleos;
    }

    public String getVelocidadProcesador() {
        return velocidadProcesador;
    }

    public void setVelocidadProcesador(String velocidadProcesador) {
        this.velocidadProcesador = velocidadProcesador;
    }

    public String getTipoBateria() {
        return tipoBateria;
    }

    public void setTipoBateria(String tipoBateria) {
        this.tipoBateria = tipoBateria;
    }

    public int getDuracionBateria() {
        return duracionBateria;
    }

    public void setDuracionBateria(int duracionBateria) {
        this.duracionBateria = duracionBateria;
    }

    public String getPuertosVideo() {
        return puertosVideo;
    }

    public void setPuertosVideo(String puertosVideo) {
        this.puertosVideo = puertosVideo;
    }

    public String getPuertosUSB() {
        return puertosUSB;
    }

    public void setPuertosUSB(String puertosUSB) {
        this.puertosUSB = puertosUSB;
    }

    public int getCantidadRanurasRAM() {
        return cantidadRanurasRAM;
    }

    public void setCantidadRanurasRAM(int cantidadRanurasRAM) {
        this.cantidadRanurasRAM = cantidadRanurasRAM;
    }

    public int getCantidadPuertosUSB() {
        return cantidadPuertosUSB;
    }

    public void setCantidadPuertosUSB(int cantidadPuertosUSB) {
        this.cantidadPuertosUSB = cantidadPuertosUSB;
    }

    public String getConUSB() {
        return conUSB;
    }

    public void setConUSB(String conUSB) {
        this.conUSB = conUSB;
    }

    public String getConWifi() {
        return conWifi;
    }

    public void setConWifi(String conWifi) {
        this.conWifi = conWifi;
    }

    public String getConHDMI() {
        return conHDMI;
    }

    public void setConHDMI(String conHDMI) {
        this.conHDMI = conHDMI;
    }

    public String getConBluetooth() {
        return conBluetooth;
    }

    public void setConBluetooth(String conBluetooth) {
        this.conBluetooth = conBluetooth;
    }

    public String getConSalidaAudifinos() {
        return conSalidaAudifinos;
    }

    public void setConSalidaAudifinos(String conSalidaAudifinos) {
        this.conSalidaAudifinos = conSalidaAudifinos;
    }

    public String getConPuertoEthernet() {
        return conPuertoEthernet;
    }

    public void setConPuertoEthernet(String conPuertoEthernet) {
        this.conPuertoEthernet = conPuertoEthernet;
    }

    public String getConLectorTarjetaMemoriaSD() {
        return conLectorTarjetaMemoriaSD;
    }

    public void setConLectorTarjetaMemoriaSD(String conLectorTarjetaMemoriaSD) {
        this.conLectorTarjetaMemoriaSD = conLectorTarjetaMemoriaSD;
    }

    public String getConVGA() {
        return conVGA;
    }

    public void setConVGA(String conVGA) {
        this.conVGA = conVGA;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(double profundidad) {
        this.profundidad = profundidad;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getModoSonido() {
        return modoSonido;
    }

    public void setModoSonido(String modoSonido) {
        this.modoSonido = modoSonido;
    }

    public int getCantidadParlantes() {
        return cantidadParlantes;
    }

    public void setCantidadParlantes(int cantidadParlantes) {
        this.cantidadParlantes = cantidadParlantes;
    }

    public String getConMicrofono() {
        return conMicrofono;
    }

    public void setConMicrofono(String conMicrofono) {
        this.conMicrofono = conMicrofono;
    }

    public String getConCamaraWeb() {
        return conCamaraWeb;
    }

    public void setConCamaraWeb(String conCamaraWeb) {
        this.conCamaraWeb = conCamaraWeb;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return "EquipoComputacional{" + "idEquipoComputacional=" + idEquipoComputacional + ", nombre=" + nombre + ", idRecursoTecnologico=" + idRecursoTecnologico + ", marca=" + marca + ", idSistemaOperativo=" + idSistemaOperativo + ", modelo=" + modelo + ", color=" + color + ", memoriaRAM=" + memoriaRAM + ", tipoRAM=" + tipoRAM + ", velocidadRAM=" + velocidadRAM + ", capacidadMaxRAM=" + capacidadMaxRAM + ", estadoEquipo=" + estadoEquipo + ", capDiscoDuro=" + capDiscoDuro + ", interfaceDiscoDuro=" + interfaceDiscoDuro + ", resolucionPantalla=" + resolucionPantalla + ", tipoResolucion=" + tipoResolucion + ", relacionAspecto=" + relacionAspecto + ", tamanioPantalla=" + tamanioPantalla + ", conAntireflejo=" + conAntireflejo + ", tarjetaGrafica=" + tarjetaGrafica + ", marcaProcesador=" + marcaProcesador + ", lineaProcesador=" + lineaProcesador + ", cantidadNucleos=" + cantidadNucleos + ", velocidadProcesador=" + velocidadProcesador + ", tipoBateria=" + tipoBateria + ", duracionBateria=" + duracionBateria + ", puertosVideo=" + puertosVideo + ", puertosUSB=" + puertosUSB + ", cantidadRanurasRAM=" + cantidadRanurasRAM + ", cantidadPuertosUSB=" + cantidadPuertosUSB + ", conUSB=" + conUSB + ", conWifi=" + conWifi + ", conHDMI=" + conHDMI + ", conBluetooth=" + conBluetooth + ", conSalidaAudifinos=" + conSalidaAudifinos + ", conPuertoEthernet=" + conPuertoEthernet + ", conLectorTarjetaMemoriaSD=" + conLectorTarjetaMemoriaSD + ", conVGA=" + conVGA + ", peso=" + peso + ", ancho=" + ancho + ", profundidad=" + profundidad + ", altura=" + altura + ", modoSonido=" + modoSonido + ", cantidadParlantes=" + cantidadParlantes + ", conMicrofono=" + conMicrofono + ", conCamaraWeb=" + conCamaraWeb + ", fechaCreacion=" + fechaCreacion + '}';
    }

}
