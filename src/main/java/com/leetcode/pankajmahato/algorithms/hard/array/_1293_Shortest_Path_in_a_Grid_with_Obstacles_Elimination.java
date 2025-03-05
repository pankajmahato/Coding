/**********************************************************************************
 *
 * https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
 *
 * You are given an m x n integer matrix grid where each cell is either 0 (empty) or 1 (obstacle). You can move up, down, left, or right from and to an empty cell in one step.
 *
 * Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1) given that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[0,0,0],[1,1,0],[0,0,0],[0,1,1],[0,0,0]], k = 1
 * Output: 6
 * Explanation: 
 * The shortest path without eliminating any obstacle is 10.
 * The shortest path with one obstacle elimination at position (3,2) is 6. Such path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
 * Example 2:
 *
 *
 * Input: grid = [[0,1,1],[1,1,1],[1,0,0]], k = 1
 * Output: -1
 * Explanation: We need to eliminate at least two obstacles to find such a walk.
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 40
 * 1 <= k <= m * n
 * grid[i][j] is either 0 or 1.
 * grid[0][0] == grid[m - 1][n - 1] == 0
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.array;

import java.util.LinkedList;
import java.util.Queue;

public class _1293_Shortest_Path_in_a_Grid_with_Obstacles_Elimination {

    public int shortestPath(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        boolean[][][] visited = new boolean[m + 1][n + 1][k + 1];

        queue.add(new int[]{0, 0, k});

        int steps = 0;

        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                int[] item = queue.remove();
                int currI = item[0];
                int currJ = item[1];
                int currObs = item[2];

                if (currI == m - 1 && currJ == n - 1) {
                    return steps;
                }

                for (int[] dir : directions) {

                    int newI = currI + dir[0];
                    int newJ = currJ + dir[1];

                    if (newI < 0 || newI >= m || newJ < 0 || newJ >= n) {
                        continue;
                    }

                    if (grid[newI][newJ] == 0 && !visited[newI][newJ][currObs]) {
                        queue.add(new int[]{newI, newJ, currObs});
                        visited[newI][newJ][currObs] = true;
                    } else if (grid[newI][newJ] == 1 && currObs > 0 && !visited[newI][newJ][currObs - 1]) {
                        queue.add(new int[]{newI, newJ, currObs - 1});
                        visited[newI][newJ][currObs - 1] = true;
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}
