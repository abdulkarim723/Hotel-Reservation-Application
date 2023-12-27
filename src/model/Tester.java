package model;

public class Tester {
    public static void main(String[] args) {
        Customer customer = new Customer("first", "second", "j@gmail.com");
        Customer customer_2 = new Customer("first", "second", "karim@gmail.com");
        try {
            System.out.println(customer);
            System.out.println(customer_2);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getLocalizedMessage());

        }

    }
}
