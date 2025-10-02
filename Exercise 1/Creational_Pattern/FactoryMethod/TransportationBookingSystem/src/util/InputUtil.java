package util;

import java.util.Scanner;

public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readString(String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }

    public static int readInt(String message) {
        System.out.print(message);
        while(!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter an integer: ");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return value;
    }
}
