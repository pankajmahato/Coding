/**********************************************************************************
 *
 * https://leetcode.com/problems/magic-squares-in-grid/
 *
 * A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.
 *
 * Given a row x col grid of integers, how many 3 x 3 magic square subgrids are there?
 *
 * Note: while a magic square can only contain numbers from 1 to 9, grid may contain numbers up to 15.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[4,3,8,4],[9,5,1,9],[2,7,6,2]]
 * Output: 1
 * Explanation: 
 * The following subgrid is a 3 x 3 magic square:
 *
 * while this one is not:
 *
 * In total, there is only one magic square inside the given grid.
 * Example 2:
 *
 * Input: grid = [[8]]
 * Output: 0
 *
 *
 * Constraints:
 *
 * row == grid.length
 * col == grid[i].length
 * 1 <= row, col <= 10
 * 0 <= grid[i][j] <= 15
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

import java.util.HashSet;
import java.util.Set;

public class _840_Magic_Squares_In_Grid {

    public int numMagicSquaresInside(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int result = 0;
        for (int i = 0; i <= rows - 3; i++) {
            for (int j = 0; j <= cols - 3; j++) {
                if (isMagicGrid(grid, i, j)) {
                    result++;
                }
            }
        }

        return result;
    }

    private boolean isMagicGrid(int[][] grid, int r, int c) {

        // Check for unique numbers
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = grid[r + i][c + j];
                if (num < 1 || num > 9 || set.contains(num)) {
                    return false;
                } else {
                    set.add(num);
                }
            }
        }

        // Check for Row and Col sum
        int sum = grid[r][c] + grid[r + 1][c] + grid[r + 2][c];

        for (int i = 0; i < 3; i++) {

            // Row check
            if (sum != grid[r][c + i] + grid[r + 1][c + i] + grid[r + 2][c + i]) {
                return false;
            }

            // Column check
            if (sum != grid[r + i][c] + grid[r + i][c + 1] + grid[r + i][c + 2]) {
                return false;
            }
        }

        // Diagonal check
        if (sum != grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2]) {
            return false;
        }

        // Anti-diagonal check
        if (sum != grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c]) {
            return false;
        }

        return true;
    }
}
