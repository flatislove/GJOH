package task2.service.impl;

import task2.model.Contact;
import task2.model.PhoneContact;
import task2.service.JsonOperation;
import task2.service.PhoneBookOperationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Implementation of the interface for working with a phone book
 */
public class PhoneBookOperationServiceImpl implements PhoneBookOperationService {

    JsonOperation fileOperation = new JsonOperationForPhoneContactImpl();

    /**
     * Method adding contact to file
     *
     * @param contact  Contact object
     * @param filename filename
     */
    @Override
    public void addContact(Contact contact, String filename) {
        List<Contact> contacts = fileOperation.readFromJsonFile(filename);
        contacts.add(contact);
        fileOperation.saveToJsonFile(filename, contacts);
    }

    /**
     * Method for editing contact
     *
     * @param contact    old contact
     * @param contactNew new contact
     * @param filename   filename
     */
    @Override
    public void editContact(Contact contact, Contact contactNew, String filename) {
        List<Contact> contacts = fileOperation.readFromJsonFile(filename);
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getId().equals(contact.getId())) {
                contacts.remove(i);
                break;
            }
        }
        contacts.add(contactNew);
        fileOperation.saveToJsonFile(filename, contacts);
    }

    /**
     * Method finds Contacts by phone number
     *
     * @param number   part of phone number
     * @param filename filename
     * @return list of contacts
     */
    @Override
    public List<Contact> findByNumber(String number, String filename) {
        List<Contact> contacts = fileOperation.readFromJsonFile(filename);
        List<Contact> resultList = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact instanceof PhoneContact) {
                Set<String> set = ((PhoneContact) contact).getPhones().keySet();
                for (String element : set) {
                    if (element.contains(number)) {
                        resultList.add(contact);
                    }
                }
            }
        }
        return resultList;
    }

    /**
     * Method finds Contacts by name
     *
     * @param name     part of firstname or lastname
     * @param filename filename
     * @return list of contacts
     */
    @Override
    public List<Contact> findByName(String name, String filename) {
        List<Contact> contacts = fileOperation.readFromJsonFile(filename);
        List<Contact> resultList = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getFirstname().contains(name) || contact.getLastname().contains(name)) {
                resultList.add(contact);
            }
        }
        return resultList;
    }

    /**
     * Method removes contact
     *
     * @param contact  contact
     * @param filename filename
     */
    @Override
    public void removeContact(Contact contact, String filename) {
        List<Contact> contacts = fileOperation.readFromJsonFile(filename);
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getId().equals(contact.getId())) {
                contacts.remove(i);
                break;
            }
        }
        fileOperation.saveToJsonFile(filename, contacts);
    }
}
