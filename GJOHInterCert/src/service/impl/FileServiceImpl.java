package service.impl;

import model.Toy;
import service.FileService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileServiceImpl implements FileService {
    @Override
    public void writeGiftToFile(Toy toy) {
        if (toy != null) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDateTime = now.format(formatter);
            try {
                File file = new File("received_toys.txt");
                FileWriter fw = new FileWriter(file, true); // true - для дозаписи в файл
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("TOY NAME: " + toy.getName() + "; DATE OF RECEIVING: " + formattedDateTime);
                bw.newLine();
                bw.close();
                fw.close();
                System.out.println("Data added to file");
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
            }
        } else {
            System.out.println("No data to write");
        }
    }
}
