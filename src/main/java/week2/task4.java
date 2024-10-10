package week2;

import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        int a, b;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first and last number: ");
        a = sc.nextInt();
        b = sc.nextInt();
        a++;
        if(a>=b)
            System.out.println("First number is: " + a + ", second number is: " + b);
        while(a<b){
            System.out.println(a++);
        }
    }
}
