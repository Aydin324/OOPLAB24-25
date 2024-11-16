package midterm_preparation.task1_restaurant;

public class Drink extends MenuItem{
    //in millilitres
    private double volume;

    public Drink(String code, String name, double price, double volume){
        super(code, name, price);
        this.volume = volume;
    }

    @Override
    public String getDescription(){
        return "Code: " + getCode() + "\nName: " + getName() + "\nPrice: " + getPrice()
                + "\nVolume: " + volume;
    }

    //getters and setters
    public double getVolume(){
        return volume;
    }
    public void setVolume(double volume){
        this.volume = volume;
    }
}
