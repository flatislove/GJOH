package task1.service;

import java.lang.reflect.Type;

/**
 * service interface for working with a file, uses generics
 */
public interface FileService {

    <T> T readFromFile(String filename, Type type);

    <T> void saveToFile(T object, String filename);
}
