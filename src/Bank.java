import java.util.*;
public class Bank {
    //private ArrayList<Customer> customers = new ArrayList<>();//chnage to link list
    private List<Customer> customers = new LinkedList<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    public Customer getCustomerByPin(int pin) {
        for (Customer customer : customers) {
            if (customer.getPin() == pin) {
                return customer;
            }
        }
        return null;
    }

    public String getAllCustomerInfo() {
        StringBuilder info = new StringBuilder();
        for (Customer customer : customers) {
            info.append(customer.toString()).append("\n");
        }
        return info.toString();
    }
}