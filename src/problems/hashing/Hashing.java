package problems.hashing;

import java.util.HashSet;
import java.util.Set;

public class Hashing {
    public char firstLetterToAppearTwice(String s) {
        Set<Character> characterSet = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (characterSet.contains(c)) return c;
            characterSet.add(c);
        }
        return ' ';
    }

    /**
     * A pangram is a sentence where every letter of the English alphabet appears at least once.
     * <p>
     * Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
     * Output: true
     * Explanation: sentence contains at least one of every letter of the English alphabet.
     * Example 2:
     * <p>
     * Input: sentence = "leetcode"
     * Output: false
     *
     * @param sentence
     * @return
     */
    public boolean checkIfPangram(String sentence) {
        int letterCount = 26;
        int current = 0;

        Set<Character> characterSet = new HashSet<>();

        for (char c : sentence.toCharArray()) {
            if (characterSet.contains(c)) {
                continue;
            }
            characterSet.add(c);
            current++;
        }
        return letterCount == current;
    }

    /**
     * Given an array nums containing n distinct numbers in the range [0, n],
     * return the only number in the range that is missing from the array.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [3,0,1]
     * Output: 2
     * Explanation: n = 3 since there are 3 numbers, so all numbers are
     * in the range [0,3]. 2 is the missing number in the range since it
     * does not appear in nums.
     * <p>
     * Example 2:
     * <p>
     * Input: nums = [0,1]
     * <p>
     * Output: 2
     * Explanation: n = 2 since there are 2 numbers, so all numbers are
     * in the range [0,2]. 2 is the missing number in the range since it
     * does not appear in nums.
     * <p>
     * Example 3:
     * <p>
     * Input: nums = [9,6,4,2,3,5,7,0,1]
     * Output: 8
     * Explanation: n = 9 since there are 9 numbers, so all numbers are in
     * the range [0,9]. 8 is the missing
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int cur = 0;
        int max = nums.length;

        for (int i = 0; i < max; i++) {
            cur += i;
        }

        return max - cur;
    }
}
