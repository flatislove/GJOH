package controller;

import model.RafflePrizes;
import model.Toy;
import service.FileService;
import service.RaffleService;
import service.impl.FileServiceImpl;
import service.impl.RaffleServiceImpl;
import view.Menu;
import view.Waiting;
import view.impl.InputImpl;
import view.impl.MenuImpl;
import view.Show;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class RaffleRunner {

    Queue<Toy> toysWaitingToBeGivenQueue = new LinkedList<>();
    RaffleService raffleService = new RaffleServiceImpl();
    FileService fileService = new FileServiceImpl();

    Map<Toy, Integer> toys = new HashMap<>();
    RafflePrizes rafflePrizes = new RafflePrizes(toys);
    Menu menu = new MenuImpl();

    Waiting waiting = new InputImpl();

    public void start() {

        do {
            String action = menu.showMenu();
            if (action.equals("0")) {
                return;
            }
            run(action);
        } while (true);
    }

    public void run(String action) {
        switch (action) {
            case "1" -> {
                System.out.println("ALL AVAILABLE GIFTS");
                Show.showGifts(rafflePrizes.getToysMap());
                waiting.waitInput();
            }
            case "2" -> {
                System.out.println("WAITING TO BE GIVEN GIFTS");
                Show.showGifts(toysWaitingToBeGivenQueue);
                waiting.waitInput();
            }
            case "3" -> {
                System.out.println("ADD GIFT");
                Show.showConditions();
                raffleService.addToy(menu.addToyMenu(), rafflePrizes.getToysMap());
                waiting.waitInput();
            }
            case "4" -> {
                System.out.println("EDIT GIFT");
                Show.showGifts(rafflePrizes.getToysMap());
                raffleService.editToy(menu.editToyMenu(), toys);
                waiting.waitInput();
            }
            case "5" -> {
                System.out.println("GET RANDOM GIFT");
                Toy toy = raffleService.getNextGift(rafflePrizes.getToysMap());
                raffleService.removeToy(toy, rafflePrizes.getToysMap());
                toysWaitingToBeGivenQueue.add(toy);
                Show.showGift(toy);
                waiting.waitInput();
            }
            case "6" -> {
                System.out.println("GET THE WON GIFT");
                fileService.writeGiftToFile(raffleService.getToyWaitingToBeGiven(toysWaitingToBeGivenQueue));
                waiting.waitInput();
            }
        }
    }
}
