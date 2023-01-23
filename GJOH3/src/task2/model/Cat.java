package task2.model;

import task2.model.enums.Color;
import task2.model.enums.Gender;
import task2.model.enums.Size;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/**
 * The class describes the representation of the Cat
 */
public class Cat extends Animal {
    private final Integer jumpHeight;

    public Cat(String name, Color color, Size size, Gender gender, Integer jumpHeight) {
        super(name, color, size, gender);
        this.jumpHeight = jumpHeight;
    }

    @Override
    public String toString() {
        AtomicReference<StringBuilder> sb = new AtomicReference<>(new StringBuilder());
        sb.get().append("Cat{\n")
                .append(" speed=").append(jumpHeight)
                .append(",\n name='").append(name).append('\'')
                .append(",\n color=").append(color)
                .append(",\n bowl=").append(bowl)
                .append(",\n gender=").append(gender)
                .append(",\n size=").append(size)
                .append("\n}");
        return sb.toString();
    }

    @Override
    public void eat(Bowl bowl) {
        if (this.bowl.equals(bowl)) {
            if (bowl.isEmpty()) {
                System.out.println(name + " can't eat. Bows is empty");
            } else {
                System.out.println(name + " ate");
                bowl.setEmpty(true);
            }
        } else {
            System.out.println("Wrong bowl");
        }
    }

    @Override
    public void walkUp() {
        if (!bowl.isEmpty()) {
            System.out.println(name + " is not here. He is near the bowl");
        } else {
            System.out.println(name + " is not here. It's a cat");
        }
    }

    @Override
    public void printInfo() {
        System.out.println("Cat:\n" + name + " " + color + " " + gender + " " + size.name() + " " + jumpHeight + " " + bowl);
    }

    @Override
    public boolean equals(Object o) {
        if (this==o) return true;
        if (!(o instanceof Cat cat)) return false;
        if (!super.equals(o)) return false;

        return Objects.equals(jumpHeight, cat.jumpHeight);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (jumpHeight!=null ? jumpHeight.hashCode():0);
        return result;
    }
}
