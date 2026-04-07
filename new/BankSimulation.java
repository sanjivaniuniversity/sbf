import java.util.Scanner;

class BankAccount {
    int accNo;
    double balance;

    BankAccount(int accNo, double balance) {
        this.accNo = accNo;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void display() {
        System.out.println("Account No: " + accNo + ", Balance: $" + balance);
    }
}

public class BankSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();

        BankAccount account = new BankAccount(accNo, balance);
        int choice;

        do {
            System.out.println("\n1.Deposit 2.Withdraw 3.Display 4.Exit");
            System.out.print("Choose: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Amount to deposit: ");
                    account.deposit(sc.nextDouble());
                }
                case 2 -> {
                    System.out.print("Amount to withdraw: ");
                    account.withdraw(sc.nextDouble());
                }
                case 3 -> account.display();
                case 4 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }
}
