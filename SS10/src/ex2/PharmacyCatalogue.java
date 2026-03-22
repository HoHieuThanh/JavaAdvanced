package ex2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PharmacyCatalogue {
    // Lệnh if (rs.next()) chỉ kiểm tra và di chuyển con trỏ 1 lần đến dòng đầu tiên của ResultSet, nên chỉ in được 1 bản ghi.
    // Gọi next():
    // Nếu có dữ liệu -> di chuyển đến dòng 1
    // Nếu không có -> trả về false
    // Sau đó không lặp lại, nên các dòng tiếp theo không được xử lý

    Statement stmt;
    ResultSet rs;

    {
        try {
            rs = stmt.executeQuery("SELECT medicine_name, stock FROM Pharmacy");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    while (rs.next()) {
            String name = rs.getString("medicine_name");
            int stock = rs.getInt("stock");

            System.out.println("Thuốc: " + name + " - Tồn kho: " + stock);
        }

}
