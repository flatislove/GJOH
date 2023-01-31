package task3.service;

import task3.model.Department;
import task3.model.Person;

import java.util.List;
import java.util.Map;

/**
 * The interface contains methods for working with people
 */
public interface PersonService {

    List<Person> getAllEmployees();

    List<Person> getAllEmployeesByDepartment(Department department);

    Map<Person, String> getAllEmployeesByWorkExperience();

    void removePerson(Person person);
}
