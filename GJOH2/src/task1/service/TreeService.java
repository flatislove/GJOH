package task1.service;

import task1.model.Family;
import task1.model.Person;

public interface TreeService {

    /**
     * The method prints information about the Tree to the console
     *
     * @param person person
     * @param depth  indent
     */
    void printFamilyTree(Person person, int depth);

    /**
     * The method save information about the family to JSON-file
     */
    void saveToJson(String filename, Family family);

    /**
     * The method prints information about persons children to the console
     */
    void printChildren(Person person);
}
