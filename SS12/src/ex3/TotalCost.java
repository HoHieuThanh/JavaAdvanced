package ex3;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

public class TotalCost {
    public static void main(String[] args) {
    // Phải dùng registerOutParameter() để khai báo tham số OUT trước khi thực thi, nếu không JDBC không thể lấy dữ liệu trả về.
    // Nếu tham số đầu ra là kiểu DECIMAL trong SQL thì trong Java phải đăng ký bằng Types.DECIMAL
//    CallableStatement call = conn.prepareCall("{call GET_SURGERY_FEE(?, ?)}");
//    call.setInt(1, 505);
//    call.execute();
//    double cost = call.getDouble(2);
        CallableStatement call = null;

        try {
            Connection conn = null;
            call = conn.prepareCall("{call GET_SURGERY_FEE(?, ?)}");
            call.setInt(1, 505);
            call.registerOutParameter(2, Types.DECIMAL);
            call.execute();
            double cost = call.getDouble(2);
            System.out.println("Chi phí phẫu thuật: " + cost);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (call != null) call.close();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }

    }
}
