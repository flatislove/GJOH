package task3.model;

import java.util.UUID;

/**
 * The abstract class represents Person
 */
public abstract class Person {

    private final UUID id;
    private final String firstname;
    private final String lastname;

    public Person(String firstname, String lastname) {
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
}
