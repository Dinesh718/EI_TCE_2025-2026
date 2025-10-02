package astronautscheduler;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TaskFactory {
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");
    
    public Task createTask(String description, String startTimeStr, String endTimeStr, String priority) {
        try {
            LocalTime startTime = LocalTime.parse(startTimeStr, TIME_FORMATTER);
            LocalTime endTime = LocalTime.parse(endTimeStr, TIME_FORMATTER);
            
            if (endTime.isBefore(startTime) || endTime.equals(startTime)) {
                throw new IllegalArgumentException("End time must be after start time");
            }
            
            return new Task(description, startTime, endTime, priority);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid time format. Use HH:mm format. Error: " + e.getMessage());
        }
    }
}