package service;

public class Validation {
    public static boolean isCorrectCount(String s) {
        try {
            int num = Integer.parseInt(s);
            return num > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isCorrectPriority(String s) {
        try {
            double num = Double.parseDouble(s);
            return num > 0 && num <= 100;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
