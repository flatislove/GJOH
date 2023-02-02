package task2.service;

import task2.model.Contact;

import java.util.List;

/**
 * The interface contains methods for working with the file
 */
public interface JsonOperation {

    /**
     * Method saves contacts list to the .json file
     *
     * @param filename filename
     * @param contacts List of contacts
     */
    void saveToJsonFile(String filename, List<Contact> contacts);

    /**
     * Method reads contacts from .json file
     *
     * @param filename filename
     * @return List of Contacts
     */
    List<Contact> readFromJsonFile(String filename);
}
