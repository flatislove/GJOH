package task2.service.impl;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import task2.model.Contact;
import task2.model.PhoneContact;
import task2.model.enums.Tag;
import task2.service.CsvOperation;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * The class contains method for working with the .csv file
 */
public class CsvOperationForPhoneContactImpl implements CsvOperation {

    /**
     * Method saves contacts list to the .csv file
     *
     * @param filename filename
     * @param contacts List of contacts
     */
    @Override
    public void saveToCSVFile(String filename, List<Contact> contacts) {
        try (FileWriter fileWriter = new FileWriter(filename)) {
            CSVPrinter printer = new CSVPrinter(fileWriter, CSVFormat.DEFAULT.withHeader("ID", "First Name", "Last Name", "Phone", "Tag"));
            for (Contact contact : contacts) {
                if (contact instanceof PhoneContact phoneContact) {
                    for (Map.Entry<String, Tag> phone : phoneContact.getPhones().entrySet()) {
                        printer.printRecord(phoneContact.getId(), phoneContact.getFirstname(), phoneContact.getLastname(), phone.getKey(), phone.getValue().name());
                    }
                }
            }
            printer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
