package task1.model.dto;

import task1.model.Family;
import task1.model.Person;

import java.util.List;
import java.util.stream.Collectors;

public class FamilyDTO {
    private String name;
    private String father;
    private String mother;
    private List<String> children;

    public FamilyDTO(Family family) {
        this.name = family.getName();
        this.father = family.getFather().getFirstname() + " " + family.getFather().getLastname();
        this.mother = family.getMother().getFirstname() + " " + family.getMother().getLastname();
        this.children = family.getChildren().stream().map(Person::getFirstname).collect(Collectors.toList());
    }
}