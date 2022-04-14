/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.conexion;

/**
 *
 * @author por_s
 */
public class ConexionFactory {

    public IConexion getConexion(String motor) {
        if (motor == null) {
            return new ConexionMySQL();
        } else if (motor.equalsIgnoreCase("MYSQL")) {
            return new ConexionMySQL();
        } else if (motor.equalsIgnoreCase("ORACLE")) {
            return new ConexionOracle();
        } else if (motor.equalsIgnoreCase("POSTGRES")) {
            return new ConexionPostgreSQL();
        } else {
            return new ConexionMySQL();

        }
    }
}
