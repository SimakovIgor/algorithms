package algorithms;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(1221));
        System.out.println(isPalindrome(12321));
        System.out.println(isPalindrome(12322));
        System.out.println(isPalindrome(122));
    }

    //1221
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
