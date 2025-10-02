package service;

public class ValidationService {
    public static boolean isValidName(String name) {
        return (name != null && !name.trim().isEmpty());
    }
}
