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
    public void addCustomer(String email, String firstName, String lastName) {
        if(queuedCustomers.get(email) == null){
            Customer customer = new Customer(firstName, lastName, email);
            queuedCustomers.put(email, customer);
            return;
        }

        System.out.println("This customer is already inserted!\n" +
                "It is not allowed to have more than one account for the same Email");
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
