package algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

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

        System.out.println(Arrays.toString(maxSlidingWindowAVLTree(arr, 3)));
    }

    /**
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

    public static int[] maxSlidingWindowAVLTree(int[] nums, int k) {
        // creating the max heap ,to get max element always
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        int[] res = new int[nums.length - k + 1];
        int counter = 0;

        for (int i = 0; i < k; i++)
            queue.add(nums[i]);

        res[counter++] = queue.peek();
        // removing the first element of the array
        queue.remove(nums[0]);

        for (int i = k; i < nums.length; i++) {
            queue.add(nums[i]);
            res[counter++] = queue.peek();
            queue.remove(nums[i - k + 1]);
        }

        return res;
    }
}
