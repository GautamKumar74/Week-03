package filereaderproblems.readafilelinebyline;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadAFileLineByLine {
    public static void main(String[] args) {
        String filePath = "src/filereaderproblems/readafilelinebyline/sample.txt";
        try (BufferedReader br= new BufferedReader(new FileReader(filePath))){
            String line;
            while ( (line= br.readLine())!=null ){
                System.out.println(line);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
