package binarysearch.searchtargetin2dsortedmatrix;

import java.util.Scanner;

public class SearchTargetInTwoDSortedMatrix {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Give Number of rows and columns you want for your 2d matrix: ");
        int numRows= sc.nextInt();
        int numColumns= sc.nextInt();

        int[][] array= new int[numRows][numColumns];
        System.out.println("Enter elements in ascending order of 2d matrix one by one: ");
        for(int i=0; i< array.length; i++){
            for(int j=0; j<array[i].length; j++){
                array[i][j]= sc.nextInt();
            }
        }

        System.out.println("Enter the target value you want to search in matrix ");
        int target= sc.nextInt();

        int left= 0;
        int right= (2*3)-1;
        int mid;
        int row;
        int col;
        boolean found= false;
        while(left<=right){
            mid= (left+right)/2;
            row= mid/numColumns;
            col= mid%numColumns;
            if(array[row][col]==target){
                System.out.println("Target found at row: " + (row+1) + ", and at column: " + (col+1) + ".");
                found= true;
                break;
            }
            else if(target<array[row][col]){
                right= mid-1;
            }
            else if(target>array[row][col]){
                left= mid+1;
            }
        }
        if(found==false){
            System.out.println("Target not found");
        }
    }
}
