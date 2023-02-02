package task3.view;

import task3.model.Department;
import task3.model.enums.Position;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * The interface contains methods for getting values from the console
 */
public interface MenuGet {

    /**
     * Default method gets value from console
     *
     * @param message message for input
     * @return String value
     */
    default String getInputValue(String message) {
        System.out.print(message + ": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    /**
     * Method gets values for Employee
     *
     * @param departments list of departments
     * @param positions   list of positions
     * @return Map names fields and values
     */
    Map<String, Object> getEmployeeValues(List<Department> departments, List<Position> positions);

    /**
     * Method get values for Department
     *
     * @return Map names fields and values
     */
    Map<String, String> getDepartmentValues();
}
