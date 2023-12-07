import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageCustomization {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the message:");
        String message = scanner.nextLine();

        String customizedMessage = customizeMessage(message);

        System.out.println("Modified Message:");
        System.out.println(customizedMessage);

        scanner.close();
    }

    private static String customizeMessage(String message) {
        message = message.replaceAll("<<name>>", "John");
        message = message.replaceAll("<<full name>>", "John Doe");
        message = message.replaceAll("91-\\d{10}", "91-9876543210");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = dateFormat.format(new Date());
        message = message.replaceAll("\\d{2}/\\d{2}/\\d{4}", currentDate);

        return message;
    }
}
