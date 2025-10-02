package model;

public class Item {
    private final String name;
    private final double price;

    public Item(String name, double price) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Item name cannot be empty");
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative");
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
}
