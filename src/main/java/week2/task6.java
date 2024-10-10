package week2;

import java.util.Scanner;

public class task6 {
    public static void main(String[] args) {
        int num;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        num = sc.nextInt();

        printText(num);
    }

    public static void printText(int num){
        for(int i=0; i<num; i++){
            System.out.println("In the beginning there were the swamp, the hoe and Java.");
        }
    }
}
