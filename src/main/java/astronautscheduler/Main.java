package astronautscheduler;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ScheduleManager manager = ScheduleManager.getInstance();
        TaskFactory factory = new TaskFactory();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Astronaut Daily Schedule Organizer ===");
        
        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks"); 
            System.out.println("3. Remove Task");
            System.out.println("4. Exit");
            System.out.print("Choose option (1-4): ");
            
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    addTask(manager, factory, scanner);
                    break;
                case "2":
                    viewTasks(manager);
                    break;
                case "3":
                    removeTask(manager, scanner);
                    break;
                case "4":
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option! Please choose 1-4.");
            }
        }
    }
    
    private static void addTask(ScheduleManager manager, TaskFactory factory, Scanner scanner) {
        try {
            System.out.print("Enter task description: ");
            String desc = scanner.nextLine();
            System.out.print("Enter start time (HH:mm): ");
            String start = scanner.nextLine();
            System.out.print("Enter end time (HH:mm): ");
            String end = scanner.nextLine();
            System.out.print("Enter priority (High/Medium/Low): ");
            String priority = scanner.nextLine();
            
            Task task = factory.createTask(desc, start, end, priority);
            
            if (manager.addTask(task)) {
                System.out.println("SUCCESS: Task added successfully!");
            } else {
                System.out.println("ERROR: Task overlaps with existing task!");
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    
    private static void viewTasks(ScheduleManager manager) {
        List<Task> tasks = manager.getAllTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for today.");
        } else {
            System.out.println("\nToday's Schedule:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
    
    private static void removeTask(ScheduleManager manager, Scanner scanner) {
        System.out.print("Enter task description to remove: ");
        String desc = scanner.nextLine();
        
        if (manager.removeTask(desc)) {
            System.out.println("SUCCESS: Task removed successfully!");
        } else {
            System.out.println("ERROR: Task not found!");
        }
    }
}