package s1;

class Service {
    protected double divideNumbers(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("b cannot be equal to 0");
        }
        return (double) a / b;
    }

    protected int getElementByNumber(int[] array, int position) throws NullPointerException, IllegalArgumentException {
        if (array == null) {
            throw new NullPointerException("array cannot be null");
        }
        if (array.length < position || position < 0) {
            throw new IllegalArgumentException("index cannot be greater than the length of the array or 0");
        }
        return array[position];
    }

    protected String paintBall(String color) throws IllegalArgumentException, UnsupportedOperationException {
        if (color == null) {
            throw new IllegalArgumentException("color cannot be null");
        }
        if (!color.equalsIgnoreCase("red")
                && !color.equalsIgnoreCase("green")
                && !color.equalsIgnoreCase("blue")) {
            throw new UnsupportedOperationException("impossible to paint. no paint");
        }
        return "ball is " + color;
    }

    protected int[] mergeDiffTwoArrays(int[] arrayOne, int[] arrayTwo)
            throws NullPointerException, IllegalArgumentException {
        if (arrayOne == null || arrayTwo == null) {
            throw new NullPointerException("array cannot be null");
        }
        if (arrayOne.length != arrayTwo.length) {
            throw new IllegalArgumentException("array length is not equal");
        }
        int[] arrayResult = new int[arrayOne.length];

        for (int i = 0; i < arrayOne.length; i++) {
            int a = arrayOne[i];
            int b = arrayTwo[i];
            int res = a - b;
            if ((a > 0 && b < 0 && res < a) || (a < 0 && b > 0 && res > a)) {
                throw new NumberFormatException("overflow integer type");
            }
            arrayResult[i] = res;
        }
        return arrayResult;
    }

    protected int[] mergeDivTwoArrays(int[] arrayOne, int[] arrayTwo)
            throws NullPointerException, IllegalArgumentException {
        if (arrayOne == null || arrayTwo == null) {
            throw new NullPointerException("array cannot be null");
        }
        if (arrayOne.length != arrayTwo.length) {
            throw new RuntimeException("array length is not equal");
        }
        int[] arrayResult = new int[arrayOne.length];

        for (int i = 0; i < arrayOne.length; i++) {
            int a = arrayOne[i];
            int b = arrayTwo[i];
            if (b == 0) {
                throw new RuntimeException("cannot be divided by 0");
            }
            arrayResult[i] = a - b;
        }
        return arrayResult;
    }
}
