package task2.model;

import task2.model.enums.Gender;
import task2.model.service.PersonService;

public class Person implements PersonService {

    private final String name;
    private final Gender gender;
    public Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public void fillBowl(Bowl bowl) {
        if (bowl.isEmpty()) {
            bowl.setEmpty(false);
            System.out.println("Fill bowl");
        } else {
            System.out.println("Bowl is not empty");
        }
    }

    public void callAnimal(Animal animal) {
        animal.walkUp();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }
}
