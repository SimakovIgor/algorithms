package problems;

import java.util.HashMap;

public class TwoNums {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> tracker = new HashMap<>();
        int len = nums.length;
        for(int i = 0; i < len; i++){
            if(tracker.containsKey(nums[i])){
                int left = tracker.get(nums[i]);
                return new int[]{left+1, i+1};
            }else{
                tracker.put(target - nums[i], i);
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        twoSum(new int[] {2,7,11,15}, 9);
    }
}
