import java.util.ArrayList;
import java.util.List;

public class AnagramPalindromePrimes {

    public static void main(String[] args) {
        int start = 0;
        int end = 100000;

        System.out.println("Prime numbers in the range " + start + " to " + end +
                " that are Anagram as well as Palindrome are:");
        printAnagramPalindromePrimes(start, end);
    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean areAnagrams(String str1, String str2) {
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        java.util.Arrays.sort(charArray1);
        java.util.Arrays.sort(charArray2);

        return java.util.Arrays.equals(charArray1, charArray2);
    }

    private static boolean isPalindrome(int num) {
        int originalNum = num;
        int reversedNum = 0;

        while (num > 0) {
            int digit = num % 10;
            reversedNum = reversedNum * 10 + digit;
            num /= 10;
        }

        return originalNum == reversedNum;
    }

    private static void printAnagramPalindromePrimes(int start, int end) {
        List<Integer> anagramPalindromePrimes = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                for (int j = i + 1; j <= end; j++) {
                    if (isPrime(j) && areAnagrams(Integer.toString(i), Integer.toString(j)) &&
                            isPalindrome(i) && isPalindrome(j)) {
                        anagramPalindromePrimes.add(i);
                        anagramPalindromePrimes.add(j);
                    }
                }
            }
        }
        System.out.println(anagramPalindromePrimes);
    }
}
