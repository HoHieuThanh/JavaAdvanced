package practice.repository;


import practice.context.DatabaseConnection;
import practice.model.Appointment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentRepository {

    // 1. Thêm
    public void addAppointment(Appointment a) {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseConnection.getConnection();

            String sql = "INSERT INTO appointments(patient_name, appointment_date, doctor_name, status) VALUES (?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);

            ps.setString(1, a.getPatientName());
            ps.setDate(2, a.getAppointmentDate());
            ps.setString(3, a.getDoctorName());
            ps.setString(4, a.getStatus());

            ps.executeUpdate();
            System.out.println("Thêm lịch khám thành công");

        } catch (Exception e) {
            System.out.println("Lỗi thêm: " + e.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {}
        }
    }

    // 2. Update
    public void updateAppointment(Appointment a) {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseConnection.getConnection();

            String sql = "UPDATE appointments SET patient_name=?, appointment_date=?, doctor_name=?, status=? WHERE id=?";
            ps = conn.prepareStatement(sql);

            ps.setString(1, a.getPatientName());
            ps.setDate(2, a.getAppointmentDate());
            ps.setString(3, a.getDoctorName());
            ps.setString(4, a.getStatus());
            ps.setInt(5, a.getId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Cập nhật thành công");
            } else {
                System.out.println("Không tìm thấy ID");
            }

        } catch (Exception e) {
            System.out.println("Lỗi update");
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {}
        }
    }

    // 3. Delete
    public void deleteAppointment(int id) {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseConnection.getConnection();

            String sql = "DELETE FROM appointments WHERE id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Xóa thành công");
            } else {
                System.out.println("Không tìm thấy ID");
            }

        } catch (Exception e) {
            System.out.println("Lỗi delete");
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {}
        }
    }

    // 4. Get by ID
    public Appointment getAppointmentById(int id) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM appointments WHERE id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                return new Appointment(
                        rs.getInt("id"),
                        rs.getString("patient_name"),
                        rs.getDate("appointment_date"),
                        rs.getString("doctor_name"),
                        rs.getString("status")
                );
            }

        } catch (Exception e) {
            System.out.println("Lỗi tìm ID");
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {}
        }

        return null;
    }

    // 5. Get all
    public List<Appointment> getAllAppointments() {

        List<Appointment> list = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            stmt = conn.createStatement();

            String sql = "SELECT * FROM appointments";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                list.add(new Appointment(
                        rs.getInt("id"),
                        rs.getString("patient_name"),
                        rs.getDate("appointment_date"),
                        rs.getString("doctor_name"),
                        rs.getString("status")
                ));
            }

        } catch (Exception e) {
            System.out.println("Lỗi lấy danh sách");
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {}
        }

        return list;
    }
}

