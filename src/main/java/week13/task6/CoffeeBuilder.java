package week13.task6;

import java.util.List;

public interface CoffeeBuilder {
    public CoffeeBuilder buildType();
    public CoffeeBuilder buildSize(String size);
    public CoffeeBuilder buildToppings(List<String> toppings);
    public Coffee build();

    public String getType();
    public String getSize();
    public List<String> getToppings();
}
