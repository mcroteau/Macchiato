package xyz.ioc.ordinary;

public class Constants {

    public static final String DB = "cafe";
    public static final String URL  = "jdbc:h2:tcp://localhost:9092/~" +
            "/Development/Projects/Macchiato/exec/" + DB +
            ";init=create schema if not exists cafe\\;" +
            "set schema cafe";
    public static final String USER = "sa";
    public static final String PASS = "";

    public static final String PARAKEET_LOOKUP = "Parakeet";


}
