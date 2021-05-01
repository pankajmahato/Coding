/**********************************************************************************
 *
 * https://leetcode.com/problems/search-a-2d-matrix/
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 * Example 2:
 *
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium;

public class _74_Search_a_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix.length;
        int m = matrix[0].length;
        int row = -1;
        int low = 0;
        int high = n - 1;


        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target >= matrix[mid][0] && target <= matrix[mid][m - 1]) {
                row = mid;
                break;
            } else if (target < matrix[mid][0]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (row < 0 || row >= n) {
            return false;
        }

        low = 0;
        high = m - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == matrix[row][mid]) {
                return true;
            } else if (target < matrix[row][mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }
}
