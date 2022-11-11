package problems.hashing;

import java.util.HashMap;
import java.util.Map;

public class CountNumberNiceSubarrays {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        int i = numberOfSubarrays(nums, 3);
    }

    /**
     * Example 5: 1248. Count Number of Nice Subarrays
     * <p>
     * Given an array of positive integers nums and an integer k. Find the number of
     * subarrays with exactly k odd numbers in them.
     * <p>
     * For example, given nums = [1, 1, 2, 1, 1], k = 3, the answer is 2. The
     * subarrays with 3 odd numbers in them are [1, 1, 2, 1, 1] and [1, 1, 2, 1, 1].
     *
     * @param nums nums
     * @param k    k
     * @return int
     */
    public static int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(0, 1);

        int ans = 0;
        int curr = 0;

        for (int num : nums) {
            curr += num % 2;
            ans += counts.getOrDefault(curr - k, 0);
            counts.put(curr, counts.getOrDefault(curr, 0) + 1);
        }

        return ans;
    }
}
