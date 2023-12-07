import java.util.Scanner;

public class GuessNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of N (N = 2^n): ");
        int n = scanner.nextInt();
        int N = (int) Math.pow(2, n);

        System.out.println("Choose a number between 0 and " + (N - 1));

        int low = 0;
        int high = N - 1;
        int guess = guessNum(low, high, scanner);

        System.out.println("The number you choose is : " + guess);
    }

    private static int guessNum(int low, int high, Scanner scanner) {
        if (low <= high) {
            int mid = (low + high) / 2;
            System.out.print("Is the number between " + low + " and " + mid + "? (true/false): ");
            boolean res = scanner.nextBoolean();

            if (res) {
                return guessNum(low, mid - 1, scanner);
            } else {
                return guessNum(mid + 1, high, scanner);
            }
        }
        return low;
    }
}
