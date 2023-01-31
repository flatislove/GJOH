package task1.view;

import java.util.Scanner;

/**
 * The class contains methods for displaying to the console
 */
public class Menu {
    public String showMenu() {
        while (true) {
            System.out.println("Choose operation:");
            System.out.println("1 - Divide");
            System.out.println("2 - Sum");
            System.out.println("3 - Difference");
            System.out.println("4 - Multiplication");
            System.out.println("0 - exit");
            String action = getValue();
            if ("01234".contains(action) && action.length()==1) {
                return action;
            }
        }
    }

    public String getValue() {
        System.out.print("Enter the action: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public Number[] getValues() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        String input1 = scanner.next();
        System.out.print("Enter the second number: ");
        String input2 = scanner.next();
        Number num1 = null;
        Number num2 = null;
        try {
            num1 = Double.parseDouble(input1);
            num2 = Double.parseDouble(input2);
        } catch (NumberFormatException e) {
            try {
                num1 = Integer.parseInt(input1);
                num2 = Integer.parseInt(input2);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input, please enter a valid number.");
            }
        }
        return new Number[]{num1, num2};
    }

    public void showMessage(String message, String example) {
        System.out.println(message + ": " + example);
    }
}
