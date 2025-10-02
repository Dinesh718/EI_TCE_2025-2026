package service;

import abstractfactory.SmartHomeFactory;
import device.Device;
import util.InputUtil;
import util.LoggerUtil;

public class AutomationService {

    public void startAutomation(SmartHomeFactory factory) {
        LoggerUtil.logInfo("Smart Home Automation Started");

        while (true) {
            try {
                String choice = InputUtil.readString(
                        "Choose device to control (Light/Thermostat/Camera) or 'exit' to quit: "
                );
                if (choice.equalsIgnoreCase("exit")) {
                    LoggerUtil.logInfo("Exiting Automation Service");
                    break;
                }

                String location = InputUtil.readString("Enter location of the device: ");
                Device device;

                switch (choice.toLowerCase()) {
                    case "light":
                        device = factory.createLight(location);
                        break;
                    case "thermostat":
                        device = factory.createThermostat(location);
                        break;
                    case "camera":
                        device = factory.createCamera(location);
                        break;
                    default:
                        LoggerUtil.logError("Invalid device choice");
                        continue;
                }

                String action = InputUtil.readString("Turn device ON or OFF: ");
                if (action.equalsIgnoreCase("on")) {
                    device.turnOn();
                } else if (action.equalsIgnoreCase("off")) {
                    device.turnOff();
                } else {
                    LoggerUtil.logError("Invalid action");
                }

            } catch (Exception e) {
                LoggerUtil.logError("Error: " + e.getMessage());
            }
        }
    }
}
