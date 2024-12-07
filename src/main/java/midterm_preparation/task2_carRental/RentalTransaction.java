package midterm_preparation.task2_carRental;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class RentalTransaction<T extends Vehicle & Rentable>{
    String transactionId;
    Date rentalDate;
    Map<T, Integer> vehicles_days;
    int customerId;

    public RentalTransaction(String transactionId, Date rentalDate, int customerId) {
        this.transactionId = transactionId;
        this.rentalDate = rentalDate;
        this.customerId = customerId;
        vehicles_days = new HashMap<>();
    }

    public void addVehicle(T vehicle, int days) {
        vehicles_days.put(vehicle, days);
    }

    public double calculateTotalAmount(){
        double total = 0;
        for(T vehicle : vehicles_days.keySet()){
            total += vehicles_days.get(vehicle) * vehicle.getRentalRate();
        }
        return total;
    }

    //getters and setters
    public String getTransactionId() {
        return transactionId;
    }
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
    public Date getRentalDate() {
        return rentalDate;
    }
    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
