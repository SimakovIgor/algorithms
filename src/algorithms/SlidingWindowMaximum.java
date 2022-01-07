package algorithms;

/**
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left
 * of the array to the very right. You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {

    }

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
}
