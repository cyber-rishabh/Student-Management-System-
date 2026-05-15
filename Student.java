/**
 * Student.java
 * Represents a Student entity with all relevant details.
 * Demonstrates: Encapsulation, Constructors, Getters/Setters
 */
public class Student {

    // ── Private fields (Encapsulation) ──────────────────────────────────────
    private int    studentId;
    private String name;
    private int    age;
    private String course;
    private double cgpa;
    private String email;

    // ── Parameterized Constructor ────────────────────────────────────────────
    public Student(int studentId, String name, int age, String course, double cgpa, String email) {
        this.studentId = studentId;
        this.name      = name;
        this.age       = age;
        this.course    = course;
        this.cgpa      = cgpa;
        this.email     = email;
    }

    // ── Getters ─────────────────────────────────────────────────────────────
    public int    getStudentId() { return studentId; }
    public String getName()      { return name;      }
    public int    getAge()       { return age;        }
    public String getCourse()    { return course;     }
    public double getCgpa()      { return cgpa;       }
    public String getEmail()     { return email;      }

    // ── Setters ─────────────────────────────────────────────────────────────
    public void setName(String name)      { this.name   = name;   }
    public void setAge(int age)           { this.age    = age;    }
    public void setCourse(String course)  { this.course = course; }
    public void setCgpa(double cgpa)      { this.cgpa   = cgpa;   }
    public void setEmail(String email)    { this.email  = email;  }

    // ── Display helper ───────────────────────────────────────────────────────
    /**
     * Returns a neatly formatted string representation of the student.
     * Called by System.out.println(student).
     */
    @Override
    public String toString() {
        return String.format(
            "| %-6d | %-20s | %-4d | %-25s | %-5.2f | %-28s |",
            studentId, name, age, course, cgpa, email
        );
    }
}
