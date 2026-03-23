package ex5.repository;

import ex5.context.DatabaseConnection;
import ex5.model.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientRepository {

    // 1. Danh sách bệnh nhân
    public List<Patient> getAll() {

        List<Patient> list = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Patients")) {

            while (rs.next()) {
                list.add(new Patient(
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("department"),
                        rs.getString("disease"),
                        rs.getInt("admission_days")
                ));
            }

        } catch (Exception e) {
            System.out.println("Lỗi lấy danh sách");
        }

        return list;
    }

    // 2. Thêm bệnh nhân (PreparedStatement)
    public void add(Patient p) {

        String sql = "INSERT INTO Patients(name, age, department, disease, admission_days) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getName()); // xử lý được L'Oréal
            ps.setInt(2, p.getAge());
            ps.setString(3, p.getDepartment());
            ps.setString(4, p.getDisease());
            ps.setInt(5, p.getDays());

            ps.executeUpdate();
            System.out.println("Thêm thành công");

        } catch (Exception e) {
            System.out.println("Lỗi thêm");
        }
    }

    // 3. Update bệnh án
    public void updateDisease(int id, String disease) {

        String sql = "UPDATE Patients SET disease=? WHERE id=?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, disease);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Cập nhật thành công");
            else
                System.out.println("Không tìm thấy bệnh nhân");

        } catch (Exception e) {
            System.out.println("Lỗi update");
        }
    }

    // 4. Xuất viện + tính phí (Stored Procedure)
    public void discharge(int id) {

        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement call = conn.prepareCall("{call CALCULATE_DISCHARGE_FEE(?, ?)}")) {

            call.setInt(1, id);
            call.registerOutParameter(2, Types.DECIMAL);

            call.execute();

            double fee = call.getDouble(2);

            System.out.println("Tổng viện phí: " + fee);

        } catch (Exception e) {
            System.out.println("Lỗi tính phí");
        }
    }
}
