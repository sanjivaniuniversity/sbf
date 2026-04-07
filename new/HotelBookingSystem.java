import java.util.ArrayList;
import java.util.Scanner;

class HotelRoom {
    int roomNo;
    boolean booked;
    String customerName;

    HotelRoom(int roomNo) {
        this.roomNo = roomNo;
        this.booked = false;
        this.customerName = "";
    }
}

public class HotelBookingSystem {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<HotelRoom> rooms = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            rooms.add(new HotelRoom(i));
        }

        int choice;
        do {
            System.out.println("\n--- Hotel Booking Menu ---");
            System.out.println("1. Display Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Show Customer Details");
            System.out.println("5. Count Booked Rooms");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> displayAvailableRooms();
                case 2 -> bookRoom();
                case 3 -> cancelBooking();
                case 4 -> showCustomerDetails();
                case 5 -> countBookedRooms();
                case 6 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }

    static void displayAvailableRooms() {
        System.out.println("Available Rooms:");
        for (HotelRoom room : rooms) {
            if (!room.booked) {
                System.out.println("Room " + room.roomNo);
            }
        }
    }

    static void bookRoom() {
        System.out.print("Enter Room No to book: ");
        int roomNumber = sc.nextInt();
        sc.nextLine();

        for (HotelRoom room : rooms) {
            if (room.roomNo == roomNumber) {
                if (!room.booked) {
                    System.out.print("Enter Customer Name: ");
                    room.customerName = sc.nextLine();
                    room.booked = true;
                    System.out.println("Room booked successfully!");
                } else {
                    System.out.println("Room already booked!");
                }
                return;
            }
        }

        System.out.println("Room not found!");
    }

    static void cancelBooking() {
        System.out.print("Enter Room No to cancel booking: ");
        int roomNumber = sc.nextInt();
        sc.nextLine();

        for (HotelRoom room : rooms) {
            if (room.roomNo == roomNumber && room.booked) {
                room.booked = false;
                room.customerName = "";
                System.out.println("Booking cancelled!");
                return;
            }
        }

        System.out.println("Room not booked or not found!");
    }

    static void showCustomerDetails() {
        for (HotelRoom room : rooms) {
            if (room.booked) {
                System.out.println("Room " + room.roomNo + " - " + room.customerName);
            }
        }
    }

    static void countBookedRooms() {
        int count = 0;
        for (HotelRoom room : rooms) {
            if (room.booked) {
                count++;
            }
        }
        System.out.println("Total booked rooms: " + count);
    }
}
