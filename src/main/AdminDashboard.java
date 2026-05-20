package main;

import java.util.Scanner;
import dao.StudentDAO;

public class AdminDashboard {

    public static void showMenu() {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {

            System.out.println("\n=== ADMIN DASHBOARD ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Exit");

            System.out.print("Choose: ");
            int choice = sc.nextInt();

            sc.nextLine(); // buffer clear

            switch (choice) {

                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Department: ");
                    String dept = sc.nextLine();

                    dao.addStudent(name, email, dept);
                    break;

                case 2:
                    dao.viewStudents();
                    break;

                case 3:
                    System.out.println("Logging out...");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}