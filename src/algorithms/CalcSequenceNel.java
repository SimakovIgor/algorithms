package algorithms;

import java.util.HashMap;
import java.util.Map;

public class CalcSequenceNel {
    public static void main(String[] args) {
        System.out.println(calc(2));
        System.out.println(calcIterative(2));
    }

    /**
     * Recursive Вычислить n-й член последовательности, заданной формулами:
     * a2n = an + an-1,
     * a2n+1 = an — an-1,
     * a0 = a1 = 1.
     *
     * @param n - el
     * @return - res
     */
    public static int calc(int n) {
        if (n < 2) return 1;
        if (n % 2 == 0)
            return calcCash(n / 2) + calcCash((n - 1) / 2);
        return calcCash(n / 2) - calcCash((n - 1) / 2);
    }

    private static Map<Integer, Integer> cache = new HashMap<>();

    /**
     * Рекурсивное решение с кэшированием значений
     * @param n - n
     * @return - calc
     */
    private static int calcCash(int n) {
        if (!cache.containsKey(n)) {
            cache.put(n, calc(n));
        }
        return cache.get(n);
    }

    /**
     * Итеративное решение
     * @param n - nth el
     * @return - result
     */
    public static int calcIterative(int n) {
        int[] f = new int[n + 1];
        f[0] = f[1] = 1;

        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0)
                f[i] = f[i / 2] + f[( i - 1) / 2];
             else
                 f[i] = f[i / 2] - f[(i - 1) / 2];
        }
        return f[n];
    }
}
