package designpatterns.structural;

// Component interface
interface Coffee {
    String getDescription();
    double getCost();
}

// Concrete Component
class BasicCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Basic Coffee";
    }
    
    @Override
    public double getCost() {
        return 2.00;
    }
}

// Decorator base class
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;
    
    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }
    
    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }
    
    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }
}

// Concrete Decorators
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }
    
    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Milk";
    }
    
    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.50;
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }
    
    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Sugar";
    }
    
    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.25;
    }
}

class WhippedCreamDecorator extends CoffeeDecorator {
    public WhippedCreamDecorator(Coffee coffee) {
        super(coffee);
    }
    
    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Whipped Cream";
    }
    
    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.75;
    }
}

class CaramelSyrupDecorator extends CoffeeDecorator {
    public CaramelSyrupDecorator(Coffee coffee) {
        super(coffee);
    }
    
    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Caramel Syrup";
    }
    
    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 1.00;
    }
}

// Demo class
public class DecoratorDemo {
    public static void main(String[] args) {
        System.out.println("=== Decorator Pattern Demo ===");
        
        // Start with basic coffee
        Coffee coffee = new BasicCoffee();
        System.out.println(coffee.getDescription() + " : $" + coffee.getCost());
        
        // Add milk
        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " : $" + coffee.getCost());
        
        // Add sugar
        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " : $" + coffee.getCost());
        
        // Create a fancy coffee from scratch
        System.out.println("\nCreating a fancy coffee:");
        Coffee fancyCoffee = new BasicCoffee();
        fancyCoffee = new WhippedCreamDecorator(fancyCoffee);
        fancyCoffee = new CaramelSyrupDecorator(fancyCoffee);
        fancyCoffee = new MilkDecorator(fancyCoffee);
        
        System.out.println(fancyCoffee.getDescription() + " : $" + fancyCoffee.getCost());
        
        // Create another combination
        System.out.println("\nCreating a simple sweet coffee:");
        Coffee sweetCoffee = new BasicCoffee();
        sweetCoffee = new SugarDecorator(sweetCoffee);
        sweetCoffee = new SugarDecorator(sweetCoffee); // Double sugar!
        
        System.out.println(sweetCoffee.getDescription() + " : $" + sweetCoffee.getCost());
        
        System.out.println("Decorator demo completed!");
    }
}