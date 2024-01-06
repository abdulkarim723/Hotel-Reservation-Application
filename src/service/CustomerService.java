package service;

import model.Customer;
import java.util.Map;
import java.util.HashMap;

public class CustomerService {
    private static final CustomerService reference = new CustomerService();
    private final Map<String, Customer> queuedCustomers;

    private CustomerService(){
        this.queuedCustomers = new HashMap<>();
    }
    public boolean addCustomer(String email, String firstName, String lastName) {
        if(!isCustomerValid(email)){
            Customer customer = new Customer(firstName, lastName, email);
            queuedCustomers.put(email, customer);
            return true;
        }

        return false;
    }

    public boolean isCustomerValid(String email) {
        return queuedCustomers.containsKey(email);
    }

    public Customer getCustomer(String customerEmail) {
        return queuedCustomers.get(customerEmail);
    }

    public void printAllCustomers() {
        for(var item : queuedCustomers.entrySet()) System.out.println(item.getValue().toString());
    }

    public static CustomerService getInstance() {
        return reference;
    }

}
