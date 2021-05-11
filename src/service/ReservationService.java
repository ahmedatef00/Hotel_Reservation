package service;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;

import java.util.*;
import java.util.concurrent.Callable;

public class ReservationService {
    //collections to store all the rooms
    public static Collection<IRoom> rooms = new HashSet<>();
    //collections to store all the reservations
    public static Collection<Reservation> reservations = new HashSet<>();

    private static ReservationService reservationService = null; //(singleton)

    private ReservationService() {
    }

    //Singleton Object
    public static ReservationService getInstance() {
        if (reservationService == null) {
            reservationService = new ReservationService();
        }
        return reservationService;
    }

    //add a new room
    public static void addRoom(IRoom room) {
        Room newRoom = new Room(room.getRoomNumber(), room.getRoomPrice(), room.getRoomType());
        rooms.add(newRoom);
    }

    public static IRoom getRoom(int roomNumber) {
        for (IRoom room : rooms) {
            if (room.getRoomNumber().equals(roomNumber)) {
                return room;
            }
        }
        return null;
    }

    public static Collection<IRoom> getRooms(int roomNumber) {
        return rooms;
    }

    // add a room reservation to the reservation set then rooms will be rooms - 1 ;
    public static Reservation reserveRoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation newReservation = new Reservation(customer, room, checkInDate, checkOutDate);
        reservations.add(newReservation);
        rooms.remove(room);
        return newReservation;
    }


    // get a customers reservation
    //Reservation has a customer then get his reservation from Reservation Model and then store them in linked list
    public static Collection<Reservation> getCustomerReservations(Customer customer) {
        Collection<Reservation> matchReservations = new LinkedList<>();
        for (Reservation reservation : reservations) {
            if (reservation.getCustomer().equals(customer)) ;
            {
                matchReservations.add(reservation);
            }
        }
        return matchReservations;
    }


    // helper function to check if a room is available after the checkin in date and before the checkout date
    public static Set<IRoom> getReservedRooms(Date checkInDate, Date checkOutDate) {
        Set<IRoom> reservedRooms = new HashSet<>();
        for (Reservation reservation : reservations) {
            IRoom room = reservation.getRoom();
            if ((reservation.getCheckInDate()).after(checkInDate) && (reservation.getCheckOutDate()).before(checkOutDate)) {
                reservedRooms.add(room);
            }
        }
        return reservedRooms;
    }


    // find all of the rooms that are available
    // only return the rooms available greater or equal to the check in date and less or equal to the checkoutdate


}
/**
 * Students will be designing and implementing a hotel reservation application.
 * The hotel reservation application will allow customers to find and book a hotel room.
 * Rooms will contain the price along with the dates that the room is reserved.
 * All room bookings will be associated with a single customer account, the customer account will include the customer name
 * (first and last) and email.
 * The application will allow customers to retrieve a list of the hotel's free rooms.
 * In addition, the hotel reservation application will allow customers to find and book rooms based on availability and price.
 */