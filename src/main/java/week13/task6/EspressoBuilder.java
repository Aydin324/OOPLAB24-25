package week13.task6;

import java.util.List;

public class EspressoBuilder implements CoffeeBuilder {
    private Coffee coffee;

    public EspressoBuilder() {
        this.coffee = new Coffee();
    }

    @Override
    public CoffeeBuilder buildType(String type) {
        coffee.setType(type);
        return this;
    }

    @Override
    public CoffeeBuilder buildSize(int size) {
        coffee.setSize(size);
        return this;
    }

    @Override
    public CoffeeBuilder buildToppings(List<String> toppings) {
        for (String topping : toppings) {
            coffee.addTopping(topping);
        }
        return this;
    }

    @Override
    public Coffee build() {
        return coffee;
    }
}
