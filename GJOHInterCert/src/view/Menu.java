package view;

import java.util.Map;

public interface Menu {
    String showMenu();

    Map<String, Object> addToyMenu();

    Map<String, Object> editToyMenu();
}
