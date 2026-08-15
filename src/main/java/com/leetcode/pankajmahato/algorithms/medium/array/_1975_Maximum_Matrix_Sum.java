/**********************************************************************************
 *
 * https://leetcode.com/problems/maximum-matrix-sum/
 *
 * You are given an n x n integer matrix. You can do the following operation any number of times:
 *
 * Choose any two adjacent elements of matrix and multiply each of them by -1.
 * Two elements are considered adjacent if and only if they share a border.
 *
 * Your goal is to maximize the summation of the matrix's elements. Return the maximum sum of the matrix's elements using the operation mentioned above.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,-1],[-1,1]]
 * Output: 4
 * Explanation: We can follow the following steps to reach sum equals 4:
 * - Multiply the 2 elements in the first row by -1.
 * - Multiply the 2 elements in the first column by -1.
 * Example 2:
 *
 *
 * Input: matrix = [[1,2,3],[-1,-2,-3],[1,2,3]]
 * Output: 16
 * Explanation: We can follow the following step to reach sum equals 16:
 * - Multiply the 2 last elements in the second row by -1.
 *
 *
 * Constraints:
 *
 * n == matrix.length == matrix[i].length
 * 2 <= n <= 250
 * -105 <= matrix[i][j] <= 105
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

public class _1975_Maximum_Matrix_Sum {

    public long maxMatrixSum(int[][] matrix) {

        // Observation:
        // Negative sign can be propagated to any cell
        // If there are even number of negatives then all can be converted to positive
        // If there are odd number of negatives then only 1 will be left negative

        int negative = 0;
        int min = Integer.MAX_VALUE;
        long sum = 0;

        for (int[] row : matrix) {
            for (int col : row) {
                min = Math.min(min, Math.abs(col));
                sum = sum + Math.abs(col);
                if (col < 0) {
                    negative++;
                }
            }
        }

        if (negative % 2 == 1) {
            // min was added already in sum
            return sum - 2 * min;
        } else {
            return sum;
        }
    }
}
