package practice;

import java.util.*;

import static java.lang.Integer.parseInt;

enum Manufacturer {
    BMW, AUDI, VW
}

public class practice {
    public static void main(String[] args) {

        Component c = new Component("Bosch pump", 0101, Manufacturer.AUDI);
        System.out.println(c.whichComponentAmI());

        Gearbox g = new Gearbox("ZF", 23, Manufacturer.BMW, 8);
        System.out.println(g.whichComponentAmI());

        List<Integer> b = new ArrayList<>();
        b.add(0);
        b.add(1);
        changeme(b);
        System.out.println(b);

    }

    public static void changeme(List<Integer> a){
        a.set(0,6);
    }

}

class Component {
    private String name;
    private int serialNumber;
    private Manufacturer manufacturer;

    public Component(String name, int serialNumber, Manufacturer manufacturer) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
    }

    public String whichComponentAmI(){
        return "Component";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}

class Wheel extends Component {
    private int diameter;

    public Wheel(String name, int serialNumber, Manufacturer manufacturer, int diameter) {
        super(name, serialNumber, manufacturer);
        this.diameter = diameter;
    }

    @Override
    public String whichComponentAmI(){
        return "Wheel";
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }
}

class Gearbox extends Component {
    private int numOfGears;

    public Gearbox(String name, int serialNumber, Manufacturer manufacturer, int numOfGears) {
        super(name, serialNumber, manufacturer);
        this.numOfGears = numOfGears;
    }

    @Override
    public String whichComponentAmI(){
        return "Gearbox";
    }

    public int getNumOfGears() {
        return numOfGears;
    }

    public void setNumOfGears(int numOfGears) {
        this.numOfGears = numOfGears;
    }
}
