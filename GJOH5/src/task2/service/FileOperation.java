package task2.service;

import task2.model.Contact;

import java.util.List;

/**
 * The interface contains methods for working with the file
 */
public interface FileOperation {
    void saveToFile(String filename, List<Contact> contacts);

    List<Contact> readFromFile(String filename);

    void saveToCSVFile(String filename, List<Contact> contacts);
}
