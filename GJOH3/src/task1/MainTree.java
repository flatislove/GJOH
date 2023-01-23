package task1;

import task1.model.Family;
import task1.model.Female;
import task1.model.Male;
import task1.model.Person;
import task1.model.enums.Auto;
import task1.model.enums.Flavour;
import task1.service.TreeService;
import task1.model.Tree;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Проделать код ревью своих работ. Некоторые стандартные интерфейсы
 */

public class MainTree {
    /**
     * Execution script
     */
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Family family = new Family();
        TreeService treeService = new Tree();
        Person eva = new Female("eva", "smith", formatter.parse("27/02/1981"), family, 5, Flavour.LILY);
        Person kain = new Male("kain", "duff", formatter.parse("12/12/2000"), family, 3, Auto.AUDI);
        Person adam = new Male("adam", "smith", formatter.parse("10/07/1980"), family, 4, Auto.MERCEDES);
        Person mike = new Male("mike", "briggs", formatter.parse("01/03/1962"), family, 7, Auto.TOYOTA);
        Person jill = new Male("jill", "briggs", formatter.parse("27/11/1982"), family, 8, Auto.AUDI);
        Person lily = new Female("lily", "torres", formatter.parse("14/05/1979"), family, 8, Flavour.TULIP);
        Person debora = new Female("debora", "duff", formatter.parse("11/01/2000"), family, 6, Flavour.LILY);
        Person alfred = new Male("alfred", "newton", formatter.parse("12/12/2020"), family, 4, Auto.AUDI);
        Person gloria = new Female("gloria", "newton", formatter.parse("22/10/1960"), family, 9, Flavour.LILY);
        Person glade = new Female("glade", "tomas", formatter.parse("15/04/2002"), family, 7, Flavour.ROSE);
        Person martha = new Female("martha", "tomas", formatter.parse("02/01/1962"), family, 7, Flavour.ROSE);
        Person venus = new Female("venus", "williams", formatter.parse("30/08/1943"), family, 8, Flavour.TULIP);
        Person albert = new Male("albert", "williams", formatter.parse("19/11/2002"), family, 9, Auto.TOYOTA);
        Person nick = new Male("nick", "stone", formatter.parse("17/09/1941"), family, 7, Auto.MERCEDES);

        kain.setParents(List.of(adam, eva));
        alfred.setParents(List.of(kain, debora));
        adam.setParents(List.of(gloria, mike));
        debora.setParents(List.of(jill, lily));
        mike.setParents(List.of(nick, venus));

        kain.addChildren(alfred);
        debora.addChildren(alfred);

        gloria.addSiblings(martha);
        kain.addSiblings(albert);

        family.setName("Smith");
        family.setFather(adam);
        family.setMother(eva);
        family.setChildren(List.of(kain, glade));

        treeService.saveToJson("src/task1/family.json", family);

        System.out.println("\nHierarchy:");
        treeService.printFamilyTree(alfred, 0);

        System.out.println("\nChildren by Person with Iterable:");
        for (Person child : kain) {
            child.printInfo();
        }

        System.out.println("\nPerson Info:");
        List<Person> persons = List.of(albert, venus);
        for (Person person : persons) {
            person.printInfo();
        }

        System.out.println("\nCompare persons:");
        System.out.println("Compare: eva and kain: " + eva.compareTo(kain));
        System.out.println("Equals: eva and debora: " + eva.equals(debora));
    }
}