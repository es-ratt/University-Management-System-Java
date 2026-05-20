package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.DBConnection;

public class StudentDAO {

    public void addStudent(String name, String email, String dept) {

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "INSERT INTO students(name,email,department) VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, dept);

            ps.executeUpdate();

            System.out.println("Student Added Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewStudents() {

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM students";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n=== STUDENTS LIST ===");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("student_id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("email") + " | " +
                    rs.getString("department")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}