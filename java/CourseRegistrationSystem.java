import java.util.*;

class Student {
    int id;
    String name;
    ArrayList<String> courses;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.courses = new ArrayList<>();
    }

    void addCourse(String course) {
        if (courses.contains(course)) {
            System.out.println("Already registered in this course.");
            return;
        }
        courses.add(course);
        System.out.println("Course added.");
    }

    void dropCourse(String course) {
        if (courses.remove(course)) {
            System.out.println("Course dropped.");
        } else {
            System.out.println("Course not found.");
        }
    }

    void displayCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses registered.");
            return;
        }
        System.out.println("Courses: " + courses);
    }

    int countCourses() {
        return courses.size();
    }
}

public class CourseRegistrationSystem {

    static HashMap<Integer, Student> students = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    // 🔹 Add Student
    static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        if (students.containsKey(id)) {
            System.out.println("Student already exists.");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.next();

        students.put(id, new Student(id, name));
        System.out.println("Student added.");
    }

    // 🔹 Register Course
    static void registerCourse() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        Student s = students.get(id);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter Course Name: ");
        String course = sc.next();

        s.addCourse(course);
    }

    // 🔹 Display Courses
    static void displayCourses() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        Student s = students.get(id);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }

        s.displayCourses();
    }

    // 🔹 Drop Course
    static void dropCourse() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        Student s = students.get(id);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter Course Name: ");
        String course = sc.next();

        s.dropCourse(course);
    }

    // 🔹 Count Courses
    static void countCourses() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        Student s = students.get(id);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("Total Courses: " + s.countCourses());
    }

    // 🔹 Menu
    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== Course Registration System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Register Course");
            System.out.println("3. Display Courses");
            System.out.println("4. Drop Course");
            System.out.println("5. Count Courses");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: registerCourse(); break;
                case 3: displayCourses(); break;
                case 4: dropCourse(); break;
                case 5: countCourses(); break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}