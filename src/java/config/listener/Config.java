package config.listener;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
import config.conexion.ConexionFactory;
import config.conexion.IConexion;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.ServiceLoader;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import model.Usuario;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Config implements HttpSessionListener, HttpSessionBindingListener, ServletContextListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session creada: " + se.getSession().toString());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session destruida: " + se.getSession().toString());

        IConexion conexionDB = ConexionFactory.getConexion("MYSQL");
        if (conexionDB.conectar() == 1) {
            Usuario user = (Usuario) se.getSession().getAttribute("user");
            manipula.ManipulaAutenticacion.cerrarSesionUsuario(conexionDB, user);
            conexionDB.desconectar();
        }
        AbandonedConnectionCleanupThread.checkedShutdown();

    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Iterator<Driver> driversIterator = ServiceLoader.load(Driver.class).iterator();
        while (driversIterator.hasNext()) {
            try {
                // Instantiates the driver
                driversIterator.next();
            } catch (Throwable t) {
                sce.getServletContext().log("JDBC Driver registration failure.", t);
            }
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // AbandonedConnectionCleanupThread.checkedShutdown();
        final ClassLoader cl = sce.getServletContext().getClassLoader();
        final Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            final Driver driver = drivers.nextElement();
            // We deregister only the classes loaded by this application's classloader
            if (driver.getClass().getClassLoader() == cl) {
                try {
                    DriverManager.deregisterDriver(driver);
                } catch (SQLException e) {
                    sce.getServletContext().log("JDBC Driver deregistration failure.", e);
                }
            }
        }
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("Se quito un atributo a la sesion" + event.getSession());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("Se agrego un atributo a la sesion" + event.getSession());
    }
}
