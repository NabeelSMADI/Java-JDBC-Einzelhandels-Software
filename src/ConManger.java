import javafx.application.Application;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConManger {

    public static final String DEFAULT_DRIVER_CLASS = "org.postgresql.Driver";
    public static  String DEFAULT_URL = "jdbc:postgresql://";
    public static  String DEFAULT_Server = "db.f4.htw-berlin.de";
    public static  String DEFAULT_Port = "5432";
    public static  String DEFAULT_DB = "_s0556209__rs_db";
    private static  String DEFAULT_USERNAME = "s0556209";
    private static  String DEFAULT_PASSWORD = ""; //Man muss password addieren
    public static Connection connection = null;




    public static boolean connect() {
        DEFAULT_URL="jdbc:postgresql://";
        DEFAULT_URL = DEFAULT_URL +DEFAULT_Server + ":" + DEFAULT_Port + "/" + DEFAULT_DB;

        try {
            Class.forName(DEFAULT_DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            // return;
        }
        connection = null;
        try {
            connection = DriverManager.getConnection(
                    DEFAULT_URL, DEFAULT_USERNAME,
                    DEFAULT_PASSWORD);
        }   catch (Exception e){
        }finally {
            if (connection != null) {
                System.out.println("Connection successful");
                return true;
            } else {
                System.out.println("Connection Failed");
                return false;
            }
        }
    }
}
