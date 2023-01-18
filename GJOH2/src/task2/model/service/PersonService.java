package task2.model.service;

import task2.model.Animal;
import task2.model.Bowl;

public interface PersonService {
    public void fillBowl(Bowl bowl);

    public void callAnimal(Animal animal);

    @Override
    public String toString();
}
