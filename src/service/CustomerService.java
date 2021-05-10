package service;

import model.Customer;

import java.util.Collection;
import java.util.HashSet;

public class CustomerService {
    // create a map of all the customers there are  without ordering it
    // and can store null values  uniuqe faster in the set collection
    public static Collection<Customer> setofCustomers = new HashSet<Customer>();

    public void addCustomer(String email, String firstName, String lasttname) {
        Customer newcustomer = new Customer(firstName, lasttname, email);

        setofCustomers.add(newcustomer);
        if (setofCustomers.add(newcustomer) == false && setofCustomers.size() > 1) {
            System.out.println("element already there");
        }

    }

    public Collection<Customer> getCustomers() {

        if (!setofCustomers.isEmpty()) {
            return setofCustomers;

        }
        return null;
    }

    public Customer getCustomer(String email) {
        for (Customer customer : setofCustomers) {
            if (customer.getEmail().equals(email)) {
                return (customer);
            }
        }
        return null;

    }
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