import java.util.ArrayList;
import java.util.Scanner;

class LibraryBook {
    int id;
    int qty;
    String title;
    String author;

    LibraryBook(int id, String title, String author, int qty) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.qty = qty;
    }

    void display() {
        System.out.println("ID: " + id + ", Title: " + title + ", Author: " + author + ", Quantity: " + qty);
    }
}

public class LibrarySystem {
    static ArrayList<LibraryBook> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Display Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addBook();
                case 2 -> issueBook();
                case 3 -> returnBook();
                case 4 -> displayBooks();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Author: ");
        String author = sc.nextLine();
        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();

        books.add(new LibraryBook(id, title, author, qty));
        System.out.println("Book added successfully!");
    }

    static void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        int id = sc.nextInt();
        boolean found = false;

        for (LibraryBook book : books) {
            if (book.id == id) {
                found = true;
                if (book.qty > 0) {
                    book.qty--;
                    System.out.println("Book issued successfully!");
                } else {
                    System.out.println("Sorry, book is out of stock!");
                }
                break;
            }
        }

        if (!found) {
            System.out.println("Book not found!");
        }
    }

    static void returnBook() {
        System.out.print("Enter Book ID to return: ");
        int id = sc.nextInt();
        System.out.print("Enter days late: ");
        int days = sc.nextInt();
        boolean found = false;

        for (LibraryBook book : books) {
            if (book.id == id) {
                found = true;
                book.qty++;
                int fine = days > 0 ? days * 5 : 0;
                System.out.println("Book returned! Fine: $" + fine);
                break;
            }
        }

        if (!found) {
            System.out.println("Book not found!");
        }
    }

    static void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("\nAvailable Books:");
        for (LibraryBook book : books) {
            book.display();
        }
    }
}
