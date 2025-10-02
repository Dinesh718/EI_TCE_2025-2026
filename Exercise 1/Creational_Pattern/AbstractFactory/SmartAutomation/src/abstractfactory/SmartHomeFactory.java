package abstractfactory;

import device.Device;

public interface SmartHomeFactory {
    Device createLight(String location);
    Device createThermostat(String location);
    Device createCamera(String location);
}
