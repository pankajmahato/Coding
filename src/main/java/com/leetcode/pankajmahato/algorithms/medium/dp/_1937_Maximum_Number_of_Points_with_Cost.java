/**********************************************************************************
 *
 * https://leetcode.com/problems/maximum-number-of-points-with-cost/
 *
 * You are given an m x n integer matrix points (0-indexed). Starting with 0 points, you want to maximize the number of points you can get from the matrix.
 *
 * To gain points, you must pick one cell in each row. Picking the cell at coordinates (r, c) will add points[r][c] to your score.
 *
 * However, you will lose points if you pick a cell too far from the cell that you picked in the previous row. For every two adjacent rows r and r + 1 (where 0 <= r < m - 1), picking cells at coordinates (r, c1) and (r + 1, c2) will subtract abs(c1 - c2) from your score.
 *
 * Return the maximum number of points you can achieve.
 *
 * abs(x) is defined as:
 *
 * x for x >= 0.
 * -x for x < 0.
 *
 *
 * Example 1:
 *
 *
 * Input: points = [[1,2,3],[1,5,1],[3,1,1]]
 * Output: 9
 * Explanation:
 * The blue cells denote the optimal cells to pick, which have coordinates (0, 2), (1, 1), and (2, 0).
 * You add 3 + 5 + 3 = 11 to your score.
 * However, you must subtract abs(2 - 1) + abs(1 - 0) = 2 from your score.
 * Your final score is 11 - 2 = 9.
 * Example 2:
 *
 *
 * Input: points = [[1,5],[2,3],[4,2]]
 * Output: 11
 * Explanation:
 * The blue cells denote the optimal cells to pick, which have coordinates (0, 1), (1, 1), and (2, 0).
 * You add 5 + 3 + 4 = 12 to your score.
 * However, you must subtract abs(1 - 1) + abs(1 - 0) = 1 from your score.
 * Your final score is 12 - 1 = 11.
 *
 *
 * Constraints:
 *
 * m == points.length
 * n == points[r].length
 * 1 <= m, n <= 105
 * 1 <= m * n <= 105
 * 0 <= points[r][c] <= 105
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.dp;

public class _1937_Maximum_Number_of_Points_with_Cost {

//    public long maxPoints(int[][] points) {
//
//        // DP with top down
//        int m = points.length;
//        int n = points[0].length;
//
//        // dp[i][j] = Maximum number of points for i-th row and j-th col
//        Long[][] dp = new Long[m][n];
//
//        long result = Integer.MIN_VALUE;
//
//        for (int col = 0; col < n; col++) {
//            dp[0][col] = (long) points[0][col];
//            result = Math.max(result, points[0][col] + solve(points, m, n, 1, col, dp));
//        }
//
//        return result;
//    }
//
//    private long solve(int[][] points, int m, int n, int row, int col, Long[][]
//            dp) {
//
//        if (row == m) {
//            return 0;
//        }
//
//        if (dp[row][col] != null) {
//            return dp[row][col];
//        }
//
//        long maxPoints = Integer.MIN_VALUE;
//        for (int i = 0; i < n; i++) {
//            long sum = points[row][i] - Math.abs(col - i) + solve(points, m, n, row + 1,
//                    i, dp);
//            maxPoints = Math.max(maxPoints, sum);
//        }
//
//        return dp[row][col] = maxPoints;
//    }

    public long maxPoints(int[][] points) {

        // DP with bottom up
        int row = points.length;
        int col = points[0].length;

        // dp[i] = Maximum number of points for i-th col for latest row
        long[] dp = new long[col];

        long result = Integer.MIN_VALUE;

        // Initialize with the 1st row
        for (int c = 0; c < col; c++) {
            dp[c] = points[0][c];
        }

        for (int r = 1; r < row; r++) {

            long[] leftMax = new long[col];
            long[] rightMax = new long[col];
            long[] newDP = new long[col];

            leftMax[0] = dp[0];
            for (int c = 1; c < col; c++) {
                leftMax[c] = Math.max(dp[c], leftMax[c - 1] - 1);
            }

            rightMax[col - 1] = dp[col - 1];
            for (int c = col - 2; c >= 0; c--) {
                rightMax[c] = Math.max(dp[c], rightMax[c + 1] - 1);
            }

            for (int c = 0; c < col; c++) {
                newDP[c] = points[r][c] + Math.max(leftMax[c], rightMax[c]);
            }

            dp = newDP;
        }

        for (int c = 0; c < col; c++) {
            result = Math.max(result, dp[c]);
        }

        return result;
    }
}
