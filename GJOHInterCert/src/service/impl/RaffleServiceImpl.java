package service.impl;

import model.Toy;
import service.PriorityRandom;
import service.RaffleService;
import service.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class RaffleServiceImpl implements RaffleService {
    @Override
    public Toy getNextGift(Map<Toy, Integer> toys) {
        if (toys.isEmpty()) {
            return null;
        }
        PriorityRandom random = new PriorityRandomImpl();
        return random.getRandomToyByPriority(new ArrayList<>(toys.keySet()));
    }

    @Override
    public Toy getToyWaitingToBeGiven(Queue<Toy> toys) {
        if (!toys.isEmpty()) {
            return toys.poll();
        }
        return null;
    }

    @Override
    public void removeToy(Toy toy, Map<Toy, Integer> toys) {
        if (!toys.isEmpty() && toy != null) {
            if (toys.get(toy) == 1) {
                toys.remove(toy);
            } else {
                toys.put(toy, toys.get(toy) - 1);
            }
        }
    }

    @Override
    public void addToy(Map<String, Object> values, Map<Toy, Integer> toys) {
        if (Validation.isCorrectCount(values.get("count").toString())
                && Validation.isCorrectPriority(values.get("priority").toString())
                && findByName(values.get("name").toString(), toys) == null) {
            try {
                Toy toy = new Toy(String.valueOf(values.get("name")), Double.parseDouble(values.get("priority").toString()));
                toys.put(toy, Integer.parseInt(values.get("count").toString()));
                System.out.println("Record added successfully");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Incorrect data or an entry with the same name exists. Entry not added");
        }
    }

    @Override
    public Toy findByName(String name, Map<Toy, Integer> toys) {
        for (Map.Entry<Toy, Integer> toy : toys.entrySet()) {
            if (toy.getKey().getName().equals(name)) {
                return toy.getKey();
            }
        }
        return null;
    }

    @Override
    public void editToy(Map<String, Object> values, Map<Toy, Integer> toys) {
        List<Toy> toyList = new ArrayList<>(toys.keySet());
        Toy toy = null;
        for (Toy value : toyList) {
            if (value.getName().equals(String.valueOf(values.get("editName")))) {
                toy = value;
            }
        }
        if (toy != null
                && Validation.isCorrectPriority(values.get("priority").toString())
                && Validation.isCorrectCount(values.get("count").toString())) {
            toy.setName(String.valueOf(values.get("name")));
            toy.setPriority(Double.parseDouble(values.get("priority").toString()));
            toys.put(toy, Integer.parseInt(values.get("count").toString()));
        } else {
            System.out.println("Incorrect data. Entry not added");
        }
    }
}
