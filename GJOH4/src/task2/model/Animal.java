package task2.model;

import task2.model.enums.Color;
import task2.model.enums.Gender;
import task2.model.enums.Size;
import task2.service.AnimalService;

import java.util.Objects;

/**
 * The abstract class describes the representation of Animal
 */
public abstract class Animal implements AnimalService, Comparable<Animal>, Cloneable {
    protected String name;
    protected Color color;
    protected Bowl bowl;
    protected Size size;

    protected Gender gender;

    public Animal(String name, Color color, Size size, Gender gender) {
        this.name = name;
        this.color = color;
        this.gender = gender;
        this.size = size;
    }

    public void setBowl(Bowl bowl) {
        this.bowl = bowl;
    }

    @Override
    public boolean equals(Object o) {
        if (this==o) return true;
        if (!this.getClass().getName().equals(o.getClass().getName())) return false;
        if (!(o instanceof Animal animal)) return false;
        if (!name.equals(animal.name)) return false;
        if (color!=animal.color) return false;
        if (!Objects.equals(bowl, animal.bowl)) return false;
        if (size!=animal.size) return false;
        return gender==animal.gender;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + color.hashCode();
        result = 31 * result + (bowl!=null ? bowl.hashCode():0);
        result = 31 * result + size.hashCode();
        result = 31 * result + gender.hashCode();
        return result;
    }

    @Override
    public int compareTo(Animal other) {
        return this.size.value.compareTo(other.size.value);
    }

    public Animal clone() {
        try {
            return (Animal) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("This class does not implement Cloneable");
        }
    }
}
