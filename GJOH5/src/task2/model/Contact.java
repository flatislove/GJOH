package task2.model;

import task2.model.enums.Tag;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * The class represents a contact in the phone book
 */
public class Contact {
    private final UUID id;
    private final String firstname;
    private final String lastname;
    private final Map<String, Tag> phones;

    public Contact(String firstname, String lastname, String phone, Tag tag) {
        this.id = UUID.randomUUID();
        this.firstname = firstname;
        this.lastname = lastname;
        this.phones = new HashMap<>();
        this.phones.put(phone, tag);
    }

    @Override
    public String toString() {
        return firstname + " " + lastname + " " + phones;
    }

    public String getId() {
        return id.toString();
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Map<String, Tag> getPhones() {
        return phones;
    }
}