package task1.model;

import java.util.ArrayList;
import java.util.List;

public class Person {
    protected String firstname;

    protected String lastname;
    protected String dateBirth;
    protected Family family;
    protected List<Person> parents;
    protected final List<Person> siblings;
    protected final List<Person> children;


    public Person(String firstname, String lastname, String dateBirth, Family family) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateBirth = dateBirth;
        this.family = family;
        this.siblings = new ArrayList<>();
        this.children = new ArrayList<>();
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

    public List<Person> getSiblings() {
        return siblings;
    }

    public void addSiblings(Person siblings) {
        this.siblings.add(siblings);
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChildren(Person child) {
        this.children.add(child);
    }

    @Override
    public String toString() {
        return firstname + " " + lastname + " " + dateBirth;
    }

    public void printInfo() {
        System.out.println(this.firstname + " " + this.lastname + " " + this.dateBirth);
    }
}
