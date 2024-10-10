package week2;

import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        double a, b, c;
        System.out.print("Enter 3 numbers: ");
        Scanner sc = new Scanner(System.in);
        a = sc.nextDouble();
        b = sc.nextDouble();
        c = sc.nextDouble();
        System.out.println("Their sum is: " + (a + b + c));
    }
}
