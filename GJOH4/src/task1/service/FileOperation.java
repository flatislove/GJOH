package task1.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Service class for working with a file, uses generics
 */
public class FileOperation implements FileService {

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public <T> T readFromFile(String filename, Type type) {
        try {
            FileReader reader = new FileReader(filename);
            T object = gson.fromJson(reader, type);
            reader.close();
            return object;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <T> void saveToFile(T object, String filename) {
        String json = gson.toJson(object);
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
