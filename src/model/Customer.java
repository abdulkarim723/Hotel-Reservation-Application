package model;

import helperClasses.CheckRegex;

public class Customer {
    private final String firstName;
    private final String lastName;
    private final String email;

    public Customer(String firstName, String lastName, String email) {
        CheckRegex.checkNameRegexPattern(firstName);
        CheckRegex.checkNameRegexPattern(lastName);
        CheckRegex.checkEmailRegexPattern(email);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer data:\nFull name: " + firstName + " " + lastName + "\nEmail: " + email;
    }
}
