import java.util.*;

class Book {
    int id;
    String title;
    String author;
    int quantity;

    Book(int id, String title, String author, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    public String toString() {
        return "ID: " + id + ", Title: " + title +
               ", Author: " + author + ", Available: " + quantity;
    }
}

class IssueRecord {
    int bookId;
    int daysIssued;

    IssueRecord(int bookId, int daysIssued) {
        this.bookId = bookId;
        this.daysIssued = daysIssued;
    }
}

public class LibraryManagementSystem {

    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<IssueRecord> issued = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // 🔹 Add Book
    static void addBook() {
        System.out.print("Enter ID Title Author Quantity: ");
        books.add(new Book(sc.nextInt(), sc.next(), sc.next(), sc.nextInt()));
        System.out.println("Book added.");
    }

    // 🔹 Display Books
    static void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book b : books) {
            System.out.println(b);
        }
    }

    // 🔹 Issue Book
    static void issueBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id && b.quantity > 0) {
                b.quantity--;

                System.out.print("Enter days issued: ");
                int days = sc.nextInt();

                issued.add(new IssueRecord(id, days));
                System.out.println("Book issued.");
                return;
            }
        }
        System.out.println("Book not available.");
    }

    // 🔹 Return Book + Fine
    static void returnBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        Iterator<IssueRecord> it = issued.iterator();

        while (it.hasNext()) {
            IssueRecord r = it.next();

            if (r.bookId == id) {

                // Increase quantity back
                for (Book b : books) {
                    if (b.id == id) {
                        b.quantity++;
                        break;
                    }
                }

                // Fine Calculation (₹10 per extra day after 7 days)
                int extraDays = r.daysIssued - 7;
                int fine = (extraDays > 0) ? extraDays * 10 : 0;

                System.out.println("Book returned.");
                System.out.println("Fine: ₹" + fine);

                it.remove();
                return;
            }
        }
        System.out.println("No such issued record.");
    }

    // 🔹 Menu
    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== Library System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: addBook(); break;
                case 2: displayBooks(); break;
                case 3: issueBook(); break;
                case 4: returnBook(); break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}