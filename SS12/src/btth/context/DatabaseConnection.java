package btth.context;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/HospitalPharmacy",
                "root",
                "Aptx4869."
        );
    }
}

