package task1;

import task1.model.Family;
import task1.model.Person;
import task1.model.Service;

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
        Service service = new Service();
        Person adam = new Person("adam","smith","12/12/2020",family);
        Person eva = new Person("eva","smith","12/10/2020",family);
        Person debora = new Person("debora","duff","12/10/2020",family);
        Person kain = new Person("kain","duff","12/12/2020",family);
        Person alfred = new Person("alfred","newton","12/12/2020",family);
        Person gloria = new Person("gloria","newton","12/12/2020",family);
        Person mike = new Person("mike","briggs","12/12/2020",family);
        Person jill = new Person("jill","briggs","12/12/2020",family);
        Person lily = new Person("lily","torres","12/12/2020",family);

        kain.setParents(List.of(adam,eva));
        alfred.setParents(List.of(kain,debora));
        adam.setParents(List.of(gloria,mike));
        debora.setParents(List.of(jill,lily));

        family.setFather(adam);
        family.setMother(eva);
        family.setChildren(List.of(kain));

        service.printFamilyTree(alfred,0);
    }
}