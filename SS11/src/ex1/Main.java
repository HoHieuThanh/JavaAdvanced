package ex1;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DBContextFixed.getConnection();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }finally {
            DBContextFixed.closeConnection(conn);
        }
    }
}
