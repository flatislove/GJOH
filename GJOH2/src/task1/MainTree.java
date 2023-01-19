package task1;

import task1.model.Family;
import task1.model.Female;
import task1.model.Male;
import task1.model.Person;
import task1.model.enums.Auto;
import task1.model.enums.Flavour;
import task1.service.PersonService;
import task1.service.TreeService;
import task1.service.impl.TreeServiceImpl;

import java.util.List;

/**
 * Обеспечить переход от использования явных классов в сторону использования абстрактных типов.
 */

public class MainTree {
    /**
     * Execution script
     *
     * @param args
     */
    public static void main(String[] args) {
        Family family = new Family();
        TreeService treeService = new TreeServiceImpl();
        PersonService eva = new Female("eva", "smith", "12/10/2020", family, 5, Flavour.LILY);
        PersonService kain = new Male("kain", "duff", "12/12/2020", family, 3, Auto.AUDI);
        PersonService adam = new Male("adam", "smith", "12/12/2020", family, 4, Auto.MERCEDES);
        PersonService mike = new Male("mike", "briggs", "12/12/2020", family, 7, Auto.TOYOTA);
        PersonService jill = new Male("jill", "briggs", "12/12/2020", family, 8, Auto.AUDI);
        PersonService lily = new Female("lily", "torres", "12/12/2020", family, 8, Flavour.TULIP);
        PersonService debora = new Female("debora", "duff", "12/10/2020", family, 6, Flavour.LILY);
        PersonService alfred = new Male("alfred", "newton", "12/12/2020", family, 4, Auto.AUDI);
        PersonService gloria = new Female("gloria", "newton", "12/12/2020", family, 9, Flavour.LILY);
        PersonService glade = new Female("glade", "tomas", "12/12/2020", family, 7, Flavour.ROSE);
        PersonService martha = new Female("martha", "tomas", "12/12/2020", family, 7, Flavour.ROSE);
        PersonService venus = new Female("venus", "williams", "12/12/2020", family, 8, Flavour.TULIP);
        PersonService albert = new Male("albert", "williams", "12/12/2020", family, 9, Auto.TOYOTA);
        PersonService nick = new Male("nick", "stone", "12/12/2020", family, 7, Auto.MERCEDES);

        kain.setParents(List.of(((Person) adam), ((Person) eva)));
        alfred.setParents(List.of(((Person) kain), ((Person) debora)));
        adam.setParents(List.of(((Person) gloria), ((Person) mike)));
        debora.setParents(List.of(((Person) jill), ((Person) lily)));
        mike.setParents(List.of(((Person) nick), ((Person) venus)));

        kain.addChildren((Person) alfred);
        debora.addChildren((Person) alfred);

        gloria.addSiblings((Person) martha);
        kain.addSiblings((Person) albert);

        family.setName("Smith");
        family.setFather((Person) adam);
        family.setMother((Person) eva);
        family.setChildren(List.of(((Person) kain), ((Person) glade)));

        treeService.saveToJson("src/task1/family.json", family);

        System.out.println("\nHierarchy:");
        treeService.printFamilyTree((Person) alfred, 0);

        System.out.println("\nChildren by Person:");
        treeService.printChildren((Person) kain);

        System.out.println("\nPerson Info:");
        alfred.printInfo();
        venus.printInfo();
    }
}