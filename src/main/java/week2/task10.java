package week2;

import java.util.Scanner;

public class task10 {
    public static void main(String[] args) {
        int answer = 73;
        Scanner input = new Scanner(System.in);
        int guess = -1, count = 0;

        while(true){
            System.out.println("Guess a number: ");
            guess = input.nextInt();
            count++;
            if(guess < 0 || guess > 100)
                continue;
            if(guess == answer){
                System.out.println("Your number is correct! Number of guesses: " + count);
                break;
            }
            if(guess<answer)
                System.out.println("Higher!");
            else
                System.out.println("Lower!");
        }
    }
}
