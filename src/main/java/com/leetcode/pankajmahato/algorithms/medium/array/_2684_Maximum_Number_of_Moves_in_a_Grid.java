/**********************************************************************************
 *
 * https://leetcode.com/problems/maximum-number-of-moves-in-a-grid/
 *
 * You are given a 0-indexed m x n matrix grid consisting of positive integers.
 *
 * You can start at any cell in the first column of the matrix, and traverse the grid in the following way:
 *
 * From a cell (row, col), you can move to any of the cells: (row - 1, col + 1), (row, col + 1) and (row + 1, col + 1) such that the value of the cell you move to, should be strictly bigger than the value of the current cell.
 * Return the maximum number of moves that you can perform.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]]
 * Output: 3
 * Explanation: We can start at the cell (0, 0) and make the following moves:
 * - (0, 0) -> (0, 1).
 * - (0, 1) -> (1, 2).
 * - (1, 2) -> (2, 3).
 * It can be shown that it is the maximum number of moves that can be made.
 * Example 2:
 *
 *
 * Input: grid = [[3,2,4],[2,1,9],[1,1,7]]
 * Output: 0
 * Explanation: Starting from any cell in the first column we cannot perform any moves.
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 2 <= m, n <= 1000
 * 4 <= m * n <= 105
 * 1 <= grid[i][j] <= 106
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

import java.util.Arrays;

public class _2684_Maximum_Number_of_Moves_in_a_Grid {

    public int maxMoves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int result = 0;
        int[][] directions = new int[][]{{-1, +1}, {0, 1}, {1, 1}};

        int[][] dp = new int[rows][cols];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }

        for (int r = 0; r < rows; r++) {
            result = Math.max(result, dfs(grid, r, 0, rows, cols, -1, directions, dp));
        }

        return result;
    }

    private int dfs(int[][] grid, int i, int j, int rows, int cols, int prev, int[][] directions, int[][] dp) {

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int movesSoFar = 0;
        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] > grid[i][j]) {

                movesSoFar = Math.max(movesSoFar, 1 + dfs(grid, x, y, rows, cols, grid[i][j], directions, dp));
            }
        }

        return dp[i][j] = movesSoFar;
    }
}
