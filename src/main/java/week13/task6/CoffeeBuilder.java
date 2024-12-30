package week13.task6;

import java.util.List;

public interface CoffeeBuilder {
    public CoffeeBuilder buildType(String type);
    public CoffeeBuilder buildSize(int size);
    public CoffeeBuilder buildToppings(List<String> toppings);
    public Coffee build();
}
