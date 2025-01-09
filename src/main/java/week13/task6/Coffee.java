package week13.task6;

import java.util.ArrayList;
import java.util.List;

public class Coffee {
    private String type;
    private String size;
    private List<String> toppings;

    public Coffee(CoffeeBuilder builder) {
        this.type = builder.getType();
        this.size = builder.getSize();
        this.toppings = builder.getToppings();
    }

    @Override
    public String toString(){
        return type + " " + size + " " + toppings;
    }

    public static class EspressoBuilder implements CoffeeBuilder{
        private String type;
        private String size;
        private List<String> toppings;

        @Override
        public CoffeeBuilder buildType(){
            type = "espresso";
            return this;
        }
        @Override
        public CoffeeBuilder buildSize(String size){
            this.size = size;
            return this;
        }
        @Override
        public CoffeeBuilder buildToppings(List<String> toppings){
            this.toppings = toppings;
            return this;
        }
        @Override
        public Coffee build(){
            return new Coffee(this);
        }
        @Override
        public String getType() {return type;}
        @Override
        public String getSize() {return size;}
        @Override
        public List<String> getToppings() {return toppings;}
    }

    public static class LatteBuilder implements CoffeeBuilder{
        private String type;
        private String size;
        private List<String> toppings;

        @Override
        public CoffeeBuilder buildType(){
            type = "latte";
            return this;
        }
        @Override
        public CoffeeBuilder buildSize(String size){
            this.size = size;
            return this;
        }
        @Override
        public CoffeeBuilder buildToppings(List<String> toppings){
            this.toppings = toppings;
            return this;
        }
        @Override
        public Coffee build(){
            return new Coffee(this);
        }
        @Override
        public String getType() {return type;}
        @Override
        public String getSize() {return size;}
        @Override
        public List<String> getToppings() {return toppings;}
    }

    public static class CapuccinoBuilder implements CoffeeBuilder{
        private String type;
        private String size;
        private List<String> toppings;

        @Override
        public CoffeeBuilder buildType(){
            type = "capuccino";
            return this;
        }
        @Override
        public CoffeeBuilder buildSize(String size){
            this.size = size;
            return this;
        }
        @Override
        public CoffeeBuilder buildToppings(List<String> toppings){
            this.toppings = toppings;
            return this;
        }
        @Override
        public Coffee build(){
            return new Coffee(this);
        }
        @Override
        public String getType() {return type;}
        @Override
        public String getSize() {return size;}
        @Override
        public List<String> getToppings() {return toppings;}
    }
}
