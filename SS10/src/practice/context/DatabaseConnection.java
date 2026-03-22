package practice.context;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/MedicalAppointmentDB";
    private static final String USER = "root";
    private static final String PASSWORD = "Aptx4869.";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

