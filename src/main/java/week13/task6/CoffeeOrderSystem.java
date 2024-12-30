package week13.task6;

import java.util.List;

public class CoffeeOrderSystem {
    public static void main(String[] args) {
        CoffeeDirector director = new CoffeeDirector();

        // Espresso
        CoffeeBuilder espressoBuilder = new EspressoBuilder();
        Coffee espresso = director.constructCoffee(espressoBuilder, "Espresso", 1, List.of("Extra Shot"));
        System.out.println(espresso);

        // Latte
        CoffeeBuilder latteBuilder = new LatteBuilder();
        Coffee latte = director.constructCoffee(latteBuilder, "Latte", 2, List.of("Vanilla Syrup", "Whipped Cream"));
        System.out.println(latte);

        // Cappuccino
        CoffeeBuilder cappuccinoBuilder = new CappuccinoBuilder();
        Coffee cappuccino = director.constructCoffee(cappuccinoBuilder, "Cappuccino", 3, List.of("Cinnamon", "Chocolate Shavings"));
        System.out.println(cappuccino);
    }
}
