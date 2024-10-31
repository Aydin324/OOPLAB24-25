package week5;

public class Car extends Vehicle implements Repairable{
    //lifespan attribute initialized in constructor

    //constructors
    public Car(String modelName){
        super(modelName);
        lifespan = expectedLifespan();
    }
    public Car(String modelName, int mileage, int health){
        super(modelName, mileage, health);
        lifespan = expectedLifespan();
    }

    //Implement method from interface and abstract class
    @Override
    public String repair(){
        return "Engine tuned and oil changed for " + modelName;
    }
    @Override
    public String service(){
        return "Service preformed for " + modelName + ". " +
                "At the time of service, vehicle had " + mileage + " miles and was at " + health + " health.";
    }
    @Override
    public int expectedLifespan(){
        return 150000;
    }

    //custom methods
    public void drive(int miles){
        mileage += miles;
        health--;
        if(health < 30 && lifespan>10000){
            lifespan -= 10000;
        }
    }

}
