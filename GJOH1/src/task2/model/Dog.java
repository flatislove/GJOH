package task2.model;

import task2.model.enums.Color;
import task2.model.enums.Gender;

public class Dog extends Animal {
    private int speed;

    public Dog(String name, Color color, Gender gender, int speed) {
        super(name, color, gender);
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "speed=" + speed +
                ", name='" + name + '\'' +
                ", color=" + color +
                ", bowl=" + bowl +
                ", gender=" + gender +
                '}';
    }

    @Override
    public void eat(Bowl bowl) {
        if (this.bowl.equals(bowl)) {
            if (bowl.isEmpty()) {
                System.out.println(this.name + " can't eat. Bows is empty");
            } else {
                System.out.println(this.name + " ate");
                bowl.setEmpty(true);
            }
        } else {
            System.out.println("Wrong bowl");
        }
    }

    @Override
    public void walkUp() {
        if (!this.bowl.isEmpty()) {
            System.out.println(this.name + " is not here. He is near the bowl");
        } else {
            System.out.println(this.name + " is here. It's a dog");
        }
    }

    @Override
    public void printInfo() {
        System.out.println("Dog:\n" + this.name + " " + this.color + " " + this.gender + " " + this.speed + " " + this.bowl);
    }
}
