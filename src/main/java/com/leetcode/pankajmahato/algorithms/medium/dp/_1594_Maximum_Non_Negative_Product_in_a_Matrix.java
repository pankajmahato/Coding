/**********************************************************************************
 *
 * https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/
 *
 * You are given a m x n matrix grid. Initially, you are located at the top-left corner (0, 0), and in each step, you can only move right or down in the matrix.
 *
 * Among all possible paths starting from the top-left corner (0, 0) and ending in the bottom-right corner (m - 1, n - 1), find the path with the maximum non-negative product. The product of a path is the product of all integers in the grid cells visited along the path.
 *
 * Return the maximum non-negative product modulo 109 + 7. If the maximum product is negative, return -1.
 *
 * Notice that the modulo is performed after getting the maximum product.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[-1,-2,-3],[-2,-3,-3],[-3,-3,-2]]
 * Output: -1
 * Explanation: It is not possible to get non-negative product in the path from (0, 0) to (2, 2), so return -1.
 * Example 2:
 *
 *
 * Input: grid = [[1,-2,1],[1,-2,1],[3,-4,1]]
 * Output: 8
 * Explanation: Maximum non-negative product is shown (1 * 1 * -2 * -4 * 1 = 8).
 * Example 3:
 *
 *
 * Input: grid = [[1,3],[0,-4]]
 * Output: 0
 * Explanation: Maximum non-negative product is shown (1 * 0 * -4 = 0).
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 15
 * -4 <= grid[i][j] <= 4
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.dp;

public class _1594_Maximum_Non_Negative_Product_in_a_Matrix {

    static class Pair {

        long max;
        long min;

        Pair(long max, long min) {
            this.max = max;
            this.min = min;
        }
    }

    final int MOD = 1_000_000_007;

    // public int maxProductPath(int[][] grid) {

    //     // DP Top Down

    //     int m = grid.length;
    //     int n = grid[0].length;

    //     // dp[i][j] = max & min product Pair to reach cell (i,j)
    //     Pair[][] dp = new Pair[m][n];

    //     Pair result = solve(0, 0, m, n, grid, dp);

    //     if (result.max < 0) {
    //         return -1;
    //     }

    //     return (int) (result.max % MOD);
    // }

    // private Pair solve(int i, int j, int m, int n, int[][] grid, Pair[][] dp) {

    //     if (i == m - 1 && j == n - 1) {
    //         return new Pair((long) grid[i][j], (long) grid[i][j]);
    //     }

    //     if (dp[i][j] != null) {
    //         return dp[i][j];
    //     }

    //     long max = Long.MIN_VALUE;
    //     long min = Long.MAX_VALUE;

    //     // Right
    //     if (j + 1 < n) {
    //         Pair right = solve(i, j + 1, m, n, grid, dp);
    //         max = Math.max(max, Math.max(grid[i][j] * right.max, grid[i][j] * right.min));
    //         min = Math.min(min, Math.min(grid[i][j] * right.max, grid[i][j] * right.min));
    //     }

    //     // Down
    //     if (i + 1 < m) {
    //         Pair down = solve(i + 1, j, m, n, grid, dp);
    //         max = Math.max(max, Math.max(grid[i][j] * down.max, grid[i][j] * down.min));
    //         min = Math.min(min, Math.min(grid[i][j] * down.max, grid[i][j] * down.min));
    //     }

    //     return dp[i][j] = new Pair(max, min);
    // }

    public int maxProductPath(int[][] grid) {

        // DP Bottom Up

        int m = grid.length;
        int n = grid[0].length;

        // dp[i][j] = max & min product Pair to reach cell (i,j)
        Pair[][] dp = new Pair[m][n];
        dp[0][0] = new Pair((long) grid[0][0], (long) grid[0][0]);

        // Fill Right base case
        for (int i = 1; i < n; i++) {
            dp[0][i] = new Pair((long) grid[0][i] * dp[0][i - 1].max, (long) grid[0][i] * dp[0][i - 1].min);
        }

        // Fill Down base case
        for (int i = 1; i < m; i++) {
            dp[i][0] = new Pair((long) grid[i][0] * dp[i - 1][0].max, (long) grid[i][0] * dp[i - 1][0].min);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                long leftMax = dp[i - 1][j].max;
                long leftMin = dp[i - 1][j].min;

                long upMax = dp[i][j - 1].max;
                long upMin = dp[i][j - 1].min;

                long max = Math.max(Math.max(grid[i][j] * leftMax, grid[i][j] * leftMin),
                        Math.max(grid[i][j] * upMax, grid[i][j] * upMin));
                long min = Math.min(Math.min(grid[i][j] * leftMax, grid[i][j] * leftMin),
                        Math.min(grid[i][j] * upMax, grid[i][j] * upMin));

                dp[i][j] = new Pair(max, min);
            }
        }

        Pair result = dp[m - 1][n - 1];

        if (result.max < 0) {
            return -1;
        }

        return (int) (result.max % MOD);
    }
}
