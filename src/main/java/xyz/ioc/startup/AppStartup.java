package xyz.ioc.startup;

import io.github.mcroteau.Parakeet;
import xyz.ioc.factory.DbFactory;
import xyz.ioc.factory.ParakeetFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;

public class AppStartup implements ServletContextListener {



    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ParakeetFactory parakeetFactory = new ParakeetFactory();
        Connection connection = DbFactory.getConnection();
        ServletContext context = servletContextEvent.getServletContext();
        System.out.println("Starting up!" + connection);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Shutting down!");
    }

}
