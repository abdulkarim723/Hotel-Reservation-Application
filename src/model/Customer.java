package model;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Customer {
    private String firstName;
    private String lastName;
    private String email;

    public Customer(String firstName, String lastName, String email) {
        String emailRegex = "^(.+)@(.+).(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        if(!matcher.matches()) {
            throw new IllegalArgumentException("email format is not supported!");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer data:\nFull name: " + firstName + " " + lastName + "\nEmail: " + email;
    }
}
