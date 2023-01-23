package task1.model;

import task1.model.enums.Auto;

import java.util.Date;

/**
 * The class describes the representation of the Male
 */
public class Male extends Person {
    private final int power;
    private final Auto auto;

    public Male(String firstname, String lastname, Date dateBirth, Family family, int power, Auto auto) {
        super(firstname, lastname, dateBirth, family);
        this.power = power;
        this.auto = auto;
    }

    @Override
    public void printInfo() {
        System.out.println(firstname + " " + lastname + " " + dateBirth + " " + power + " " + auto);
    }
}
