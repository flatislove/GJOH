package task2.model;

import task2.model.enums.Color;
import task2.model.enums.Gender;
import task2.model.service.AnimalService;

public abstract class Animal {
    protected String name;
    protected Color color;
    protected Bowl bowl;

    protected Gender gender;

    public Animal(String name, Color color, Gender gender) {
        this.name = name;
        this.color = color;
        this.gender = gender;
    }

    public void setBowl(Bowl bowl) {
        this.bowl = bowl;
    }
}
