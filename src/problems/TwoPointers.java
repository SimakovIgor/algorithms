package problems;

import java.util.ArrayList;
import java.util.List;


public class TwoPointers {
    public static void main(String[] args) {
        int[] ints1 = {1, 3, 4, 6};
        int[] ints2 = {1, 2, 5, 7};
        System.out.println(combine(ints1, ints2));
    }

    /**
     * Given two sorted integer arrays, return an array that combines both of them and is also sorted.
     *
     * @param arr1 - arr1
     * @param arr2 - arr2
     * @return - List<Integer>
     */
    public static List<Integer> combine(int[] arr1, int[] arr2) {
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                ans.add(arr1[i]);
                i++;
            } else {
                ans.add(arr2[j]);
                j++;
            }
        }

        while (i < arr1.length) {
            ans.add(arr1[i]);
            i++;
        }

        while (j < arr2.length) {
            ans.add(arr2[j]);
            j++;
        }

        return ans;
    }

    /**
     * Example 4: 392. Is Subsequence.
     * <p>
     * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
     * <p>
     * A subsequence of a string is a new string that is formed from the original
     * string by deleting some (can be none) of the characters without disturbing
     * the relative positions of the remaining characters. (i.e., "ace" is a
     * subsequence of "abcde" while "aec" is not).
     *
     * @param s s
     * @param t t
     * @return boolean
     */
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == s.length();
    }

    /**
     * Example 2: Given a sorted array of unique integers and a target integer,
     * return true if there exists a pair of numbers that sum to target, false otherwise.
     * This problem is similar to Two Sum.
     * <p>
     * For example, given nums = [1, 2, 4, 6, 8, 9, 14, 15] and target = 13, return true
     * because 4 + 9 = 13.
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean checkForTarget(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int curr = nums[left] + nums[right];
            if (curr == target) {
                return true;
            }

            if (curr > target) {
                right--;
            } else {
                left++;
            }
        }

        return false;
    }

    /**
     * Example 1: Return true if a given string is a palindrome, false otherwise.
     * <p>
     * A string is a palindrome if it reads the same forwards as backwards.
     * That means, after reversing it, it is still the same string.
     * For example: "abcdcba", or "racecar".
     *
     * @param s
     * @return
     */
    public boolean checkIfPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
