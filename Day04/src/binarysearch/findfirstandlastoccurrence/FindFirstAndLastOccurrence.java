package binarysearch.findfirstandlastoccurrence;

import java.util.Scanner;

public class FindFirstAndLastOccurrence {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the size of your sorted array: ");
        int n= sc.nextInt();

        int[] array= new int[n];
        System.out.println("Enter elements of your sorted array one by one: ");
        for(int i=0; i<array.length; i++){
            array[i]= sc.nextInt();
        }
        System.out.println("Enter the target element of which firstOccurrence and lastOccurrence will be calculated: ");
        int target= sc.nextInt();

        int firstOccurrence= findFirstOccurrence(array,target);
        System.out.println("Elements first occurrence index is: " + firstOccurrence);
        int lastOccurrence= findLastOccurrence(array,target);
        System.out.println("Elements last occurrence index is: " + lastOccurrence);
    }
    private static int findFirstOccurrence(int[] array, int target){
        int left=0;
        int right= array.length-1;
        int mid;
        int firstOccurrence=-1;
        while(left<=right){
            mid= (left+right)/2;
            if(target==array[mid]){
                right= mid-1;
                firstOccurrence= mid;
            }
            else if(target<array[mid]){
                right= mid -1;
            }
            else if(target>array[mid]){
                left= mid+1;
            }
        }
        return firstOccurrence;
    }
    private static int findLastOccurrence(int[] array, int target){
        int left=0;
        int right= array.length-1;
        int mid;
        int lastOccurrence=-1;
        while(left<=right){
            mid= (left+right)/2;
            if(target==array[mid]){
                left= mid+1;
                lastOccurrence= mid;
            }
            else if(target<array[mid]){
                right= mid -1;
            }
            else if(target>array[mid]){
                left= mid+1;
            }
        }
        return lastOccurrence;
    }
}
