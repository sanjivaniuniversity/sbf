import java.io.*;
import java.util.*;

class Student implements Serializable {
    int id;
    String name;
    String branch;
    double marks;

    Student(int id, String name, String branch, double marks) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.marks = marks;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name +
               ", Branch: " + branch + ", Marks: " + marks;
    }
}

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static final String FILE_NAME = "students.dat";

    // 🔹 Load data from file
    static void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            students = (ArrayList<Student>) ois.readObject();
        } catch (Exception e) {
            // file may not exist first time
        }
    }

    // 🔹 Save data to file
    static void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
        } catch (Exception e) {
            System.out.println("Error saving data");
        }
    }

    // 🔹 Add student
    static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.id == id) {
                System.out.println("ID already exists!");
                return;
            }
        }

        System.out.print("Enter Name: ");
        String name = sc.next();

        System.out.print("Enter Branch: ");
        String branch = sc.next();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        students.add(new Student(id, name, branch, marks));
        saveToFile();
        System.out.println("Student added successfully.");
    }

    // 🔹 Display all
    static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No records found.");
            return;
        }

        for (Student s : students) {
            System.out.println(s);
        }
    }

    // 🔹 Search
    static void searchStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.id == id) {
                System.out.println("Found: " + s);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // 🔹 Update
    static void updateStudent() {
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.id == id) {
                System.out.print("Enter new Name: ");
                s.name = sc.next();

                System.out.print("Enter new Branch: ");
                s.branch = sc.next();

                System.out.print("Enter new Marks: ");
                s.marks = sc.nextDouble();

                saveToFile();
                System.out.println("Updated successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // 🔹 Delete
    static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        Iterator<Student> it = students.iterator();

        while (it.hasNext()) {
            Student s = it.next();
            if (s.id == id) {
                it.remove();
                saveToFile();
                System.out.println("Deleted successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // 🔹 Main Menu
    public static void main(String[] args) {
        loadFromFile();

        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All");
            System.out.println("3. Search by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: displayStudents(); break;
                case 3: searchStudent(); break;
                case 4: updateStudent(); break;
                case 5: deleteStudent(); break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}