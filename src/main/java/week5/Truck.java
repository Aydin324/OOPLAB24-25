package week5;

public class Truck extends Vehicle implements Repairable{
    //lifespan attribute initialized in constructor

    //constructors
    public Truck(String modelName){
        super(modelName);
        lifespan = expectedLifespan();
    }
    public Truck(String modelName, int mileage, int health){
        super(modelName, mileage, health);
        lifespan = expectedLifespan();
    }

    //Implement method from interface and abstract class
    @Override
    public String repair(){
        return "Engine overhauled and tyres changed for " + modelName;
    }
    @Override
    public String service(){
        return "Service preformed for " + modelName + ". " +
                "At the time of service, vehicle had " + mileage + " miles and was at " + health + " health.";
    }
    @Override
    public int expectedLifespan(){
        return 1000000;
    }

    //custom methods
    public void haul(int loadWeight){
        mileage += 1000;
        if(loadWeight > 5000){
            health -= 5;
        }
        else{
            health--;
        }
        if(health < 30){
            lifespan -= 20000;
        }

    }
}
