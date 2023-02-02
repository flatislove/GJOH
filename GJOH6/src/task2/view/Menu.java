package task2.view;

import task2.model.Contact;
import task2.model.enums.Tag;

import java.util.*;

/**
 * The class contains methods for displaying to the console
 */
public class Menu implements Waiting, ShowMenu, GetMenu, AddNumbers {

    /**
     * Method shows main menu
     *
     * @return action
     */
    @Override
    public String showMenu() {
        while (true) {
            System.out.println("Choose operation:");
            System.out.println("1 - See phone book");
            System.out.println("2 - Add contact");
            System.out.println("3 - Edit contact");
            System.out.println("4 - Find by number");
            System.out.println("5 - Find by name");
            System.out.println("6 - Remove contact");
            System.out.println("7 - Add numbers to contact");
            System.out.println("8 - Save book to XML");
            System.out.println("0 - exit");
            String action = getValue("Enter the action");
            if ("012345678".contains(action) && action.length()==1) {
                return action;
            }
        }
    }

    /**
     * Method shows contacts to the console
     *
     * @param contacts list of contacts
     */
    @Override
    public void showContacts(List<Contact> contacts) {
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println("#: " + (i + 1) + " " + contacts.get(i));
        }
    }

    /**
     * Method shows tags(labels) for phone numbers
     *
     * @return Map of index and tag
     */
    @Override
    public Map<Integer, Tag> showTags() {
        Map<Integer, Tag> map = new HashMap<>();
        for (int i = 0; i < Tag.values().length; i++) {
            map.put(i, Tag.values()[i]);
        }
        return map;
    }

    /**
     * Method gets values for contacts fields
     *
     * @return Map of contacts values
     */
    @Override
    public Map<String, Object> getContactsValues() {
        Map<String, Object> map = new HashMap<>();
        map.put("firstname", getValue("Enter firstname"));
        map.put("lastname", getValue("Enter lastname"));
        map.put("phone", getValue("Enter phone number"));
        Map<Integer, Tag> tagMap = showTags();
        System.out.println(tagMap);
        Integer tag = Integer.parseInt(getValue("Enter tag number"));
        map.put("tag", tagMap.get(tag));
        return map;
    }

    /**
     * The interface contains method for adding phone numbers to the contact
     *
     * @return Map of phone numbers and tags
     */
    @Override
    public Map<String, Object> addContactsNumber() {
        Map<String, Object> map = new HashMap<>();
        map.put("phone", getValue("Enter phone number"));
        Map<Integer, Tag> tagMap = showTags();
        System.out.println(tagMap);
        Integer tag = Integer.parseInt(getValue("Enter tag number"));
        map.put("tag", tagMap.get(tag));
        return map;
    }
}
