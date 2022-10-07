package algorithms;

/**
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left
 * of the array to the very right. You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position.
 * <p>
 * Return the max sliding window.
 * <p>
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * <p>
 * Input: nums = [1], k = 1
 * Output: [1]
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] arr = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};

        findLength("1101100111");
    }

    /**
     * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left
     * of the array to the very right. You can only see the k numbers in the window.
     * Each time the sliding window moves right by one position.
     * <p>
     * Return the max sliding window.
     * <p>
     * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
     * Output: [3,3,5,5,6,7]
     * <p>
     * Input: nums = [1], k = 1
     * Output: [1]
     * <p>
     * <p>
     * Time Complexity: O(N * K).
     * The outer loop runs n-k+1 times and the inner loop runs k times for every iteration of outer loop.
     * So time complexity is O((n-k+1)*k) which can also be written as O(N * K).
     * Space Complexity: O(1).
     * No extra space is required.
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int size = nums.length - k + 1;
        int[] res = new int[size];

        for (int start = 0; start < size; start++) {
            int max = nums[start];
            int end = start + k - 1;

            for (int j = start + 1; j <= end; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                }
            }

            res[start] = max;
        }

        return res;
    }


    /**
     * Given an array of positive integers nums and an integer k,
     * find the length of the longest subarray whose sum is less than or equal to k.
     *
     * @param nums nums
     * @param k    k
     * @return int
     */
    public static int findLength(int[] nums, int k) {
        int left = 0;
        int curr = 0;
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {
            curr += nums[right];
            while (curr > k) {
                curr -= nums[left];
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }

    /**
     * You are given a binary substring s (a string containing only "0" and "1").
     * An operation involves flipping a "0" into a "1". What is the length of the
     * longest substring containing only "1" after performing at most one operation?
     * <p>
     * For example, given s = "1101100111", the answer is 5. If you perform the operation
     * at index 2, the string becomes 1111100111.
     *
     * @param s
     * @return
     */
    public static int findLength(String s) {
        int left = 0;
        int curr = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) == '0') {
                curr++;
            }

            while (curr > 1) {
                if (s.charAt(left) == '0') {
                    curr--;
                }

                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }


}
