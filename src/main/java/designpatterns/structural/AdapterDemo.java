package designpatterns.structural;

// Target interface (what the client expects)
interface ModernPrinter {
    void printDocument(String content);
}

// Adaptee (the old, incompatible class)
class LegacyPrinter {
    public void printText(String text) {
        System.out.println("Legacy Printer: " + text);
    }
    
    public void initialize() {
        System.out.println("Legacy Printer: Initializing...");
    }
    
    public void cleanup() {
        System.out.println("Legacy Printer: Cleaning up...");
    }
}

// Adapter (makes the old class compatible with the new interface)
class PrinterAdapter implements ModernPrinter {
    private LegacyPrinter legacyPrinter;
    
    public PrinterAdapter(LegacyPrinter legacyPrinter) {
        this.legacyPrinter = legacyPrinter;
    }
    
    @Override
    public void printDocument(String content) {
        // Adapt the modern interface to the legacy implementation
        legacyPrinter.initialize();
        legacyPrinter.printText(content);
        legacyPrinter.cleanup();
        System.out.println("--- Document printed successfully ---");
    }
}

// Demo class
public class AdapterDemo {
    public static void main(String[] args) {
        System.out.println("=== Adapter Pattern Demo ===");
        
        // Client code expects ModernPrinter interface
        ModernPrinter printer;
        
        // Using the adapter to make LegacyPrinter work with ModernPrinter
        LegacyPrinter oldPrinter = new LegacyPrinter();
        printer = new PrinterAdapter(oldPrinter);
        
        // Client can use the modern interface without knowing about the legacy system
        printer.printDocument("Astronaut Daily Schedule Report");
        printer.printDocument("Mission Critical Task List");
        
        System.out.println("Adapter demo completed!");
    }
}