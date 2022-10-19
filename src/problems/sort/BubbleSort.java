package problems.sort;

import java.util.Arrays;

/**
 * Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent
 * elements if they are in wrong order.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 6, 2, 9, 5, 9, 3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
