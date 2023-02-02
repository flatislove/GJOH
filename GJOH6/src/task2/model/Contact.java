package task2.model;

import java.util.UUID;

public abstract class Contact {

    private final UUID id;
    private final String firstname;
    private final String lastname;

    public Contact(String firstname, String lastname) {
        this.id = UUID.randomUUID();
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String toString() {
        return firstname + " " + lastname;
    }
}
