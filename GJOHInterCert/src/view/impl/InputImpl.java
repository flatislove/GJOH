package view.impl;

import view.Input;
import view.Waiting;

import java.util.Scanner;

public class InputImpl implements Input, Waiting {
    public String getInputValue(String message) {
        System.out.print(message + ": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public void waitInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Press any key...");
        sc.nextLine();
    }
}
