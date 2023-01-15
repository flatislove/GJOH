package task1.model;

import java.util.ArrayList;
import java.util.List;

public class Service {
    public void printFamilyTree(Person person, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("     *");
        }
        System.out.println(person.getFirstname()+" "+person.getLastname());

        List<Person> parents = person.getParents();

        if (parents!=null){
            for (Person parent : parents) {
                printFamilyTree(parent, depth + 1);
            }
        }
    }

    public List<Person> getSiblings(Person person) {
        Family family = person.getFamily();
        List<Person> children = family.getChildren();
        List<Person> siblings = new ArrayList<>();
        for (Person child : children) {
            if (!child.equals(person)) {
                siblings.add(child);
            }
        }
        return siblings;
    }
}
