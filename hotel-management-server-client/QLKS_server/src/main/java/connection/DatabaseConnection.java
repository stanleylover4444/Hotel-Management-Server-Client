package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static DatabaseConnection instance = new DatabaseConnection();
    public static DatabaseConnection getInstance()
    {
        return instance;
    }
    
    public static Connection opConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databasename=QLKS"; 
        String user = "sa";
        String pass = "dockerStrongPwd123";
        Connection con = DriverManager.getConnection(connectionUrl,user,pass);
        return con;
    }
}
