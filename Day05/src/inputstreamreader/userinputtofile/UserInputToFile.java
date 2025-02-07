package inputstreamreader.userinputtofile;

import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        String filePath = "src/inputstreamreader/userinputtofile/user_input.txt"; // Output file

        try (
                InputStreamReader inputStreamReader = new InputStreamReader(System.in);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                FileWriter fileWriter = new FileWriter(filePath, true); // Append mode
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
        ) {
            System.out.println("Enter text (type 'exit' to stop):");

            String userInput;
            while (true) {
                userInput = bufferedReader.readLine();
                if ("exit".equalsIgnoreCase(userInput)) {
                    break; // Stop if user enters "exit"
                }
                bufferedWriter.write(userInput);
                bufferedWriter.newLine(); // Write input as a new line
            }

            System.out.println("Input saved to " + filePath);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

