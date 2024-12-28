/**********************************************************************************
 *
 * https://leetcode.com/problems/search-a-2d-matrix/
 *
 * You are given an m x n integer matrix matrix with the following two properties:
 *
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 * Given an integer target, return true if target is in matrix or false otherwise.
 *
 * You must write a solution in O(log(m * n)) time complexity.
 *
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

package com.leetcode.pankajmahato.algorithms.medium.binarysearch;

public class _74_Search_a_2D_Matrix {
//    public boolean searchMatrix(int[][] matrix, int target) {
//
//        int n = matrix.length;
//        int m = matrix[0].length;
//        int row = -1;
//        int low = 0;
//        int high = n - 1;
//
//
//        while (low <= high) {
//            int mid = low + (high - low) / 2;
//            if (target >= matrix[mid][0] && target <= matrix[mid][m - 1]) {
//                row = mid;
//                break;
//            } else if (target < matrix[mid][0]) {
//                high = mid - 1;
//            } else {
//                low = mid + 1;
//            }
//        }
//        if (row < 0 || row >= n) {
//            return false;
//        }
//
//        low = 0;
//        high = m - 1;
//        while (low <= high) {
//            int mid = low + (high - low) / 2;
//            if (target == matrix[row][mid]) {
//                return true;
//            } else if (target < matrix[row][mid]) {
//                high = mid - 1;
//            } else {
//                low = mid + 1;
//            }
//        }
//
//        return false;
//    }

    public boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length;
        int col = matrix[0].length;
        int l = 0;
        int r = row * col - 1;

        while (l <= r) {

            int mid = l + (r - l) / 2;
            int i = mid / col;
            int j = mid % col;
            if (matrix[i][j] < target) {
                l = mid + 1;
            } else if (matrix[i][j] > target) {
                r = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
