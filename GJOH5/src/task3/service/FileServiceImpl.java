package task3.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import task3.model.Department;
import task3.model.Employee;
import task3.model.Person;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the interface for working with a file
 */
public class FileServiceImpl implements FileService {

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String filenameEmp = "src/task3/people.json";
    String filenameDep = "src/task3/department.json";

    @Override
    public List<Person> readPersonFromFile() {
        try {
            FileReader reader = new FileReader(filenameEmp);
            Type type = new TypeToken<List<Employee>>() {
            }.getType();
            List<Person> people = gson.fromJson(reader, type);
            reader.close();
            return people;
        } catch (IOException e) {
            System.out.println("File not found");
            savePersonToFile(new ArrayList<>());
        }
        return new ArrayList<>();
    }

    @Override
    public void savePersonToFile(List<Person> people) {
        String json = gson.toJson(people);
        try {
            FileWriter writer = new FileWriter(filenameEmp);
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Department> readDepartmentFromFile() {
        try {
            FileReader reader = new FileReader(filenameDep);
            Type type = new TypeToken<List<Department>>() {
            }.getType();
            List<Department> departments = gson.fromJson(reader, type);
            reader.close();
            return departments;
        } catch (IOException e) {
            System.out.println("File not found");
            savePersonToFile(new ArrayList<>());
        }
        return new ArrayList<>();
    }

    @Override
    public void saveDepartmentToFile(List<Department> departments) {
        String json = gson.toJson(departments);
        try {
            FileWriter writer = new FileWriter(filenameDep);
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
