package week1;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Task 1
        /*System.out.println("My name is Aydin Sulejmanovic");*/

        //Task 2
        /*System.out.println("Hello World!\n (And all people of the world)");*/

        //Task 3
        //System.out.println("Seconds in a 365-day year: " + 365*24*60*60);

        //Task 4
        /*Scanner sc = new Scanner(System.in);
        System.out.println("Enter two integers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Sum: " + (a+b));*/

        //Task 5
        /*Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int a = sc.nextInt();
        if(a>0)
            System.out.println("Number is positive!");
        else
            System.out.println("Number is negative!");*/

        //Task 6
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two integers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        if(a>b)
            System.out.println(a+" is greater than "+ b);
        else if(a<b)
            System.out.println(a+" is less than "+ b);
        else
            System.out.println(a+" is equal to "+b);
            }
}