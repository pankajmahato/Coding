/**********************************************************************************
 *
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/
 *
 * Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.
 *
 * A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
 *
 * All the visited cells of the path are 0.
 * All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
 * The length of a clear path is the number of visited cells of this path.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[0,1],[1,0]]
 * Output: 2
 * Example 2:
 *
 *
 * Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
 * Output: 4
 * Example 3:
 *
 * Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
 * Output: -1
 *
 *
 * Constraints:
 *
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 100
 * grid[i][j] is 0 or 1
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class _1091_Shortest_Path_in_Binary_Matrix {

    int[][] directions = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    private boolean canMove(int i, int j, int m, int n) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        // BFS
        int m = grid.length;
        int n = grid[0].length;

        if (m == 0 || n == 0 || grid[0][0] != 0) {
            return -1;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        grid[0][0] = 1;

        int level = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            while (size-- > 0) {

                int[] val = queue.remove();
                if (val[0] == m - 1 && val[1] == n - 1) {
                    return level + 1;
                }
                for (int[] dir : directions) {
                    int i = val[0] + dir[0];
                    int j = val[1] + dir[1];

                    if (canMove(i, j, m, n) && grid[i][j] == 0) {
                        grid[i][j] = 1;
                        queue.add(new int[]{i, j});
                    }
                }
            }
            level++;
        }
        return -1;

    }

//    public int shortestPathBinaryMatrix(int[][] grid) {
//
//        // Dijkstra
//        int m = grid.length;
//        int n = grid[0].length;
//
//        if (m == 0 || n == 0 || grid[0][0] != 0) {
//            return -1;
//        }
//
//        int[][] result = new int[m][n];
//        for (int[] row : result) {
//            Arrays.fill(row, Integer.MAX_VALUE);
//        }
//
//        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
//        queue.add(new int[]{0, 0, 0});
//        grid[0][0] = 1;
//        result[0][0] = 0;
//
//        while (!queue.isEmpty()) {
//
//            int[] val = queue.remove();
//
//            for (int[] dir : directions) {
//                int i = val[1] + dir[0];
//                int j = val[2] + dir[1];
//                int dist = 1;
//                if (canMove(i, j, m, n) && grid[i][j] == 0 && val[0] + dist < result[i][j]) {
//                    grid[i][j] = 1;
//                    result[i][j] = val[0] + dist;
//                    queue.add(new int[]{result[i][j], i, j});
//                }
//            }
//        }
//        return result[m - 1][n - 1] == Integer.MAX_VALUE ? -1 : result[m - 1][n - 1] + 1;
//
//    }

}
