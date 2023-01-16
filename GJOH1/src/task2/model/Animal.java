package task2.model;

import task2.model.enums.Color;
import task2.model.enums.Gender;

public class Animal {
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setBowl(Bowl bowl) {
        this.bowl = bowl;
    }

    public void eat(Bowl bowl) {
        if (bowl.equals(this.bowl)) {
            if (bowl.isEmpty()) {
                System.out.println("Animal can't eat. Bows is empty");
            } else {
                bowl.setEmpty(true);
                System.out.println("Animal ate");
            }
        } else {
            System.out.println("Wrong bowl");
        }
    }

    public void walkUp() {
        if (!this.bowl.isEmpty()) {
            System.out.println(this.name + " is not here. He is near the bowl");
        } else {
            System.out.println(this.name + " is here");
        }
    }

    public void printInfo() {
        System.out.println("Animal:\n" + this.name + " " + this.color + " " + this.gender + " " + this.bowl);
    }
}
