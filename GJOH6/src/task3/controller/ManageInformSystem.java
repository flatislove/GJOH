package task3.controller;

import task3.model.Department;
import task3.model.Person;
import task3.model.enums.Position;
import task3.service.*;
import task3.service.impl.DepartmentServiceImpl;
import task3.service.impl.FileServiceDepartmentImpl;
import task3.service.impl.FileServicePersonImpl;
import task3.service.impl.PersonServiceImpl;
import task3.view.Menu;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Class linking model and view
 */
public class ManageInformSystem {

    Menu menu = new Menu();
    FileServicePerson fileServicePerson = new FileServicePersonImpl();
    FileServiceDepartment fileServiceDepartment = new FileServiceDepartmentImpl();
    PersonService personService = new PersonServiceImpl();
    DepartmentService departmentService = new DepartmentServiceImpl();
    Parser parser = new Parser();
    String filenameEmp = "src/task3/people.json";
    String filenameDep = "src/task3/department.json";

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
                System.out.println("\nEMPLOYEES");
                List<Person> employees = fileServicePerson.readFromFile(filenameEmp);
                menu.showObjects(employees);
                menu.waitInput();
            }
            case "2" -> {
                System.out.println("\nEMPLOYEES BY DEPARTMENT");
                List<Department> departments = fileServiceDepartment.readFromFile(filenameDep);
                menu.showObjects(departments);
                String department = menu.getInputValue("Enter departments number");
                menu.showObjects(personService.getAllEmployeesByDepartment(departments.get(Integer.parseInt(department) - 1), filenameEmp));
                menu.waitInput();
            }
            case "3" -> {
                System.out.println("\nEXPERIENCE EMPLOYEES");
                menu.showEmployeesWithExperience(personService.getAllEmployeesByWorkExperience(filenameEmp));
                menu.waitInput();
            }
            case "4" -> {
                System.out.println("ADD DEPARTMENT");
                Map<String, String> map = menu.getDepartmentValues();
                Department department = new Department(map.get("name"), map.get("description"));
                departmentService.addDepartment(department, filenameDep);
            }
            case "5" -> {
                System.out.println("ADD EMPLOYEE");
                List<Department> departments = fileServiceDepartment.readFromFile(filenameDep);
                List<Position> positions = Arrays.asList(Position.values());
                Map<String, Object> map = menu.getEmployeeValues(departments, positions);
                Person employee = parser.getEmployeeFromMap(map, departments, positions);
                List<Person> person = fileServicePerson.readFromFile(filenameEmp);
                person.add(employee);
                fileServicePerson.saveToFile(person, filenameEmp);
            }
            case "6" -> {
                System.out.println("\nREMOVE PERSON");
                List<Person> people = fileServicePerson.readFromFile(filenameEmp);
                menu.showObjects(people);
                String index = menu.getInputValue("Enter the number of the person to delete");
                personService.removePerson(people.get(Integer.parseInt(index) - 1), filenameEmp);
            }
        }
    }
}
