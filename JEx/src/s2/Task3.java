package s2;

public class Task3 {
    public static void main(String[] args) {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            try {
                printSum(23, 234);
            } catch (NullPointerException | NumberFormatException e) {
                System.out.println(e.getMessage());
            }

            int[] abc = {1, 2};
            abc[3] = 9;
        } catch (NullPointerException ex) {
            System.out.println("Pointer cannot be null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Ordinal element does not exist in array");
        } catch (Exception ex) {
            System.out.println("Something went wrong");
        }
    }

    private static void printSum(Integer a, Integer b) throws NullPointerException, NumberFormatException {
        int res = a + b;
        if ((a > 0 && b < 0 && res < a) || (a < 0 && b > 0 && res > a)) {
            throw new NumberFormatException("overflow integer type");
        }
        System.out.println(a + b);
    }
}
