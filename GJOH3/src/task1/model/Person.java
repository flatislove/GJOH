package task1.model;

import task1.service.PersonService;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * The abstract class describes the representation of Person
 */

public abstract class Person implements PersonService, Iterable<Person>, Comparable<Person> {
    protected String firstname;

    protected String lastname;
    protected Date dateBirth;
    protected Family family;
    protected List<Person> parents;
    protected final List<Person> siblings;
    protected final List<Person> children;


    public Person(String firstname, String lastname, Date dateBirth, Family family) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateBirth = dateBirth;
        this.family = family;
        this.siblings = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public PersonIterator iterator() {
        return new PersonIterator();
    }

    private class PersonIterator implements Iterator<Person> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < children.size();
        }

        @Override
        public Person next() {
            return children.get(index++);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public int compareTo(Person o) {
        return this.dateBirth.compareTo(o.dateBirth);
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Date getDateBirth() {
        return dateBirth;
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

    @Override
    public boolean equals(Object o) {
        if (this==o) return true;
        if (!(o instanceof Person person)) return false;

        if (!getFirstname().equals(person.getFirstname())) return false;
        if (!getLastname().equals(person.getLastname())) return false;
        if (!dateBirth.equals(person.dateBirth)) return false;
        if (!family.equals(person.family)) return false;
        if (getParents()!=null ? !getParents().equals(person.getParents()):person.getParents()!=null) return false;
        if (getSiblings()!=null ? !getSiblings().equals(person.getSiblings()):person.getSiblings()!=null) return false;
        return getChildren()!=null ? getChildren().equals(person.getChildren()):person.getChildren()==null;
    }

    @Override
    public int hashCode() {
        int result = getFirstname().hashCode();
        result = 31 * result + getLastname().hashCode();
        result = 31 * result + dateBirth.hashCode();
        result = 31 * result + family.hashCode();
        return result;
    }
}
