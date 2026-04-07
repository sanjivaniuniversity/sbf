import java.util.*;

public class ATMSystem {

    static final int CORRECT_PIN = 1234;
    static double balance = 5000.0;
    static Scanner sc = new Scanner(System.in);

    // 🔐 PIN Verification
    static boolean verifyPin() {
        int attempts = 3;

        while (attempts > 0) {
            System.out.print("Enter PIN: ");
            int pin = sc.nextInt();

            if (pin == CORRECT_PIN) {
                return true;
            } else {
                attempts--;
                System.out.println("Incorrect PIN. Attempts left: " + attempts);
            }
        }
        return false;
    }

    // 💰 Check Balance
    static void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    // ➕ Deposit
    static void deposit() {
        System.out.print("Enter amount to deposit: ₹");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }

        balance += amount;
        System.out.println("Deposit successful.");
    }

    // ➖ Withdraw
    static void withdraw() {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful.");
        }
    }

    // 📋 Menu
    static void menu() {
        while (true) {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: checkBalance(); break;
                case 2: deposit(); break;
                case 3: withdraw(); break;
                case 4:
                    System.out.println("Thank you for using ATM.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // 🚀 Main
    public static void main(String[] args) {

        System.out.println("===== Welcome to ATM =====");

        if (verifyPin()) {
            System.out.println("Access granted.");
            menu();
        } else {
            System.out.println("Too many incorrect attempts. Card blocked.");
        }
    }
}