package task2;

import task2.model.*;
import task2.model.enums.Color;
import task2.model.enums.Gender;
import task2.model.enums.Size;
import task2.service.PersonService;

import java.util.List;

/**
 * Проделать код ревью своих работ. Некоторые стандартные интерфейсы
 */
public class MainPersonThing {
    /**
     * Execution script
     *
     * @param args args
     */
    public static void main(String[] args) {

        PersonService person = new Person("Anna", Gender.FEMALE);
        Animal cat = new Cat("Tomas", Color.BLACK, Size.SMAll, Gender.MALE, 2);
        Animal dog = new Dog("Rich", Color.WHITE, Size.MEDIUM, Gender.MALE, 4);

        Bowl dogsBowl = new Bowl(Color.GRAY);
        Bowl catsBowl = new Bowl(Color.BLACK);

        cat.setBowl(catsBowl);
        dog.setBowl(dogsBowl);

        List<Animal> animals = List.of(dog, cat);
        for (Animal animal : animals) {
            animal.printInfo();
        }
        System.out.println();

        for (Animal animal : animals) {
            person.callAnimal(animal);
        }
        System.out.println();

        cat.eat(catsBowl);
        dog.eat(dogsBowl);
        System.out.println();

        cat.eat(dogsBowl);
        dog.eat(catsBowl);
        System.out.println();

        person.fillBowl(catsBowl);
        person.fillBowl(catsBowl);
        person.fillBowl(dogsBowl);
        System.out.println();

        for (Animal animal : animals) {
            person.callAnimal(animal);
        }
        System.out.println();

        cat.eat(catsBowl);
        dog.eat(dogsBowl);
        System.out.println();

        for (Animal animal : animals) {
            person.callAnimal(animal);
        }
        System.out.println();

        Animal cloneAnimal = cat.clone();
        System.out.println("Equals dog and cat: "+dog.equals(cat));
        System.out.println("Compare cat and cat's clone: "+cloneAnimal.compareTo(cat));
        System.out.println("Equals cat and cat's clone: "+cloneAnimal.equals(cat));
    }
}