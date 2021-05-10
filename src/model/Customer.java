package model;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Customer {
    private final String firstName;
    private String lastName;
    private String email;
    private final String  emailRegex = "^(.+)@(.+).(.+)$";
    private final Pattern pattern = Pattern.compile(emailRegex);

    public Customer(String firstName, String lastName, String email) {
        // if the email does not match the regex pattern throw and invalid argument exceptions
        if (!pattern.matcher(email).matches()) {
            throw new IllegalArgumentException("Invalid email");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String toString(){
        return "Customer: " + firstName + " " + lastName + ". Email:" + email;
    }

}
