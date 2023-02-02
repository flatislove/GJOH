package task2.controller;

import task2.model.Contact;
import task2.model.PhoneContact;
import task2.service.*;
import task2.service.impl.CsvOperationForPhoneContactImpl;
import task2.service.impl.JsonOperationForPhoneContactImpl;
import task2.service.impl.PhoneBookOperationServiceImpl;
import task2.view.Menu;

import java.util.List;
import java.util.Map;

/**
 * Class linking model and view
 */
public class ManagePhoneBook {

    String filename = "src/task2/contacts.json";
    String filenameCSV = "src/task2/contacts.csv";
    Menu menu = new Menu();
    PhoneBookOperationService phoneBookOperation = new PhoneBookOperationServiceImpl();
    JsonOperation jsonOperation = new JsonOperationForPhoneContactImpl();
    CsvOperation csvOperation = new CsvOperationForPhoneContactImpl();
    Parser parser = new Parser();

    public void start() {
        do {
            String action = menu.showMenu();
            if (action.equals("0")) {
                return;
            }
            checkAction(action);
        } while (true);
    }

    public void checkAction(String action) {
        switch (action) {
            case "1" -> {
                System.out.println("\nCONTACTS");
                menu.showContacts(jsonOperation.readFromJsonFile(filename));
                menu.waitInput();
            }
            case "2" -> {
                menu.showMessage("\nADD");
                Map<String, Object> map = menu.getContactsValues();
                phoneBookOperation.addContact(parser.mapToContact(map), filename);
            }
            case "3" -> {
                menu.showMessage("\nEDIT");
                List<Contact> contacts = jsonOperation.readFromJsonFile(filename);
                menu.showContacts(contacts);
                int positionContactsForEdit = Integer.parseInt(menu.getValue("Enter contacts number(#) for edit"));
                Contact oldContact = contacts.get(positionContactsForEdit - 1);
                Map<String, Object> newValues = menu.getContactsValues();
                phoneBookOperation.editContact(oldContact, parser.mapToContact(newValues), filename);
            }
            case "4" -> {
                menu.showMessage("\nFIND BY NUMBER");
                String number = menu.getValue("Enter number for search");
                List<Contact> contactsByNumber = phoneBookOperation.findByNumber(number, filename);
                menu.showContacts(contactsByNumber);
                menu.waitInput();
            }
            case "5" -> {
                menu.showMessage("\nFIND BY NAME");
                String name = menu.getValue("Enter name for search");
                List<Contact> contactsByName = phoneBookOperation.findByName(name, filename);
                menu.showContacts(contactsByName);
                menu.waitInput();
            }
            case "6" -> {
                menu.showMessage("\nREMOVE");
                List<Contact> contactsForRemove = jsonOperation.readFromJsonFile(filename);
                menu.showContacts(contactsForRemove);
                int positionContactsForRemove = Integer.parseInt(menu.getValue("Enter contacts number(#) for remove"));
                if (positionContactsForRemove - 1 <= contactsForRemove.size() && positionContactsForRemove - 1 >= 0) {
                    phoneBookOperation.removeContact(contactsForRemove.get(positionContactsForRemove - 1), filename);
                } else {
                    menu.showMessage("Wrong number...");
                }
            }
            case "7" -> {
                menu.showMessage("\nADD NUMBERS");
                List<Contact> contactsForAddNumbers = jsonOperation.readFromJsonFile(filename);
                menu.showContacts(contactsForAddNumbers);
                int positionContactsForAddNumbers = Integer.parseInt(menu.getValue("Enter contact number(#) to add numbers"));
                Contact contact = contactsForAddNumbers.get(positionContactsForAddNumbers - 1);
                Map<String, Object> numberToAdd = menu.addContactsNumber();
                if (contact instanceof PhoneContact) {
                    ((PhoneContact) contact).getPhones().put(numberToAdd.get("phone").toString(), parser.getTagByObject(numberToAdd.get("tag")));
                }
                jsonOperation.saveToJsonFile(filename, contactsForAddNumbers);
            }
            case "8" -> {
                List<Contact> contactsForCSV = jsonOperation.readFromJsonFile(filename);
                csvOperation.saveToCSVFile(filenameCSV, contactsForCSV);
            }
        }
    }
}
