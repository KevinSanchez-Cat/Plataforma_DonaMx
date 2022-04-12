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
public class ConexionPostgreSQL extends IConexion {

    public ConexionPostgreSQL() {
        super();

    }

    @Override
    public void init() {
        super.init();
        setHost("localhost");
        setPort("5433");
        setUser("postgres");
        setPassword("password");
    }

    @Override
    public int conectar() {
        System.out.println("Se conecto a POSTGRESQL");
        return 1;
    }

    @Override
    public int desconectar() {
        System.out.println("Se desconecto de POSTGRESQL");
        return 1;
    }

}
