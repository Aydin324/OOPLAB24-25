package week13.task6;

import java.util.List;

public class CoffeeDirector {
    public Coffee constructCoffee(CoffeeBuilder builder, String type, int size, List<String> toppings) {
        return builder.buildType(type)
                .buildSize(size)
                .buildToppings(toppings)
                .build();
    }
}
