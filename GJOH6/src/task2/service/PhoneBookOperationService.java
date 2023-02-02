package task2.service;

import task2.model.Contact;

import java.util.List;

/**
 * The interface contains methods for working with the phone book
 */
public interface PhoneBookOperationService {

    /**
     * Method adding contact to file
     *
     * @param contact  Contact object
     * @param filename filename
     */
    void addContact(Contact contact, String filename);

    /**
     * Method for editing contact
     *
     * @param contact    old contact
     * @param contactNew new contact
     * @param filename   filename
     */
    void editContact(Contact contact, Contact contactNew, String filename);

    /**
     * Method finds Contacts by phone number
     *
     * @param number   part of phone number
     * @param filename filename
     * @return list of contacts
     */
    List<Contact> findByNumber(String number, String filename);

    /**
     * Method finds Contacts by name
     *
     * @param name     part of firstname or lastname
     * @param filename filename
     * @return list of contacts
     */
    List<Contact> findByName(String name, String filename);

    /**
     * Method removes contact
     *
     * @param contact  contact
     * @param filename filename
     */
    void removeContact(Contact contact, String filename);
}
