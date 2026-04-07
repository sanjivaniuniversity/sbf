import java.util.ArrayList;
import java.util.Scanner;

class StudentRecord {
    int id;
    String name;
    String branch;
    double marks;

    StudentRecord(int id, String name, String branch, double marks) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.marks = marks;
    }

    public String toString() {
        return id + " | " + name + " | " + branch + " | " + marks;
    }
}

public class StudentManagementSystem {
    static ArrayList<StudentRecord> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n1.Add 2.Display 3.Search 4.Update 5.Delete 6.Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> displayStudents();
                case 3 -> searchStudent();
                case 4 -> updateStudent();
                case 5 -> deleteStudent();
                case 6 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }

    static void addStudent() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Branch: ");
        String branch = sc.nextLine();
        System.out.print("Marks: ");
        double marks = sc.nextDouble();

        students.add(new StudentRecord(id, name, branch, marks));
        System.out.println("Student added!");
    }

    static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No records.");
            return;
        }

        students.forEach(System.out::println);
    }

    static void searchStudent() {
        System.out.print("ID to search: ");
        int id = sc.nextInt();

        students.stream()
                .filter(student -> student.id == id)
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("Not found."));
    }

    static void updateStudent() {
        System.out.print("ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        students.stream()
                .filter(student -> student.id == id)
                .findFirst()
                .ifPresentOrElse(student -> {
                    System.out.print("New Name: ");
                    student.name = sc.nextLine();
                    System.out.print("New Branch: ");
                    student.branch = sc.nextLine();
                    System.out.print("New Marks: ");
                    student.marks = sc.nextDouble();
                    System.out.println("Updated!");
                }, () -> System.out.println("Not found."));
    }

    static void deleteStudent() {
        System.out.print("ID to delete: ");
        int id = sc.nextInt();

        boolean removed = students.removeIf(student -> student.id == id);
        System.out.println(removed ? "Deleted!" : "Not found.");
    }
}
