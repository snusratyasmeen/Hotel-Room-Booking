import java.util.Scanner;

public class HotelRoomBooking {

    static Scanner sc = new Scanner(System.in);

    static String customerName = "";
    static int roomNumber = 0;
    static String roomType = "";
    static double roomPrice = 0;
    static boolean booked = false;

    public static void viewRooms() {
        System.out.println("\n===== AVAILABLE ROOMS =====");
        System.out.println("1. Room 101 - Single - Rs.1000/day");
        System.out.println("2. Room 102 - Double - Rs.1800/day");
        System.out.println("3. Room 103 - Deluxe - Rs.2500/day");
    }

    public static void bookRoom() {

        if (booked) {
            System.out.println("A room is already booked.");
            return;
        }

        System.out.print("Enter customer name: ");
        customerName = sc.nextLine();

        viewRooms();

        System.out.print("Choose room: ");
        int choice = sc.nextInt();

        System.out.print("Enter number of days: ");
        int days = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {
            roomNumber = 101;
            roomType = "Single";
            roomPrice = 1000;
        } else if (choice == 2) {
            roomNumber = 102;
            roomType = "Double";
            roomPrice = 1800;
        } else if (choice == 3) {
            roomNumber = 103;
            roomType = "Deluxe";
            roomPrice = 2500;
        } else {
            System.out.println("Invalid room choice!");
            return;
        }

        double total = roomPrice * days;
        booked = true;

        System.out.println("\n===== BOOKING CONFIRMED =====");
        System.out.println("Customer: " + customerName);
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Room Type: " + roomType);
        System.out.println("Days: " + days);
        System.out.println("Total Bill: Rs." + total);
    }

    public static void viewBooking() {

        if (!booked) {
            System.out.println("No booking found.");
            return;
        }

        System.out.println("\n===== BOOKING DETAILS =====");
        System.out.println("Customer: " + customerName);
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Room Type: " + roomType);
        System.out.println("Price per Day: Rs." + roomPrice);
    }

    public static void cancelBooking() {

        if (!booked) {
            System.out.println("No booking to cancel.");
            return;
        }

        booked = false;
        customerName = "";
        roomNumber = 0;
        roomType = "";
        roomPrice = 0;

        System.out.println("Booking cancelled successfully!");
    }

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== HOTEL ROOM BOOKING =====");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. View Booking");
            System.out.println("4. Cancel Booking");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    viewRooms();
                    break;

                case 2:
                    bookRoom();
                    break;

                case 3:
                    viewBooking();
                    break;

                case 4:
                    cancelBooking();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
