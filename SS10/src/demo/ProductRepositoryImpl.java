package demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository{
    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        Connection con;
        Statement stmt = null;
        ResultSet rs = null;
        con = ConnectMySql.connection();
        try {
            stmt = con.createStatement();
            String sql = "select * from products";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Product product = new Product();
                product.setProId(rs.getInt("id"));
                product.setProName(rs.getString("name"));
                product.setExpireDate(rs.getDate("expire_date").toLocalDate());
                product.setPrice(rs.getDouble("price"));
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectMySql.closeAll(con, stmt, rs);
        }
        return List.of();
    }
}
