package task2.model.service;

import task2.model.Bowl;

public interface PersonService {
    void fillBowl(Bowl bowl);

    void callAnimal(AnimalService animal);

    @Override
    String toString();
}
