package task2.service.impl;

import com.google.gson.reflect.TypeToken;
import task2.model.Contact;
import task2.model.PhoneContact;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import task2.service.JsonOperation;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Implementation of the interface for working with a file
 */
public class JsonOperationForPhoneContactImpl implements JsonOperation {

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Method reads contacts from .json file
     *
     * @param filename filename
     * @return List of Contacts
     */
    @Override
    public List<Contact> readFromJsonFile(String filename) {
        try {
            FileReader reader = new FileReader(filename);
            Type type = new TypeToken<List<PhoneContact>>() {
            }.getType();
            List<Contact> contacts = gson.fromJson(reader, type);
            reader.close();
            return contacts;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    /**
     * Method saves contacts list to the .json file
     *
     * @param filename filename
     * @param contacts List of contacts
     */
    @Override
    public void saveToJsonFile(String filename, List<Contact> contacts) {
        String json = gson.toJson(contacts);
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
