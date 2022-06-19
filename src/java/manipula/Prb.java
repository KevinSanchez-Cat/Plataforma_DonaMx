package manipula;

import controller.inicio.MailSender;
import java.util.List;
import model.Notificacion;
import model.Rol;
import model.Usuario;
import utils.GenericResponse;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Prb {

    public static void main(String[] args) {
        ManipulaRol m = new ManipulaRol();
        Rol role1 = new Rol(0, "PENDIENTE");
        Rol role2 = new Rol(0, "DEFECTO");
        Rol role3 = new Rol(0, "ADMINISTRADOR");
        Rol role4 = new Rol(0, "MANAGER");
        Rol role5 = new Rol(0, "PAQUETERIA");
        Rol role6 = new Rol(0, "VOLUNTARIO");
        Rol role7 = new Rol(0, "DONADOR");
        Rol role8 = new Rol(0, "DONATARIO");

        //  lst.forEach(System.out::println);
        /*ManipulaNotificacion manipula=new ManipulaNotificacion();
        Notificacion notificacion=new Notificacion();
        notificacion.setEstadoVisualizacion("0");
        notificacion.setFechaNotificacion(utils.Misc.getDateTimeActualJava());
        notificacion.setIdUsuarioDestino(4);
        notificacion.setMensaje("Tu registro fue exitoso!");
        notificacion.setPrioridad("0");*/
        // GenericResponse<Notificacion> resouesta=manipula.registrar(notificacion);
        //System.out.println(resouesta.getMensaje());
        ManipulaUsuario manipula2 = new ManipulaUsuario();
        // List<Notificacion> lstNot=manipula2.getNotificacion(4);
        // lstNot.forEach(System.out::println);
        MailSender mail = new MailSender();
        mail.send("ksanchezv2@Toluca.tecnm.mx", "Esto es una prueba", "Este correo fue enviado usando JavaMail");
        //mail.send("ksanchezv2@Toluca.tecnm.mx", "Esto es una prueba", "Este correo fue enviado usando JavaMail", "adjunto.pdf", "C:\\ruta\\archivo.pdf");
    }
}
