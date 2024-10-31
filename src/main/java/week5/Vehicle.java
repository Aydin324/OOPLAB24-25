package week5;

public abstract class Vehicle {
    //attributes
    protected String modelName;
    protected int mileage;
    protected int health;
    protected int lifespan;

    //constructors
    public Vehicle(String modelName, int mileage, int health) {
        this.modelName = modelName;
        this.mileage = mileage;
        if(health<0 || health>100)
            this.health = 100;
        else
            this.health = health;
    };
    public Vehicle(String modelName){
        this.modelName = modelName;
        mileage = 0;
        health = 100;
    }

    //getters
    public String getModelName() {
        return modelName;
    }
    public int getMileage() {
        return mileage;
    }
    public int getHealth() {
        return health;
    }

    //abstract methods
    public abstract String service();
    public abstract int expectedLifespan();

    //implemented methods
    public boolean needsMaintenance(){
        if(health<70)
            return true;
        return false;
    }
    public int calculateRemainingLifespan(){
        double index = health/100.;
        if((int)(expectedLifespan()*index)>0)
            return (int)(expectedLifespan()*index);
        return 0;
    }
    public void simulateYear(){
        if(lifespan < 0.5*expectedLifespan()){
            health -= 5;
        }
        else {
            lifespan = calculateRemainingLifespan();
        }
    }
    public void preformMaintenance(Vehicle vehicle){
        if(vehicle instanceof Car){
            Car car = (Car)vehicle;
            car.drive(5000);
        }
        else if(vehicle instanceof Truck){
            Truck truck = (Truck)vehicle;
            truck.haul(6000);
        }
        else {
            Motorcycle motorcycle = (Motorcycle)vehicle;
            motorcycle.race(300);
        }
    }

    //Override print
    public String toString(){
        return "\tVehicle name: " + modelName + ", mileage: " + mileage + ", health: " + health + ", lifespan: " + lifespan;
    }
}
