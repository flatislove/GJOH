package task2.model;

import task2.model.enums.Color;
import task2.model.enums.Gender;

public class Cat extends Animal{
    private int jumpHeight;

    public Cat(String name, Color color, Gender gender, int jumpHeight) {
        super(name, color, gender);
        this.jumpHeight = jumpHeight;
    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    public void setJumpHeight(int jumpHeight) {
        this.jumpHeight = jumpHeight;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "jumpHeight=" + jumpHeight +
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
            System.out.println(this.name + " is not here. It's a cat");
        }
    }

    @Override
    public void printInfo() {
        System.out.println("Cat:\n" + this.name + " " + this.color + " " + this.gender + " " + this.jumpHeight + " " + this.bowl);
    }
}
