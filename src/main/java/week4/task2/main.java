package week4.task2;

public class main {
    public static void main(String[] args) {
        Circle c = new Circle("Pink", FillType.FILLED, 5.00);
        Rectangle r = new Rectangle("Blue", FillType.NOT_FILLED, 8.00, 2.00);

        c.displayInfo();
        r.displayInfo();
    }
}
