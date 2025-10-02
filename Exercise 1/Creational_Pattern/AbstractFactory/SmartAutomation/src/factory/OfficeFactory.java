package factory;

import abstractfactory.SmartHomeFactory;
import device.Device;
import device.Light;
import device.Thermostat;
import device.Camera;

public class OfficeFactory implements SmartHomeFactory {

    @Override
    public Device createLight(String location) {
        return new Light("Office " + location);
    }

    @Override
    public Device createThermostat(String location) {
        return new Thermostat("Office " + location);
    }

    @Override
    public Device createCamera(String location) {
        return new Camera("Office " + location);
    }
}
