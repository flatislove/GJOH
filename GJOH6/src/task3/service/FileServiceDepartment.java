package task3.service;

import task3.model.Department;

import java.util.List;

/**
 * The interface contains methods for Department for saving and reading a file
 */
public interface FileServiceDepartment extends FileService {

    List<Department> readFromFile(String filename);

    void saveToFile(List<?> departments, String filename);
}
