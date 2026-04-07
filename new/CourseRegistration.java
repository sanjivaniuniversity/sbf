import java.util.ArrayList;
import java.util.Scanner;

class CourseStudent {
    int id;
    String name;
    ArrayList<String> courses = new ArrayList<>();

    CourseStudent(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class CourseRegistration {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<CourseStudent> students = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Course Registration Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Register Course");
            System.out.println("3. Display Courses");
            System.out.println("4. Drop Course");
            System.out.println("5. Count Courses");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> registerCourse();
                case 3 -> displayCourses();
                case 4 -> dropCourse();
                case 5 -> countCourses();
                case 6 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }

    static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        students.add(new CourseStudent(id, name));
        System.out.println("Student added!");
    }

    static CourseStudent findStudent(int id) {
        for (CourseStudent student : students) {
            if (student.id == id) {
                return student;
            }
        }
        return null;
    }

    static void registerCourse() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        CourseStudent student = findStudent(id);

        if (student != null) {
            System.out.print("Enter Course Name to register: ");
            String course = sc.nextLine();
            student.courses.add(course);
            System.out.println("Course registered!");
        } else {
            System.out.println("Student not found!");
        }
    }

    static void displayCourses() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        CourseStudent student = findStudent(id);

        if (student != null) {
            System.out.println("Registered Courses: " + student.courses);
        } else {
            System.out.println("Student not found!");
        }
    }

    static void dropCourse() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        CourseStudent student = findStudent(id);

        if (student != null) {
            System.out.print("Enter Course Name to drop: ");
            String course = sc.nextLine();
            if (student.courses.remove(course)) {
                System.out.println("Course dropped!");
            } else {
                System.out.println("Course not found!");
            }
        } else {
            System.out.println("Student not found!");
        }
    }

    static void countCourses() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        CourseStudent student = findStudent(id);

        if (student != null) {
            System.out.println("Total courses registered: " + student.courses.size());
        } else {
            System.out.println("Student not found!");
        }
    }
}
