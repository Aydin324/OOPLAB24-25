package week6.tasks_generics;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class tasks {
    public static void main(String[] args) {
        //task 1 test code
        ArrayList<Integer> list = new ArrayList<>(asList(1,2,3,4,5));
        System.out.println(printEvenOddSums(list));

        //task 2 test code
        List<String> list2 = new ArrayList<String>(asList("jedan", "dva", "tri"));
        System.out.println(reverseOrder(list2));
    }

    //task 1 method
    public static <T extends Number> String printEvenOddSums(List<T> list){
        double evenSum = 0, oddSum = 0, member;
        for(T num : list){
            member = num.doubleValue();
            if(member%2!=0)
                oddSum += member;
            else
                evenSum += member;
        }
        return "Even sum: " + evenSum + "\nOdd sum: " + oddSum;
    }

    //task 2 method
    public static <T> ArrayList<T> reverseOrder(List<T> list){
        ArrayList<T> reversed = new ArrayList<>();
        for(int i=list.size()-1; i>-1; i--){
            reversed.add(list.get(i));
        }
        return reversed;
    }
}
