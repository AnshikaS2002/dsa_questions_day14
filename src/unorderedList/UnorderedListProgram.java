package unorderedList;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class UnorderedListProgram {

    public static void main(String[] args) {
        UnorderedList<String> wordList = new UnorderedList<>();
        Scanner scanner = new Scanner(System.in);

        try (Scanner fileScanner = new Scanner(new File("wordList2.txt"))) {
            while (fileScanner.hasNext()) {
                wordList.add(fileScanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Current Word List:");
        wordList.display();
        System.out.print("Enter a word to search: ");
        String searchWord = scanner.next();

        if (wordList.search(searchWord)) {
            System.out.println("Word is present. Removing from the list.");
            wordList.remove(searchWord);
        } else {
            System.out.println("Word not found. Adding to the list.");
            wordList.add(searchWord);
        }

        System.out.println("Updating the list file:");
        wordList.display();
        wordList.saveToFile("wordList2.txt");

        scanner.close();
    }
}
