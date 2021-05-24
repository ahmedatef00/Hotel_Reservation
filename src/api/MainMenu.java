package api;
import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class MainMenu {

    public static void startActions() throws ParseException {
        int actions = getActions(); // collect input
        switch(actions) {

            // Make a reservation
            case 1:
                System.out.println("Enter your email to reserve a room!");
                Scanner scannerEmail = new Scanner(System.in);
                String userEmail = scannerEmail.next().toString();

                //Select a Room
                System.out.print("Here are the rooms available!");
                ReservationService.printAllRooms();

                System.out.println("What room would you like?");
                Scanner scannerRoomSelection = new Scanner(System.in);
                String selectedRoom = scannerRoomSelection.next().toString();

                System.out.println("What check in date would you like?");
                Scanner scannerCheckInDate = new Scanner(System.in);
                String customerCheckInDate = scannerCheckInDate.next().toString();
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                Date checkInDate = formatter.parse(customerCheckInDate);

                System.out.println("What check out date would you like?");
                Scanner scannerCheckOutDate = new Scanner(System.in);
                String customerCheckOutDate = scannerCheckInDate.next().toString();
                Date checkOutDate = formatter.parse(customerCheckInDate);

                // Get a customer
                Customer selectedCustomer = CustomerService.getCustomer(userEmail);
                // Get a room
                IRoom customerReservedRooms = ReservationService.getARoom(selectedRoom);

                try {
                    ReservationService.reserveARoom(selectedCustomer, customerReservedRooms, checkInDate, checkOutDate);
                }
                catch (IllegalArgumentException exception) {
                    System.out.println("Please try again with valid information!");
                    MainMenu.startActions();
                }

                System.out.println("Room Reserved!");

                MainMenu.startActions();

                // See my reservations
            case 2:
                System.out.println("What is the email address associated with your reservation?");
                Scanner scannerCustomerEmail = new Scanner(System.in);
                String customerEmail = scannerCustomerEmail.next().toString();

                reservationViewer(customerEmail);

                MainMenu.startActions();

                // Create a customer account
            case 3:
                // First name
                System.out.println("What is your first name?");
                Scanner newScannerCustomerFirstName = new Scanner(System.in);
                String newCustomerFirstName = newScannerCustomerFirstName.next().toString();

                // Last name
                System.out.println("What is your last name?");
                Scanner newScannerLastName = new Scanner(System.in);
                String newCustomerLastName = newScannerLastName.next().toString();

                // Email
                System.out.println("Enter your email");
                Scanner newScannerEmail = new Scanner(System.in);
                String newUserEmail = newScannerEmail.next().toString();

                try {
                    CustomerService.addCustomer(newCustomerFirstName, newCustomerLastName, newUserEmail);
                }
                catch (IllegalArgumentException exception) {
                    System.out.println("Please try again! Incorrect input.");
                }
                MainMenu.startActions();

                // Open the admin menu
            case 4:
                AdminMenu aMenu = new AdminMenu();
                AdminMenu.startActions();

                // Exit the program
            case 5:
                System.out.println("Goodbye!");
                break;

        }
    }

    public static void main(String [] args) throws ParseException {
        MainMenu menuObject = new MainMenu();
        menuObject.startActions();
    }

    public static int getActions() {
        System.out.println("1. Find and reserve a room, 2. See my reservation, 3. Create an account, 4. Go to the Admin window, 5. Exit. Enter your number selection!");
        Scanner scanner = new Scanner(System.in);
        int scannerNumber = Integer.parseInt(scanner.next());
        return scannerNumber;
    }

    // To view all customers
    public static void reservationViewer(String customerEmail){
        Collection<Reservation> allCustomerReservations = ReservationService.getCustomersReservation(CustomerService.getCustomer(customerEmail));

        for (Reservation reservation : allCustomerReservations) {
            System.out.println(reservation);
        }
    }
}