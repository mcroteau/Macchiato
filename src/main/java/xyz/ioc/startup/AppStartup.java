package xyz.ioc.startup;

import io.github.mcroteau.Parakeet;
import org.h2.tools.RunScript;
import xyz.ioc.factory.DbFactory;
import xyz.ioc.factory.ParakeetFactory;
import xyz.ioc.ordinary.Constants;
import xyz.ioc.ordinary.Utils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AppStartup implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ParakeetFactory parakeetFactory = new ParakeetFactory();
        try {

            Connection conn = DbFactory.getConnection();
            ServletContext context = servletContextEvent.getServletContext();
            System.out.println("Starting up!" + conn);

            RunScript.execute(conn, new FileReader("exec/create-db.sql"));

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Shutting down!");

        try {
            Connection conn = DbFactory.getConnection();
            RunScript.execute(conn, new FileReader("exec/drop-db.sql"));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
