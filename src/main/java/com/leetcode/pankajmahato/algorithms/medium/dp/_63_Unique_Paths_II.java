/**********************************************************************************
 *
 * https://leetcode.com/problems/unique-paths-ii/
 *
 * You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
 *
 * An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
 *
 * Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 *
 * The testcases are generated so that the answer will be less than or equal to 2 * 109.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: 2
 * Explanation: There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 * Example 2:
 *
 *
 * Input: obstacleGrid = [[0,1],[0,0]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] is 0 or 1.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.dp;

public class _63_Unique_Paths_II {

    // public int uniquePathsWithObstacles(int[][] obstacleGrid) {

    //     // DP Top Down

    //     int m = obstacleGrid.length;
    //     int n = obstacleGrid[0].length;

    //     // dp[i][j] = Total number of unique paths to reach cell (i,j)
    //     int[][] dp = new int[m][n];
    //     for (int[] arr : dp) {
    //         Arrays.fill(arr, -1);
    //     }

    //     return solve(0, 0, m, n, obstacleGrid, dp);
    // }

    // private int solve(int i, int j, int m, int n, int[][] grid, int[][] dp) {

    //     if (i >= m || j >= n || grid[i][j] == 1) {
    //         return 0;
    //     }

    //     if (i == m - 1 && j == n - 1) {
    //         return 1;
    //     }

    //     if (dp[i][j] != -1) {
    //         return dp[i][j];
    //     }

    //     int right = solve(i, j + 1, m, n, grid, dp);
    //     int down = solve(i + 1, j, m, n, grid, dp);

    //     return dp[i][j] = right + down;
    // }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        // DP Bottom Up

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // dp[i][j] = Total number of unique paths to reach cell (i,j)
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
