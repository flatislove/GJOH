package s2;

public class Task2 {
    public static void main(String[] args) {
        method(new int[]{0, 1, 2, 4, 45});
        method(new int[]{0, 1, 2, 4, 4, 5, 6, 3, 7, 9, 2});
    }

    private static void method(int[] intArray) {
        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
//            double catchedRes1 = (double) intArray[8] / d; // x/0 = infinity result
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException | IndexOutOfBoundsException e) {
            System.out.println("Catching exception: " + e.getMessage());
        }
    }
}
