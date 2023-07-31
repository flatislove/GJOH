package s3.controller;

import s3.model.PersonData;
import s3.service.PersonDataOperation;
import s3.service.PersonDataOperationImpl;
import s3.view.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * Class linking model and view
 */
public class ManagePersonData {
    Menu menu = new Menu();
    PersonDataOperation personDataOperation = new PersonDataOperationImpl();

    List<PersonData> personDataList = new ArrayList<>();

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
                menu.showContacts(personDataList);
                menu.waitInput();
            }
            case "2" -> {
                menu.showMessage("\nADD");
                String data = menu.addContactValuesView();
                personDataOperation.addContact(data, personDataList);
            }
            case "3" -> {
                System.out.println("\nSAVE");
                personDataOperation.saveBook(personDataList);
                menu.showMessage("Saved Data...");
                menu.waitInput();
            }
        }
    }
}
