package service;

import model.Customer;
import java.util.Map;
import java.util.HashMap;

public class CustomerService {
    private static CustomerService reference = new CustomerService();
    private Map<String, Customer> queuedCustomers;

    private CustomerService(){
        this.queuedCustomers = new HashMap<String, Customer>();
    }
    public void addCustomer(String email, String firstName, String lastName) {
        Customer customer = new Customer(firstName, lastName, email);
        queuedCustomers.put(email, customer);
    }

    public Customer getCustomer(String customerEmail) {
        return queuedCustomers.get(customerEmail);
    }


    public Map<String, Customer> getAllCustomers() {
        return queuedCustomers;
    }

    public void printAllCustomers() {
        for(var item : queuedCustomers.entrySet()) System.out.println(item.getValue().toString());
    }

    public static CustomerService getInstance() {
        return reference;
    }

}
