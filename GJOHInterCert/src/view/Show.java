package view;

import model.Toy;

import java.util.Map;
import java.util.Queue;

public class Show {
    public static void showGifts(Map<Toy, Integer> toys) {
        if (toys.isEmpty()) {
            showMessage("Сart is empty");
        } else {
            for (Map.Entry<Toy, Integer> toy : toys.entrySet()) {
                showGift(toy.getKey(), toy.getValue());
            }
        }
    }

    public static void showGifts(Queue<Toy> toys) {
        if (toys.isEmpty()) {
            showMessage("Сart is empty");
        } else {
            for (Toy toy : toys) {
                showGift(toy);
            }
        }
    }

    public static void showMessage(String message) {
        System.out.println(message);
    }

    public static void showGift(Toy toy) {
        if (toy != null) {
            showMessage("------------------TOY-------------------");
            showMessage("ID: " + toy.getId());
            showMessage("NAME: " + toy.getName());
            showMessage("PRIORITY: " + toy.getPriority());
            showMessage("----------------------------------------");
        } else {
            showMessage("No data");
        }
    }

    public static void showGift(Toy toy, int count) {
        if (toy != null) {
            showMessage("------------------TOY-------------------");
            showMessage("ID: " + toy.getId());
            showMessage("NAME: " + toy.getName());
            showMessage("PRIORITY: " + toy.getPriority());
            showMessage("AMOUNT: " + count);
            showMessage("----------------------------------------");
        } else {
            showMessage("No data");
        }
    }

    public static void showConditions() {
        showMessage("---------------CONDITIONS---------------");
        showMessage("name - any text");
        showMessage("priority - 0.0 < x <= 100.00");
        showMessage("amount - 0 < x < MAX.INT");
        showMessage("----------------------------------------");
    }
}
