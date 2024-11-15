package ConexionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class BaseDatosOrtiz {
    private static final String URL = "jdbc:mysql://localhost:3306/Ortiz";
    private static final String USER = "admin";
    private static final String PASSWORD = "nautilus";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
