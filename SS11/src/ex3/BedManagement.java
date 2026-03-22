package ex3;

public class BedManagement {
    public static void main(String[] args) {
        // executeUpdate() trả về số dòng bị ảnh hưởng, nếu bằng 0 thì dữ liệu không tồn tại.
        //    String sql = "UPDATE Beds Set bed status = 'Occupied' WHERE bed_id = " + inputId;
        //    stmt.executeUpdate(sql);
        //        System.out.println("Đã cập nhật");
        String sql = "UPDATE Beds SET bed_status = 'Occupied' WHERE bed_id = " + inputId;

        int rowsAffected = stmt.executeUpdate(sql);

        if (rowsAffected > 0) {
            System.out.println("Đã cập nhật trạng thái giường thành công");
        } else {
            System.out.println("Mã giường không tồn tại");
        }

    }
}
