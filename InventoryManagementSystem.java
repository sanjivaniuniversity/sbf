import java.util.*;

// Class to store Product details
class Product {
    int productId;
    String name;
    double price;
    int quantity;

    // Constructor
    Product(int productId, String name, double price, int quantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to display product details
    void display() {
        System.out.println("ID: " + productId +
                ", Name: " + name +
                ", Price: ₹" + price +
                ", Quantity: " + quantity);
    }

    // Method to calculate total value of this product
    double totalValue() {
        return price * quantity;
    }
}

public class InventoryManagementSystem {

    static ArrayList<Product> products = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n--- Inventory Management System ---");
            System.out.println("1. Add Product");
            System.out.println("2. Display All Products");
            System.out.println("3. Update Product Quantity");
            System.out.println("4. Search Product by ID");
            System.out.println("5. Calculate Total Inventory Value");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    displayProducts();
                    break;
                case 3:
                    updateQuantity();
                    break;
                case 4:
                    searchProduct();
                    break;
                case 5:
                    calculateTotalValue();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);
    }

    // Add new product
    static void addProduct() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        products.add(new Product(id, name, price, quantity));

        System.out.println("Product added successfully.");
    }

    // Display all products
    static void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        System.out.println("\n--- Product List ---");
        for (Product p : products) {
            p.display();
        }
    }

    // Update product quantity
    static void updateQuantity() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        for (Product p : products) {
            if (p.productId == id) {
                System.out.print("Enter new quantity: ");
                p.quantity = sc.nextInt();
                System.out.println("Quantity updated successfully.");
                return;
            }
        }

        System.out.println("Product not found.");
    }

    // Search product by ID
    static void searchProduct() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        for (Product p : products) {
            if (p.productId == id) {
                System.out.println("Product Found:");
                p.display();
                return;
            }
        }

        System.out.println("Product not found.");
    }

    // Calculate total inventory value
    static void calculateTotalValue() {
        double total = 0;

        for (Product p : products) {
            total += p.totalValue();
        }

        System.out.println("Total Inventory Value: ₹" + total);
    }
} 
