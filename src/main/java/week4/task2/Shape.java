package week4.task2;

enum FillType{
    FILLED, NOT_FILLED
}

public class Shape {
    private String color;
    private FillType fillType;

    public Shape(String color, FillType fillType) {
        this.color = color;
        this.fillType = fillType;
    }

    public void displayInfo(){
        System.out.println("Color: " + color + ", FillType: " + fillType);
    }

    public String getColor() {
        return color;
    }

    public FillType getFillType() {
        return fillType;
    }
}
