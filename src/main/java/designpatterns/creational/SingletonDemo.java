package designpatterns.creational;

// Singleton class
class ConfigurationManager {
    private static ConfigurationManager instance;
    private String appName;
    private String version;
    
    private ConfigurationManager() {
        // Private constructor to prevent instantiation
        appName = "Astronaut Scheduler";
        version = "1.0.0";
        System.out.println("ConfigurationManager instance created!");
    }
    
    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }
    
    public String getAppName() {
        return appName;
    }
    
    public String getVersion() {
        return version;
    }
    
    public void setAppName(String name) {
        this.appName = name;
    }
    
    public void displayConfig() {
        System.out.println("App: " + appName + " v" + version);
    }
}

// Demo class
public class SingletonDemo {
    public static void main(String[] args) {
        System.out.println("=== Singleton Pattern Demo ===");
        
        // Get the singleton instance multiple times
        ConfigurationManager config1 = ConfigurationManager.getInstance();
        ConfigurationManager config2 = ConfigurationManager.getInstance();
        
        // Show they are the same instance
        System.out.println("config1 == config2: " + (config1 == config2));
        System.out.println("config1 hash: " + System.identityHashCode(config1));
        System.out.println("config2 hash: " + System.identityHashCode(config2));
        
        // Use the singleton
        config1.displayConfig();
        
        // Change through one reference, see it in the other
        config1.setAppName("Space Mission Planner");
        config2.displayConfig(); // Shows the updated name
        
        System.out.println("Singleton demo completed!");
    }
}