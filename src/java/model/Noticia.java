package model;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Noticia {

    private int idNoticia;
    private int idUsuario;
    private String titulo;
    private String autor;
    private Timestamp fecha;
    private String detalle;
    private String imagen;

    public Noticia() {
    }

    public Noticia(int idUsuario, String titulo, String autor, Timestamp fecha, String detalle, String imagen) {
        this.idUsuario = idUsuario;
        this.titulo = titulo;
        this.autor = autor;
        this.fecha = fecha;
        this.detalle = detalle;
        this.imagen = imagen;
    }

    public Noticia(int idNoticia, int idUsuario, String titulo, String autor, Timestamp fecha, String detalle, String imagen) {
        this.idNoticia = idNoticia;
        this.idUsuario = idUsuario;
        this.titulo = titulo;
        this.autor = autor;
        this.fecha = fecha;
        this.detalle = detalle;
        this.imagen = imagen;
    }

    public int getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(int idNoticia) {
        this.idNoticia = idNoticia;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

}
