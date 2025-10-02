package util;

public class ValidationUtil {

    public static void validateSeats(int seats) throws Exception {
        if(seats <= 0) {
            throw new Exception("Seats must be greater than 0");
        }
    }
}
