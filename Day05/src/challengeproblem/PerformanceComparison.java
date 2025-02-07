package challengeproblem;

import java.io.*;
import java.util.StringTokenizer;

public class PerformanceComparison {
    public static void main(String[] args) {
        // 1. Compare StringBuilder and StringBuffer
        compareStringBuilderAndBuffer();

        // 2. Compare FileReader and InputStreamReader
        String filePath = "src/challengeproblem/large_text_file.txt"; // file exists (100MB)
        compareFileReadingMethods(filePath);
    }

    // Method to compare StringBuilder and StringBuffer
    private static void compareStringBuilderAndBuffer() {
        int iterations = 1_000_000;
        String text = "hello";

        // StringBuilder Performance Test
        long startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long stringBuilderTime = System.currentTimeMillis() - startTime;
        System.out.println("StringBuilder time: " + stringBuilderTime + " ms");

        // StringBuffer Performance Test
        startTime = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(text);
        }
        long stringBufferTime = System.currentTimeMillis() - startTime;
        System.out.println("StringBuffer time: " + stringBufferTime + " ms");
    }

    // Method to compare FileReader and InputStreamReader
    private static void compareFileReadingMethods(String filePath) {
        // FileReader Test
        long startTime = System.currentTimeMillis();
        int wordCountFileReader = countWordsUsingFileReader(filePath);
        long fileReaderTime = System.currentTimeMillis() - startTime;
        System.out.println("FileReader - Word Count: " + wordCountFileReader + ", Time: " + fileReaderTime + " ms");

        // InputStreamReader Test
        startTime = System.currentTimeMillis();
        int wordCountInputStreamReader = countWordsUsingInputStreamReader(filePath);
        long inputStreamReaderTime = System.currentTimeMillis() - startTime;
        System.out.println("InputStreamReader - Word Count: " + wordCountInputStreamReader + ", Time: " + inputStreamReaderTime + " ms");
    }

    // Count words using FileReader
    private static int countWordsUsingFileReader(String filePath) {
        int wordCount = 0;
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {
                wordCount += new StringTokenizer(line).countTokens();
            }
        } catch (IOException e) {
            System.err.println("Error reading file with FileReader: " + e.getMessage());
        }
        return wordCount;
    }

    // Count words using InputStreamReader
    private static int countWordsUsingInputStreamReader(String filePath) {
        int wordCount = 0;
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "UTF-8");
             BufferedReader br = new BufferedReader(isr)) {

            String line;
            while ((line = br.readLine()) != null) {
                wordCount += new StringTokenizer(line).countTokens();
            }
        } catch (IOException e) {
            System.err.println("Error reading file with InputStreamReader: " + e.getMessage());
        }
        return wordCount;
    }
}

