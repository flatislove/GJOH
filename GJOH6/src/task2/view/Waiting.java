package task2.view;

import java.util.Scanner;

/**
 * The interface contains waiting input method
 */
public interface Waiting {

    default void waitInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Press any key...");
        sc.nextLine();
    }
}
