package task2.model;

import task2.model.enums.Color;
import task2.model.enums.Gender;
import task2.model.service.AnimalService;

public abstract class Animal implements AnimalService {
    protected String name;
    protected Color color;
    protected Bowl bowl;

    protected Gender gender;

    public Animal(String name, Color color, Gender gender) {
        this.name = name;
        this.color = color;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Bowl getBowl() {
        return bowl;
    }

    public void setBowl(Bowl bowl) {
        this.bowl = bowl;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
