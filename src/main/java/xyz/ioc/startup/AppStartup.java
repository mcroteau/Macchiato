package xyz.ioc.startup;

import io.github.mcroteau.Parakeet;
import org.h2.tools.RunScript;
import xyz.ioc.dao.PostDao;
import xyz.ioc.dao.UserDao;
import xyz.ioc.common.DbFactory;
import xyz.ioc.common.ParakeetFactory;
import xyz.ioc.common.Constants;

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
            PostDao postDao = new PostDao();
            UserDao userDao = new UserDao();

            ParakeetFactory parakeetFactory = new ParakeetFactory();
            Parakeet parakeet = parakeetFactory.getParakeet();

            Connection conn = DbFactory.getConnection();
            ServletContext context = servletContextEvent.getServletContext();
            context.setAttribute(Constants.PARAKEET_LOOKUP, parakeet);
            context.setAttribute(Constants.POSTS_DAO_LOOKUP, postDao);
            context.setAttribute(Constants.USER_DAO_LOOKUP, userDao);

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
