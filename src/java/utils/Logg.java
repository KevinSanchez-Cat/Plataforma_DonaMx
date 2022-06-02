package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Logg {

    public static String loggReset = "\033[30m";
    public static String loggGris = "\033[1m";
    public static String loggNegro = "\033[2m";
    public static String loggRojo = "\033[31m";
    public static String loggVerdeLimon = "\033[32m";
    public static String loggAmarilloLima = "\033[33m";
    public static String loggAzulRey = "\033[34m";
    public static String loggRosa = "\033[35m";
    public static String loggAzulTurquesa = "\033[36m";
    public static String loggGrisBajo = "\033[37m";
    public static String loggNegro2 = "\033[38m";
    public static String loggSubrayadoAzulRey = "\033[44m";
    public static String loggSubrayadoRosa = "\033[45m";
    public static String loggSubrayadoAmarillo = "\033[43m";
    public static String loggSubrayadoVerde = "\033[42m";
    public static String loggSubrayadoRojo = "\033[41m";
    public static String loggSubrayadoAzulTurquesa = "\033[46m";
    public static String loggSubrayadoGris = "\033[47m";

    public static void exito(String message) {
        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println(Logg.loggVerdeLimon + "EXITO [" + dtf3.format(LocalDateTime.now()) + "]: " + message + Logg.loggReset);

    }

    public static void debug(String message) {
        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println("DEBUG [" + dtf3.format(LocalDateTime.now()) + "]: " + message);

    }

    public static void info(String message) {
        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println(Logg.loggAzulRey + "INFO [" + dtf3.format(LocalDateTime.now()) + "]: " + message + Logg.loggReset);

    }

    public static void advertencia(String message) {
        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println(Logg.loggRosa + "ADVERTENCIA [" + dtf3.format(LocalDateTime.now()) + "]: " + message + Logg.loggReset);
    }

    public static void error(String message) {
        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    }

    public static void fatal(String message) {
        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println(Logg.loggNegro + "FATAL [" + dtf3.format(LocalDateTime.now()) + "]: " + message + Logg.loggReset);
        System.exit(0);
    }

    /*
    
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println("yyyy/MM/dd HH:mm:ss-> "+dtf.format(LocalDateTime.now()));

        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss");
        System.out.println("yy/MM/dd HH:mm:ss-> "+dtf2.format(LocalDateTime.now()));

       

        DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        System.out.println("yyyy/MM/dd HH:mm-> "+dtf4.format(LocalDateTime.now()));

        DateTimeFormatter dtf5 = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm");
        System.out.println("yyyy/MM/dd hh:mm:ss-> "+dtf5.format(LocalDateTime.now()));
     */
}
