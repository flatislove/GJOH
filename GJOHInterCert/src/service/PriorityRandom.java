package service;

import model.Toy;

import java.util.List;

public interface PriorityRandom {
    Toy getRandomToyByPriority(List<Toy> toyList);
}
