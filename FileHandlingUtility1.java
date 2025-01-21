import java.io.*;
import java.util.Scanner;

public class FileHandlingUtility1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) { // Loop to repeatedly ask for operations
            System.out.println("Enter the file path:");
            String filePath = scanner.nextLine();

            System.out.println("Choose an operation:");
            System.out.println("1. Read File");
            System.out.println("2. Write File");
            System.out.println("3. Modify File");
            System.out.println("4. Exit"); // Option to exit
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    readFile(filePath);
                    break;
                case 2:
                    System.out.println("Enter content to write into the file:");
                    String contentToWrite = scanner.nextLine();
                    writeFile(filePath, contentToWrite);
                    break;
                case 3:
                    System.out.println("Enter content to append to the file:");
                    String contentToAppend = scanner.nextLine();
                    modifyFile(filePath, contentToAppend);
                    break;
                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close(); // Close the scanner
                    return; // Exit the program
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to read a file
    public static void readFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            System.out.println("Reading file: " + filePath);
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + filePath + " (" + e.getMessage() + ")");
        }
    }

    // Method to write to a file
    public static void writeFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            System.out.println("Successfully wrote to the file: " + filePath);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + filePath + " (" + e.getMessage() + ")");
        }
    }

    // Method to modify (append to) a file
    public static void modifyFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content);
            writer.newLine(); // Add a newline after the appended content
            System.out.println("Successfully modified the file: " + filePath);
        } catch (IOException e) {
            System.out.println("Error modifying file: " + filePath + " (" + e.getMessage() + ")");
        }
    }
}
