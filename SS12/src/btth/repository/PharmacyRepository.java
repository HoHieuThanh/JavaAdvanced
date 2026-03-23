package btth.repository;

import btth.context.DatabaseConnection;

import java.sql.*;

public class PharmacyRepository {

    // 1: Update stock
    public void updateMedicineStock(int id, int addedQuantity) {

        String sql = "UPDATE medicines SET stock = stock + ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, addedQuantity); // đúng thứ tự
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Cập nhật kho thành công");
            else
                System.out.println("Không tìm thấy thuốc");

        } catch (Exception e) {
            System.out.println("Lỗi update stock");
        }
    }

    // 2: Tìm theo khoảng giá
    public void findMedicinesByPriceRange(double min, double max) {

        String sql = "SELECT * FROM medicines WHERE price BETWEEN ? AND ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, min);
            ps.setDouble(2, max);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " - " +
                                rs.getString("name") + " - " +
                                rs.getDouble("price")
                );
            }

        } catch (Exception e) {
            System.out.println("Lỗi tìm kiếm");
        }
    }

    // 3: Gọi procedure tính tiền đơn thuốc
    public void getPrescriptionTotal(int id) {

        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement call = conn.prepareCall("{call CalculatePrescriptionTotal(?, ?)}")) {

            call.setInt(1, id);
            call.registerOutParameter(2, Types.DECIMAL);

            call.execute();

            double total = call.getDouble(2);

            System.out.println("Tổng tiền đơn thuốc: " + total);

        } catch (Exception e) {
            System.out.println("Lỗi tính tiền");
        }
    }

    // 4: Doanh thu theo ngày
    public void getDailyRevenue(String date) {

        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement call = conn.prepareCall("{call GetDailyRevenue(?, ?)}")) {

            call.setDate(1, Date.valueOf(date));
            call.registerOutParameter(2, Types.DECIMAL);

            call.execute();

            double revenue = call.getDouble(2);

            System.out.println("Doanh thu ngày: " + revenue);

        } catch (Exception e) {
            System.out.println("Lỗi doanh thu");
        }
    }
}
