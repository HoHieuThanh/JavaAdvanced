package ex1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;

public class Main {
        // Phần 1
        // Do JDBC mặc định bật auto-commit, nên mỗi câu lệnh SQL được thực thi sẽ tự động lưu ngay vào database như một transaction riêng lẻ. Vì vậy, khi câu lệnh trừ thuốc chạy thành công thì dữ liệu đã được commit, dù sau đó xảy ra lỗi (như exception), hệ thống không thể tự rollback lại, dẫn đến tình trạng dữ liệu bị lệch (đã trừ kho nhưng chưa ghi lịch sử).

        // Phần 2
        public void capPhatThuoc(int medicineId, int patientId) {

            Connection conn = null;
            PreparedStatement ps1 = null;
            PreparedStatement ps2 = null;

            try {
                DatabaseMetaData DatabaseManager = null;
                conn = DatabaseManager.getConnection();
                conn.setAutoCommit(false);

                // 1. Trừ kho
                String sql1 = "UPDATE Medicine_Inventory SET quantity = quantity - 1 WHERE medicine_id = ?";
                ps1 = conn.prepareStatement(sql1);
                ps1.setInt(1, medicineId);
                ps1.executeUpdate();

                // 2. Ghi lịch sử
                String sql2 = "INSERT INTO Prescription_History(patient_id, medicine_id, date) VALUES (?, ?, NOW())";
                ps2 = conn.prepareStatement(sql2);
                ps2.setInt(1, patientId);
                ps2.setInt(2, medicineId);
                ps2.executeUpdate();
                conn.commit();

                System.out.println("Cấp phát thuốc thành công!");

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
                    if (ps1 != null) ps1.close();
                    if (ps2 != null) ps2.close();
                    if (conn != null) conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


}
