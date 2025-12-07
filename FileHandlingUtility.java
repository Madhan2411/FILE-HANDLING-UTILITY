import java.io.*;
import java.nio.file.*;

public class FileHandlingUtility {

    //  1. WRITE TO FILE 
    public static void writeToFile(String fileName, String content) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(content);
            writer.close();
            System.out.println(" File created and written successfully.");
        } catch (IOException e) {
            System.out.println(" Error writing to file: " + e.getMessage());
        }
    }

    //  2. READ FROM FILE 
    public static void readFile(String fileName) {
        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(reader);

            String line;
            System.out.println(" FILE CONTENT:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println(" Error reading file: " + e.getMessage());
        }
    }

    //  3. MODIFY (APPEND) FILE 
    public static void appendToFile(String fileName, String content) {
        try {
            FileWriter writer = new FileWriter(fileName, true);  
            writer.write("\n" + content);
            writer.close();
            System.out.println(" Content appended successfully.");
        } catch (IOException e) {
            System.out.println("✘ Error modifying file: " + e.getMessage());
        }
    }

    //  MAIN PROGRAM 
    public static void main(String[] args) {

        String fileName = "sample.txt";

        // Step 1: Write new file
        writeToFile(fileName, "Hello! This is the original content of the file.");

        // Step 2: Read file content
        readFile(fileName);

        // Step 3: Modify / Append new content
        appendToFile(fileName, "This is the newly added appended content.");

        // Step 4: Read updated file
        readFile(fileName);
    }
}
