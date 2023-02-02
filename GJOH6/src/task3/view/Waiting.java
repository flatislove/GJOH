package task3.view;

import java.util.Scanner;

public interface Waiting {

    default void waitInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Press any key...");
        sc.nextLine();
    }
}
