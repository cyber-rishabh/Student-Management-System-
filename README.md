# 📚 Student Management System

A console-based **Student Management System** built with **Core Java** and **Object-Oriented Programming** concepts — designed to be clear, interview-ready, and suitable for a campus placement portfolio (e.g., Cognizant Java FSE).

---

## 🖥️ Sample Output

```
  Welcome to the Student Management System!
  Sample data has been pre-loaded for demonstration.

╔═══════════════════════════════════════╗
║      STUDENT MANAGEMENT SYSTEM        ║
╠═══════════════════════════════════════╣
║   1. Add Student                      ║
║   2. View All Students                ║
║   3. Search Student by ID             ║
║   4. Update Student Details           ║
║   5. Delete Student Record            ║
║   0. Exit                             ║
╚═══════════════════════════════════════╝
  Enter your choice: 2

╔══════════════════════════════╗
║      ALL STUDENT RECORDS     ║
╚══════════════════════════════╝
+--------+----------------------+------+---------------------------+-------+------------------------------+
| ID     | Name                 | Age  | Course                    | CGPA  | Email                        |
+--------+----------------------+------+---------------------------+-------+------------------------------+
| 1001   | Aarav Sharma         | 21   | B.Tech Computer Science   | 8.75  | aarav.sharma@college.edu     |
| 1002   | Priya Verma          | 20   | B.Tech Information Tech   | 9.10  | priya.verma@college.edu      |
| 1003   | Rahul Gupta          | 22   | B.Tech Electronics        | 7.85  | rahul.gupta@college.edu      |
| 1004   | Sneha Patel          | 21   | BCA                       | 8.40  | sneha.patel@college.edu      |
| 1005   | Karan Mehta          | 23   | MCA                       | 8.95  | karan.mehta@college.edu      |
+--------+----------------------+------+---------------------------+-------+------------------------------+
  Total students: 5
```

---

## 🗂️ Project Structure

```
StudentManagementSystem/
├── src/
│   ├── Main.java                   # Entry point — menu loop & switch-case
│   ├── Student.java                # Student model — encapsulation, constructors
│   └── StudentManagementSystem.java  # Business logic — CRUD, ArrayList, exceptions
├── README.md
└── CONCEPTS.md
```

---

## ▶️ How to Run

### Prerequisites
- Java JDK 8 or higher installed
- Any terminal / command prompt

### Steps

```bash
# 1. Clone or download the project
git clone https://github.com/your-username/StudentManagementSystem.git
cd StudentManagementSystem/src

# 2. Compile all Java files
javac Main.java Student.java StudentManagementSystem.java

# 3. Run the application
java Main
```

> **Tip:** If you're using an IDE (IntelliJ IDEA / Eclipse / VS Code), open the `src/` folder as the project root and run `Main.java`.

---

## ✨ Features

| # | Feature | Description |
|---|---------|-------------|
| 1 | **Add Student** | Enroll a new student with validation |
| 2 | **View All Students** | Display all records in a formatted table |
| 3 | **Search by ID** | Find a specific student by their unique ID |
| 4 | **Update Details** | Modify any student field (keeps existing on blank input) |
| 5 | **Delete Record** | Remove a student with a confirmation prompt |
| — | **Sample Data** | 5 realistic pre-loaded students for demo |

---

## 🧠 Java Concepts Demonstrated

| Concept | Where Used |
|---------|-----------|
| **Classes & Objects** | `Student`, `StudentManagementSystem`, `Main` |
| **Encapsulation** | Private fields + public getters/setters in `Student.java` |
| **Constructors** | Parameterized constructor in `Student.java` |
| **ArrayList** | `ArrayList<Student>` for in-memory data storage |
| **Exception Handling** | `try-catch` for `InputMismatchException`, `NumberFormatException` |
| **Loops** | `while` loop for menu, `for-each` for displaying records |
| **Switch-case** | Menu navigation in `Main.java` |
| **Methods** | Modular methods for each CRUD operation |
| **`@Override` / `toString()`** | Custom table-row format in `Student.java` |
| **Scanner** | User input from console |

---

## 🎯 Interview Tips

**Q: Why did you use ArrayList instead of an array?**  
A: ArrayList grows dynamically — we don't know in advance how many students will be added. Arrays have a fixed size, making ArrayList more practical here.

**Q: How is encapsulation applied?**  
A: All fields in `Student.java` are `private`. External classes can only access them via public getters/setters, protecting data integrity.

**Q: How does your exception handling work?**  
A: `InputMismatchException` is caught when a user types text where a number is expected (e.g., entering "abc" for Age). The scanner buffer is cleared and the user gets a friendly error message.

**Q: What would you improve with more time?**  
A: File persistence (saving to `.txt` or `.csv`), a basic GUI using Java Swing, or replacing ArrayList with a HashMap for O(1) ID lookups.

---

## 👤 Author

**Your Name**  
B.Tech Computer Science | 2025 Batch  
GitHub: [github.com/your-username](https://github.com/your-username)
