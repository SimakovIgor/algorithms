package algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
 * <p>
 * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. Elements that
 * do not appear in arr2 should be placed at the end of arr1 in ascending order.
 * <p>
 * Example 1:
 * <p>
 * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * Output: [2,2,2,1,4,3,3,9,6,7,19]
 * <p>
 * Example 2:
 * <p>
 * Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
 * Output: [22,28,8,6,17,44]
 */
public class RelativeSortArray {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        relativeSortArray(new int[]{28, 3, 6, 22, 8, 22, 44, 17}, new int[]{22, 28, 8, 6})
                )
        );
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr2) {
            map.put(num, 0);
        }

        int last = arr1.length - 1;
        int[] res = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            if (map.containsKey(arr1[i]))
                map.put(arr1[i], map.get(arr1[i]) + 1);
            else
                res[last--] = arr1[i];
        }

        int i = 0;
        for (int num : arr2) {
            for (int j = 0; j < map.get(num); j++) {
                res[i++] = num;
            }
        }

        Arrays.sort(res, i, res.length);

        return res;
    }
}
