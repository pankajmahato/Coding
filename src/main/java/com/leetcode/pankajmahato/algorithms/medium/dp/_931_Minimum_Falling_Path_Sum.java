/**********************************************************************************
 *
 * https://leetcode.com/problems/minimum-falling-path-sum/
 *
 * Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
 *
 * A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * Output: 13
 * Explanation: There are two falling paths with a minimum sum as shown.
 * Example 2:
 *
 *
 * Input: matrix = [[-19,57],[-40,-5]]
 * Output: -59
 * Explanation: The falling path with a minimum sum is shown.
 *
 *
 * Constraints:
 *
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 100
 * -100 <= matrix[i][j] <= 100
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.dp;

public class _931_Minimum_Falling_Path_Sum {

//    public int minFallingPathSum(int[][] matrix) {
//
//        // DP with top down
//        int n = matrix.length;
//
//        // dp[row][col] = Minimum falling path sum till row and col
//        Integer[][] dp = new Integer[n][n];
//
//        int result = Integer.MAX_VALUE;
//
//        for (int col = 0; col < n; col++) {
//
//            result = Math.min(result, solve(matrix, n, 0, col, dp));
//        }
//
//        return result;
//    }
//
//    private int solve(int[][] matrix, int n, int row, int col, Integer[][] dp) {
//
//        if (col < 0 || col >= n) {
//            // Return very large number but less than Integer.MAX_VALUE to prevent
//            overflow
//            return 1_000_000_000;
//        }
//
//        if (dp[row][col] != null) {
//            return dp[row][col];
//        }
//
//        if (row == n - 1) {
//            return matrix[row][col];
//        }
//
//        int left = matrix[row][col] + solve(matrix, n, row + 1, col - 1, dp);
//        int mid = matrix[row][col] + solve(matrix, n, row + 1, col, dp);
//        int right = matrix[row][col] + solve(matrix, n, row + 1, col + 1, dp);
//
//        return dp[row][col] = Math.min(left, Math.min(mid, right));
//    }

    public int minFallingPathSum(int[][] matrix) {

        // DP with bottom up
        int n = matrix.length;

        // dp[row][col] = Minimum falling path sum till row and col
        Integer[][] dp = new Integer[n][n];

        int result = Integer.MAX_VALUE;

        for (int row = 0; row < n; row++) {

            for (int col = 0; col < n; col++) {

                int sum = matrix[row][col];

                int min = Integer.MAX_VALUE;
                for (int shift = -1; shift <= 1; shift++) {

                    int prevRow = row - 1;
                    int prevCol = col + shift;
                    if (prevRow >= 0 && prevCol >= 0 && prevCol < n) {
                        min = Math.min(min, dp[prevRow][prevCol]);
                    }
                }
                if (min == Integer.MAX_VALUE) {
                    min = 0;
                }

                dp[row][col] = sum + min;
            }
        }

        for (int col = 0; col < n; col++) {
            result = Math.min(result, dp[n - 1][col]);
        }

        return result;
    }
}
