/**********************************************************************************
 *
 * https://leetcode.com/problems/number-of-closed-islands/
 *
 * Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.
 *
 * Return the number of closed islands.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
 * Output: 2
 * Explanation: 
 * Islands in gray are closed because they are completely surrounded by water (group of 1s).
 * Example 2:
 *
 *
 *
 * Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
 * Output: 1
 * Example 3:
 *
 * Input: grid = [[1,1,1,1,1,1,1],
 *                [1,0,0,0,0,0,1],
 *                [1,0,1,1,1,0,1],
 *                [1,0,1,0,1,0,1],
 *                [1,0,1,1,1,0,1],
 *                [1,0,0,0,0,0,1],
 *                [1,1,1,1,1,1,1]]
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= grid.length, grid[0].length <= 100
 * 0 <= grid[i][j] <=1
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

public class _1254_Number_of_Closed_Islands {

    public int closedIsland(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int result = 0;

        int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 0 && isClosedIsland(grid, rows, cols, i, j, directions)) {
                    result++;
                }
            }
        }

        return result;
    }

    private boolean isClosedIsland(int[][] grid, int rows, int cols, int i, int j, int[][] directions) {

        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return false;
        }

        if (grid[i][j] == 1) {
            return true;
        }

        grid[i][j] = 1;

        boolean result = true;
        for (int[] dir : directions) {

            int x = i + dir[0];
            int y = j + dir[1];

            // Traverse all cells so call recursion first
            result = isClosedIsland(grid, rows, cols, x, y, directions) && result;
        }

        return result;
    }
}
