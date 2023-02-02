package task3.service.impl;

import task3.model.Department;
import task3.model.Employee;
import task3.model.Person;
import task3.service.FileServicePerson;
import task3.service.PersonService;

import java.util.*;

/**
 * Implementation of the interface for working with people
 */
public class PersonServiceImpl implements PersonService {

    FileServicePerson fileService = new FileServicePersonImpl();

    /**
     * Method gets all Employees by Department
     *
     * @param department department
     * @param filename   filename
     * @return List of Person
     */
    @Override
    public List<Person> getAllEmployeesByDepartment(Department department, String filename) {
        List<Person> people = fileService.readFromFile(filename);
        List<Person> list = new ArrayList<>();
        for (Person employee : people) {
            if (employee instanceof Employee && ((Employee) employee).getDepartment().equals(department)) {
                list.add(employee);
            }
        }
        return list;
    }

    /**
     * Method gets all Employees with work experience
     *
     * @param filename filename
     * @return Map of Person and experience
     */
    @Override
    public Map<Person, String> getAllEmployeesByWorkExperience(String filename) {
        List<Person> people = fileService.readFromFile(filename);
        Map<Person, String> map = new HashMap<>();
        Date now = new Date();
        for (Person person : people) {
            if (person instanceof Employee) {
                map.put(person, String.valueOf((now.getTime() - ((Employee) person).getGotAJob().getTime()) / 86400000));
            }
        }
        return map;
    }

    /**
     * Method removes Person
     *
     * @param person   person
     * @param filename filename
     */
    @Override
    public void removePerson(Person person, String filename) {
        List<Person> people = fileService.readFromFile(filename);
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getId().equals(person.getId())) {
                people.remove(i);
                break;
            }
        }
        fileService.saveToFile(people, filename);
    }
}
