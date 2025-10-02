import factory.TaskFactory;
import manager.ScheduleManager;
import observer.ConflictObserver;
import exception.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ScheduleManager manager = ScheduleManager.getInstance();
        manager.addObserver(new ConflictObserver());

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n==== Astronaut Daily Schedule Organizer ====");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter description: ");
                        String desc = scanner.nextLine();
                        System.out.print("Enter start time (HH:mm): ");
                        String start = scanner.nextLine();
                        System.out.print("Enter end time (HH:mm): ");
                        String end = scanner.nextLine();
                        System.out.print("Enter priority (High/Medium/Low): ");
                        String priority = scanner.nextLine();
                        manager.addTask(TaskFactory.createTask(desc, start, end, priority));
                        break;

                    case 2:
                        System.out.print("Enter task description to remove: ");
                        String removeDesc = scanner.nextLine();
                        manager.removeTask(removeDesc);
                        break;

                    case 3:
                        manager.viewTasks();
                        break;

                    case 4:
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (InvalidTimeFormatException | TaskConflictException | TaskNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}
