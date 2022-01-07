package algorithms.sort;

import java.util.Arrays;

/**
 * Quicksort is a sorting algorithm, which is leveraging the divide-and-conquer principle.
 * It has an average O(n log n) complexity and it’s one of the most used sorting algorithms, especially for big data volumes.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {8, 1, 6, 5, 3, 14, 22, 10, 9};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex, end);
        }
    }

    public static int partition(int[] arr, int begin, int end) {
        int rightIndex = end;
        int leftIndex = begin;
        int pivot = arr[begin + (end - begin) / 2];

        while (leftIndex <= rightIndex) {
            while (arr[leftIndex] < pivot) {
                leftIndex++;
            }
            while (arr[rightIndex] > pivot) {
                rightIndex--;
            }
            if (leftIndex <= rightIndex) {
                int temp = arr[leftIndex];
                arr[leftIndex] = arr[rightIndex];
                arr[rightIndex] = temp;

                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }
}
