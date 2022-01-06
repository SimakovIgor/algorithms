package algorithms;

/**
 * Given an integer x, return true if x is palindrome integer.
 *
 * An integer is a palindrome when it reads the same backward as forward.
 *
 * For example, 121 is a palindrome while 123 is not.
 *
 * Ex:
 *
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 *
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 *
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(1221));
        System.out.println(isPalindrome(122));
        System.out.println(isPalindrome(1222));
    }

    public static boolean isPalindrome(int target) {
        if (target < 0 || target % 10 == 0) return false;

        int reverse = 0;
        while (target > reverse) {
            reverse = reverse * 10 + target % 10;
            target = target / 10;
        }

        return target == reverse || target == reverse / 10;
    }
}
