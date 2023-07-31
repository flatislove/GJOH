package s3.service;

import s3.model.PersonData;

import java.util.List;

/**
 * The interface contains methods for working with the person data
 */
public interface PersonDataOperation {

    void addContact(String person, List<PersonData> personDataList);

    void saveBook(List<PersonData> personData);
}
