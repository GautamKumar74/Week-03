package sortingalgorithms.mergesort;

import java.util.Scanner;

public class MergeSortBookPrices {
    private static void mergeSort(int[] inputArray){
        int inputLength= inputArray.length;

        if(inputLength<2){
            return;
        }

        int midIndex= inputLength/2;
        int[] leftHalf= new int[midIndex];
        int[] rightHalf= new int[inputLength-midIndex];

        for(int i=0; i<midIndex; i++){
            leftHalf[i] = inputArray[i];
        }
        for(int i=midIndex; i<inputLength; i++){
            rightHalf[i-midIndex] = inputArray[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(inputArray, leftHalf, rightHalf);
    }

    public static void merge(int[] prices, int[] leftHalf, int[] rightHalf) {
        int leftHalfSize= leftHalf.length;
        int rightHalfSize= rightHalf.length;
        int i=0; int j=0; int k=0;
        while(i<leftHalfSize && j<rightHalfSize){
            if(leftHalf[i]<=rightHalf[j]){
                prices[k]= leftHalf[i];
                i++;
            }
            else{
                prices[k]= rightHalf[j];
                j++;
            }
            k++;
        }
        while(i<leftHalfSize){
            prices[k]= leftHalf[i];
            i++;
            k++;
        }
        while(j<rightHalfSize){
            prices[k]= rightHalf[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of books: ");
        int n = sc.nextInt();
        int[] prices = new int[n];

        System.out.println("Enter the book prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        mergeSort(prices); // Call merge sort

        System.out.println("Sorted book prices in ascending order:");
        for (int price : prices) {
            System.out.print(price + " ");
        }

        sc.close();
    }
}
