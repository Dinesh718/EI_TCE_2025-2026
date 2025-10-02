package designpatterns.behavioural;

// Simple Product class for demo
class Product {
    private String name;
    private double price;
    private int weight;
    
    public Product(String name, double price, int weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }
    
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getWeight() { return weight; }
    
    @Override
    public String toString() {
        return name + " - $" + price + " - " + weight + "g";
    }
}

// Strategy interface
interface SortStrategy {
    java.util.List<Product> sort(java.util.List<Product> products);
}

// Concrete strategy for price-based sorting
class PriceSortStrategy implements SortStrategy {
    @Override
    public java.util.List<Product> sort(java.util.List<Product> products) {
        products.sort((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        return products;
    }
}

// Concrete strategy for name-based sorting
class NameSortStrategy implements SortStrategy {
    @Override
    public java.util.List<Product> sort(java.util.List<Product> products) {
        products.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
        return products;
    }
}

// Concrete strategy for weight-based sorting
class WeightSortStrategy implements SortStrategy {
    @Override
    public java.util.List<Product> sort(java.util.List<Product> products) {
        products.sort((p1, p2) -> Integer.compare(p1.getWeight(), p2.getWeight()));
        return products;
    }
}

// Context class that uses a strategy
class ProductSorter {
    private SortStrategy strategy;
    
    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }
    
    public java.util.List<Product> sortProducts(java.util.List<Product> products) {
        if (strategy == null) {
            throw new IllegalStateException("Strategy not set");
        }
        return strategy.sort(products);
    }
}

// Demo class
public class StrategyDemo {
    public static void main(String[] args) {
        System.out.println("=== Strategy Pattern Demo ===");
        
        // Create sample products
        java.util.List<Product> products = java.util.Arrays.asList(
            new Product("Laptop", 999.99, 2000),
            new Product("Mouse", 25.50, 100),
            new Product("Keyboard", 75.00, 500),
            new Product("Monitor", 299.99, 3500)
        );
        
        ProductSorter sorter = new ProductSorter();
        
        // Sort by price
        sorter.setStrategy(new PriceSortStrategy());
        java.util.List<Product> priceSorted = sorter.sortProducts(new java.util.ArrayList<>(products));
        System.out.println("\nSorted by Price (Low to High):");
        priceSorted.forEach(System.out::println);
        
        // Sort by name
        sorter.setStrategy(new NameSortStrategy());
        java.util.List<Product> nameSorted = sorter.sortProducts(new java.util.ArrayList<>(products));
        System.out.println("\nSorted by Name (A to Z):");
        nameSorted.forEach(System.out::println);
        
        // Sort by weight
        sorter.setStrategy(new WeightSortStrategy());
        java.util.List<Product> weightSorted = sorter.sortProducts(new java.util.ArrayList<>(products));
        System.out.println("\nSorted by Weight (Light to Heavy):");
        weightSorted.forEach(System.out::println);
        
        System.out.println("\nStrategy demo completed!");
    }
}