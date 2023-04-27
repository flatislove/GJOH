package s2;

import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {
        input();
    }

    private static void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter line:");
        String inputString;
        while (true) {
            try {
                inputString = getStringInput(scanner);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Input: " + inputString);
    }

    private static String getStringInput(Scanner scanner) throws Exception {
        String result = "";
        boolean isValidInput = false;

        while (!isValidInput) {
            result = scanner.nextLine();
            if (result.isEmpty()) {
                throw new Exception("You can't enter blank lines");
            } else {
                isValidInput = true;
            }
        }
        return result;
    }
}
