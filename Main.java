import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main.java
 * Entry point of the Student Management System.
 * Demonstrates: menu-driven programming, loops, switch-case, Scanner
 *
 * Author  : Student Developer
 * Version : 1.0
 * Purpose : Campus placement / interview project
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        System.out.println("\n  Welcome to the Student Management System!");
        System.out.println("  Sample data has been pre-loaded for demonstration.\n");

        boolean running = true;

        // ── Menu loop ────────────────────────────────────────────────────────
        while (running) {
            printMenu();

            try {
                System.out.print("  Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        sms.addStudent();
                        break;
                    case 2:
                        sms.viewAllStudents();
                        break;
                    case 3:
                        sms.searchStudentById();
                        break;
                    case 4:
                        sms.updateStudent();
                        break;
                    case 5:
                        sms.deleteStudent();
                        break;
                    case 0:
                        System.out.println("\n  Thank you for using Student Management System. Goodbye!\n");
                        running = false;
                        break;
                    default:
                        System.out.println("  [ERROR] Invalid choice. Please enter a number from 0 to 5.");
                }

            } catch (InputMismatchException e) {
                System.out.println("  [ERROR] Please enter a valid numeric choice.");
                scanner.nextLine(); // clear bad input
            }

            // Pause between operations for readability
            if (running) {
                System.out.println("\n  Press Enter to continue...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    // ── Menu display ─────────────────────────────────────────────────────────
    private static void printMenu() {
        System.out.println("\n╔═══════════════════════════════════════╗");
        System.out.println("║      STUDENT MANAGEMENT SYSTEM        ║");
        System.out.println("╠═══════════════════════════════════════╣");
        System.out.println("║   1. Add Student                      ║");
        System.out.println("║   2. View All Students                ║");
        System.out.println("║   3. Search Student by ID             ║");
        System.out.println("║   4. Update Student Details           ║");
        System.out.println("║   5. Delete Student Record            ║");
        System.out.println("║   0. Exit                             ║");
        System.out.println("╚═══════════════════════════════════════╝");
    }
}
