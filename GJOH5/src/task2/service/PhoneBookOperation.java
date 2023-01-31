package task2.service;

import task2.model.Contact;

import java.util.List;

/**
 * The interface contains methods for working with the phone book
 */
public interface PhoneBookOperation {
    List<Contact> getAllContacts();

    void addContact(Contact contact);

    void editContact(Contact contact, Contact contactNew);

    List<Contact> findByNumber(String number);

    List<Contact> findByName(String name);

    void removeContact(Contact contact);

    void saveBook(List<Contact> contacts);

    void saveBookToCSV(List<Contact> contacts);

}
