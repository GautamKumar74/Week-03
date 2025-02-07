package stringbuilderproblems.reversestringproblem;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter String to reverse: ");
        String s= sc.nextLine();
        StringBuilder str= new StringBuilder();
        str.append(s);
        str.reverse();
        s= str.toString();
        System.out.println("Reversed String: " + s);
    }
}
