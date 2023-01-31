package task3.service;

import task3.model.Department;
import task3.model.Employee;
import task3.model.Person;

import java.util.*;

/**
 * Implementation of the interface for working with people
 */
public class PersonServiceImpl implements PersonService {
    FileService fileservice = new FileServiceImpl();

    @Override
    public List<Person> getAllEmployees() {
        return fileservice.readPersonFromFile();
    }

    @Override
    public List<Person> getAllEmployeesByDepartment(Department department) {
        List<Person> people = fileservice.readPersonFromFile();
        List<Person> list = new ArrayList<>();
        for (Person employee : people) {
            if (employee instanceof Employee && ((Employee) employee).getDepartment().equals(department)) {
                list.add(employee);
            }
        }
        return list;
    }

    @Override
    public Map<Person, String> getAllEmployeesByWorkExperience() {
        List<Person> people = fileservice.readPersonFromFile();
        Map<Person, String> map = new HashMap<>();
        Date now = new Date();
        for (Person person : people) {
            if (person instanceof Employee) {
                map.put(person, String.valueOf((now.getTime() - ((Employee) person).getGotAJob().getTime()) / 86400000));
            }
        }
        return map;
    }

    @Override
    public void removePerson(Person person) {
        List<Person> people = fileservice.readPersonFromFile();
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getId().equals(person.getId())) {
                people.remove(i);
                break;
            }
        }
        fileservice.savePersonToFile(people);
    }
}
