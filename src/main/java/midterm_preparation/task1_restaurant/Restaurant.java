package midterm_preparation.task1_restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Restaurant {
    private String restaurantName;
    private List<Customer> customers;
    private Map<String, MenuItem> menuItems;

    public Restaurant(String restaurantName) {
        this.restaurantName = restaurantName;
        this.customers = new ArrayList<Customer>();
        this.menuItems = new HashMap<String, MenuItem>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.put(menuItem.getName(), menuItem);
    }

    public Customer getCustomer(String id){
        for(Customer customer : customers){
            if(customer.getCustomerId().equals(id)){
                return customer;
            }
        }
        return null;
    }

    public void displayMenu(){
        for(String name : menuItems.keySet()){
            System.out.println(menuItems.get(name).getDescription());
        }
    }

    public double calculateTotalSales(){
        double totalSales = 0;
        for(Customer customer : customers){
            for(TableReservation<? extends MenuItem> reservation : customer.getReservations()){
                totalSales += reservation.calculateTotalAmount();
            }
        }
        return totalSales;
    }
}
