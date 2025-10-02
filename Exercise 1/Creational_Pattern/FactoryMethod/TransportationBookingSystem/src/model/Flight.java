package model;

public class Flight extends Transportation {

    public Flight() {
        super("Flight", 150);
    }

    @Override
    public void bookTicket(String source, String destination, int seats) throws Exception {
        if (seats <= 0) 
            throw new Exception("Seats must be greater than 0");
        if (seats > capacity) 
            throw new Exception("Not enough seats available");
        if (source == null || source.isEmpty() || destination == null || destination.isEmpty())
            throw new Exception("Source and destination cannot be empty");

        System.out.println(seats + " seat(s) booked on Flight from " + source + " to " + destination + " successfully!");
        capacity -= seats;
    }
}
