package util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import exception.InvalidTimeFormatException;

public class TimeValidator {
    public static LocalTime parseTime(String time) throws InvalidTimeFormatException {
        try {
            return LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
        } catch (DateTimeParseException e) {
            throw new InvalidTimeFormatException("Error: Invalid time format.");
        }
    }
}
