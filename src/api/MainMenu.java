package api;

import model.Customer;
import service.CustomerService;

public class MainMenu {

    public static void main(String[] args) {
        // write your code here

        CustomerService customerService = new CustomerService();
        customerService.addCustomer("ashmed@email.com", "aa", "bb");
    }
}
