/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Logg {

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

    public static void debug(String message) {
        java.util.Date date = new java.util.Date();
        System.out.println("DEBUG [" + date.getTime() + "] :" + message);
    }

    public static void info(String message) {
        java.util.Date date = new java.util.Date();
        System.out.println(Logg.loggAzulRey + "INFO [" + date.getTime() + "] :" + message);
    }

    public static void advertencia(String message) {
        java.util.Date date = new java.util.Date();
        System.out.println(Logg.loggAmarilloLima + "ADVERTENCIA [" + date.getTime() + "] :" + message);
    }

    public static void error(String message) {
        java.util.Date date = new java.util.Date();
        System.out.println(Logg.loggRojo + "ERROR [" + date.getTime() + "] :" + message);
    }

    public static void fatal(String message) {
        java.util.Date date = new java.util.Date();
        System.out.println(Logg.loggNegro + "FATAL [" + date.getTime() + "] :" + message);
        System.exit(0);
    }

}
