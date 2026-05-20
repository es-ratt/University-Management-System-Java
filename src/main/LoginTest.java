package main;

import java.util.Scanner;
import dao.UserDAO;

public class LoginTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== UNIVERSITY LOGIN ===");

        System.out.print("Username: ");
        String username = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        UserDAO dao = new UserDAO();
        String role = dao.login(username, password);

        if (role != null) {

            System.out.println("Login Successful!");
            System.out.println("Role: " + role);

            if (role.equals("ADMIN")) {
                AdminDashboard.showMenu();
            }

        } else {
            System.out.println("Invalid Username or Password");
        }
    }
}