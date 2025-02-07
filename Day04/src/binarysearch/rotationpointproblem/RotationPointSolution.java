package binarysearch.rotationpointproblem;

import java.util.Scanner;

public class RotationPointSolution {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n= sc.nextInt();
        int[] arr= new int[n];
        for(int i=0; i<n; i++){
            arr[i]= sc.nextInt();
        }
        int left= 0;
        int right= n-1;
        int mid;
        while(left<=right){
            mid= (left+right)/2;
            if(arr[mid]>arr[right]){
                left= mid+1;
            }
            else{
                right= mid;
            }
        }
        System.out.println(left);
    }
}
