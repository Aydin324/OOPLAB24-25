package week2;

import java.util.Scanner;

public class task8 {
    public static void main(String[] args) {
        int num;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        num = sc.nextInt();

        draw(num);
    }

    public static void draw(int e){
        for(int i=e; i>=0; i--){
            for(int j=0; j<i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
