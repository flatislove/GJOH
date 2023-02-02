package task3.service;

import task3.model.Person;

import java.util.List;

/**
 * The interface contains methods for Person for saving and reading a file
 */
public interface FileServicePerson extends FileService {

    List<Person> readFromFile(String filename);

    void saveToFile(List<?> people, String filename);
}
