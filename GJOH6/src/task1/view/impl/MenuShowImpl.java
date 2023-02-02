package task1.view.impl;

import task1.view.MenuGet;
import task1.view.MenuShow;

/**
 * The class contains show-methods for displaying to the console
 */
public class MenuShowImpl implements MenuShow {

    /**
     * Method shows message to the console
     *
     * @param message String value of message
     * @param example additional information for output
     */
    @Override
    public void showMessage(String message, String example) {
        System.out.println(message + ": " + example);
    }

    /**
     * Method shows main menu
     *
     * @param menuGet interface for getting value
     * @return number of action
     */
    @Override
    public String showMenu(MenuGet menuGet) {
        while (true) {
            System.out.println("Choose operation:");
            System.out.println("1 - Divide");
            System.out.println("2 - Sum");
            System.out.println("3 - Difference");
            System.out.println("4 - Multiplication");
            System.out.println("0 - exit");
            String action = menuGet.getInputValue();
            if ("01234".contains(action) && action.length()==1) {
                return action;
            }
        }
    }
}
