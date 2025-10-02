package factory;

import model.*;

public class TransportationFactory {

    public static Transportation createTransportation(String type) throws Exception {
        switch(type.toLowerCase()) {
            case "bus":
                return new Bus();
            case "train":
                return new Train();
            case "flight":
                return new Flight();
            default:
                throw new Exception("Invalid transportation type");
        }
    }
}
