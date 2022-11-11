package problems.arrays_and_strings;

/**
 * Given an integer array nums sorted in non-decreasing order, return an array of the
 * squares of each number sorted in non-decreasing order.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * Example 2:
 * <p>
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in non-decreasing order.
 * <p>
 * <p>
 * Follow up: Squaring each element and sorting the new array is very trivial,
 * could you find an O(n) solution using a different approach?
 */
public class SquaresSortedArray {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int[] ans = new int[nums.length];

        for (int i = nums.length - 1; i >= 0 ; i--) {
            int square;
            if (Math.pow(nums[left], 2) >= Math.pow(nums[right], 2)) {
                square = nums[left];
                left++;
            } else {
                square = nums[right];
                right--;
            }
            ans[i] = square * square;
        }

        return ans;
    }
}
