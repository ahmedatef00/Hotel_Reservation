package api;

import model.Customer;
import model.IRoom;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.List;

public class AdminResource {
    public static AdminResource adminResource;

    private AdminResource(){};

    // Get the customer
    public Customer getCustomer(String email) {
        return CustomerService.getCustomer(email);
    }

    // Add a room
    public void addRoom(List<IRoom> rooms) {
        for (IRoom room: rooms) {
            ReservationService.addRoom(room);
        }
    }

    // Get all of the rooms
    public Collection<IRoom> getAllRooms(){
        return ReservationService.getAllRooms();
    }

    // Get all of the customers
    public Collection<Customer> getAllCustomers(){
        return CustomerService.getAllCustomers();
    }

    // print all of the reservations
    public void displayAllReservations(){
        ReservationService.printAllReservation();
    }
}