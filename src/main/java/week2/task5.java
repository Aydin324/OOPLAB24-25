package week2;

import java.util.Scanner;

public class task5 {
    public static void main(String[] args) {
        int sum=0;
        int num;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any number");
        num = sc.nextInt();
        for(int i=0; i<=num; i++){
            sum += (int)Math.pow(2, i);
        }
        System.out.println("The sum is: " + sum);
    }
}
