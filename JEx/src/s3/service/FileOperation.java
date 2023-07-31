package s3.service;

import s3.model.PersonData;

import java.util.List;

/**
 * The interface contains methods for working with the file
 */
public interface FileOperation {
    void saveToFile(String filenamePath, List<PersonData> personData) throws Exception;
}
