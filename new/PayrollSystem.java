import java.util.Scanner;

class EmployeeRecord {
    int id;
    String name;
    double basicSalary;
    double hra;
    double da;
    double deduction;
    double netSalary;

    EmployeeRecord(int id, String name, double basicSalary) {
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
        calculateSalary();
    }

    void calculateSalary() {
        hra = basicSalary * 0.2;
        da = basicSalary * 0.1;
        deduction = basicSalary * 0.05;
        netSalary = basicSalary + hra + da - deduction;
    }

    void displaySalarySlip() {
        System.out.println("\n--- Salary Slip ---");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Basic Salary: $" + basicSalary);
        System.out.println("HRA: $" + hra);
        System.out.println("DA: $" + da);
        System.out.println("Deduction: $" + deduction);
        System.out.println("Net Salary: $" + netSalary);
    }
}

public class PayrollSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Basic Salary: ");
        double salary = sc.nextDouble();

        EmployeeRecord employee = new EmployeeRecord(id, name, salary);
        employee.displaySalarySlip();
    }
}
