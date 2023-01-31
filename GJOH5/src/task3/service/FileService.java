package task3.service;

import task3.model.Department;
import task3.model.Person;

import java.util.List;

/**
 * The interface contains methods for working with the file
 */
public interface FileService {
    List<Person> readPersonFromFile();

    void savePersonToFile(List<Person> people);

    List<Department> readDepartmentFromFile();

    void saveDepartmentToFile(List<Department> departments);
}
