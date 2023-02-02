package task3.service;

import task3.model.Department;
import task3.model.Person;

import java.util.List;
import java.util.Map;

/**
 * The interface contains methods for working with people
 */
public interface PersonService {

    /**
     * Method gets all Employees by Department
     *
     * @param department department
     * @param filename   filename
     * @return List of Person
     */
    List<Person> getAllEmployeesByDepartment(Department department, String filename);

    /**
     * Method gets all Employees with work experience
     *
     * @param filename filename
     * @return Map of Person and experience
     */
    Map<Person, String> getAllEmployeesByWorkExperience(String filename);

    /**
     * Method removes Person
     *
     * @param person   person
     * @param filename filename
     */
    void removePerson(Person person, String filename);
}
