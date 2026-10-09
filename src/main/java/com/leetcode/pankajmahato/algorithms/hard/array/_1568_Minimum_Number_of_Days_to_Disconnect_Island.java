/**********************************************************************************
 *
 * https://leetcode.com/problems/minimum-number-of-days-to-disconnect-island/
 *
 * You are given an m x n binary grid grid where 1 represents land and 0 represents water. An island is a maximal 4-directionally (horizontal or vertical) connected group of 1's.
 *
 * The grid is said to be connected if we have exactly one island, otherwise is said disconnected.
 *
 * In one day, we are allowed to change any single land cell (1) into a water cell (0).
 *
 * Return the minimum number of days to disconnect the grid.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[0,1,1,0],[0,1,1,0],[0,0,0,0]]
 *
 * Output: 2
 * Explanation: We need at least 2 days to get a disconnected grid.
 * Change land grid[1][1] and grid[0][2] to water and get 2 disconnected island.
 * Example 2:
 *
 *
 * Input: grid = [[1,1]]
 * Output: 2
 * Explanation: Grid of full water is also disconnected ([[1,1]] -> [[0,0]]), 0 islands.
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 30
 * grid[i][j] is either 0 or 1.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.array;

public class _1568_Minimum_Number_of_Days_to_Disconnect_Island {

    public int minDays(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int count = getNumberOfIslands(grid, rows, cols);
        if (count == 0 || count > 1) {
            return 0;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    count = getNumberOfIslands(grid, rows, cols);
                    if (count == 0 || count > 1) {
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }

        // When number of island is '1' then it can be disconnected by maximum 2 moves (days) by isolating any corner '1'
        return 2;
    }

    private int getNumberOfIslands(int[][] grid, int rows, int cols) {

        int count = 0;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (visited[i][j] == false && grid[i][j] == 1) {
                    dfs(grid, rows, cols, i, j, visited);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int[][] grid, int rows, int cols, int i, int j, boolean[][] visited) {

        if (i < 0 || i >= rows || j < 0 || j >= cols || visited[i][j] == true || grid[i][j] == 0) {
            return;
        }

        visited[i][j] = true;

        dfs(grid, rows, cols, i - 1, j, visited);
        dfs(grid, rows, cols, i, j + 1, visited);
        dfs(grid, rows, cols, i + 1, j, visited);
        dfs(grid, rows, cols, i, j - 1, visited);
    }
}
