package s3.view;

import s3.model.PersonData;

import java.util.*;

/**
 * The class contains methods for displaying to the console
 */
public class Menu {
    public String showMenu() {
        while (true) {
            showMessage("Choose operation:");
            showMessage("1 - See persons data");
            showMessage("2 - Add person data");
            showMessage("3 - Save data to TXT");
            showMessage("0 - exit");
            String action = getValue("Enter the action");
            if ("0123".contains(action) && action.length() == 1) {
                return action;
            }
        }
    }

    public String getValue(String message) {
        showMessage(message + ": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void showContacts(List<PersonData> personData) {
        for (int i = 0; i < personData.size(); i++) {
            showMessage("#: " + (i + 1) + " " + personData.get(i));
        }
    }

    public String addContactValuesView() {
        showMessage("Format: lastname firstname middlename birthdate(dd.mm.yyyy) phoneNumber(12 digits) gender(character f or m)");
        showMessage("Data is separated by spaces");
        return getValue("Enter data row");
    }


    public void waitInput() {
        Scanner sc = new Scanner(System.in);
        showMessage("Press any key...");
        sc.nextLine();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
