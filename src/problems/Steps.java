package problems;

/**
 * На вершине лесенки, содержащей N ступенек, находится мячик, который начинает прыгать по ним вниз, к основанию.
 * Мячик может прыгнуть на следующую ступеньку, на ступеньку через одну или через 2. (То есть, если мячик лежит на 8-ой
 * ступеньке, то он может переместиться на 5-ую, 6-ую или 7-ую.) Определить число всевозможных «маршрутов»
 * мячика с вершины на землю.
 */
public class Steps {
    public static void main(String[] args) {
        System.out.println(calcRec(4));
        System.out.println(calcIterative(4));
    }

    /**
     * Рекурсивное решение
     *
     * @param n - count
     * @return - result
     */
    public static int calcRec(int n) {
        if (n == 3) return 4;
        if (n == 2) return 2;
        if (n == 1) return 1;
        return calcRec(n - 1) + calcRec(n - 2) + calcRec(n - 3);
    }

    /**
     * Реализация через массив значений
     * @param n
     * @return
     */
    public static int calcIterative(int n) {
        if (n == 3) return 4;
        if (n == 2) return 2;
        if (n == 1) return 1;

        int[] f = new int[n];
        f[0] = 1;
        f[1] = 2;
        f[2] = 4;
        for (int i = 3; i < n; i++) {
            f[i] = f[i - 1] + f[i - 2] + f[i - 3];
        }
        return f[n - 1];
    }
}
