import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class BinarySearchWord {

    public static void main(String[] args) {
        try {
            String[] wordList = readWordListFromFile("wordList.txt");
            Arrays.sort(wordList);
            String searchWord = getUserInput("Enter a word to search: ");
            boolean isWordFound = binarySearch(wordList, searchWord);

            if (isWordFound) {
                System.out.println(searchWord + " found in the list.");
            } else {
                System.out.println(searchWord + " not found in the list.");
            }
        } catch (IOException e) {
            System.err.println("Error reading the word list file: " + e.getMessage());
        }
    }

    private static String[] readWordListFromFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line = reader.readLine();
        reader.close();
        return line.split(",");
    }

    private static String getUserInput(String prompt) throws IOException {
        BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));
        System.out.print(prompt);
        return reader.readLine();
    }

    private static boolean binarySearch(String[] wordList, String searchWord) {
        int low = 0;
        int high = wordList.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int res = searchWord.compareTo(wordList[mid]);
            if (res == 0) {
                return true;
            } else if (res < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
