package ChallengeProblem;

import java.util.Arrays;
import java.util.Scanner;

public class ChallengeProblem {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the size of array for linear search operation: ");
        int n= sc.nextInt();
        int[] array= new int[n];
        System.out.println("Enter the elements one by one to find the first missing positive number : ");
        for(int i=0; i<n; i++){
            array[i]= sc.nextInt();
        }
        int result= linearSearch(array);
        System.out.println("First missing Positive integer found is: " + result);

        System.out.println("Enter target element you want to search in above array");
        int target= sc.nextInt();
        int binarySearchResult= binarySearch(array, target);
        if(binarySearchResult<0){
            System.out.println("Element not found");
        }
        else{
            System.out.println("After Sorting Element found at index: " + binarySearchResult);
        }
    }
    private static int linearSearch(int[] array){
        int[] array2= new int[array.length+2];
        int ans=-1;
        for(int i=0; i< array.length; i++){
            if(array[i]>0 && array[i]<=array.length){
                array2[array[i]]++;
            }
        }
        for(int i=1; i< array2.length; i++){
            if(array2[i]<1){
                ans=i;
                break;
            }
        }
        return ans;
    }
    private static int binarySearch(int[] array, int target){
        Arrays.sort(array);
        int left= 0;
        int right= array.length-1;
        int mid=-1;
        while (left<=right){
            mid= (left+right)/2;
            if(target==array[mid]){
                return mid;
            }
            else if(array[mid]<target){
                left= mid+1;
            }
            else if(array[mid]>target){
                right= mid-1;
            }
        }
        return -1;
    }
}
