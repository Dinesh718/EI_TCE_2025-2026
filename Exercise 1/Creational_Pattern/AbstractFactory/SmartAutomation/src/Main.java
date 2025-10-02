import factory.HomeFactory;
import factory.OfficeFactory;
import abstractfactory.SmartHomeFactory;
import service.AutomationService;
import util.InputUtil;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Smart Home Automation");
        String environment = InputUtil.readString("Select environment (Home/Office): ");

        SmartHomeFactory factory;
        if (environment.equalsIgnoreCase("home")) {
            factory = new HomeFactory();
        } else if (environment.equalsIgnoreCase("office")) {
            factory = new OfficeFactory();
        } else {
            System.out.println("Invalid environment. Defaulting to Home.");
            factory = new HomeFactory();
        }

        AutomationService service = new AutomationService();
        service.startAutomation(factory);
    }
}
