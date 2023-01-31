package task3.view;

import task3.model.Department;
import task3.model.Person;
import task3.model.enums.Position;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * The class contains methods for displaying to the console
 */
public class Menu {
    public String mainMenu() {
        while (true) {
            System.out.println("MENU");
            System.out.println("1 - Show All Employees");
            System.out.println("2 - Show All Employees By Department");
            System.out.println("3 - Show All Employees By Work Experience");
            System.out.println("4 - Add Department");
            System.out.println("5 - Add Employee");
            System.out.println("6 - Remove Employee");
            System.out.println("0 - exit");
            String action = getValue("Enter the action");
            if ("0123456".contains(action) && action.length()==1) {
                return action;
            }
        }
    }

    public String getValue(String message) {
        System.out.print(message + ": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public Map<String, Object> getEmployeeValues(List<Department> departments, List<Position> positions) {
        Map<String, Object> map = new HashMap<>();
        map.put("firstname", getValue("Enter firstname"));
        map.put("lastname", getValue("Enter lastname"));
        showObjects(departments);
        map.put("department", getValue("Enter department"));
        showObjects(positions);
        map.put("position", getValue("Enter position"));
        map.put("date", getValue("Enter got a job(format yyyy-MM-dd"));
        return map;
    }

    public void showObjects(List<?> objects) {
        for (int i = 0; i < objects.size(); i++) {
            System.out.println("# " + (i + 1) + " " + objects.get(i));
        }
    }

    public Map<String, String> getDepartmentValues() {
        Map<String, String> map = new HashMap<>();
        map.put("name", getValue("Enter name of department"));
        map.put("activity", getValue("Enter description"));
        return map;
    }

    public void waitInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Press any key...");
        sc.nextLine();
    }

    public void showEmployeesWithExperience(Map<Person, String> map) {
        for (Map.Entry<Person, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - Experience: " + entry.getValue() + " days");
        }
    }
}
