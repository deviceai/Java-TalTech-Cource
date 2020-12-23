package mywebapp.jdbc;

import java.sql.*;


public class TestConnection {
    public static void main(String[] args) throws Exception {

        Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5433/taltech_course",
                "postgres",
                "postgres");

        try(conn; Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery("SELECT 1");

            if (!rs.next()){
                throw new RuntimeException("error");
            }

            System.out.println(rs.getInt(1));
        }
    }
}
