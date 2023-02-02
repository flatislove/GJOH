package task2.model;

import task2.model.enums.Tag;

import java.util.HashMap;
import java.util.Map;

/**
 * The class represents a contact in the phone book
 */
public class PhoneContact extends Contact {

    private final Map<String, Tag> phones;

    public PhoneContact(String firstname, String lastname, String phone, Tag tag) {
        super(firstname, lastname);
        this.phones = new HashMap<>();
        this.phones.put(phone, tag);
    }

    public Map<String, Tag> getPhones() {
        return phones;
    }

    @Override
    public String toString() {
        return getFirstname() + " " + getLastname() + " " + phones;
    }
}