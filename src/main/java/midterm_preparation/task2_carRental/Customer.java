package midterm_preparation.task2_carRental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    String customerId;
    String name;
    String phoneNumber;
    List<RentalTransaction<? extends Vehicle>> rentalHistory;

    public Customer(String customerId, String name, String phoneNumber){
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        rentalHistory = new ArrayList<>();
    }

    public void addRentalTransaction(RentalTransaction<? extends Vehicle> rentalTransaction){
        rentalHistory.add(rentalTransaction);
    }

    //s and g
    public String getCustomerId(){
        return customerId;
    }
    public String getName(){
        return name;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setCustomerId(String customerId){
        this.customerId = customerId;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
}
