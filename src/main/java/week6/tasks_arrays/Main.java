package week6.tasks_arrays;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] arr = {2, 55, 44, 33, 22, 87};

        //testing tasks 1, 2, 3 and 4
        /*System.out.println("Index of the smallest: " + indexOfTheSmallest(arr));

        System.out.println("Idex of the smallest starting from 2: " + indexOfTheSmallestStartingFrom(arr, 2));

        System.out.println("Array before swap: ");
        printArray(arr);
        swap(arr, 0, 5);
        System.out.println("Array after swap: ");
        printArray(arr);*/

        //testing task 5
        /*
        Scanner sc = new Scanner(System.in);
        printArray(arr);
        System.out.print("\nEnter the element you're seeking: ");
        int element = sc.nextInt();
        System.out.println(myBinarySearch(arr, element));
        */

        //testing task 6
        //printElegantly(arr);


    }

    //utilities
    public static int smallest(int[] array, int start){
        int smallest = array[start];
        for(int i=start; i<array.length; i++){
            if(array[i]<smallest){
                smallest = array[i];
            }
        }
        return smallest;
    }

    public static void printArray(int[] array){
        for(int i=0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }
    }


    //task 1
    public static int smallest(int[] array){
        return Arrays.stream(array).min().getAsInt();
    }

    //task 2
    public static int indexOfTheSmallest(int[] array){
        int smallest = smallest(array);
        for(int i=0; i<array.length; i++){
            if(array[i] == smallest){
                return i;
            }
        }
        return -1;
    }

    //task 3
    public static int indexOfTheSmallestStartingFrom(int[] array, int start){
        int smallest = smallest(array, start);
        for(int i=start; i<array.length; i++){
            if(array[i] == smallest){
                return i;
            }
        }
        return -1;
    }

    //task 4
    public static void swap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    //task 5
    public static int myBinarySearch(int[] array, int element) {
        int left = 0, right = array.length - 1;
        int pointer;

        while (left <= right) {
            pointer = left + (right - left) / 2;

            if (array[pointer] == element) {
                return pointer;
            } else if (array[pointer] < element) {
                left = pointer + 1;
            } else {
                right = pointer - 1;
            }
        }

        System.out.println("Element not found");
        return -1;
    }

    //task 6
    public static void printElegantly(int[] array){
        System.out.print("[");
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]);
            if(i!=array.length-1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }


}
