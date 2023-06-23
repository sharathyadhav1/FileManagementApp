package ManagmentApp;

import java.util.*;

public class App {
    private static List<String> fileNames = new ArrayList<>();

    public static void main(String[] args) {
        displayWelcomeScreen();
    }

    public static void displayWelcomeScreen() {
        System.out.println("Welcome to File Management App");
        System.out.println("Developer: Your Name");
        System.out.println("----------------------------");
        System.out.println("Select an option:");
        System.out.println("1. Show current file names in ascending order");
        System.out.println("2. File management");
        System.out.println("3. Close the application");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (option) {
            case 1:
                displayFileNames();
                break;
            case 2:
                handleFileManagement(scanner);
                break;
            case 3:
                closeApplication();
                break;
            default:
                System.out.println("Invalid option");
                displayWelcomeScreen();
        }
    }

    public static void displayFileNames() {
        if (fileNames.isEmpty()) {
            System.out.println("No files found");
        } else {
            Collections.sort(fileNames);
            System.out.println("Current file names in ascending order:");
            for (String fileName : fileNames) {
                System.out.println(fileName);
            }
        }
        displayWelcomeScreen();
    }

    public static void handleFileManagement(Scanner scanner) {
        System.out.println("File Management");
        System.out.println("----------------------------");
        System.out.println("Select an option:");
        System.out.println("1. Add a file");
        System.out.println("2. Delete a file");
        System.out.println("3. Search for a file");
        System.out.println("4. Back to main menu");

        int option = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (option) {
            case 1:
                System.out.println("Enter file name:");
                String fileName = scanner.nextLine();
                addFile(fileName);
                break;
            case 2:
                System.out.println("Enter file name:");
                String deleteFileName = scanner.nextLine();
                deleteFile(deleteFileName);
                break;
            case 3:
                System.out.println("Enter file name to search:");
                String searchFileName = scanner.nextLine();
                searchFile(searchFileName);
                break;
            case 4:
                displayWelcomeScreen();
                break;
            default:
                System.out.println("Invalid option");
                handleFileManagement(scanner);
        }
    }

    public static void addFile(String fileName) {
        fileNames.add(fileName);
        System.out.println("File added successfully");
        handleFileManagement(new Scanner(System.in));
    }

    public static void deleteFile(String fileName) {
        if (fileNames.remove(fileName)) {
            System.out.println("File deleted successfully");
        } else {
            System.out.println("File not found");
        }
        handleFileManagement(new Scanner(System.in));
    }

    public static void searchFile(String fileName) {
        boolean found = false;
        for (String name : fileNames) {
            if (name.equals(fileName)) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("File found");
        } else {
            System.out.println("File not found");
        }
        handleFileManagement(new Scanner(System.in));
    }

    public static void closeApplication() {
        System.out.println("Closing the application...");
        System.exit(0);
    }
}