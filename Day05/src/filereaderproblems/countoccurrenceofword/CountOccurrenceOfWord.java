package filereaderproblems.countoccurrenceofword;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class CountOccurrenceOfWord {
    public static void main(String[] args) {
        String filePath = "src/filereaderproblems/readafilelinebyline/sample.txt";
        String target= "I";
        int count= 0;
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line=br.readLine())!=null){
               String[] word= line.split("\\s+");
               for(int i=0; i<word.length; i++){
                   if(target.equals(word[i])){
                       count++;
                   }
               }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(count);
    }
}
