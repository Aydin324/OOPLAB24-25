package week2;

import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        int num;
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        while(true){
            System.out.print("Enter an integer: ");
            num = sc.nextInt();
            sum += num;
            if(num == 0){
                break;
            }
        }
        System.out.println("The sum is: " + sum);
    }
}
