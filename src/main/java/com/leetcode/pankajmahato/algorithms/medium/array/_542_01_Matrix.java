/**********************************************************************************
 *
 * https://leetcode.com/problems/01-matrix/
 *
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 *
 * The distance between two cells sharing a common edge is 1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: [[0,0,0],[0,1,0],[0,0,0]]
 * Example 2:
 *
 *
 * Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
 * Output: [[0,0,0],[0,1,0],[1,2,1]]
 *
 *
 * Constraints:
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * mat[i][j] is either 0 or 1.
 * There is at least one 0 in mat.
 *
 *
 * Note: This question is the same as 1765: https://leetcode.com/problems/map-of-highest-peak/
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _542_01_Matrix {

    public int[][] updateMatrix(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        int[][] result = new int[rows][cols];
        for (int[] row : result) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    result[i][j] = 0;
                    queue.add(new int[]{i, j});
                }
            }
        }

        int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while (!queue.isEmpty()) {

            int[] val = queue.remove();
            int currentDistance = result[val[0]][val[1]];

            for (int[] dir : directions) {
                int i = val[0] + dir[0];
                int j = val[1] + dir[1];

                if (i >= 0 && i < rows && j >= 0 && j < cols && result[i][j] == -1) {
                    result[i][j] = currentDistance + 1;
                    queue.add(new int[]{i, j});
                }
            }
        }

        return result;
    }
}
