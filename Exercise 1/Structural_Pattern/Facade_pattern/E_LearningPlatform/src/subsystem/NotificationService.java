// file: subsystem/NotificationService.java
package subsystem;

import util.LoggerUtil;

public class NotificationService {

    public void sendEnrollmentNotification(String studentName, String courseName) {
        LoggerUtil.logInfo("Sending notification: " + studentName + " enrolled in " + courseName);
        // Simulated email/SMS logic
    }
}
