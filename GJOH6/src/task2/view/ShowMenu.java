package task2.view;

import task2.model.Contact;
import task2.model.enums.Tag;

import java.util.List;
import java.util.Map;

/**
 * The interface contains methods for showing to the console
 */
public interface ShowMenu {

    /**
     * Method shows main menu
     *
     * @return action
     */
    String showMenu();

    /**
     * Default method shows message to the console
     *
     * @param message any message for output
     */
    default void showMessage(String message) {
        System.out.println(message);
    }

    /**
     * Method shows tags(labels) for phone numbers
     *
     * @return Map of index and tag
     */
    Map<Integer, Tag> showTags();

    /**
     * Method shows contacts to the console
     *
     * @param contacts list of contacts
     */
    void showContacts(List<Contact> contacts);
}
