package binarysearch.findpeakelement;

import java.util.Scanner;

public class FindPeakElement {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Give Size of array: ");
        int n= sc.nextInt();

        int[] array= new int[n];

        System.out.println("Enter elements of array one by one: ");
        for(int i=0; i<n; i++){
            array[i]= sc.nextInt();
        }

        int left=0;
        int right= array.length-1;
        int mid;

        while(left<=right){
            mid= (left+right)/2;
            if(array[mid]>array[mid-1] && array[mid]>array[mid+1]){
                System.out.println("Peak Element: " + array[mid]);
                break;
            }
            else if(array[mid]<array[mid-1]){
                right= mid-1;
            }
            else if(array[mid]<array[mid+1]){
                left= mid+1;
            }
        }
    }
}
