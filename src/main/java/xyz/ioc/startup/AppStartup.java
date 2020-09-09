package xyz.ioc.startup;

import io.github.mcroteau.Parakeet;
import org.h2.tools.RunScript;
import xyz.ioc.factory.DbFactory;
import xyz.ioc.factory.ParakeetFactory;
import xyz.ioc.ordinary.Constants;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.FileReader;
import java.sql.Connection;

public class AppStartup implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {

            System.out.println("Starting up!");
            ParakeetFactory parakeetFactory = new ParakeetFactory();
            Parakeet parakeet = parakeetFactory.getParakeet();

            Connection conn = DbFactory.getConnection();
            ServletContext context = servletContextEvent.getServletContext();
            context.setAttribute(Constants.PARAKEET_LOOKUP, parakeet);

            RunScript.execute(conn, new FileReader("exec/create-db.sql"));

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        try {
            System.out.println("Shutting down!");
            Connection conn = DbFactory.getConnection();
            RunScript.execute(conn, new FileReader("exec/drop-db.sql"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
