package problems;

import java.util.Arrays;
import java.util.List;

public class FindTwoMaxNumsInArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(find(List.of(1, 4, 2, 6, -2, 10, 10))));
    }

    public static int[] find(List<Integer> list) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int i : list) {
            if (max1 <= max2) {
                max1 = Math.max(max1, i);
            } else {
                max2 = Math.max(max2, i);
            }
        }
        return new int[]{max1, max2};
    }
}
