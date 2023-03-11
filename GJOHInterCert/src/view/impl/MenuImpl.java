package view.impl;

import view.Input;
import view.Menu;

import java.util.HashMap;
import java.util.Map;

public class MenuImpl implements Menu {

    Input input = new InputImpl();

    public String showMenu() {
        while (true) {
            System.out.println("MENU");
            System.out.println("1 - Show All Available Gifts");
            System.out.println("2 - Show All Waiting To Be Given Gifts");
            System.out.println("3 - Add Gift");
            System.out.println("4 - Edit Gift");
            System.out.println("5 - Get Random Gift");
            System.out.println("6 - Get the won Gift");
            System.out.println("0 - exit");
            String action = input.getInputValue("Enter the action");
            if ("0123456".contains(action) && action.length() == 1) {
                return action;
            }
        }
    }

    public Map<String, Object> addToyMenu() {
        Map<String, Object> values = new HashMap<>();
        values.put("name", input.getInputValue("Enter toy's name"));
        values.put("priority", input.getInputValue("Enter priority"));
        values.put("count", input.getInputValue("Enter toys amount"));
        return values;
    }

    public Map<String, Object> editToyMenu() {
        Map<String, Object> values = new HashMap<>();
        values.put("editName", input.getInputValue("Enter toy's name to edit"));
        values.put("name", input.getInputValue("Enter new name"));
        values.put("priority", input.getInputValue("Enter priority"));
        values.put("count", input.getInputValue("Enter new toy's amount "));
        return values;
    }
}
