package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        if (item == null) throw new IllegalArgumentException("Item cannot be null");
        items.add(item);
    }

    public List<Item> getItems() {
        return List.copyOf(items);
    }

    public double calculateTotal() {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }

    public boolean isEmpty() { return items.isEmpty(); }
}
