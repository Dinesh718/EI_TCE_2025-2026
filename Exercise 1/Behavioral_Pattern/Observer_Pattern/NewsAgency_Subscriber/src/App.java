
import service.NewsService;
import util.LoggerUtil;

import java.util.Scanner;
import java.util.logging.Logger;

public class App {
    private static final Logger LOGGER = LoggerUtil.getLogger();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NewsService newsService = new NewsService();

        boolean exit = false;
        while (!exit) {
            try {
                System.out.println("\n=== News Agency Menu ===");
                System.out.println("1. Add Subscriber");
                System.out.println("2. Remove Subscriber");
                System.out.println("3. Publish News");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");

                int choice = Integer.parseInt(scanner.nextLine().trim());
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter subscriber name: ");
                        String name = scanner.nextLine();
                        newsService.addSubscriber(name);
                    }
                    case 2 -> {
                        System.out.print("Enter subscriber name to remove: ");
                        String name = scanner.nextLine();
                        newsService.removeSubscriber(name);
                    }
                    case 3 -> {
                        System.out.print("Enter news to publish: ");
                        String news = scanner.nextLine();
                        newsService.publishNews(news);
                    }
                    case 4 -> {
                        LOGGER.info("Exiting application...");
                        exit = true;
                    }
                    default -> LOGGER.warning("Invalid choice. Try again.");
                }
            } catch (NumberFormatException e) {
                LOGGER.severe("Invalid input. Please enter a number.");
            } catch (Exception e) {
                LOGGER.severe("Unexpected error: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
