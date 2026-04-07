import java.util.*;

class Employee {
    int id;
    String name;
    double basicSalary;

    Employee(int id, String name, double basicSalary) {
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
    }

    // 💰 Calculate Salary
    void generateSalarySlip() {

        double hra = basicSalary * 0.20;   // 20% HRA
        double da  = basicSalary * 0.10;   // 10% DA
        double deduction = basicSalary * 0.05; // 5% deduction

        double netSalary = basicSalary + hra + da - deduction;

        System.out.println("\n===== Salary Slip =====");
        System.out.println("Employee ID   : " + id);
        System.out.println("Name          : " + name);
        System.out.println("Basic Salary  : ₹" + basicSalary);
        System.out.println("HRA (20%)     : ₹" + hra);
        System.out.println("DA (10%)      : ₹" + da);
        System.out.println("Deduction (5%): ₹" + deduction);
        System.out.println("----------------------------");
        System.out.println("Net Salary    : ₹" + netSalary);
    }
}

public class PayrollSystem {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Employee> employees = new ArrayList<>();

    // 🔹 Add Employee
    static void addEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Name: ");
        String name = sc.next();

        System.out.print("Enter Basic Salary: ");
        double salary = sc.nextDouble();

        employees.add(new Employee(id, name, salary));
        System.out.println("Employee added.");
    }

    // 🔹 Display Salary Slips
    static void displaySalarySlips() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        for (Employee e : employees) {
            e.generateSalarySlip();
        }
    }

    // 🔹 Menu
    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== Payroll System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Salary Slips");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: addEmployee(); break;
                case 2: displaySalarySlips(); break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}