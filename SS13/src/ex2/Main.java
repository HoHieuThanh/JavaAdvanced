package ex2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;

public class Main {
    // Phần 1
    // Việc chỉ in lỗi bằng System.out.println() mà không xử lý thêm là vi phạm nguyên tắc Transaction vì khi xảy ra lỗi, giao dịch đang ở trạng thái  chưa commit nhưng cũng chưa được hủy bỏ. Điều này khiến kết nối giữ transaction dở, có thể gây khóa dữ liệu và ảnh hưởng đến các thao tác khác. Hành động bắt buộc bị bỏ quên là gọi rollback() để đưa database về trạng thái an toàn trước khi lỗi xảy ra.

    // Phần 2
    public void thanhToanVienPhi(int patientId, int invoiceId, double amount) {

        Connection conn = null;

        try {
            DatabaseMetaData DatabaseManager = null;
            conn = DatabaseManager.getConnection();

            conn.setAutoCommit(false);

            // 1. Trừ tiền
            String sql1 = "UPDATE Patient_Wallet SET balance = balance - ? WHERE patient_id = ?";
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.setDouble(1, amount);
            ps1.setInt(2, patientId);
            ps1.executeUpdate();

            // 2. Update hóa đơn
            String sql2 = "UPDATE Invoicess SET status = 'PAID' WHERE invoice_id = ?";
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setInt(1, invoiceId);
            ps2.executeUpdate();

            // commit
            conn.commit();
            System.out.println("Thanh toán hoàn tất!");

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
