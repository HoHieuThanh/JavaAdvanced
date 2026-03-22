package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
    public Connection getHospitalConn(){
        // Mỗi lần gọi hàm đều tạo connection mới nhưng không đóng lại, dẫn đến sau một thời gian số lượng connection đạt giới hạn làm hệ thống bị treo hoặc không truy cập được database do chiếm bộ nhớ.
        try {
            return DriverManager.getConnection("jdbc:mysql://192.168.1.10:3306/Hospital_DB", "admin", "med123");
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
