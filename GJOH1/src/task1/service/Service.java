package task1.service;

import task1.model.Family;
import task1.model.Person;

public interface Service {

    void printFamilyTree(Person person, int depth);

    void saveToJson(String filename, Family family);

    void printChildren(Person person);
}
