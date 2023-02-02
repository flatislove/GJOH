package task1.view;

/**
 * Interface contains show-methods for displaying to the console
 */
public interface MenuShow {

    /**
     * Method shows message to the console
     *
     * @param message String value of message
     * @param example additional information for output
     */
    void showMessage(String message, String example);

    /**
     * Method shows main menu
     *
     * @param menuGet interface for getting value
     * @return number of action
     */
    String showMenu(MenuGet menuGet);
}
