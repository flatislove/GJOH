package task1.service;

import task1.model.Person;

import java.util.List;

public interface PersonService {

    void setParents(List<Person> parents);

    /**
     * The method prints information about the Person to the console
     */
    void printInfo();

    void addChildren(Person child);

    void addSiblings(Person siblings);
}
