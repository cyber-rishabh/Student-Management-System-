import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * StudentManagementSystem.java
 * Contains all CRUD operations for managing student records.
 * Demonstrates: ArrayList, Exception Handling, Methods, OOP
 */
public class StudentManagementSystem {

    // ── In-memory data store ─────────────────────────────────────────────────
    private ArrayList<Student> studentList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // ── Table border constants ───────────────────────────────────────────────
    private static final String HEADER =
        "+--------+----------------------+------+---------------------------+-------+------------------------------+";
    private static final String COL_TITLES =
        "| ID     | Name                 | Age  | Course                    | CGPA  | Email                        |";

    // ════════════════════════════════════════════════════════════════════════
    //  Constructor – pre-loads sample records
    // ════════════════════════════════════════════════════════════════════════
    public StudentManagementSystem() {
        loadSampleData();
    }

    /**
     * Pre-loads realistic sample students so the app is immediately usable.
     */
    private void loadSampleData() {
        studentList.add(new Student(1001, "Aarav Sharma",   21, "B.Tech Computer Science",  8.75, "aarav.sharma@college.edu"));
        studentList.add(new Student(1002, "Priya Verma",    20, "B.Tech Information Tech",  9.10, "priya.verma@college.edu"));
        studentList.add(new Student(1003, "Rahul Gupta",    22, "B.Tech Electronics",       7.85, "rahul.gupta@college.edu"));
        studentList.add(new Student(1004, "Sneha Patel",    21, "BCA",                      8.40, "sneha.patel@college.edu"));
        studentList.add(new Student(1005, "Karan Mehta",    23, "MCA",                      8.95, "karan.mehta@college.edu"));
    }

