package model;

import java.util.Map;

public class RafflePrizes {
    private final Map<Toy, Integer> toysMap;

    public RafflePrizes(Map<Toy, Integer> toys) {
        this.toysMap = toys;
    }

    public Map<Toy, Integer> getToysMap() {
        return toysMap;
    }
}
