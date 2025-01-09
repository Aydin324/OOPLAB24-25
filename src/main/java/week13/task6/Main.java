package week13.task6;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {
        CoffeeDirector director = new CoffeeDirector();

        //espresso
        Coffee espresso = director.constructCoffee(new Coffee.EspressoBuilder(), "large", asList("cinammon", "salt"));
        System.out.println(espresso);

        //latte
        Coffee latte = director.constructCoffee(new Coffee.LatteBuilder(), "small", asList("cinammon", "salt"));
        System.out.println(latte);
    }
}
