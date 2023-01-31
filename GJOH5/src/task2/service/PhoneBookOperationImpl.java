package task2.service;

import task2.model.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Implementation of the interface for working with a phone book
 */
public class PhoneBookOperationImpl implements PhoneBookOperation {

    String filename = "src/task2/contacts.json";
    String filenameCSV = "src/task2/contacts.csv";
    FileOperation fileOperation = new FileOperationImpl();

    @Override
    public List<Contact> getAllContacts() {
        return fileOperation.readFromFile(filename);
    }

    @Override
    public void addContact(Contact contact) {
        List<Contact> contacts = getAllContacts();
        contacts.add(contact);
        fileOperation.saveToFile(filename, contacts);
    }

    @Override
    public void editContact(Contact contact, Contact contactNew) {
        List<Contact> contacts = getAllContacts();
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getId().equals(contact.getId())) {
                contacts.remove(i);
                break;
            }
        }
        contacts.add(contactNew);
        fileOperation.saveToFile(filename, contacts);
    }

    @Override
    public List<Contact> findByNumber(String number) {
        List<Contact> contacts = getAllContacts();
        List<Contact> resultList = new ArrayList<>();
        for (Contact contact : contacts) {
            Set<String> set = contact.getPhones().keySet();
            for (String element : set) {
                if (element.contains(number)) {
                    resultList.add(contact);
                }
            }
        }
        return resultList;
    }

    @Override
    public List<Contact> findByName(String name) {
        List<Contact> contacts = getAllContacts();
        List<Contact> resultList = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getFirstname().contains(name) || contact.getLastname().contains(name)) {
                resultList.add(contact);
            }
        }
        return resultList;
    }

    @Override
    public void removeContact(Contact contact) {
        List<Contact> contacts = getAllContacts();
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getId().equals(contact.getId())) {
                contacts.remove(i);
                break;
            }
        }
        fileOperation.saveToFile(filename, contacts);
    }

    @Override
    public void saveBook(List<Contact> contacts) {
        fileOperation.saveToFile(filename, contacts);
    }

    @Override
    public void saveBookToCSV(List<Contact> contacts) {
        fileOperation.saveToCSVFile(filenameCSV, contacts);
    }
}
