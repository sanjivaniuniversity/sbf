import java.util.*;

class Booking {
    int roomNumber;
    String customerName;

    Booking(int roomNumber, String customerName) {
        this.roomNumber = roomNumber;
        this.customerName = customerName;
    }

    public String toString() {
        return "Room: " + roomNumber + ", Customer: " + customerName;
    }
}

public class HotelBookingSystem {

    static final int TOTAL_ROOMS = 5;
    static boolean[] rooms = new boolean[TOTAL_ROOMS];
    static ArrayList<Booking> bookings = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // 🔹 Display Rooms
    static void displayRooms() {
        System.out.println("\n--- Room Status ---");
        for (int i = 0; i < TOTAL_ROOMS; i++) {
            System.out.println("Room " + (i + 1) + ": " + (rooms[i] ? "Booked" : "Available"));
        }
    }

    // 🔹 Book Room
    static void bookRoom() {
        System.out.print("Enter room number (1-" + TOTAL_ROOMS + "): ");
        int room = sc.nextInt();

        if (room < 1 || room > TOTAL_ROOMS) {
            System.out.println("Invalid room number.");
            return;
        }

        if (rooms[room - 1]) {
            System.out.println("Room already booked.");
            return;
        }

        System.out.print("Enter customer name: ");
        String name = sc.next();

        rooms[room - 1] = true;
        bookings.add(new Booking(room, name));

        System.out.println("Room booked successfully.");
    }

    // 🔹 Cancel Booking
    static void cancelBooking() {
        System.out.print("Enter room number to cancel: ");
        int room = sc.nextInt();

        if (room < 1 || room > TOTAL_ROOMS || !rooms[room - 1]) {
            System.out.println("Invalid or unbooked room.");
            return;
        }

        rooms[room - 1] = false;

        Iterator<Booking> it = bookings.iterator();
        while (it.hasNext()) {
            if (it.next().roomNumber == room) {
                it.remove();
                break;
            }
        }

        System.out.println("Booking cancelled.");
    }

    // 🔹 Show Bookings
    static void showBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        System.out.println("\n--- Booking Details ---");
        for (Booking b : bookings) {
            System.out.println(b);
        }
    }

    // 🔹 Count Booked Rooms
    static void countBookedRooms() {
        int count = 0;
        for (boolean r : rooms) {
            if (r) count++;
        }
        System.out.println("Total booked rooms: " + count);
    }

    // 🔹 Menu
    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== Hotel Booking System =====");
            System.out.println("1. Display Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Show Booking Details");
            System.out.println("5. Count Booked Rooms");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: displayRooms(); break;
                case 2: bookRoom(); break;
                case 3: cancelBooking(); break;
                case 4: showBookings(); break;
                case 5: countBookedRooms(); break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}