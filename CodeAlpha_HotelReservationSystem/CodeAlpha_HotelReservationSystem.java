import java.util.*;

class Room {
    int roomNumber;
    String category;
    boolean isBooked;
    double price;

    Room(int roomNumber, String category, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.price = price;
        this.isBooked = false;
    }
}

public class CodeAlpha_HotelReservationSystem {

    static ArrayList<Room> rooms = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        initializeRooms();

        while (true) {
            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View Booking Details");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: viewAvailableRooms(); break;
                case 2: bookRoom(); break;
                case 3: cancelBooking(); break;
                case 4: viewBookingDetails(); break;
                case 5: 
                    System.out.println("Thank you for using the system!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // Initialize hotel rooms
    public static void initializeRooms() {
        rooms.add(new Room(101, "Standard", 1500));
        rooms.add(new Room(102, "Standard", 1500));
        rooms.add(new Room(201, "Deluxe", 2500));
        rooms.add(new Room(202, "Deluxe", 2500));
        rooms.add(new Room(301, "Suite", 4000));
    }

    // Display all available (not booked) rooms
    public static void viewAvailableRooms() {
        System.out.println("\n--- AVAILABLE ROOMS ---");
        for (Room r : rooms) {
            if (!r.isBooked) {
                System.out.println("Room: " + r.roomNumber + " | Category: " + r.category + " | Price: ₹" + r.price);
            }
        }
    }

    // Book a room
    public static void bookRoom() {
        System.out.print("\nEnter room number to book: ");
        int number = sc.nextInt();

        for (Room r : rooms) {
            if (r.roomNumber == number) {
                if (r.isBooked) {
                    System.out.println("Room is already booked.");
                } else {
                    r.isBooked = true;
                    System.out.println("✅ Room " + r.roomNumber + " booked successfully!");
                    System.out.println("You have to pay: ₹" + r.price);
                }
                return;
            }
        }
        System.out.println("Room not found.");
    }

    // Cancel room booking
    public static void cancelBooking() {
        System.out.print("\nEnter room number to cancel booking: ");
        int number = sc.nextInt();

        for (Room r : rooms) {
            if (r.roomNumber == number) {
                if (r.isBooked) {
                    r.isBooked = false;
                    System.out.println("Booking cancelled for room " + r.roomNumber);
                } else {
                    System.out.println("Room is not booked.");
                }
                return;
            }
        }
        System.out.println("Room not found.");
    }

    // View all booked rooms
    public static void viewBookingDetails() {
        System.out.println("\n--- BOOKED ROOMS ---");
        boolean found = false;

        for (Room r : rooms) {
            if (r.isBooked) {
                System.out.println("Room: " + r.roomNumber + " | Category: " + r.category + " | Amount: ₹" + r.price);
                found = true;
            }
        }

        if (!found)
            System.out.println("No rooms are booked.");
    }
}

