package sortingalgorithms.quicksort;

import java.util.Scanner;

public class QuickSortProductPrices {
    // Function to perform Quick Sort
    private static void quickSort(int[] array, int lowIndex, int highIndex){

        if(lowIndex>=highIndex){
            return;
        }

        int pivot= array[highIndex];

        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer<rightPointer){
            while (array[leftPointer]<= pivot && leftPointer<rightPointer){
                leftPointer++;
            }
            while (array[rightPointer]>= pivot && leftPointer<rightPointer){
                rightPointer--;
            }
            swap(array, leftPointer, rightPointer);
        }

        swap(array, leftPointer, highIndex);

        quickSort(array, lowIndex, leftPointer-1);
        quickSort(array, leftPointer+1, highIndex);
    }

    private static void swap(int[] array, int index1, int index2){
        int temp= array[index1];
        array[index1]= array[index2];
        array[index2]= temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();
        int[] prices = new int[n];

        System.out.println("Enter the product prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        quickSort(prices, 0, n - 1); // Call quick sort

        System.out.println("Sorted product prices in ascending order:");
        for (int price : prices) {
            System.out.print(price + " ");
        }

        sc.close();
    }
}

