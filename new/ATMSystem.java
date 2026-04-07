import java.util.Scanner;

public class ATMSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pin = 1234;
        int enteredPin;
        int choice;
        double balance = 5000;

        System.out.print("Enter PIN: ");
        enteredPin = sc.nextInt();

        if (enteredPin != pin) {
            System.out.println("Incorrect PIN! Exiting.");
            return;
        }

        do {
            System.out.println("\n1.Check Balance 2.Deposit 3.Withdraw 4.Exit");
            System.out.print("Choose: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> System.out.println("Balance: $" + balance);
                case 2 -> {
                    System.out.print("Deposit amount: ");
                    balance += sc.nextDouble();
                }
                case 3 -> {
                    System.out.print("Withdraw amount: ");
                    double amount = sc.nextDouble();
                    if (amount <= balance) {
                        balance -= amount;
                    } else {
                        System.out.println("Insufficient balance!");
                    }
                }
                case 4 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }
}
