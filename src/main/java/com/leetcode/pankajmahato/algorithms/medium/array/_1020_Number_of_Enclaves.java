/**********************************************************************************
 *
 * https://leetcode.com/problems/number-of-enclaves/
 *
 * You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
 *
 * A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.
 *
 * Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * Output: 3
 * Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.
 * Example 2:
 *
 *
 * Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
 * Output: 0
 * Explanation: All 1s are either on the boundary or can reach the boundary.
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 500
 * grid[i][j] is either 0 or 1.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

public class _1020_Number_of_Enclaves {

    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int result = 0;

        int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 1) {
                dfs(grid, rows, cols, i, 0, directions);
            }

            if (grid[i][cols - 1] == 1) {
                dfs(grid, rows, cols, i, cols - 1, directions);
            }
        }

        for (int i = 0; i < cols; i++) {
            if (grid[0][i] == 1) {
                dfs(grid, rows, cols, 0, i, directions);
            }

            if (grid[rows - 1][i] == 1) {
                dfs(grid, rows, cols, rows - 1, i, directions);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 1) {
                    result++;
                }
            }
        }

        return result;
    }

    private void dfs(int[][] grid, int rows, int cols, int i, int j, int[][] directions) {

        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return;
        }

        if (grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;

        for (int[] dir : directions) {

            int x = i + dir[0];
            int y = j + dir[1];

            // Traverse all cells
            dfs(grid, rows, cols, x, y, directions);
        }
    }
}
