package task1.model;

import task1.model.enums.Auto;

public class Male extends Person {
    private int power;
    private Auto auto;

    public Male(String firstname, String lastname, String dateBirth, Family family, int power, Auto auto) {
        super(firstname, lastname, dateBirth, family);
        this.power = power;
        this.auto = auto;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    @Override
    public void printInfo() {
        System.out.println(this.firstname + " " + this.lastname + " " + this.dateBirth + " " + this.power + " " + this.auto);
    }
}
