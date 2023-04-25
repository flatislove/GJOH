package s1;

import java.util.Arrays;

class Scenarios {
    static Service service = new Service();

    protected static void scenarioOne() {


        System.out.println("1 task");

        System.out.println(service.divideNumbers(1, 2));
        System.out.println(service.divideNumbers(4, 4));
        System.out.println(service.divideNumbers(0, 2));
        try {
            System.out.println(service.divideNumbers(2, 0));
        } catch (Exception e) {
            System.out.println(e.getClass().toString() + " - " + e.getMessage());
        }

        System.out.println();

        System.out.println(service.getElementByNumber(new int[]{0, 1, 2, 3, 4}, 3));
        try {
            System.out.println(service.getElementByNumber(null, 3));
        } catch (Exception e) {
            System.out.println(e.getClass().toString() + " - " + e.getMessage());
        }
        try {
            System.out.println(service.getElementByNumber(new int[]{0, 1, 2, 3, 4}, 6));
        } catch (Exception e) {
            System.out.println(e.getClass().toString() + " - " + e.getMessage());
        }

        System.out.println();

        System.out.println(service.paintBall("green"));
        System.out.println(service.paintBall("RED"));
        try {
            System.out.println(service.paintBall("yellow"));
        } catch (Exception e) {
            System.out.println(e.getClass().toString() + " - " + e.getMessage());
        }
    }

    public static void scenarioTwo() {

        System.out.println("\ntask2");
        System.out.println(Arrays.toString(service.mergeDiffTwoArrays(new int[]{1, 2, 3, 4, 5, 6}, new int[]{6, 5, 4, 3, 2, 1})));

        try {
            System.out.println(Arrays.toString(service.mergeDiffTwoArrays(new int[]{Integer.MIN_VALUE, 2, 3, 4, 5, 6}, new int[]{6, 5, 4, 3, 2, 1})));
        } catch (Exception e) {
            System.out.println(e.getClass().toString() + " - " + e.getMessage());
        }

        try {
            System.out.println(Arrays.toString(service.mergeDiffTwoArrays(null, new int[]{6, 5, 4, 3, 2, 1})));
        } catch (Exception e) {
            System.out.println(e.getClass().toString() + " - " + e.getMessage());
        }

        try {
            System.out.println(Arrays.toString(service.mergeDiffTwoArrays(new int[]{6, 5}, new int[]{6, 5, 4, 3, 2, 1})));
        } catch (Exception e) {
            System.out.println(e.getClass().toString() + " - " + e.getMessage());
        }
    }

    public static void scenarioThree() {

        System.out.println("\ntask3");
        System.out.println(Arrays.toString(service.mergeDivTwoArrays(new int[]{1, 2, 3, 4, 5, 6}, new int[]{6, 5, 4, 3, 2, 1})));

        try {
            System.out.println(Arrays.toString(service.mergeDivTwoArrays(new int[]{Integer.MIN_VALUE, 2, 3, 4, 5, 6}, new int[]{6, 5, 4, 0, 2, 1})));
        } catch (Exception e) {
            System.out.println(e.getClass().toString() + " - " + e.getMessage());
        }

        try {
            System.out.println(Arrays.toString(service.mergeDivTwoArrays(null, new int[]{6, 5, 4, 3, 2, 1})));
        } catch (Exception e) {
            System.out.println(e.getClass().toString() + " - " + e.getMessage());
        }

        try {
            System.out.println(Arrays.toString(service.mergeDivTwoArrays(new int[]{6, 5}, new int[]{6, 5, 4, 3, 2, 1})));
        } catch (Exception e) {
            System.out.println(e.getClass().toString() + " - " + e.getMessage());
        }
    }
}
