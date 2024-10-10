package week2;

import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        String pass = "Mijau", re;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter password: ");
            re = sc.nextLine();
            if(re.equals(pass)){
                System.out.println("RIGHT!!! Secret key is: " + pass);
                break;
            }

        }
    }
}
