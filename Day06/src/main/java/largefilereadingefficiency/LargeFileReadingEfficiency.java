package largefilereadingefficiency;

import java.io.*;

public class LargeFileReadingEfficiency {
    public static void main(String[] args) {
        String basePath = "src/main/java/largefilereadingefficiency/";
        String[] fileNames = {"file_1MB.txt", "file_100MB.txt", "file_500MB.txt"};

        System.out.println("Reading files using FileReader and InputStreamReader...\n");

        for (String fileName : fileNames) {
            String filePath = basePath + fileName;
            System.out.println("Processing file: " + filePath);

            // Read using FileReader (Character Stream)
            long fileReaderTime = measureFileReadTimeWithFileReader(filePath);
            System.out.println("FileReader Time: " + fileReaderTime + " ms");

            // Read using InputStreamReader (Byte Stream)
            long inputStreamReaderTime = measureFileReadTimeWithInputStreamReader(filePath);
            System.out.println("InputStreamReader Time: " + inputStreamReaderTime + " ms");

            System.out.println("------------------------------------");
        }
    }

    // Measure time taken by FileReader
    private static long measureFileReadTimeWithFileReader(String filePath) {
        long startTime = System.currentTimeMillis();
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fileReader)) {
            while (br.readLine() != null); // Read line by line
        } catch (IOException e) {
            System.err.println("Error reading with FileReader: " + e.getMessage());
        }
        return System.currentTimeMillis() - startTime;
    }

    // Measure time taken by InputStreamReader
    private static long measureFileReadTimeWithInputStreamReader(String filePath) {
        long startTime = System.currentTimeMillis();
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath));
             BufferedReader br = new BufferedReader(isr)) {
            while (br.readLine() != null); // Read line by line
        } catch (IOException e) {
            System.err.println("Error reading with InputStreamReader: " + e.getMessage());
        }
        return System.currentTimeMillis() - startTime;
    }
}
