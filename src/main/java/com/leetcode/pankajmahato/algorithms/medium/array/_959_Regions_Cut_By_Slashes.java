/**********************************************************************************
 *
 * https://leetcode.com/problems/regions-cut-by-slashes/
 *
 * An n x n grid is composed of 1 x 1 squares where each 1 x 1 square consists of a '/', '\', or blank space ' '. These characters divide the square into contiguous regions.
 *
 * Given the grid grid represented as a string array, return the number of regions.
 *
 * Note that backslash characters are escaped, so a '\' is represented as '\\'.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [" /","/ "]
 * Output: 2
 * Example 2:
 *
 *
 * Input: grid = [" /","  "]
 * Output: 1
 * Example 3:
 *
 *
 * Input: grid = ["/\\","\\/"]
 * Output: 5
 * Explanation: Recall that because \ characters are escaped, "\\/" refers to \/, and "/\\" refers to /\.
 *
 *
 * Constraints:
 *
 * n == grid.length == grid[i].length
 * 1 <= n <= 30
 * grid[i][j] is either '/', '\', or ' '.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

public class _959_Regions_Cut_By_Slashes {

    public int regionsBySlashes(String[] grid) {

        int rows = grid[0].length();

        // Convert 1 cell into 9 cells
        rows = rows * 3;
        int cols = rows;

        // '/' -> 
        // [ 0 0 1]
        // [ 0 1 0]
        // [ 1 0 0]

        // '\' -> 
        // [ 1 0 0]
        // [ 0 1 0]
        // [ 0 0 1]
        int[][] box = new int[rows][cols];

        // Transform grid to box
        for (int i = 0; i < grid.length; i++) {

            int column = 0;
            for (int j = 0; j < grid[i].length(); j++) {

                if (grid[i].charAt(j) == '\\') {
                    fillLogicalCell(box, i, j, "backward");
                } else if (grid[i].charAt(j) == '/') {
                    fillLogicalCell(box, i, j, "forward");
                }
                column++;
            }
        }

        int result = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (box[i][j] == 0) {
                    dfs(box, i, j, rows, cols);
                    result++;
                }
            }
        }

        return result;
    }

    private void fillLogicalCell(int[][] grid, int i, int j, String slash) {

        // '/' -> 
        // [ 0 0 1]
        // [ 0 1 0]
        // [ 1 0 0]
        if ("forward".equals(slash)) {
            grid[i * 3][j * 3 + 2] = 1;
            grid[i * 3 + 1][j * 3 + 1] = 1;
            grid[i * 3 + 2][j * 3] = 1;
        }

        // '\' -> 
        // [ 1 0 0]
        // [ 0 1 0]
        // [ 0 0 1]
        if ("backward".equals(slash)) {
            grid[i * 3][j * 3] = 1;
            grid[i * 3 + 1][j * 3 + 1] = 1;
            grid[i * 3 + 2][j * 3 + 2] = 1;
        }
    }

    private void dfs(int[][] grid, int i, int j, int rows, int cols) {

        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == 1) {
            return;
        }

        grid[i][j] = 1;

        dfs(grid, i - 1, j, rows, cols);
        dfs(grid, i, j + 1, rows, cols);
        dfs(grid, i + 1, j, rows, cols);
        dfs(grid, i, j - 1, rows, cols);
    }
}
