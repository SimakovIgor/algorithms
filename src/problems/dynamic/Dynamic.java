package problems.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Dynamic {
    public static void main(String[] args) {
        int[] ints = {5, 14};
        List<Integer> lists = howSumOnes(300, ints);
        System.out.println(lists);
    }

    public static List<Integer> howSumOnes(int target, int[] nums) {
        HashMap<Integer, List<Integer>> memo = new HashMap<>();
        return howSumOnesRecursion(target, nums, memo);
    }

    public static List<Integer> howSumOnesRecursion(int target, int[] nums,
                                                    HashMap<Integer, List<Integer>> memo) {
        if (memo.containsKey(target)) return memo.get(target);
        if (target == 0) return new ArrayList<>();
        if (target < 0) return null;

        for (int num : nums) {
            int reminder = target - num;
            List<Integer> integers = howSumOnesRecursion(reminder, nums, memo);
            if (integers != null) {
                integers.add(num);
                memo.put(target, integers);
                return memo.get(target);
            }
        }
        memo.put(target, null);
        return null;
    }

    public static List<List<Integer>> combineAllSums(int target, int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        combineAllSumsRecursion(list, new ArrayList<>(), nums, target, 0);

        return list;
    }

    public static void combineAllSumsRecursion(List<List<Integer>> ans, List<Integer> cur,
                                               int[] nums, int target, int start) {
        if (target == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (cur.contains(i)) continue;
            cur.add(nums[i]);
            combineAllSumsRecursion(ans, cur, nums, target - nums[i], i);
            cur.remove(cur.size() - 1);
        }
    }
}
