package ex1;

import java.sql.*;

public class DoctorLogin {
    public static void main(String[] args) throws SQLException {
    // PreparedStatement chống SQL Injection vì Cơ chế "Pre-compiled" (biên dịch trước) tách riêng câu lệnh SQL và dữ liệu đầu vào.
//    String sql = "SELECT * FROM Doctors WHERE code = '" + code + "' AND pass = '" + pass + "'";
//    Statement stmt = conn.createStatement();
//    ResultSet rs = stmt.executeQuery(sql);
        String sql = "SELECT * FROM Doctors WHERE code = ? AND pass = ?";
        Connection conn = null;
        PreparedStatement ps = conn.prepareStatement(sql);
        String code = "dt1";
        String pass = "12345";
        ps.setString(1, code);
        ps.setString(2, pass);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            System.out.println("Đăng nhập thành công");
        }else {
            System.out.println("Sai thông tin");
        }
    }
}
