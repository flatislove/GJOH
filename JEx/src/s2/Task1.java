package s2;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        input();
    }

    private static void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter float number:");

        float inputFloat = getFloatInput(scanner);

        System.out.println("Number: " + inputFloat);
    }

    public static float getFloatInput(Scanner scanner) {
        float result = 0.0f;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                result = Float.parseFloat(scanner.nextLine());
                isValidInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Incorrect value");
            }
        }
        return result;
    }
}
