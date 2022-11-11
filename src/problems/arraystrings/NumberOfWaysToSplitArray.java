package problems.arraystrings;

public class NumberOfWaysToSplitArray {

    /**
     * Given an integer array nums, find the number of ways to split the array
     * into two parts so that the first section has a sum
     * greater than or equal to the sum of the second section.
     * The second section should have at least one number.
     *
     * @param nums {10, 4, -8, 7}
     * @return
     */
    public int waysToSplitArray(int[] nums) {
        //10,14,6,13
        int ans = 0;
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];

        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + prefix[i];
        }

        for (int i = 0; i < nums.length; i++) {
            int left = prefix[i];
            int right = prefix[prefix.length - 1] - left;
            if (left >= right) {
                ans++;
            }
        }
        return ans;
    }

    public int waysToSplitArrayWithoutArr(int[] nums) {
        int ans = 0;
        int total = 0;
        int left = 0;

        for (int num : nums) {
            total += num;
        }

        for (int num : nums) {
            left += num;
            int right = total - left;
            if (left >= right) {
                ans++;
            }
        }
        return ans;
    }

    public boolean findBalance(int[] nums) {
        int total = 0;
        int left = 0;

        for (int num : nums) {
            total = num;
        }

        for (int num : nums) {
            left += num;
            int right = total - left;
            if (left == right) return true;
        }
        return false;
    }

    /**
     * Given an array nums. We define a running sum of an
     * array as runningSum[i] = sum(nums[0]…nums[i]).
     * <p>
     * Return the running sum of nums.
     * <p>
     * Input: nums = [1,2,3,4]
     * Output: [1,3,6,10]
     * Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
     *
     * @return int[]
     */
    public int[] runningSum(int[] nums) {
        //1,3,6,10
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        return prefix;
    }

    /**
     * Given an array of integers nums, you start with an initial positive value startValue.
     * <p>
     * In each iteration, you calculate the step by step sum of startValue plus
     * elements in nums (from left to right).
     * <p>
     * Return the minimum positive value of startValue such that the step by
     * step sum is never less than 1.
     * <p>
     * Input: nums = [-3,2,-3,4,2]
     * Output: 5
     * Explanation: If you choose startValue = 4, in the third iteration your step by step sum is less than 1.
     * step by step sum
     * startValue = 4 | startValue = 5 | nums
     * (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
     * (1 +2 ) = 3  | (2 +2 ) = 4    |   2
     * (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
     * (0 +4 ) = 4  | (1 +4 ) = 5    |   4
     * (4 +2 ) = 6  | (5 +2 ) = 7    |   2
     *
     * @return
     */
    public int minimumValueToGetPositiveStepByStepSum(int[] nums) {
        int min = Integer.MAX_VALUE;
        int current = 0;

        for (int i = 0; i < nums.length; i++) {
            current += nums[i];
            min = Math.min(min, current);
        }

        if (min > 0) return 1;

        return Math.abs(min - 1);
    }
}
