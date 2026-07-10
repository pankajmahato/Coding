/**********************************************************************************
 *
 * https://leetcode.com/problems/shortest-bridge/
 *
 * You are given an n x n binary matrix grid where 1 represents land and 0 represents water.
 *
 * An island is a 4-directionally connected group of 1's not connected to any other 1's. There are exactly two islands in grid.
 *
 * You may change 0's to 1's to connect the two islands to form one island.
 *
 * Return the smallest number of 0's you must flip to connect the two islands.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [[0,1],[1,0]]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
 * Output: 2
 * Example 3:
 *
 * Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * n == grid.length == grid[i].length
 * 2 <= n <= 100
 * grid[i][j] is either 0 or 1.
 * There are exactly two islands in grid.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

import java.util.LinkedList;
import java.util.Queue;

public class _934_Shortest_Bridge {

    public int shortestBridge(int[][] grid) {

        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = new int[][]{
                {0, 1}, 
            {-1, 0}, {1, 0},
                {0, -1}
        };

        // Find the first '1'

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {

                    // Visit all '1's
                    dfs(grid, n, i, j, visited, queue, directions);

                    // Find shortest distance from multiple sources
                    return bfs(grid, n, visited, queue, directions);
                }
            }
        }

        return -1;
    }

    private boolean isSafe(int n, int i, int j) {
        return i >= 0 && i < n && j >= 0 && j < n;
    }

    private void dfs(int[][] grid, int n, int i, int j, boolean[][] visited, Queue<int[]> queue, int[][] directions) {

        if (!isSafe(n, i, j) || grid[i][j] == 0 || visited[i][j] == true) {
            return;
        }

        visited[i][j] = true;
        queue.add(new int[]{i, j});

        for (int[] dir : directions) {

            int x = i + dir[0];
            int y = j + dir[1];
            dfs(grid, n, x, y, visited, queue, directions);
        }
    }

    private int bfs(int[][] grid, int n, boolean[][] visited, Queue<int[]> queue, int[][] directions) {

        int steps = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            while (size-- > 0) {
                int[] val = queue.remove();

                int i = val[0];
                int j = val[1];

                for (int[] dir : directions) {

                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (isSafe(n, x, y) && visited[x][y] == false) {
                        if (grid[x][y] == 1) {
                            return steps;
                        }
                        visited[x][y] = true;
                        queue.add(new int[]{x, y});
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}
