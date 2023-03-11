package service;

import model.Toy;

import java.util.Map;
import java.util.Queue;

public interface RaffleService {
    Toy getNextGift(Map<Toy, Integer> toys);

    Toy getToyWaitingToBeGiven(Queue<Toy> toys);

    void removeToy(Toy toy, Map<Toy, Integer> toys);

    void addToy(Map<String, Object> values, Map<Toy, Integer> toys);

    Toy findByName(String name, Map<Toy, Integer> toys);

    void editToy(Map<String, Object> values, Map<Toy, Integer> toys);
}
