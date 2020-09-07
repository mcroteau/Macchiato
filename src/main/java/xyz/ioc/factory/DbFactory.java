package xyz.ioc.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbFactory {

    public static final String URL = "jdbc:h2:tcp://localhost:9092/~/Development/Projects/Macchiatto/exec/mach3";
    public static final String USER = "sa";
    public static final String PASS = "";

    public static Connection getConnection() {
        try {
            Class.forName("org.h2.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }
}
