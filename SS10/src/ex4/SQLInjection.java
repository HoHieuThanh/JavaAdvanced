package ex4;

import java.sql.ResultSet;

public class SQLInjection {
    public static void main(String[] args) {

        // Sau khi nối chuỗi, câu SQL trở thành:
        // SELECT * FROM Patients WHERE full_name = '' OR '1'='1'
        // '1' = '1' thì luôn true, có toán tử OR thì WHERE sẽ luôn true

//        String patientName = " ' OR '1'='1";
//        String sql = "SELECT * FROM Patients WHERE full_name = '" + patientName + "'";
//        ResultSet rs = stmt.executeQuery(sql);
        String patientName = inputName;
        patientName = patientName.replace("'", "")
                .replace("--", "")
                .replace(";", "");

        String sql = "SELECT * FROM Patients WHERE full_name = '" + patientName + "'";

        ResultSet rs = stmt.executeQuery(sql);

    }
}
