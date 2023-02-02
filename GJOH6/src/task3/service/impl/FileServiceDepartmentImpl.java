package task3.service.impl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import task3.model.Department;
import task3.service.FileServiceDepartment;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation interface contains methods for Department for saving and reading a file
 */
public class FileServiceDepartmentImpl implements FileServiceDepartment {

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Override
    public List<Department> readFromFile(String filename) {
        try {
            FileReader reader = new FileReader(filename);
            Type type = new TypeToken<List<Department>>() {
            }.getType();
            List<Department> departments = gson.fromJson(reader, type);
            reader.close();
            return departments;
        } catch (IOException e) {
            System.out.println("File not found");
            saveToFile(new ArrayList<>(), filename);
        }
        return new ArrayList<>();
    }

    @Override
    public void saveToFile(List<?> departments, String filename) {
        String json = gson.toJson(departments);
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
