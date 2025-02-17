package midterm_preparation.task1_restaurant;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerId;
    private String name;
    private String phoneNumber;
    private List<TableReservation<? extends MenuItem>> reservations;

    public Customer(String customerId, String name, String phoneNumber) {
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.reservations = new ArrayList<TableReservation<? extends MenuItem>>();
    }

    public void addReservation(TableReservation<? extends MenuItem> reservation) {
        reservations.add(reservation);
    }

    //setters and getters
    public String getCustomerId() {
        return customerId;
    }
    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public List<TableReservation<? extends MenuItem>> getReservations() {
        return reservations;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setReservations(List<TableReservation<? extends MenuItem>> reservations) {
        this.reservations = reservations;
    }
}
