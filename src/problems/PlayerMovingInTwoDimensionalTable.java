package problems;

/**
 * В прямоугольной таблице NxM в начале игрок находится в левой верхней клетке. За один ход ему разрешается перемещаться
 * в соседнюю клетку либо вправо, либо вниз (влево и вверх перемещаться запрещено). Посчитайте, сколько есть способов
 * у игрока попасть в правую нижнюю клетку.
 */
public class PlayerMovingInTwoDimensionalTable {
    public static void main(String[] args) {
        System.out.println(calcRec(3, 3));
        System.out.println(calcIt(3, 3));
    }

    /**
     * Рекурсивное решение
     * @param m - m
     * @param n - n
     * @return - result
     */
    public static int calcRec(int m, int n) {
        if (m == 1 || n == 1) return 1;
        return calcRec(m - 1, n) + calcRec(m, n - 1);
    }

    /**
     *
     * @param m
     * @param n
     * @return
     */
    public static int calcIt(int m, int n) {
        int[][] f = new int[m][n];

        for (int i = 0; i < m; i++ ) {
            for (int j = 0; j < n; j++ ) {
                if (i == 0 || j == 0)
                    f[i][j] = 1;
                else
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }
}
