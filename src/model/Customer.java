package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {
    private final String firstName;
    private final String lastName;
    private final String email;

    public Customer(String firstName, String lastName, String email) {
        checkNameRegexPattern(firstName);
        checkNameRegexPattern(lastName);
        checkEmailRegexPattern(email);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    private static void checkRegexPattern(String regexPattern, String string, String errorMessage) {
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(string);
        if(!matcher.matches())
            throw new IllegalArgumentException(errorMessage);
    }
    private static void checkEmailRegexPattern(String string) {
        String emailRegex = "^(.+)@(.+).(.+)$";
        String errorMessage = "Email format is not supported!";
        checkRegexPattern(emailRegex, string, errorMessage);
    }

    private static void checkNameRegexPattern(String string) {
        String nameRegex = "[a-zA-Z 0-9]+";
        String errorMessage = "Name format is not supported!";
        checkRegexPattern(nameRegex, string, errorMessage);
    }

    @Override
    public String toString() {
        return "Customer data:\nFull name: " + firstName + " " + lastName + "\nEmail: " + email;
    }
}
