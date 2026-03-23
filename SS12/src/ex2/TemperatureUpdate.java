package ex2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TemperatureUpdate {
    public static void main(String[] args) throws SQLException {
        // setDouble(), setInt() của PreparedStatement tự xử lý định dạng chuẩn dữ liệu truyền vào nên không ảnh hưởng bới định dạng số của hệ điều hành
//        double temp = 37.5;
//        String sql = "UPDATE Vitals SET temperature = " + temp + " WHERE p_id = " + patientId;
//        stmt.executeUpdate(sql);

        double temp = 37.5;
        int heartRate = 20;
        int patientId = 1;
        String sql = "UPDATE Vitals SET temperature = ?, heart_rate = ? WHERE p_id = ?";

        Connection conn = null;
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setDouble(1, temp);
        ps.setInt(2, heartRate);
        ps.setInt(3, patientId);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Cập nhật thành công");
        } else {
            System.out.println("Không tìm thấy bệnh nhân");
        }

    }
}
