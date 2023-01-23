package task1.model;

import com.google.gson.Gson;
import task1.model.dto.FamilyDTO;
import task1.service.TreeService;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Tree implements TreeService {

    public void printFamilyTree(Person person, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("     *");
        }
        System.out.println(person.getFirstname() + " " + person.getLastname() + " | siblings:" + person.getSiblings());

        List<Person> parents = person.getParents();

        if (parents!=null) {
            for (Person parent : parents) {
                printFamilyTree(parent, depth + 1);
            }
        }
    }

    @Override
    public void printChildren(Person person) {
        System.out.println(person + "\nChildren:\n" + person.getChildren());
    }

    public void saveToJson(String fileName, Family family) {
        FamilyDTO familyDTO = new FamilyDTO(family);
        Gson gson = new Gson();
        String json = gson.toJson(familyDTO);
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
