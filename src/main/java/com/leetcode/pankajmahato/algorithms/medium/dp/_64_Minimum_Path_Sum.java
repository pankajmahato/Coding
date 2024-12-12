/**********************************************************************************
 *
 * https://leetcode.com/problems/minimum-path-sum/
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 * Example 2:
 *
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 200
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.dp;

public class _64_Minimum_Path_Sum {

//    public int minPathSum(int[][] grid) {
//
//        // DP with top down
//        int row = grid.length;
//        int col = grid[0].length;
//
//        // dp[r][c] = Minimum path sum till r-th row and c-th column
//        Integer[][] dp = new Integer[row][col];
//
//        return solve(grid, row, col, 0, 0, dp);
//    }
//
//    private int solve(int[][] grid, int row, int col, int r, int c, Integer[][]
//            dp) {
//
//        if (r >= row || c >= col) {
//            return Integer.MAX_VALUE;
//        }
//
//        if (r == row - 1 && c == col - 1) {
//            return grid[r][c];
//        }
//
//        if (dp[r][c] != null) {
//            return dp[r][c];
//        }
//
//        int right = solve(grid, row, col, r, c + 1, dp);
//        int left = solve(grid, row, col, r + 1, c, dp);
//
//        return dp[r][c] = grid[r][c] + Math.min(left, right);
//    }

    public int minPathSum(int[][] grid) {

        // DP with bottom up
        int row = grid.length;
        int col = grid[0].length;

        // dp[r][c] = Minimum path sum till r-th row and c-th column
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];

        // Fill all right cell values
        for (int c = 1; c < col; c++) {
            dp[0][c] = dp[0][c - 1] + grid[0][c];
        }

        // Fill all down cell values
        for (int r = 1; r < row; r++) {
            dp[r][0] = dp[r - 1][0] + grid[r][0];
        }

        for (int r = 1; r < row; r++) {
            for (int c = 1; c < col; c++) {
                dp[r][c] = grid[r][c] + Math.min(dp[r - 1][c], dp[r][c - 1]);
            }
        }

        return dp[row - 1][col - 1];
    }
}
