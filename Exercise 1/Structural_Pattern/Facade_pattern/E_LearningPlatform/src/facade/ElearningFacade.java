// file: facade/ElearningFacade.java
package facade;

import subsystem.CourseManager;
import subsystem.UserManager;
import subsystem.PaymentProcessor;
import subsystem.NotificationService;
import util.LoggerUtil;

import java.util.*;

public class ElearningFacade {

    private final CourseManager courseManager;
    private final UserManager userManager;
    private final PaymentProcessor paymentProcessor;
    private final NotificationService notificationService;

    private final Map<String, List<String>> courseEnrollments = new HashMap<>();
    private final List<String> courses = new ArrayList<>();

    public ElearningFacade() {
        this.courseManager = new CourseManager();
        this.userManager = new UserManager();
        this.paymentProcessor = new PaymentProcessor();
        this.notificationService = new NotificationService();

        // Predefined courses
        courses.addAll(Arrays.asList("Java Programming", "Python", "Data Structures", "Machine Learning"));
    }

    public void listCourses() {
        LoggerUtil.logInfo("Listing available courses:");
        for (String course : courses) {
            System.out.println("- " + course);
        }
    }

    public void enrollStudent(String studentName, String courseName, double payment) {
        try {
            if (!courses.contains(courseName)) {
                LoggerUtil.logError("Course not found: " + courseName);
                return;
            }

            userManager.registerStudent(studentName);
            courseManager.addCourse(courseName);
            paymentProcessor.processPayment(studentName, payment);
            notificationService.sendEnrollmentNotification(studentName, courseName);

            courseEnrollments.computeIfAbsent(courseName, _ -> new ArrayList<>()).add(studentName);

            LoggerUtil.logInfo("Enrollment successful for " + studentName + " in " + courseName);
        } catch (Exception e) {
            LoggerUtil.logError("Error during enrollment: " + e.getMessage());
        }
    }

    public void listStudentsInCourse(String courseName) {
        List<String> students = courseEnrollments.get(courseName);
        if (students == null || students.isEmpty()) {
            System.out.println("No students enrolled in " + courseName);
            return;
        }
        LoggerUtil.logInfo("Students in " + courseName + ":");
        for (String student : students) {
            System.out.println("- " + student);
        }
    }
}
