/**********************************************************************************
 *
 * https://leetcode.com/problems/set-matrix-zeroes/
 *
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 *
 * You must do it in place.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 * Example 2:
 *
 *
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -231 <= matrix[i][j] <= 231 - 1
 *
 *
 * Follow up:
 *
 * A straightforward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

public class _73_Set_Matrix_Zeroes {
    public void setZeroes(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean firstRowImpacted = false;
        boolean firstColImpacted = false;

        // Check for first Row
        for (int col = 0; col < cols; col++) {
            if (matrix[0][col] == 0) {
                firstRowImpacted = true;
                break;
            }
        }

        // Check for first Col
        for (int row = 0; row < rows; row++) {
            if (matrix[row][0] == 0) {
                firstColImpacted = true;
                break;
            }
        }

        // Set 1st cell of Row and Col to Zero to mark it
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        // Set first row
        if (firstRowImpacted) {
            for (int col = 0; col < cols; col++) {
                matrix[0][col] = 0;

            }
        }

        // Set first col
        if (firstColImpacted) {
            for (int row = 0; row < rows; row++) {
                matrix[row][0] = 0;
            }
        }
    }
}
