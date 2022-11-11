package problems;

import java.util.Arrays;
import java.util.HashMap;

public class TwoNums {
    public static int[] twoSum(int[] nums, int m) {
        HashMap<Integer, Integer> tracker = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (tracker.containsKey(nums[i])) {
                int left = tracker.get(nums[i]);
                return new int[]{left + 1, i + 1};
            } else {
                tracker.put(m - nums[i], i);
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1, 4, 5, 3, 2}, 8)));
    }
}
