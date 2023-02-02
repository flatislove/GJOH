package task3.view;

import task3.model.Department;
import task3.model.Person;
import task3.model.enums.Position;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The class contains methods for displaying to the console
 */
public class Menu implements Waiting, MenuShow, MenuGet {

    /**
     * Method shows main menu
     *
     * @return action
     */
    @Override
    public String showMenu() {
        while (true) {
            System.out.println("MENU");
            System.out.println("1 - Show All Employees");
            System.out.println("2 - Show All Employees By Department");
            System.out.println("3 - Show All Employees By Work Experience");
            System.out.println("4 - Add Department");
            System.out.println("5 - Add Employee");
            System.out.println("6 - Remove Employee");
            System.out.println("0 - exit");
            String action = getInputValue("Enter the action");
            if ("0123456".contains(action) && action.length()==1) {
                return action;
            }
        }
    }

    /**
     * Method shows Employees and experience
     *
     * @param map map persons and experiences
     */
    @Override
    public void showEmployeesWithExperience(Map<Person, String> map) {
        for (Map.Entry<Person, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - Experience: " + entry.getValue() + " days");
        }
    }

    /**
     * Method shows objects to the console
     *
     * @param objects list of objects
     */
    @Override
    public void showObjects(List<?> objects) {
        for (int i = 0; i < objects.size(); i++) {
            System.out.println("# " + (i + 1) + " " + objects.get(i));
        }
    }

    /**
     * Method gets values for Employee
     *
     * @param departments list of departments
     * @param positions   list of positions
     * @return Map names fields and values
     */
    @Override
    public Map<String, Object> getEmployeeValues(List<Department> departments, List<Position> positions) {
        Map<String, Object> map = new HashMap<>();
        map.put("firstname", getInputValue("Enter firstname"));
        map.put("lastname", getInputValue("Enter lastname"));
        showObjects(departments);
        map.put("department", getInputValue("Enter department"));
        showObjects(positions);
        map.put("position", getInputValue("Enter position"));
        map.put("date", getInputValue("Enter got a job(format yyyy-MM-dd"));
        return map;
    }

    /**
     * Method get values for Department
     *
     * @return Map names fields and values
     */
    @Override
    public Map<String, String> getDepartmentValues() {
        Map<String, String> map = new HashMap<>();
        map.put("name", getInputValue("Enter name of department"));
        map.put("activity", getInputValue("Enter description"));
        return map;
    }
}
