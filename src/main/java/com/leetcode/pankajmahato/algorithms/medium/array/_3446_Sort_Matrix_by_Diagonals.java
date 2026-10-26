/**********************************************************************************
 *
 * https://leetcode.com/problems/sort-matrix-by-diagonals/
 *
 * You are given an n x n square matrix of integers grid. Return the matrix such that:
 *
 * The diagonals in the bottom-left triangle (including the middle diagonal) are sorted in non-increasing order.
 * The diagonals in the top-right triangle are sorted in non-decreasing order.
 *
 *
 * Example 1:
 *
 * Input: grid = [[1,7,3],[9,8,2],[4,5,6]]
 *
 * Output: [[8,2,3],[9,6,7],[4,5,1]]
 *
 * Explanation:
 *
 *
 *
 * The diagonals with a black arrow (bottom-left triangle) should be sorted in non-increasing order:
 *
 * [1, 8, 6] becomes [8, 6, 1].
 * [9, 5] and [4] remain unchanged.
 * The diagonals with a blue arrow (top-right triangle) should be sorted in non-decreasing order:
 *
 * [7, 2] becomes [2, 7].
 * [3] remains unchanged.
 * Example 2:
 *
 * Input: grid = [[0,1],[1,2]]
 *
 * Output: [[2,1],[1,0]]
 *
 * Explanation:
 *
 *
 *
 * The diagonals with a black arrow must be non-increasing, so [0, 2] is changed to [2, 0]. The other diagonals are already in the correct order.
 *
 * Example 3:
 *
 * Input: grid = [[1]]
 *
 * Output: [[1]]
 *
 * Explanation:
 *
 * Diagonals with exactly one element are already in order, so no changes are needed.
 *
 *
 *
 * Constraints:
 *
 * grid.length == grid[i].length == n
 * 1 <= n <= 10
 * -105 <= grid[i][j] <= 105
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _3446_Sort_Matrix_by_Diagonals {

    public int[][] sortMatrix(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        // Sort bottom left
        for (int row = 0; row < rows; row++) {
            sortDiagonal(row, 0, grid, rows, cols, false);
        }

        // Sort top right
        for (int col = 1; col < cols; col++) {
            sortDiagonal(0, col, grid, rows, cols, true);
        }

        return grid;
    }

    private void sortDiagonal(int row, int col, int[][] grid, int rows, int cols, boolean asc) {

        List<Integer> list = new ArrayList<>();

        int i = row;
        int j = col;

        while (i < rows && j < cols) {
            list.add(grid[i][j]);
            i++;
            j++;
        }

        if (asc) {
            Collections.sort(list);
        } else {
            Collections.sort(list, Collections.reverseOrder());
        }

        i = row;
        j = col;
        for (int num : list) {
            grid[i][j] = num;
            i++;
            j++;
        }
    }
}
