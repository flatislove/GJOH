package task1.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Person {
    private String firstname;

    private String lastname;
    private String dateBirth;
    private Family family;
    private List<Person> parents;
    private Set<Person> printedSiblings = new HashSet<>();

    public Person(String firstname, String lastname, String dateBirth, Family family) {
        this.firstname=firstname;
        this.lastname=lastname;
        this.dateBirth = dateBirth;
        this.family = family;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public List<Person> getParents() {
        return parents;
    }

    public void setParents(List<Person> parents) {
        this.parents = parents;
    }

    @Override
    public String toString() {
        return firstname +" "+ lastname;
    }
}