    // ════════════════════════════════════════════════════════════════════════
    //  1. ADD STUDENT
    // ════════════════════════════════════════════════════════════════════════
    public void addStudent() {
        System.out.println("\n╔══════════════════════════════╗");
        System.out.println("║       ADD NEW STUDENT        ║");
        System.out.println("╚══════════════════════════════╝");

        try {
            System.out.print("  Enter Student ID   : ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume leftover newline

            // Check for duplicate ID
            if (findStudentById(id) != null) {
                System.out.println("  [ERROR] Student ID " + id + " already exists!");
                return;
            }

            System.out.print("  Enter Name         : ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) { System.out.println("  [ERROR] Name cannot be empty."); return; }

            System.out.print("  Enter Age          : ");
            int age = scanner.nextInt();
            if (age < 15 || age > 60) { System.out.println("  [ERROR] Age must be between 15 and 60."); return; }
            scanner.nextLine();

            System.out.print("  Enter Course       : ");
            String course = scanner.nextLine().trim();

            System.out.print("  Enter CGPA (0-10)  : ");
            double cgpa = scanner.nextDouble();
            if (cgpa < 0.0 || cgpa > 10.0) { System.out.println("  [ERROR] CGPA must be between 0.0 and 10.0."); return; }
            scanner.nextLine();

            System.out.print("  Enter Email        : ");
            String email = scanner.nextLine().trim();

            // Create and store new Student object
            Student newStudent = new Student(id, name, age, course, cgpa, email);
            studentList.add(newStudent);

            System.out.println("\n  [SUCCESS] Student added successfully!");
            System.out.println("  " + newStudent.getName() + " (ID: " + newStudent.getStudentId() + ") has been enrolled.");

        } catch (InputMismatchException e) {
            System.out.println("  [ERROR] Invalid input! Please enter the correct data type.");
            scanner.nextLine(); // clear bad input from buffer
        }
    }

    // ════════════════════════════════════════════════════════════════════════
    //  2. VIEW ALL STUDENTS
    // ════════════════════════════════════════════════════════════════════════
    public void viewAllStudents() {
        System.out.println("\n╔══════════════════════════════╗");
        System.out.println("║      ALL STUDENT RECORDS     ║");
        System.out.println("╚══════════════════════════════╝");

        if (studentList.isEmpty()) {
            System.out.println("  No student records found.");
            return;
        }

        printTableHeader();
        for (Student s : studentList) {
            System.out.println(s);   // calls Student.toString()
        }
        System.out.println(HEADER);
        System.out.println("  Total students: " + studentList.size());
    }

    // ════════════════════════════════════════════════════════════════════════
    //  3. SEARCH STUDENT BY ID
    // ════════════════════════════════════════════════════════════════════════
    public void searchStudentById() {
        System.out.println("\n╔══════════════════════════════╗");
        System.out.println("║     SEARCH STUDENT BY ID     ║");
        System.out.println("╚══════════════════════════════╝");

        try {
            System.out.print("  Enter Student ID to search: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Student found = findStudentById(id);
            if (found != null) {
                System.out.println("\n  Student found:\n");
                printTableHeader();
                System.out.println(found);
                System.out.println(HEADER);
            } else {
                System.out.println("  [NOT FOUND] No student with ID " + id + " exists.");
            }

        } catch (InputMismatchException e) {
            System.out.println("  [ERROR] Invalid ID format. Please enter a number.");
            scanner.nextLine();
        }
    }

    // ════════════════════════════════════════════════════════════════════════
    //  4. UPDATE STUDENT DETAILS
    // ════════════════════════════════════════════════════════════════════════
    public void updateStudent() {
        System.out.println("\n╔══════════════════════════════╗");
        System.out.println("║      UPDATE STUDENT INFO     ║");
        System.out.println("╚══════════════════════════════╝");

        try {
            System.out.print("  Enter Student ID to update: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Student student = findStudentById(id);
            if (student == null) {
                System.out.println("  [NOT FOUND] No student with ID " + id + ".");
                return;
            }

            System.out.println("  Found: " + student.getName() + ". Enter new details (press Enter to keep current):\n");

            System.out.print("  New Name   [" + student.getName()   + "]: ");
            String name = scanner.nextLine().trim();
            if (!name.isEmpty()) student.setName(name);

            System.out.print("  New Age    [" + student.getAge()    + "]: ");
            String ageStr = scanner.nextLine().trim();
            if (!ageStr.isEmpty()) {
                int age = Integer.parseInt(ageStr);
                if (age >= 15 && age <= 60) student.setAge(age);
                else System.out.println("  [WARN] Age out of range – kept existing value.");
            }

            System.out.print("  New Course [" + student.getCourse() + "]: ");
            String course = scanner.nextLine().trim();
            if (!course.isEmpty()) student.setCourse(course);

            System.out.print("  New CGPA   [" + student.getCgpa()   + "]: ");
            String cgpaStr = scanner.nextLine().trim();
            if (!cgpaStr.isEmpty()) {
                double cgpa = Double.parseDouble(cgpaStr);
                if (cgpa >= 0.0 && cgpa <= 10.0) student.setCgpa(cgpa);
                else System.out.println("  [WARN] CGPA out of range – kept existing value.");
            }

            System.out.print("  New Email  [" + student.getEmail()  + "]: ");
            String email = scanner.nextLine().trim();
            if (!email.isEmpty()) student.setEmail(email);

            System.out.println("\n  [SUCCESS] Student record updated successfully!");

        } catch (NumberFormatException e) {
            System.out.println("  [ERROR] Invalid number format entered.");
        } catch (InputMismatchException e) {
            System.out.println("  [ERROR] Invalid input type.");
            scanner.nextLine();
        }
    }

    // ════════════════════════════════════════════════════════════════════════
    //  5. DELETE STUDENT RECORD
    // ════════════════════════════════════════════════════════════════════════
    public void deleteStudent() {
        System.out.println("\n╔══════════════════════════════╗");
        System.out.println("║     DELETE STUDENT RECORD    ║");
        System.out.println("╚══════════════════════════════╝");

        try {
            System.out.print("  Enter Student ID to delete: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Student student = findStudentById(id);
            if (student == null) {
                System.out.println("  [NOT FOUND] No student with ID " + id + ".");
                return;
            }

            System.out.print("  Are you sure you want to delete " + student.getName() + "? (yes/no): ");
            String confirm = scanner.nextLine().trim().toLowerCase();

            if (confirm.equals("yes")) {
                studentList.remove(student);
                System.out.println("  [SUCCESS] Student record deleted successfully.");
            } else {
                System.out.println("  Delete operation cancelled.");
            }

        } catch (InputMismatchException e) {
            System.out.println("  [ERROR] Invalid ID format.");
            scanner.nextLine();
        }
    }

    // ════════════════════════════════════════════════════════════════════════
    //  HELPER – Find student by ID (linear search through ArrayList)
    // ════════════════════════════════════════════════════════════════════════
    private Student findStudentById(int id) {
        for (Student s : studentList) {
            if (s.getStudentId() == id) {
                return s;
            }
        }
        return null; // not found
    }

    // ════════════════════════════════════════════════════════════════════════
    //  HELPER – Print table header
    // ════════════════════════════════════════════════════════════════════════
    private void printTableHeader() {
        System.out.println(HEADER);
        System.out.println(COL_TITLES);
        System.out.println(HEADER);
    }
}
