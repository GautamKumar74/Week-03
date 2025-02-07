package stringbuilderproblems.removeduplicatesfromstring;

import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter a string to remove duplicates from it: ");
        String str= sc.nextLine();
        StringBuilder sb= new StringBuilder();
        HashSet<Character> set= new HashSet<>();
        for(char ch: str.toCharArray()){
            if(!set.contains(ch)){
                set.add(ch);
                sb.append(ch);
            }
        }
        System.out.println(sb);
    }
}
