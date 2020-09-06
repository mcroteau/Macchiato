package xyz.ioc.startup;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppStartup implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Starting up!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Shutting down!");
    }

}
