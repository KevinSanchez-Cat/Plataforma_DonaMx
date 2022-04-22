package model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Estudiante extends UsuarioGeneral {

    private int idEstudiante;
    private int idUsuario;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;//DATE
    private String genero;
    private String presentacion;
    private int numeroTelMovil;
    private int numeroTelFijo;
    private String lugarNacimiento;
    private String nacionalidad;
    private String nivelEducativo;
    private String ocupacion;
    private String tipoEscuela;
    private String gradoEscolar;
    private double promedioAnterior;
    private boolean estatusEscolar;
    private String intereses;
    private String habilidades;

    public Estudiante() {
        super();
    }

    public Estudiante(int usuario, String nombres, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, String genero, String nacionalidad, String nivelEducativo, String ocupacion) {
        this.idUsuario = usuario;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.nacionalidad = nacionalidad;
        this.nivelEducativo = nivelEducativo;
        this.ocupacion = ocupacion;
    }

    public Estudiante(int idEstudiante, int usuario, String nombres, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, String genero, String presentacion, int numeroTelMovil, int numeroTelFijo, String lugarNacimiento, String nacionalidad, String nivelEducativo, String ocupacion, String tipoEscuela, String gradoEscolar, double promedioAnterior, boolean estatusEscolar, String intereses, String habilidades, Direccion direccion, List<Donacion> lstDonaciones, List<Solicitud> lstSolicitudes, List<Notificacion> lstNotificaciones, boolean estadoLogico, String fechaCreacion, String fotoUsuario) {
        super(direccion, lstDonaciones, lstSolicitudes, lstNotificaciones, estadoLogico, fechaCreacion, fotoUsuario);
        this.idEstudiante = idEstudiante;
        this.idUsuario = usuario;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.presentacion = presentacion;
        this.numeroTelMovil = numeroTelMovil;
        this.numeroTelFijo = numeroTelFijo;
        this.lugarNacimiento = lugarNacimiento;
        this.nacionalidad = nacionalidad;
        this.nivelEducativo = nivelEducativo;
        this.ocupacion = ocupacion;
        this.tipoEscuela = tipoEscuela;
        this.gradoEscolar = gradoEscolar;
        this.promedioAnterior = promedioAnterior;
        this.estatusEscolar = estatusEscolar;
        this.intereses = intereses;
        this.habilidades = habilidades;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    public String getIntereses() {
        return intereses;
    }

    public void setIntereses(String intereses) {
        this.intereses = intereses;
    }

    public boolean isEstatusEscolar() {
        return estatusEscolar;
    }

    public void setEstatusEscolar(boolean estatusEscolar) {
        this.estatusEscolar = estatusEscolar;
    }

    public double getPromedioAnterior() {
        return promedioAnterior;
    }

    public void setPromedioAnterior(double promedioAnterior) {
        this.promedioAnterior = promedioAnterior;
    }

    public String getGradoEscolar() {
        return gradoEscolar;
    }

    public void setGradoEscolar(String gradoEscolar) {
        this.gradoEscolar = gradoEscolar;
    }

    public String getTipoEscuela() {
        return tipoEscuela;
    }

    public void setTipoEscuela(String tipoEscuela) {
        this.tipoEscuela = tipoEscuela;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getNivelEducativo() {
        return nivelEducativo;
    }

    public void setNivelEducativo(String nivelEducativo) {
        this.nivelEducativo = nivelEducativo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public int getNumeroTelFijo() {
        return numeroTelFijo;
    }

    public void setNumeroTelFijo(int numeroTelFijo) {
        this.numeroTelFijo = numeroTelFijo;
    }

    public int getNumeroTelMovil() {
        return numeroTelMovil;
    }

    public void setNumeroTelMovil(int numeroTelMovil) {
        this.numeroTelMovil = numeroTelMovil;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "idEstudiante=" + idEstudiante + ", usuario=" + idUsuario + ", nombres=" + nombres + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", fechaNacimiento=" + fechaNacimiento + ", genero=" + genero + ", presentacion=" + presentacion + ", numeroTelMovil=" + numeroTelMovil + ", numeroTelFijo=" + numeroTelFijo + ", lugarNacimiento=" + lugarNacimiento + ", nacionalidad=" + nacionalidad + ", nivelEducativo=" + nivelEducativo + ", ocupacion=" + ocupacion + ", tipoEscuela=" + tipoEscuela + ", gradoEscolar=" + gradoEscolar + ", promedioAnterior=" + promedioAnterior + ", estatusEscolar=" + estatusEscolar + ", intereses=" + intereses + ", habilidades=" + habilidades + '}';
    }

}
