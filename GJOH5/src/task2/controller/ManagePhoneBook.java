package task2.controller;

import task2.model.Contact;
import task2.model.enums.Tag;
import task2.service.PhoneBookOperation;
import task2.service.PhoneBookOperationImpl;
import task2.view.Menu;

import java.util.List;
import java.util.Map;

/**
 * Class linking model and view
 */
public class ManagePhoneBook {
    Menu menu = new Menu();
    PhoneBookOperation phoneBookOperation = new PhoneBookOperationImpl();

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
                menu.showContacts(phoneBookOperation.getAllContacts());
                menu.waitInput();
            }
            case "2" -> {
                menu.showMessage("\nADD");
                Map<String, Object> map = menu.addContactValues();
                phoneBookOperation.addContact(mapToContact(map));
            }
            case "3" -> {
                menu.showMessage("\nEDIT");
                List<Contact> contacts = phoneBookOperation.getAllContacts();
                menu.showContacts(contacts);
                int positionContactsForEdit = Integer.parseInt(menu.getValue("Enter contacts number(#) for edit"));
                Contact oldContact = contacts.get(positionContactsForEdit - 1);
                Map<String, Object> newValues = menu.addContactValues();
                phoneBookOperation.editContact(oldContact, mapToContact(newValues));
            }
            case "4" -> {
                menu.showMessage("\nFIND BY NUMBER");
                String number = menu.getValue("Enter number for search");
                List<Contact> contactsByNumber = phoneBookOperation.findByNumber(number);
                menu.showContacts(contactsByNumber);
                menu.waitInput();
            }
            case "5" -> {
                menu.showMessage("\nFIND BY NAME");
                String name = menu.getValue("Enter name for search");
                List<Contact> contactsByName = phoneBookOperation.findByName(name);
                menu.showContacts(contactsByName);
                menu.waitInput();
            }
            case "6" -> {
                menu.showMessage("\nREMOVE");
                List<Contact> contactsForRemove = phoneBookOperation.getAllContacts();
                menu.showContacts(contactsForRemove);
                int positionContactsForRemove = Integer.parseInt(menu.getValue("Enter contacts number(#) for remove"));
                if (positionContactsForRemove - 1 <= contactsForRemove.size() && positionContactsForRemove - 1 >= 0) {
                    phoneBookOperation.removeContact(contactsForRemove.get(positionContactsForRemove - 1));
                } else {
                    menu.showMessage("Wrong number...");
                }
            }
            case "7" -> {
                menu.showMessage("\nADD NUMBERS");
                List<Contact> contactsForAddNumbers = phoneBookOperation.getAllContacts();
                menu.showContacts(contactsForAddNumbers);
                int positionContactsForAddNumbers = Integer.parseInt(menu.getValue("Enter contact number(#) to add numbers"));
                Contact contact = contactsForAddNumbers.get(positionContactsForAddNumbers - 1);
                Map<String, Object> numberToAdd = menu.addContactsNumber();
                contact.getPhones().put(numberToAdd.get("phone").toString(), getTagByObject(numberToAdd.get("tag")));
                phoneBookOperation.saveBook(contactsForAddNumbers);
            }
            case "8" -> {
                List<Contact> contactsForCSV = phoneBookOperation.getAllContacts();
                phoneBookOperation.saveBookToCSV(contactsForCSV);
            }
        }
    }

    public Contact mapToContact(Map<String, Object> values) {
        return new Contact(
                values.get("firstname").toString(),
                values.get("lastname").toString(),
                values.get("phone").toString(),
                getTagByObject(values.get("tag")));
    }

    public Tag getTagByObject(Object o) {
        for (int i = 0; i < Tag.values().length; i++) {
            if (o!=null && o.toString().equals(Tag.values()[i].toString())) {
                return Tag.values()[i];
            }
        }
        return Tag.PRIVATE;
    }
}
