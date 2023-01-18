package task2;

import task2.model.*;
import task2.model.enums.Color;
import task2.model.enums.Gender;
import task2.model.service.AnimalService;
import task2.model.service.PersonService;

public class MainPersonThing {
    public static void main(String[] args) {

        PersonService person = new Person("Anna", Gender.FEMALE);
        AnimalService cat = new Cat("Tomas", Color.BLACK, Gender.MALE, 2);
        AnimalService dog = new Dog("Rich", Color.WHITE, Gender.MALE, 4);

        Bowl dogsBowl = new Bowl(Color.GRAY);
        Bowl catsBowl = new Bowl(Color.BLACK);

        cat.setBowl(catsBowl);
        dog.setBowl(dogsBowl);

        dog.printInfo();
        cat.printInfo();
        System.out.println();

        person.callAnimal(cat);
        person.callAnimal(dog);
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

        person.callAnimal(cat);
        person.callAnimal(dog);
        System.out.println();

        cat.eat(catsBowl);
        dog.eat(dogsBowl);
        System.out.println();

        person.callAnimal(cat);
        person.callAnimal(dog);
    }
}