# 🧩 Java Concepts Used — Student Management System

A quick-reference guide explaining **how and why** each Java concept was applied.
Perfect for interview preparation.

---

## 1. Classes and Objects

A **class** is a blueprint; an **object** is a real instance of it.

```java
// Blueprint (class)
public class Student { ... }

// Object created from the blueprint
Student s = new Student(1001, "Aarav Sharma", 21, "B.Tech CS", 8.75, "aarav@college.edu");
```

Three classes in this project, each with a single responsibility:
- `Student` → models data
- `StudentManagementSystem` → handles logic
- `Main` → handles user interaction

---

## 2. Encapsulation

Fields are `private`; access is controlled via `public` getters and setters.

```java
private String name;           // nobody can change this directly

public String getName()        { return name; }          // read
public void   setName(String n){ this.name = n; }        // controlled write
```

**Why?** Prevents invalid data from being set directly (e.g., setting age to -5).

---

## 3. Constructors

A constructor runs once when an object is created. Ours takes all fields as parameters so every Student is fully initialised immediately.

```java
public Student(int studentId, String name, int age, String course, double cgpa, String email) {
    this.studentId = studentId;
    this.name      = name;
    // ...
}
```

---

## 4. ArrayList

```java
ArrayList<Student> studentList = new ArrayList<>();

studentList.add(student);         // add
studentList.remove(student);      // delete
for (Student s : studentList) {}  // iterate
studentList.size();               // count
```

**Why ArrayList over array?**  
Arrays need a fixed size at creation. ArrayList resizes automatically, which suits a system where the number of students isn't known in advance.

---

## 5. Exception Handling

```java
try {
    int id = scanner.nextInt();   // could throw InputMismatchException
} catch (InputMismatchException e) {
    System.out.println("[ERROR] Please enter a number.");
    scanner.nextLine();           // clear the bad token from the buffer
}
```

Exceptions caught in this project:
- `InputMismatchException` — user types letters where a number is expected
- `NumberFormatException` — caught when parsing strings to int/double

---

## 6. Loops

**while loop** — keeps the menu alive until the user exits:
```java
while (running) {
    printMenu();
    // get choice, process
}
```

**for-each loop** — iterates the student list cleanly:
```java
for (Student s : studentList) {
    System.out.println(s);
}
```

---

## 7. Switch-Case

Cleaner than a long chain of if-else for discrete menu choices:

```java
switch (choice) {
    case 1: sms.addStudent();       break;
    case 2: sms.viewAllStudents();  break;
    // ...
    default: System.out.println("Invalid choice");
}
```

---

## 8. Method Overriding — toString()

`toString()` is a method inherited from Java's `Object` class.
We **override** it so `System.out.println(student)` prints a formatted table row instead of a memory address.

```java
@Override
public String toString() {
    return String.format("| %-6d | %-20s | ...", studentId, name, ...);
}
```

---

## 9. Linear Search

Finding a student by ID uses a simple loop — no external libraries needed:

```java
private Student findStudentById(int id) {
    for (Student s : studentList) {
        if (s.getStudentId() == id) return s;
    }
    return null;
}
```

Return `null` when not found → caller checks `if (student == null)`.

---

## Common Interview Questions & Answers

**Q: What is the difference between `==` and `.equals()`?**  
`==` checks if two references point to the same object in memory. `.equals()` checks if two objects have the same content/value.

**Q: What is `this` keyword?**  
`this` refers to the current object. Used in constructors to distinguish between the parameter `name` and the field `this.name`.

**Q: What happens if you don't call `scanner.nextLine()` after `scanner.nextInt()`?**  
`nextInt()` reads the number but leaves the newline character in the buffer. The next `nextLine()` call reads that leftover newline as an empty string. Calling `scanner.nextLine()` immediately after consumes and discards it.

**Q: Why is your `findStudentById` method `private`?**  
It's an internal helper used only within `StudentManagementSystem`. Making it `private` follows encapsulation — it's an implementation detail, not part of the public API.
