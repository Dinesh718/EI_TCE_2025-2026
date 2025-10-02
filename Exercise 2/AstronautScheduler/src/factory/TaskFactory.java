package factory;

import model.Task;
import util.TimeValidator;
import exception.InvalidTimeFormatException;
import model.PriorityLevel;
import java.time.LocalTime;

public class TaskFactory {
    public static Task createTask(String description, String start, String end, String priority)
            throws InvalidTimeFormatException {
        LocalTime startTime = TimeValidator.parseTime(start);
        LocalTime endTime = TimeValidator.parseTime(end);

        if (endTime.isBefore(startTime)) {
            throw new InvalidTimeFormatException("End time cannot be before start time.");
        }

        PriorityLevel priorityLevel = PriorityLevel.valueOf(priority.toUpperCase());
        return new Task(description, startTime, endTime, priorityLevel);
    }
}
