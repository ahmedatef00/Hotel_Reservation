package api;
import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;
import java.util.Collection;
import java.util.Date;

public class HotelResource {
    public static HotelResource hotelResource;

    private HotelResource() {}

    // get a customer class
    public Customer getCustomer(String email){
        return CustomerService.getCustomer(email);
    }

    // create a new customer
    public void createACustomer(String email, String firstName, String lastName){
        CustomerService.addCustomer(email, firstName, lastName);
    }

    // return a room
    public IRoom getRoom(String roomNumber) {
        return ReservationService.getARoom(roomNumber);
    }

    // booking a room
    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate) {
        return ReservationService.reserveARoom(CustomerService.getCustomer(customerEmail), room, checkInDate, checkOutDate);
    }

    // return the customers reservations
    public Collection<Reservation> getCustomersReservations(String customerEmail){
        return ReservationService.getCustomersReservation(getCustomer(customerEmail));
    }

    // find a room
    public Collection<IRoom> findARoom(Date checkIn, Date checkOut){
        return ReservationService.findRooms(checkIn,checkOut);
    }


}