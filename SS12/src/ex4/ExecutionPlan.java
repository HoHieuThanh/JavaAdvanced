package ex4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecutionPlan {
    public static void main(String[] args) throws SQLException {
        //Mỗi lần lặp DB phải:
        //Parse SQL (phân tích cú pháp)
        //Tạo Execution Plan (kế hoạch thực thi)
        //Nếu 1000 bản ghi → làm lại 1000 lần
        //Gây:
        //Tốn CPU DB Server
        //Tăng thời gian xử lý
        //Hiệu năng rất chậm
//        for (TestResult tr: list){
//            String sql = "INSERT INTO Results(data) VALUES('" + tr.getData() + "')";
//            Statement stmt = conn.createStatement();
//            stmt.executeUpdate(sql);
//        }

        String sql = "INSERT INTO Results(data) VALUES(?)";

        Connection conn = null;
        PreparedStatement ps = conn.prepareStatement(sql);

        for (TestResult tr : list) {
            ps.setString(1, tr.getData());
            ps.executeUpdate();
        }

        ps.close();

    }
}
