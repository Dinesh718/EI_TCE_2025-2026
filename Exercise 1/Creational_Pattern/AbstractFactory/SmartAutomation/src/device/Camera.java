package device;

public class Camera implements Device {
    private String location;

    public Camera(String location) {
        this.location = location;
    }

    @Override
    public void turnOn() {
        System.out.println("Camera in " + location + " is recording");
    }

    @Override
    public void turnOff() {
        System.out.println("Camera in " + location + " is off");
    }
}
