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
public class ConexionOracle extends IConexion {

    public ConexionOracle() {
        super();
        init();
    }

    @Override
    public final void init() {
        super.init();
        setHost("localhost");
        setPort("1521");
        setUser("admin");
        setPassword("password123");
    }

    @Override
    public int conectar() {
        System.out.println("Se conecto a MYSQL");
        return 1;
    }

    @Override
    public int desconectar() {
        System.out.println("Se desconecto a MYSQL");
        return 1;
    }
}
