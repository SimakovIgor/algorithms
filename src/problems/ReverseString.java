package problems;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        reverse("Hello world");
    }
    public static String reverse(String str) {
        char[] chars = str.toCharArray();
        char[] result = new char[chars.length];

        for (int i = chars.length - 1, j = 0; i >= 0; i--) {
            result[j++] = chars[i];
        }
        return Arrays.toString(result);
    }
}
