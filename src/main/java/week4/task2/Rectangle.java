package week4.task2;

import static java.lang.Math.pow;

public class Rectangle extends Shape{
    private double width, height;

    public Rectangle(String color, FillType fillType, double width, double height) {
        super(color, fillType);
        this.width = width;
        this.height = height;
    }

    @Override
    public void displayInfo(){
        System.out.println("Color: " + getColor() + ", FillType: " + getFillType() + ", Width: " + width + ", Height: " + height);
    }

    public double getArea(){
        return height * width;
    }
}
