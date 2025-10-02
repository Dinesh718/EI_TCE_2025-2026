package model;

public abstract class Transportation {
    protected String name;
    protected int capacity;

    public Transportation(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    // Updated to include source and destination
    public abstract void bookTicket(String source, String destination, int seats) throws Exception;

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
}
