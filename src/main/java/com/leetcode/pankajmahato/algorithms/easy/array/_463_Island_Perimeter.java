/**********************************************************************************
 *
 * https://leetcode.com/problems/island-perimeter/
 *
 * You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
 *
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 *
 * The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * Output: 16
 * Explanation: The perimeter is the 16 yellow stripes in the image above.
 * Example 2:
 *
 * Input: grid = [[1]]
 * Output: 4
 * Example 3:
 *
 * Input: grid = [[1,0]]
 * Output: 4
 *
 *
 * Constraints:
 *
 * row == grid.length
 * col == grid[i].length
 * 1 <= row, col <= 100
 * grid[i][j] is 0 or 1.
 * There is exactly one island in grid.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.easy.array;

import java.util.LinkedList;
import java.util.Queue;

public class _463_Island_Perimeter {

    public int islandPerimeter(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 1) {
                    return bfs(grid, i, j);
                }
            }
        }

        return -1;
    }

    private int bfs(int[][] grid, int i, int j) {

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] directions = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

        int result = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        grid[i][j] = -1;

        while (!queue.isEmpty()) {

            int[] val = queue.remove();

            for (int[] dir : directions) {
                int x = val[0] + dir[0];
                int y = val[1] + dir[1];

                if (x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] == 0) {
                    result++;
                    continue;
                }

                if (grid[x][y] == -1) {
                    continue;
                }
                grid[x][y] = -1;
                queue.add(new int[]{x, y});
            }
        }

        return result;
    }
}
