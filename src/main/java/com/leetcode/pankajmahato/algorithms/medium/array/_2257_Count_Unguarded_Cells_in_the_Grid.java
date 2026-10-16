/**********************************************************************************
 *
 * https://leetcode.com/problems/count-unguarded-cells-in-the-grid/
 *
 * You are given two integers m and n representing a 0-indexed m x n grid. You are also given two 2D integer arrays guards and walls where guards[i] = [rowi, coli] and walls[j] = [rowj, colj] represent the positions of the ith guard and jth wall respectively.
 *
 * A guard can see every cell in the four cardinal directions (north, east, south, or west) starting from their position unless obstructed by a wall or another guard. A cell is guarded if there is at least one guard that can see it.
 *
 * Return the number of unoccupied cells that are not guarded.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: m = 4, n = 6, guards = [[0,0],[1,1],[2,3]], walls = [[0,1],[2,2],[1,4]]
 * Output: 7
 * Explanation: The guarded and unguarded cells are shown in red and green respectively in the above diagram.
 * There are a total of 7 unguarded cells, so we return 7.
 * Example 2:
 *
 *
 * Input: m = 3, n = 3, guards = [[1,1]], walls = [[0,1],[1,0],[2,1],[1,2]]
 * Output: 4
 * Explanation: The unguarded cells are shown in green in the above diagram.
 * There are a total of 4 unguarded cells, so we return 4.
 *
 *
 * Constraints:
 *
 * 1 <= m, n <= 105
 * 2 <= m * n <= 105
 * 1 <= guards.length, walls.length <= 5 * 104
 * 2 <= guards.length + walls.length <= m * n
 * guards[i].length == walls[j].length == 2
 * 0 <= rowi, rowj < m
 * 0 <= coli, colj < n
 * All the positions in guards and walls are unique.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

public class _2257_Count_Unguarded_Cells_in_the_Grid {

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {

        // Gaurd = 1; Wall = 2; Guarded = 3;
        int[][] grid = new int[m][n];

        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 1;
        }

        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 2;
        }

        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        int nonEmpty = guards.length + walls.length;

        for (int[] guard : guards) {

            for (int[] dir : directions) {
                int i = guard[0] + dir[0];
                int j = guard[1] + dir[1];

                while (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] != 1 && grid[i][j] != 2) {
                    if (grid[i][j] == 0) {
                        nonEmpty++;
                        grid[i][j] = 3;
                    }
                    i = i + dir[0];
                    j = j + dir[1];
                }
            }
        }

        return m * n - nonEmpty;
    }
}
