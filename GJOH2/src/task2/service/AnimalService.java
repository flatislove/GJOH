package task2.service;

import task2.model.Bowl;

/**
 * The interface describes the interaction with Animal
 */
public interface AnimalService {
    /**
     * The method describes animals eating
     *
     * @param bowl bowl
     */
    void eat(Bowl bowl);

    /**
     * The method describes animals walk up
     */
    void walkUp();

    /**
     * The method prints information about the Animal to the console
     */
    void printInfo();

    /**
     * The method sets the Bowl
     */
    void setBowl(Bowl catsBowl);
}
