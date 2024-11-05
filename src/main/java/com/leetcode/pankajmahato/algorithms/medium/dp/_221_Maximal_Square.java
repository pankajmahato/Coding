/**********************************************************************************
 *
 * https://leetcode.com/problems/maximal-square/
 *
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 4
 * Example 2:
 *
 *
 * Input: matrix = [["0","1"],["1","0"]]
 * Output: 1
 * Example 3:
 *
 * Input: matrix = [["0"]]
 * Output: 0
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] is '0' or '1'.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.dp;

public class _221_Maximal_Square {
    public int maximalSquare(char[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1')
                    dp[i][j] = Math.min(
                            Math.min(getCorrectedVal(dp, i - 1, j), getCorrectedVal(dp, i - 1, j - 1)),
                            getCorrectedVal(dp, i, j - 1)) + 1;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }

    private int getCorrectedVal(int[][] dp, int i, int j) {
        return i < 0 || j < 0 ? 0 : dp[i][j];
    }
}
