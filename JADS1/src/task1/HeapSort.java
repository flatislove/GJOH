package task1;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 42, 8, 0, -5};
        System.out.println(Arrays.toString(array));
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sort(int[] array) {
        makeMaxHeap(array);
        int size = array.length - 1;
        for (int i = size; i > 0; i--) {
            int tmp = array[i];
            array[i] = array[0];
            array[0] = tmp;
            size--;
            updateHeap(array, 0, size);
        }
    }

    private static void makeMaxHeap(int[] array) {
        int size = array.length - 1;

        for (int i = size / 2; i >= 0; i--) {
            updateHeap(array, i, size);
        }
    }

    private static void updateHeap(int[] array, int i, int size) {
        int max;

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left <= size && array[left] > array[i]) {
            max = left;
        } else {
            max = i;
        }

        if (right <= size && array[right] > array[max]) {
            max = right;
        }

        if (max != i) {
            int tmp = array[i];
            array[i] = array[max];
            array[max] = tmp;
            updateHeap(array, max, size);
        }
    }
}
