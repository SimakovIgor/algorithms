package problems;

public class FindSquareInMatrix {
    /**
     * We need to find the largest square comprising of all ones in the given
     * m×n matrix. In other words we need to find the largest set of connected
     * ones in the given matrix that forms a square.
     *
     * @param M square
     * @return - largest square
     */
    static int maxSubSquare(int[][] M) {
        int i, j;
        int R = M.length;         //no of rows in M[][]
        int C = M[0].length;     //no of columns in M[][]
        int[][] S = new int[R][C];

        /* Set first column of S[][]*/
        for (i = 0; i < R; i++) {
            S[i][0] = M[i][0];
        }

        /* Set first row of S[][]*/
        for (j = 0; j < C; j++) {
            S[0][j] = M[0][j];
        }

        /* Construct other entries of S[][]*/
        for (i = 1; i < R; i++) {
            for (j = 1; j < C; j++) {
                if (M[i][j] == 1) {
                    int min = Math.min(S[i - 1][j], S[i - 1][j - 1]);
                    S[i][j] = Math.min(S[i][j - 1], min) + 1;
                } else {
                    S[i][j] = 0;
                }
            }
        }

        /* Find the maximum entry, and indexes of maximum entry
            in S[][] */
        int max_diag = 0;
        for (i = 0; i < R; i++) {
            for (j = 0; j < C; j++) {
                if (max_diag < S[i][j]) {
                    max_diag = S[i][j];
                }
            }
        }

        return max_diag * max_diag;
    }

    // Driver program
    public static void main(String[] args) {
        int[][] M = {{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};

        System.out.println(maxSubSquare(M));
    }
}
