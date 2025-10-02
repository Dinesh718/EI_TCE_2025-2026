package device;

public class Thermostat implements Device {
    private String location;

    public Thermostat(String location) {
        this.location = location;
    }

    @Override
    public void turnOn() {
        System.out.println("Thermostat in " + location + " is set ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Thermostat in " + location + " is set OFF");
    }
}
