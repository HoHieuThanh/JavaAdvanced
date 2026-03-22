package demo;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.List;

public class ConnectMySql {
    public static Connection connection(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "Aptx4869.");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public static void closeAll(Connection con, Statement stmt, ResultSet rs){
        if (con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        ProductRepository repo = new ProductRepositoryImpl();
        List<Product> products = repo.getProducts();
        for (Product p: products){
            System.out.println(p);
        }
    }
}
