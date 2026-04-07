import java.util.*;

// Class to store Consumer details
class Consumer {
    int consumerId;
    String name;
    int unitsConsumed;
    double billAmount;

    // Constructor
    Consumer(int consumerId, String name, int unitsConsumed) {
        this.consumerId = consumerId;
        this.name = name;
        this.unitsConsumed = unitsConsumed;
        this.billAmount = calculateBill(unitsConsumed);
    }

    // Method to calculate bill based on slab rates
    double calculateBill(int units) {
        double amount = 0;

        if (units <= 100) {
            amount = units * 5;
        } 
        else if (units <= 200) {
            amount = (100 * 5) + (units - 100) * 7;
        } 
        else {
            amount = (100 * 5) + (100 * 7) + (units - 200) * 10;
        }

        return amount;
    }

    // Display consumer details
    void display() {
        System.out.println("ID: " + consumerId +
                ", Name: " + name +
                ", Units: " + unitsConsumed +
                ", Bill: ₹" + billAmount);
    }
}

public class ElectricityBillSystem {

    static ArrayList<Consumer> consumers = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n--- Electricity Bill System ---");
            System.out.println("1. Add Consumer");
            System.out.println("2. Display All Bills");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addConsumer();
                    break;
                case 2:
                    displayConsumers();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 3);
    }

    // Add new consumer
    static void addConsumer() {
        System.out.print("Enter Consumer ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Units Consumed: ");
        int units = sc.nextInt();

        consumers.add(new Consumer(id, name, units));

        System.out.println("Consumer added successfully.");
    }

    // Display all consumers and bills
    static void displayConsumers() {
        if (consumers.isEmpty()) {
            System.out.println("No records found.");
            return;
        }

        System.out.println("\n--- Consumer Bills ---");
        for (Consumer c : consumers) {
            c.display();
        }
    }
}