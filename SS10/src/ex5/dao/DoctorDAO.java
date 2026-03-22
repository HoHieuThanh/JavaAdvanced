package ex5.dao;

import demo.ConnectMySql;
import ex5.model.Doctor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

    public List<Doctor> getAllDoctors() {

        List<Doctor> list = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectMySql.connection();
            stmt = conn.createStatement();

            String sql = "SELECT * FROM Doctors";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Doctor d = new Doctor(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("specialty")
                );
                list.add(d);
            }

        } catch (Exception e) {
            System.out.println("Lỗi lấy danh sách bác sĩ");
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    public boolean addDoctor(Doctor d) {

        Connection conn = null;
        Statement stmt = null;

        try {
            conn = ConnectMySql.connection();
            stmt = conn.createStatement();

            String id = d.getId().replace("'", "");
            String name = d.getName().replace("'", "");
            String sp = d.getSpecialty().replace("'", "");

            String sql = "INSERT INTO Doctors VALUES ('"
                    + id + "', '"
                    + name + "', '"
                    + sp + "')";

            int rows = stmt.executeUpdate(sql);

            return rows > 0;

        } catch (Exception e) {
            System.out.println("Lỗi thêm bác sĩ: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    public void countBySpecialty() {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectMySql.connection();
            stmt = conn.createStatement();

            String sql = "SELECT specialty, COUNT(*) AS total FROM Doctors GROUP BY specialty";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(
                        rs.getString("specialty") + ": " +
                                rs.getInt("total")
                );
            }

        } catch (Exception e) {
            System.out.println("Lỗi thống kê");
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
