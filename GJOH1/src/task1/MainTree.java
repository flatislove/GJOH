package task1;

import task1.model.Family;
import task1.model.Female;
import task1.model.Male;
import task1.model.Person;
import task1.model.enums.Auto;
import task1.model.enums.Flavour;
import task1.service.Service;
import task1.service.ServiceImpl;

import java.util.List;

/**
  Реализовать, с учетом ооп подхода, приложение Для проведения исследований с генеалогическим древом.
  Идея: описать некоторое количество компонент, например: модель человека компонента хранения связей и
  отношений между людьми: родитель, ребёнок - классика, но можно подумать и про отношение, брат, свекровь,
  сестра и т. д. компонент для проведения исследований дополнительные компоненты, например отвечающие за
  вывод данных в консоль, загрузку и сохранения в файл, получение\построение отдельных моделей человека
  Под “проведением исследования” можно понимать получение всех детей выбранного человека.
 */

public class MainTree {
    public static void main(String[] args) {
        Family family = new Family();
        Service service = new ServiceImpl();
        Person eva = new Female("eva", "smith", "12/10/2020", family, 5, Flavour.LILY);
        Person kain = new Male("kain", "duff", "12/12/2020", family, 3, Auto.AUDI);
        Person adam = new Male("adam", "smith", "12/12/2020", family, 4, Auto.MERCEDES);
        Person mike = new Male("mike", "briggs", "12/12/2020", family, 7, Auto.TOYOTA);
        Person jill = new Male("jill", "briggs", "12/12/2020", family, 8, Auto.AUDI);
        Person lily = new Female("lily", "torres", "12/12/2020", family, 8, Flavour.TULIP);
        Person debora = new Female("debora", "duff", "12/10/2020", family, 6, Flavour.LILY);
        Person alfred = new Male("alfred", "newton", "12/12/2020", family, 4, Auto.AUDI);
        Person gloria = new Female("gloria", "newton", "12/12/2020", family, 9, Flavour.LILY);
        Person glade = new Female("glade", "tomas", "12/12/2020", family, 7, Flavour.ROSE);
        Person martha = new Female("martha", "tomas", "12/12/2020", family, 7, Flavour.ROSE);
        Person venus = new Female("venus", "williams", "12/12/2020", family, 8, Flavour.TULIP);
        Person albert = new Male("albert", "williams", "12/12/2020", family, 9, Auto.TOYOTA);
        Person nick = new Male("nick", "stone", "12/12/2020", family, 7, Auto.MERCEDES);

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

        service.saveToJson("src/task1/family.json", family);

        System.out.println("\nHierarchy:");
        service.printFamilyTree(alfred, 0);

        System.out.println("\nChildren by Person:");
        service.printChildren(kain);

        System.out.println("\nPerson Info:");
        alfred.printInfo();
        venus.printInfo();
    }
}