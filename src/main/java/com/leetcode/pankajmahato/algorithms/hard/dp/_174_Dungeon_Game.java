/**********************************************************************************
 *
 * https://leetcode.com/problems/dungeon-game/
 *
 * The demons had captured the princess and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of m x n rooms laid out in a 2D grid. Our valiant knight was initially positioned in the top-left room and must fight his way through dungeon to rescue the princess.
 *
 * The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
 *
 * Some of the rooms are guarded by demons (represented by negative integers), so the knight loses health upon entering these rooms; other rooms are either empty (represented as 0) or contain magic orbs that increase the knight's health (represented by positive integers).
 *
 * To reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
 *
 * Return the knight's minimum initial health so that he can rescue the princess.
 *
 * Note that any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: dungeon = [[-2,-3,3],[-5,-10,1],[10,30,-5]]
 * Output: 7
 * Explanation: The initial health of the knight must be at least 7 if he follows the optimal path: RIGHT-> RIGHT -> DOWN -> DOWN.
 * Example 2:
 *
 * Input: dungeon = [[0]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * m == dungeon.length
 * n == dungeon[i].length
 * 1 <= m, n <= 200
 * -1000 <= dungeon[i][j] <= 1000
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.dp;

public class _174_Dungeon_Game {

    // public int calculateMinimumHP(int[][] dungeon) {

    //     // DP Top Down

    //     int m = dungeon.length;
    //     int n = dungeon[0].length;

    //     // dp[i][j] = Minimum health to reach from cell (i,j)
    //     int[][] dp = new int[m][n];
    //     for (int[] arr : dp) {
    //         Arrays.fill(arr, Integer.MAX_VALUE);
    //     }

    //     return solve(0, 0, m, n, dungeon, dp);
    // }

    // private int solve(int i, int j, int m, int n, int[][] grid, int[][] dp) {

    //     if (i >= m || j >= n) {
    //         return Integer.MAX_VALUE;
    //     }

    //     if (i == m - 1 && j == n - 1) {

    //         if (grid[i][j] <= 0) {
    //             return Math.abs(grid[i][j]) + 1;
    //         } else {
    //             return 1;
    //         }
    //     }

    //     if (dp[i][j] != Integer.MAX_VALUE) {
    //         return dp[i][j];
    //     }

    //     int right = solve(i, j + 1, m, n, grid, dp);
    //     int down = solve(i + 1, j, m, n, grid, dp);

    //     int minHealth = Math.min(right, down) - grid[i][j];

    //     if (minHealth <= 0) {
    //         return dp[i][j] = 1;
    //     } else {
    //         return dp[i][j] = minHealth;
    //     }
    // }

    public int calculateMinimumHP(int[][] dungeon) {

        // DP Bottom Up

        int m = dungeon.length;
        int n = dungeon[0].length;

        // dp[i][j] = Minimum health to reach from cell (i,j)
        int[][] dp = new int[m][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                if (i == m - 1 && j == n - 1) {

                    if (dungeon[i][j] <= 0) {
                        dp[i][j] = Math.abs(dungeon[i][j]) + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                } else {

                    int right = j + 1 >= n ? Integer.MAX_VALUE : dp[i][j + 1];
                    int down = i + 1 >= m ? Integer.MAX_VALUE : dp[i + 1][j];

                    int minHealth = Math.min(right, down) - dungeon[i][j];

                    if (minHealth <= 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = minHealth;
                    }
                }
            }
        }

        return dp[0][0];
    }
}
