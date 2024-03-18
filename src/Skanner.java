import java.util.Scanner;

public class Skanner {
    private static Scanner scanner = new Scanner(System.in);

    public static Scanner getScanner() {
        return scanner;
    }

    public static void close() {
        scanner.close();
    }
}