package midterm_preparation.task2_carRental;

import java.util.Date;
import java.util.HashMap;

public abstract class Vehicle implements Rentable {
    String vehicleId, name;
    double rentalRate;
    HashMap<Date, Integer> kilometersRecord = new HashMap<>();

    public Vehicle(String vehicleId, String name, double rentalRate) {
        this.vehicleId = vehicleId;
        this.name = name;
        this.rentalRate = rentalRate;
    }

    @Override
    public double applyDiscount(double discountRate){
        if(discountRate>100 || discountRate<=0)
            return rentalRate;
        double coefficient = 1 - (discountRate / (double)100);
        return coefficient*rentalRate;
    }

    @Override
    public String getDescription() {
        return "Name: " + name + ", Rental Rate: " + rentalRate;
    }

    public void addKilometers(Date date, int kilometers){
        if(!kilometersRecord.containsKey(date)){
            kilometersRecord.put(date, kilometers);
        }
        else{
            kilometers = kilometersRecord.get(date) + kilometers;
            kilometersRecord.put(date, kilometers);
        }
    }

    public int getTotalKilometers(){
        int odometer = 0;
        for(Date date : kilometersRecord.keySet()){
            odometer += kilometersRecord.get(date);
        }
        return odometer;
    }

    //getters and setters
    public String getVehicleId() {
        return vehicleId;
    }
    public String getName() {
        return name;
    }
    public double getRentalRate() {
        return rentalRate;
    }
    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }
    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }
    public void setName(String name) {
        this.name = name;
    }
}
