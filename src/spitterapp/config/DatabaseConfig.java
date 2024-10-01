package spitterapp.config;

import java.io.Closeable;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DatabaseConfig {


    private static final String url = "jdbc:mysql://localhost:3306/my_local_db?useSSL=false";
    private static final String user = "MySqlUser";
    private static final String password = "mySqlPass";


    //Connection conn = DriverManager.getConnection(url,user,password);
    //Statement statement = conn.createStatement();


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }

    public static boolean closeConnection(Connection connection) {
        if(connection != null) {
            try{
                connection.close();
                return true;
            } catch (SQLException e) {
                throw new RuntimeException(e);

            }
        }
        return false;
    }
}
