package device;

public class Light implements Device {
    private String location;

    public Light(String location) {
        this.location = location;
    }

    @Override
    public void turnOn() {
        System.out.println("Light in " + location + " is ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Light in " + location + " is OFF");
    }
}
