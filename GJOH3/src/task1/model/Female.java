package task1.model;

import task1.model.enums.Flavour;

import java.util.Date;

/**
 * The class describes the representation of the Female
 */
public class Female extends Person {
    private final int beauty;
    private final Flavour flavour;

    public Female(String firstname, String lastname, Date dateBirth, Family family, int beauty, Flavour flavour) {
        super(firstname, lastname, dateBirth, family);
        this.beauty = beauty;
        this.flavour = flavour;
    }

    @Override
    public void printInfo() {
        System.out.println(firstname + " " + lastname + " " + dateBirth + " " + beauty + " " + flavour);
    }
}
