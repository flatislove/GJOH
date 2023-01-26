package task2.model;

import task2.model.material.Material;

/**
 * Class using generic types
 * @param <T> material
 * @param <V> volume
 */

public class AnimalHouse<T extends Material, V extends Number> {

    private final T material;
    private final V volume;

    public AnimalHouse(T material, V volume) {
        this.material = material;
        this.volume = volume;
    }

    public T getMaterial() {
        return material;
    }

    public void printHouse() {
        String material = this.material.getName();
        String color = this.material.getColor().name();
        String volume = this.volume.toString();
        System.out.println("Animal House:" + "\nMaterial: " + material + "\nVolume: " + volume + "\nColor: " + color);
    }
}
