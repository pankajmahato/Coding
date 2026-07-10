/**********************************************************************************
 *
 * https://leetcode.com/problems/spiral-matrix-ii/
 *
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 * Example 2:
 *
 * Input: n = 1
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 20
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

public class _59_Spiral_Matrix_II {

    public int[][] generateMatrix(int n) {

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        int count = 1;
        int[][] result = new int[n][n];

        while (top <= bottom && left <= right) {

            // Fill top row
            for (int i = left; i <= right; i++) {
                result[top][i] = count++;
            }
            top++;

            // Fill right col
            for (int i = top; i <= bottom; i++) {
                result[i][right] = count++;
            }
            right--;

            if (top <= bottom) {
                // Fill bottom row
                for (int i = right; i >= left; i--) {
                    result[bottom][i] = count++;
                }
                bottom--;
            }

            if (left <= right) {
                // Fill left col
                for (int i = bottom; i >= top; i--) {
                    result[i][left] = count++;
                }
                left++;
            }
        }

        return result;
    }
}
