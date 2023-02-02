package task3.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import task3.model.Employee;
import task3.model.Person;
import task3.service.FileServicePerson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the interface for working with a file
 */
public class FileServicePersonImpl implements FileServicePerson {

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public List<Person> readFromFile(String filename) {
        try {
            FileReader reader = new FileReader(filename);
            Type type = new TypeToken<List<Employee>>() {
            }.getType();
            List<Person> people = gson.fromJson(reader, type);
            reader.close();
            return people;
        } catch (IOException e) {
            System.out.println("File not found");
            saveToFile(new ArrayList<>(), filename);
        }
        return new ArrayList<>();
    }

    @Override
    public void saveToFile(List<?> people, String filename) {
        String json = gson.toJson(people);
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
