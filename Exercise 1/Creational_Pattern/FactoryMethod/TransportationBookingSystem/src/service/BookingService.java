package service;

import factory.TransportationFactory;
import model.Transportation;
import util.InputUtil;
import util.LoggerUtil;
import util.ValidationUtil;

public class BookingService {

    public void startBooking() {
        LoggerUtil.logInfo("Booking Service Started");
        while(true) {
            try {
                String type = InputUtil.readString("Enter transportation type (Bus/Train/Flight) or 'exit' to quit: ");
                if(type.equalsIgnoreCase("exit")) {
                    LoggerUtil.logInfo("Exiting Booking Service");
                    break;
                }

                Transportation transport = TransportationFactory.createTransportation(type);

                String source = InputUtil.readString("Enter source city: ");
                String destination = InputUtil.readString("Enter destination city: ");
                int seats = InputUtil.readInt("Enter number of seats to book: ");
                ValidationUtil.validateSeats(seats);

                transport.bookTicket(source, destination, seats);

            } catch(Exception e) {
                LoggerUtil.logError("Error: " + e.getMessage());
            }
        }
    }
}
