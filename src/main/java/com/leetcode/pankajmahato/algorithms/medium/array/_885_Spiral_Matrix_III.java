/**********************************************************************************
 *
 * https://leetcode.com/problems/spiral-matrix-iii/
 *
 * You start at the cell (rStart, cStart) of an rows x cols grid facing east. The northwest corner is at the first row and column in the grid, and the southeast corner is at the last row and column.
 *
 * You will walk in a clockwise spiral shape to visit every position in this grid. Whenever you move outside the grid's boundary, we continue our walk outside the grid (but may return to the grid boundary later.). Eventually, we reach all rows * cols spaces of the grid.
 *
 * Return an array of coordinates representing the positions of the grid in the order you visited them.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: rows = 1, cols = 4, rStart = 0, cStart = 0
 * Output: [[0,0],[0,1],[0,2],[0,3]]
 * Example 2:
 *
 *
 * Input: rows = 5, cols = 6, rStart = 1, cStart = 4
 * Output: [[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]
 *
 *
 * Constraints:
 *
 * 1 <= rows, cols <= 100
 * 0 <= rStart < rows
 * 0 <= cStart < cols
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

import java.util.ArrayList;
import java.util.List;

public class _885_Spiral_Matrix_III {

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {

        List<int[]> result = new ArrayList<>();
        result.add(new int[]{rStart, cStart});

        int steps = 0;
        while (result.size() < rows * cols) {

            // Move East
            steps++;
            int count = 0;
            while (count < steps) {
                cStart++;
                addToResult(result, rStart, cStart, rows, cols);
                count++;
            }

            // Move South
            count = 0;
            while (count < steps) {
                rStart++;
                addToResult(result, rStart, cStart, rows, cols);
                count++;
            }

            // Move West
            steps++;
            count = 0;
            while (count < steps) {
                cStart--;
                addToResult(result, rStart, cStart, rows, cols);
                count++;
            }

            // Move North
            count = 0;
            while (count < steps) {
                rStart--;
                addToResult(result, rStart, cStart, rows, cols);
                count++;
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    private void addToResult(List<int[]> result, int i, int j, int rows, int cols) {

        if (i >= 0 && i < rows && j >= 0 && j < cols) {
            result.add(new int[]{i, j});
        }
    }

    // public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
    //     int[][] directions = {
    //             { 0, 1 }, // EAST - 0
    //             { 1, 0 }, // SOUTH - 1
    //             { 0, -1 }, // WEST - 2
    //             { -1, 0 } // NORTH - 3
    //     };

    //     int[][] result = new int[rows * cols][2];
    //     int step = 0; // how many steps to move
    //     int dir = 0; // which direction

    //     result[0] = new int[] { rStart, cStart };
    //     int count = 1;

    //     while (count < rows * cols) {
    //         // When we move EAST or WEST, we need to increase our steps by 1
    //         if (dir == 0 || dir == 2)
    //             step++;

    //         for (int i = 0; i < step; i++) {
    //             rStart += directions[dir][0];
    //             cStart += directions[dir][1];

    //             if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) { // check valid
    //                 result[count++] = new int[] { rStart, cStart };
    //             }
    //         }

    //         dir = (dir + 1) % 4; // turn to next direction
    //     }

    //     return result;
    // }
}
