package stringbufferproblems.concatenatestringsusingstringbuffer;

import java.util.Scanner;

public class ConcatenateStrings {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter how many strings you want to concatenate: ");
        int n= sc.nextInt();
        System.out.println("Enter " + n + " Strings to concatenate: ");
        String[] arr= new String[n];
        for(int i=0; i<n; i++){
            arr[i]= sc.next();
        }
        StringBuffer sb= new StringBuffer();
        for(int i=0; i< arr.length; i++){
            sb.append(arr[i]);
        }
        System.out.println("Concatenated Strings are: " + sb);
    }
}
