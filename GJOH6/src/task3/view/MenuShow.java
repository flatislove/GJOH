package task3.view;

import task3.model.Person;

import java.util.List;
import java.util.Map;

/**
 * The interface contains methods for showing to the console
 */
public interface MenuShow {

    /**
     * Method shows main menu
     *
     * @return action
     */
    String showMenu();

    /**
     * Method shows Employees and experience
     *
     * @param map map persons and experiences
     */
    void showEmployeesWithExperience(Map<Person, String> map);

    /**
     * Method shows objects to the console
     *
     * @param objects list of objects
     */
    void showObjects(List<?> objects);
}
