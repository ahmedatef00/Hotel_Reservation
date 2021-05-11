package api;

import model.Customer;
import model.Room;
import service.CustomerService;
import service.ReservationService;

public class MainMenu {

    public static void main(String[] args) {
        // write your code here
        CustomerService customerService = new CustomerService();
        customerService.addCustomer("ashmed@email.com", "aa", "bb");
        ReservationService.getInstance();
    }
}
