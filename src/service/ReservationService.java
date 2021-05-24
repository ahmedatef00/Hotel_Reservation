package service;

import model.*;

import java.util.*;

public class ReservationService {
//    private String roomNumber;
//    private String roomId;
//    private Double price;
//    private RoomType enumeration;

    //Collections to store all of the rooms
    public static Collection<IRoom> rooms = new HashSet<>();
    public static Collection<Reservation> reservations = new HashSet<>();

    private static ReservationService reservationService = null;

    private ReservationService(){}

    // create a static reservation service
    public static ReservationService getInstance(){
        if (null == reservationService){
            reservationService = new ReservationService();
        }
        return reservationService;
    }

    // Add a new room
    public static void addRoom(IRoom room) {
        Room newRoom = new Room(room.getRoomNumber(), room.getRoomPrice(), room.getRoomType());
        rooms.add(newRoom);
    }

    // get a room from the collection of rooms
    public static IRoom getARoom(String roomId) {
        for (IRoom room: rooms){
            if ((room.getRoomNumber()).equals(roomId)) {
                return room;
            }
        }
        return null;
    }

    // add a room reservation to the reservation set
    public static Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        Reservation newReservation = new Reservation(customer, room,checkInDate, checkOutDate);
        reservations.add(newReservation);
        rooms.remove(room);
        return newReservation;
    }

    // get a customers reservation
    public static Collection<Reservation> getCustomersReservation(Customer customer) {
        Collection<Reservation> matchingReservations = new LinkedList<>();
        for (Reservation reservation : ReservationService.reservations) {
            if((reservation.getCustomer()).equals(customer)){
                matchingReservations.add(reservation);
            }

        }
        return matchingReservations;
    }

    // find all of the rooms that are available
    // only return the rooms available greater or equal to the check in date and less or equal to the checkoutdate
    public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        Collection<IRoom> freeRooms = new HashSet<>();
        // loop through all the rooms and check for those that have not been reserved for
        // that given checkInDate and checkOutDate.
        Set<IRoom> reservedRooms = getReservedRooms(checkInDate, checkOutDate);

        for (IRoom room : rooms){
            if(reservedRooms.contains(room)){
                freeRooms.add(room);
            }
        }
        return freeRooms;
    }

    // helper function to check if a room is available after the checkin in date and before the checkout date
    public static Set<IRoom> getReservedRooms(Date checkInDate, Date checkOutDate) {
        Set<IRoom> reservedRooms = new HashSet<>();
        for (Reservation reservation: reservations){
            IRoom room = reservation.getRoom();
            if ((reservation.getCheckInDate()).after(checkInDate) && (reservation.getCheckOutDate().before(checkOutDate))){
                reservedRooms.add(room);
            }
        }
        return reservedRooms;
    }

    //print all of the reservations
    public static void printAllReservation(){
        for(Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }

    // return all of the customers if they are in the customer collection
    public static Collection<IRoom> getAllRooms(){
        return rooms;
    }

    public static void printAllRooms(){
        Collection<IRoom> availableRooms = getAllRooms();

        for (IRoom room: availableRooms){
            System.out.println(room);
        }

    }
}