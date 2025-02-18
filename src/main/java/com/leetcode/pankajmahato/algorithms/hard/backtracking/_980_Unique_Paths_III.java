/**********************************************************************************
 *
 * https://leetcode.com/problems/unique-paths-iii/
 *
 * You are given an m x n integer array grid where grid[i][j] could be:
 *
 * 1 representing the starting square. There is exactly one starting square.
 * 2 representing the ending square. There is exactly one ending square.
 * 0 representing empty squares we can walk over.
 * -1 representing obstacles that we cannot walk over.
 * Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
 * Output: 2
 * Explanation: We have the following two paths: 
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 * Example 2:
 *
 *
 * Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
 * Output: 4
 * Explanation: We have the following four paths: 
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
 * 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
 * 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
 * 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
 * Example 3:
 *
 *
 * Input: grid = [[0,1],[2,0]]
 * Output: 0
 * Explanation: There is no path that walks over every empty square exactly once.
 * Note that the starting and ending square can be anywhere in the grid.
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 20
 * 1 <= m * n <= 20
 * -1 <= grid[i][j] <= 2
 * There is exactly one starting cell and one ending cell.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.backtracking;

public class _980_Unique_Paths_III {

    int directions[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    int result = 0;
    int allowed = 1;
    int m;
    int n;

    public int uniquePathsIII(int[][] grid) {

        m = grid.length;
        n = grid[0].length;
        int x = 0;
        int y = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    allowed++;
                } else if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                }
            }
        }

        uniquePathsIIIUtil(grid, 0, x, y);

        return result;
    }

    private void uniquePathsIIIUtil(int[][] grid, int count, int i, int j) {

        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == -1) {
            return;
        }
        if (grid[i][j] == 2) {
            if (count == allowed) {
                result++;
            }
            return;
        }

        grid[i][j] = -1;
        for (int k = 0; k < directions.length; k++) {
            uniquePathsIIIUtil(grid, count + 1, i + directions[k][0], j + directions[k][1]);
        }
        grid[i][j] = 0;
    }
}
