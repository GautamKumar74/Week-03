package inputstreamreader.convertbytestreamtocharacterstream;

import java.io.*;

public class InputStreamReaderExample {
    public static void main(String[] args) {
        // Specify the file path
        String filePath = "src/inputstreamreader/convertbytestreamtocharacterstream/example.txt"; // Ensure this file exists in the correct location

        try (
                FileInputStream fileInputStream = new FileInputStream(filePath);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader)
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
