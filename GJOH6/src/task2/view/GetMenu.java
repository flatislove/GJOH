package task2.view;

import java.util.Map;
import java.util.Scanner;

/**
 * The interface contains methods for getting values
 */
public interface GetMenu {

    /**
     * Default method gets String value from console
     *
     * @param message any message for output
     * @return String value from console
     */
    default String getValue(String message) {
        System.out.print(message + ": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    /**
     * Method gets values for contacts fields
     *
     * @return Map of contacts values
     */
    Map<String, Object> getContactsValues();
}
