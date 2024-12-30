package week13.task6;

import java.util.ArrayList;
import java.util.List;

public class Coffee {
    private int size;
    private String type;
    private List<String> toppings;

    public Coffee(){
        this.toppings = new ArrayList<String>();
    }

    public void setSize(int size){
        this.size = size;
    }
    public void setType(String type){
        this.type = type;
    }
    public void setToppings(List<String> toppings){
        this.toppings = toppings;
    }
    public void addTopping(String topping){
        this.toppings.add(topping);
    }

    @Override
    public String toString(){
        return this.type + " " + this.size + " " + this.toppings;
    }
}
