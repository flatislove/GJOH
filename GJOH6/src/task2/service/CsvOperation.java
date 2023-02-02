package task2.service;

import task2.model.Contact;

import java.util.List;

/**
 * The interface contains method for working with the .csv file
 */
public interface CsvOperation {

    /**
     * Method saves contacts list to the .csv file
     *
     * @param filename filename
     * @param contacts List of contacts
     */
    void saveToCSVFile(String filename, List<Contact> contacts);
}
