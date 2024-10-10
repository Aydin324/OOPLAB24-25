package practice;

import java.util.Scanner;

public class practice {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number : ");
        int num = 7;

        /*for(int i=num; i>0; i--){
            for(int j=num-i; j>0; j--){
                System.out.print(" ");
            }
            for(int k=(i*2)-1; k>0; k--){
                System.out.print("*");
            }
            System.out.println();
        }*/

        draw(5);
    }

    public static void draw(int e){
        for(int i=0; i<=e; i++){
            for(int j=0; j<i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
