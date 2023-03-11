package model;

import java.util.UUID;

public class Toy {
    private final UUID id;
    private String name;
    private double priority;

    public Toy(String name, double priority) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", priority=" + priority +
                '}';
    }

    public String getId() {
        return id.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPriority() {
        return priority;
    }

    public void setPriority(double priority) {
        this.priority = priority;
    }
}
