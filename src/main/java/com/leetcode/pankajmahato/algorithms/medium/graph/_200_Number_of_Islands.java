/**********************************************************************************
 *
 * https://leetcode.com/problems/number-of-islands/
 *
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.graph;

public class _200_Number_of_Islands {
    private int[][] DIRS = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (dfs(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean dfs(char[][] grid, int x, int y) {
        if (outBound(grid, x, y) || grid[x][y] != '1') {
            return false;
        }
        grid[x][y] = '2';
        for (int[] dir : DIRS) {
            dfs(grid, x + dir[0], y + dir[1]);
        }
        return true;

    }

    private boolean outBound(char[][] grid, int x, int y) {
        return x < 0 || x >= grid.length || y < 0 || y >= grid[0].length;
    }
}
