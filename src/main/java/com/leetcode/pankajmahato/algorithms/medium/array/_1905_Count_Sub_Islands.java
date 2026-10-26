/**********************************************************************************
 *
 * https://leetcode.com/problems/count-sub-islands/
 *
 * You are given two m x n binary matrices grid1 and grid2 containing only 0's (representing water) and 1's (representing land). An island is a group of 1's connected 4-directionally (horizontal or vertical). Any cells outside of the grid are considered water cells.
 *
 * An island in grid2 is considered a sub-island if there is an island in grid1 that contains all the cells that make up this island in grid2.
 *
 * Return the number of islands in grid2 that are considered sub-islands.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid1 = [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]], grid2 = [[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]
 * Output: 3
 * Explanation: In the picture above, the grid on the left is grid1 and the grid on the right is grid2.
 * The 1s colored red in grid2 are those considered to be part of a sub-island. There are three sub-islands.
 * Example 2:
 *
 *
 * Input: grid1 = [[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]], grid2 = [[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]
 * Output: 2 
 * Explanation: In the picture above, the grid on the left is grid1 and the grid on the right is grid2.
 * The 1s colored red in grid2 are those considered to be part of a sub-island. There are two sub-islands.
 *
 *
 * Constraints:
 *
 * m == grid1.length == grid2.length
 * n == grid1[i].length == grid2[i].length
 * 1 <= m, n <= 500
 * grid1[i][j] and grid2[i][j] are either 0 or 1.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

public class _1905_Count_Sub_Islands {

    public int countSubIslands(int[][] grid1, int[][] grid2) {

        int rows = grid1.length;
        int cols = grid1[0].length;

        int result = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid2[i][j] == 1 && checkSubsetIsland(grid1, grid2, i, j, rows, cols)) {
                    result++;
                }
            }
        }

        return result;
    }

    private boolean checkSubsetIsland(int[][] grid1, int[][] grid2, int i, int j, int rows, int cols) {

        if (i < 0 || i >= rows || j < 0 || j >= cols || grid2[i][j] == 0) {
            return true;
        }

        if (grid1[i][j] == 0) {
            return false;
        }

        grid2[i][j] = 0;

        boolean top = checkSubsetIsland(grid1, grid2, i - 1, j, rows, cols);
        boolean right = checkSubsetIsland(grid1, grid2, i, j + 1, rows, cols);
        boolean down = checkSubsetIsland(grid1, grid2, i + 1, j, rows, cols);
        boolean left = checkSubsetIsland(grid1, grid2, i, j - 1, rows, cols);

        return top && right && down && left;
    }
}
