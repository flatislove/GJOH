package s3.service;

import s3.model.PersonData;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Implementation of the interface for working with a file
 */
public class FileOperationImpl implements FileOperation {

    @Override
    public void saveToFile(String filename, List<PersonData> personDataList) throws Exception {
        Map<String, List<PersonData>> map = new HashMap<>();

        for (PersonData person : personDataList) {
            if (!map.containsKey(person.getLastname())) {
                map.put(person.getLastname(), new ArrayList<>());
            }
            map.get(person.getLastname()).add(person);
        }

        try {
            for (Map.Entry<String, List<PersonData>> entry : map.entrySet()) {
                String lastName = entry.getKey();
                List<PersonData> dataList = entry.getValue();

                FileWriter writer = new FileWriter(filename + lastName + ".txt", false);

                for (PersonData personData : dataList) {
                    String line = buildDataLine(personData);
                    writer.write(line + System.lineSeparator());
                }

                writer.close();
            }
        } catch (Exception e) {
            if (e instanceof FileNotFoundException) {
                throw new FileNotFoundException("File not found. FilePath: " + filename);
            }
            if (e instanceof IOException) {
                throw new IOException("File write error.");
            }
            throw new Exception("Unknown error writing file.");
        }
    }

    private String buildDataLine(PersonData personData) {
        return personData.toString();
    }
}
