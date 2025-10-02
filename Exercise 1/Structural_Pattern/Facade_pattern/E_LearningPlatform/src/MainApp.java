import facade.ElearningFacade;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        ElearningFacade facade = new ElearningFacade();
        Scanner sc = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("\n--- E-Learning Platform ---");
            System.out.println("1) List of Courses");
            System.out.println("2) Add Student to a Course");
            System.out.println("3) List of Students in a Course");
            System.out.println("4) Exit");
            System.out.print("Enter your choice: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Invalid input! Please enter a number between 1-4.");
                continue;
            }

            switch (choice) {
                case 1:
                    facade.listCourses();
                    break;
                case 2:
                    System.out.print("Enter student name: ");
                    String studentName = sc.nextLine();
                    System.out.print("Enter course name: ");
                    String courseName = sc.nextLine();
                    System.out.print("Enter payment amount: ");
                    double payment = 0;
                    try {
                        payment = Double.parseDouble(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid payment amount! Try again.");
                        break;
                    }
                    facade.enrollStudent(studentName, courseName, payment);
                    break;
                case 3:
                    System.out.print("Enter course name: ");
                    String cName = sc.nextLine();
                    facade.listStudentsInCourse(cName);
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.err.println("Invalid choice! Enter a number between 1-4.");
            }
        }

        sc.close();
    }
}
