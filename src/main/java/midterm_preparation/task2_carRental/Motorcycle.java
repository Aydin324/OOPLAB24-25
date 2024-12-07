package midterm_preparation.task2_carRental;

public class Motorcycle extends Vehicle{
    double engineCapacity;

    public Motorcycle(String vehicleId, String name, double rentalRate, double engineCapacity) {
        super(vehicleId, name, rentalRate);
        this.engineCapacity = engineCapacity;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Engine Capacity: " + engineCapacity;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }
    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }
}
