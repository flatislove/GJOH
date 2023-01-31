package task3.controller;

import task3.model.Department;
import task3.model.Employee;
import task3.model.Person;
import task3.model.enums.Position;
import task3.service.*;
import task3.view.Menu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Class linking model and view
 */
public class ManageInformSystem {
    Menu menu = new Menu();
    FileService fileService = new FileServiceImpl();
    PersonService personService = new PersonServiceImpl();
    DepartmentService departmentService = new DepartmentServiceImpl();

    public void start() {
        do {
            String action = menu.mainMenu();
            if (action.equals("0")) {
                return;
            }
            checkAction(action);
        } while (true);
    }

    public void checkAction(String action) {
        switch (action) {
            case "1" -> {
                System.out.println("\nEMPLOYEES");
                List<Person> employees = personService.getAllEmployees();
                menu.showObjects(employees);
                menu.waitInput();
            }
            case "2" -> {
                System.out.println("\nEMPLOYEES BY DEPARTMENT");
                List<Department> departments = departmentService.getAllDepartments();
                menu.showObjects(departments);
                String department = menu.getValue("Enter departments number");
                menu.showObjects(personService.getAllEmployeesByDepartment(departments.get(Integer.parseInt(department) - 1)));
                menu.waitInput();
            }
            case "3" -> {
                System.out.println("\nEXPERIENCE EMPLOYEES");
                menu.showEmployeesWithExperience(personService.getAllEmployeesByWorkExperience());
            }
            case "4" -> {
                System.out.println("ADD DEPARTMENT");
                Map<String, String> map = menu.getDepartmentValues();
                Department department = new Department(map.get("name"), map.get("description"));
                departmentService.addDepartment(department);
            }
            case "5" -> {
                System.out.println("ADD EMPLOYEE");
                List<Department> departments = fileService.readDepartmentFromFile();
                List<Position> positions = Arrays.asList(Position.values());
                Map<String, Object> map = menu.getEmployeeValues(departments, positions);
                Person employee = getEmployeeFromMap(map, departments, positions);
                List<Person> person = fileService.readPersonFromFile();
                person.add(employee);
                fileService.savePersonToFile(person);
            }
            case "6" -> {
                System.out.println("\nREMOVE PERSON");
                List<Person> people = personService.getAllEmployees();
                menu.showObjects(people);
                String index = menu.getValue("Enter the number of the person to delete");
                personService.removePerson(people.get(Integer.parseInt(index) - 1));
            }
        }
    }

    private Person getEmployeeFromMap(Map<String, Object> map, List<Department> departments, List<Position> positions) {
        return new Employee(
                map.get("firstname").toString(),
                map.get("lastname").toString(),
                departments.get(Integer.parseInt(map.get("department").toString()) - 1),
                positions.get(Integer.parseInt(map.get("position").toString()) - 1),
                getDateFromString(map.get("date").toString()));
    }

    public Date getDateFromString(String date) {
        Date date1 = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date1 = formatDate.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return date1;
        }
        return date1;
    }
}
