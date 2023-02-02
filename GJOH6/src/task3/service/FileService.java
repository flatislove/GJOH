package task3.service;

import java.util.List;

/**
 * The interface contains methods for saving and reading a file
 */
public interface FileService {

    List<?> readFromFile(String filename);

    void saveToFile(List<?> objects, String filename);
}
