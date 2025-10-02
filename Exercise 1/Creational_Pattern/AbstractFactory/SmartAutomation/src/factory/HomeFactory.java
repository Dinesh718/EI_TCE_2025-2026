package factory;

import abstractfactory.SmartHomeFactory;
import device.Device;
import device.Light;
import device.Thermostat;
import device.Camera;

public class HomeFactory implements SmartHomeFactory {

    @Override
    public Device createLight(String location) {
        return new Light(location);
    }

    @Override
    public Device createThermostat(String location) {
        return new Thermostat(location);
    }

    @Override
    public Device createCamera(String location) {
        return new Camera(location);
    }
}
