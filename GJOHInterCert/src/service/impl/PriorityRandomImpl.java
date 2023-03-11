package service.impl;

import model.Toy;
import service.PriorityRandom;

import java.util.List;
import java.util.Random;

public class PriorityRandomImpl implements PriorityRandom {

    public Toy getRandomToyByPriority(List<Toy> toyList) {
        int sumValues = 0;
        for (Toy toy : toyList) {
            sumValues += toy.getPriority();
        }
        Random random = new Random();
        int randomNum = random.nextInt(sumValues) + 1;
        int pointer = 0;
        double currentSum = 0;
        while (randomNum > currentSum) {
            currentSum += toyList.get(pointer++).getPriority();
        }
        return toyList.get(pointer - 1);
    }
}
