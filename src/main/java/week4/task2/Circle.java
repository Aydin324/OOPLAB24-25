package week4.task2;

import static java.lang.Math.pow;

public class Circle extends Shape {
    private double radius;
    public final double pi = 3.14;

    public Circle(String color, FillType fillType, double radius){
        super(color, fillType);
        this.radius = radius;
    }

    @Override
    public void displayInfo(){
        System.out.println("Color: " + getColor() + ", FillType: " + getFillType() + ", Radius: " + radius);
    }

    public double getArea(){
        return pi*pow(radius, 2);
    }

    public double calculateCircumference(double PI, double r){
        return 2*PI*r;
    }

    public double calculateCircumference(double r){
        return 2*pi*r;
    }
}
