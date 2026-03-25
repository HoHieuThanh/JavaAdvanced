package ex3;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
    public void xuatVienVaThanhToan(int maBenhNhan, double tienVienPhi) {

        Connection conn = null;

        try {
            DatabaseMetaData DatabaseManager = null;
            conn = DatabaseManager.getConnection();
            conn.setAutoCommit(false);

            // Lấy số dư
            String sqlCheck = "SELECT balance FROM Patient_Wallet WHERE patient_id = ?";
            PreparedStatement psCheck = conn.prepareStatement(sqlCheck);
            psCheck.setInt(1, maBenhNhan);
            ResultSet rs = psCheck.executeQuery();

            if (!rs.next()) {
                throw new Exception("Không tìm thấy bệnh nhân");
            }

            double balance = rs.getDouble("balance");

            // BẪY 1: Thiếu tiền
            if (balance < tienVienPhi) {
                throw new Exception("Số dư không đủ để thanh toán");
            }

            // Trừ tiền
            String sql1 = "UPDATE Patient_Wallet SET balance = balance - ? WHERE patient_id = ?";
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.setDouble(1, tienVienPhi);
            ps1.setInt(2, maBenhNhan);

            int row1 = ps1.executeUpdate();

            // BẪY 2: Không có dòng bị ảnh hưởng
            if (row1 == 0) {
                throw new Exception("Không cập nhật được ví bệnh nhân");
            }

            // Giải phóng giường
            String sql2 = "UPDATE Beds SET status = 'Trống' WHERE patient_id = ?";
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setInt(1, maBenhNhan);

            int row2 = ps2.executeUpdate();

            // BẪY 2
            if (row2 == 0) {
                throw new Exception("Không cập nhật được giường");
            }

            // Cập nhật trạng thái bệnh nhân
            String sql3 = "UPDATE Patients SET status = 'Đã xuất viện' WHERE id = ?";
            PreparedStatement ps3 = conn.prepareStatement(sql3);
            ps3.setInt(1, maBenhNhan);

            int row3 = ps3.executeUpdate();

            // BẪY 2
            if (row3 == 0) {
                throw new Exception("Không cập nhật được bệnh nhân");
            }

            // Thành công
            conn.commit();
            System.out.println("Xuất viện và thanh toán thành công");

        } catch (Exception e) {

            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            System.out.println("Lỗi: " + e.getMessage());

        } finally {
            try {
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
