package problems;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(calcRec(5));
        System.out.println(calcDynamicProgramming(5));
        System.out.println(calcIterative(5));
    }

    /**
     * Method 1 Рекурсивное решение
     * Time Complexity: T(n) = T(n) which is linear.
     * Extra Space: O(n) if we consider the function call stack size, otherwise O(1).
     */
    public static int calcRec(int n) {
        if (n == 0 || n == 1) return n;
        return calcRec(n - 1) + calcRec(n - 2);
    }

    /**
     * Method 2 (Use Dynamic Programming)
     * @param n - n
     * @return - count
     */
    public static int calcDynamicProgramming(int n) {
        int[] f = new int[n + 2]; // 1 extra to handle case, n = 0
        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 2] + f[i - 1];
        }
        return f[n];
    }

    /**
     * Method 3 (Space Optimized Method 2)
     *
     * Time Complexity:O(n)
     * Extra Space: O(1)
     */
    public static int calcIterative(int n) {
        int first = 0, second = 1, temp;
        if (n == 0 ) return first;

        for (int i = 2; i <= n; i++) {
            temp = first + second;
            first = second;
            second = temp;
        }
        return second;
    }

}
