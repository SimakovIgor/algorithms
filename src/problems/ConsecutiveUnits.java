package problems;

/**
 * Требуется найти в бинарном векторе самую длинную последовательность единиц и вывести её длину.
 */
public class ConsecutiveUnits {
    public static void main(String[] args) {
        int[] n = {0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1};
        System.out.println(countIt(n));
        System.out.println(countRec(n, 0, n.length, 0));
    }

    /**
     * Итеративное решение
     */
    public static int countIt(int[] s) {

        int cur = 0, max = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == 1) {
                cur++;
                if (cur > max) max = cur;
            } else cur = 0;
        }
        return max;
    }

    /**
     * Рекурсивное решение
     */
    public static int countRec(int[] s, int count, int sLength, int max) {
        if (sLength == 0) return max;
        if (s[sLength - 1] == 1) {
            count++;
            if (count > max) max = count;
        } else {
            count = 0;
        }

        return countRec(s, count, sLength -= 1, max);
    }
}

