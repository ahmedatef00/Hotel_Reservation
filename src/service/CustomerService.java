package service;

import model.Customer;
import netscape.javascript.JSObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;

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

    public void writeFile(String email) {
        try {
            FileOutputStream file = new FileOutputStream("s.txt");
            Customer customer = getCustomer(email);
            file.write(customer.toString().getBytes(StandardCharsets.UTF_8));
            file.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(this.toString());

    }

    public static void readFile() {
        try {
            File file = new File("s.txt");
            file.renameTo(new File("Test.txt"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

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