package api;

import model.Customer;
import model.Room;
import service.CustomerService;
import service.ReservationService;

import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MainMenu {

    public static void main(String[] args) {
        // write your code here
        CustomerService customerService = new CustomerService();
        customerService.addCustomer("ashmed@email.com", "aa", "bb");
//        ReservationService.getInstance();
        Thread th = new Thread(() -> {
            customerService.writeFile("ashmed@email.com");
        });

        th.start();


    }


}
