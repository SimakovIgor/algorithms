package algorithms;

/**
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm}
 * valued coins, how many ways can we make the change? The order of coins doesn’t matter.
 * For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4.
 * For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
 * So the output should be 5.
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] S = {1, 2, 3};
        int n = 3;

        System.out.println(countRec(S, S.length, n));
        System.out.println(countIt(S, n));
    }

    /**
     * Рекурсивное решение
     *
     * @param S - набор монет
     * @param n - число
     */
    public static int countRec(int[] S, int sLength, int n) {
        if (n == 0) return 1;
        if (n < 0) return 0;

        // If there are no coins then no solution exist
        if (sLength == 0) return 0;
        return countRec(S, sLength - 1, n)
                + countRec(S, sLength, n - S[sLength - 1]);
    }

    /**
     *  Like other typical Dynamic Programming(DP) problems, recomputations of same subproblems can be avoided by
     *  constructing a temporary array table[][] in bottom up manner.
     *
     * Time complexity of this function: O(mn)
     * Space Complexity of this function: O(n)
     *
     */
    public static int countIt(int[] S, int n) {
        // table[i] will be storing the number of solutions
        // for value i. We need n+1 rows as the table is
        // constructed in bottom up manner using the base
        // case (n = 0)
        int[] table = new int[n + 1];

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int i = 0; i < S.length; i++) {
            for (int j = S[i]; j <= n; j++) {
                table[j] += table[j - S[i]];
            }
        }

        return table[n];
    }
}
