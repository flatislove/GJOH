package task3.model;

import java.util.UUID;

/**
 * The class represents a department in the organization
 */
public class Department {
    private final UUID id;
    private String name;
    private final String kindOfActivity;

    public Department(String name, String kindOfActivity) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.kindOfActivity = kindOfActivity;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " " + kindOfActivity;
    }

    @Override
    public boolean equals(Object o) {
        if (this==o) return true;
        if (!(o instanceof Department that)) return false;

        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}

