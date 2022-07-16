package HubertRoszyk.company.database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static String URL = "jdbc:mysql://localhost:3306/game";
    private static String USER = "root";
    private  static String PASSWORD = "1234";
    private static Connection connection = null;

    public static Connection connect() throws SQLException {

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
}
