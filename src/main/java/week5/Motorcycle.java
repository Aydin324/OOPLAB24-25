package week5;

public class Motorcycle extends Vehicle {
    //lifespan attribute initialized in constructor

    //constructors
    public Motorcycle(String modelName){
        super(modelName);
        lifespan = expectedLifespan();
    }
    public Motorcycle(String modelName, int mileage, int health){
        super(modelName, mileage, health);
        lifespan = expectedLifespan();
    }

    //overriding abstract class methods
    @Override
    public String service(){
        return "Chain lubricated for " + modelName + ". " +
                "At the time of service, vehicle had " + mileage + " miles and was at " + health + " health.";
    }
    @Override
    public int expectedLifespan(){
        return 50000;
    }

    //custom methods
    public void race(int raceMiles){
        mileage += raceMiles;
        health -= 5;
        if(health < 40){
            lifespan -= 5000;
        }
    }
}
