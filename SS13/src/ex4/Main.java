package ex4;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public List<BenhNhanDTO> getDashboardData() {

        List<BenhNhanDTO> result = new ArrayList<>();
        Map<Integer, BenhNhanDTO> map = new HashMap<>();

        String sql = """
        SELECT b.id, b.name, 
               d.id AS dv_id, d.name AS dv_name
        FROM BenhNhan b
        LEFT JOIN DichVuSuDung d 
        ON b.id = d.maBenhNhan
    """;

        Statement DatabaseManager = null;
        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                int id = rs.getInt("id");
                if (!map.containsKey(id)) {
                    BenhNhanDTO bn = new BenhNhanDTO();
                    bn.setId(id);
                    bn.setName(rs.getString("name"));
                    bn.setDsDichVu(new ArrayList<>());

                    map.put(id, bn);
                }

                BenhNhanDTO bn = map.get(id);

                // BẪY 2: LEFT JOIN có thể NULL dịch vụ
                int dvId = rs.getInt("dv_id");

                if (!rs.wasNull()) { // tránh NullPointer
                    DichVu dv = new DichVu();
                    dv.setId(dvId);
                    dv.setName(rs.getString("dv_name"));

                    bn.getDsDichVu().add(dv);
                }
            }

            result.addAll(map.values());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
