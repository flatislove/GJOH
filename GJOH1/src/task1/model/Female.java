package task1.model;

import task1.model.enums.Flavour;

public class Female extends Person {
    private int beauty;
    private Flavour flavour;

    public Female(String firstname, String lastname, String dateBirth, Family family, int beauty, Flavour flavour) {
        super(firstname, lastname, dateBirth, family);
        this.beauty = beauty;
        this.flavour = flavour;
    }

    public int getBeauty() {
        return beauty;
    }

    public void setBeauty(int beauty) {
        this.beauty = beauty;
    }

    public Flavour getFlavour() {
        return flavour;
    }

    public void setFlavour(Flavour flavour) {
        this.flavour = flavour;
    }

    @Override
    public void printInfo() {
        System.out.println(this.firstname + " " + this.lastname + " " + this.dateBirth + " " + this.beauty + " " + this.flavour);
    }
}
