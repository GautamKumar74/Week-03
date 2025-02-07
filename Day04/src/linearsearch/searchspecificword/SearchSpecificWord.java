package linearsearch.searchspecificword;

import java.util.Scanner;

public class SearchSpecificWord {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number of sentences in which you want to search the word: ");
        int n= sc.nextInt();
        sc.nextLine(); // Consume the leftover newline
        System.out.println("Enter sentences one by one: ");
        String[] arr= new String[n];
        for(int i=1; i<=arr.length; i++){
            System.out.println("Enter sentence: " + i + " ");
            arr[i-1]= sc.nextLine();
        }
        System.out.println("Enter the word you want to search in these sentences: ");
        String word= sc.next();
        String result= search(arr,word);
        System.out.println(result);
    }
    private static String search(String[] arr, String word){
        for(int i=0; i< arr.length; i++){
            String[] wordInSentence= arr[i].split("\\s+");
            for(String searched: wordInSentence){
                if(searched.equals(word)){
                    return arr[i];
                }
            }
        }
        return "not found";
    }
}
