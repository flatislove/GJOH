package task2.service;

import com.google.gson.reflect.TypeToken;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import task2.model.Contact;
import task2.model.enums.Tag;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * Implementation of the interface for working with a file
 */
public class FileOperationImpl implements FileOperation {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public List<Contact> readFromFile(String filename) {
        try {
            FileReader reader = new FileReader(filename);
            Type type = new TypeToken<List<Contact>>() {
            }.getType();
            List<Contact> contacts = gson.fromJson(reader, type);
            reader.close();
            return contacts;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }


    @Override
    public void saveToFile(String filename, List<Contact> contacts) {
        String json = gson.toJson(contacts);
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveToCSVFile(String filename, List<Contact> contacts) {
        try (FileWriter fileWriter = new FileWriter(filename)) {
            CSVPrinter printer = new CSVPrinter(fileWriter, CSVFormat.DEFAULT.withHeader("ID", "First Name", "Last Name", "Phone", "Tag"));
            for (Contact contact : contacts) {
                for (Map.Entry<String, Tag> phone : contact.getPhones().entrySet()) {
                    printer.printRecord(contact.getId(), contact.getFirstname(), contact.getLastname(), phone.getKey(), phone.getValue().name());
                }
            }
            printer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
