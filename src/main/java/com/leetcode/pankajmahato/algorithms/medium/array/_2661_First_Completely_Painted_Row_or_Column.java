/**********************************************************************************
 *
 * https://leetcode.com/problems/first-completely-painted-row-or-column/
 *
 * You are given a 0-indexed integer array arr, and an m x n integer matrix mat. arr and mat both contain all the integers in the range [1, m * n].
 *
 * Go through each index i in arr starting from index 0 and paint the cell in mat containing the integer arr[i].
 *
 * Return the smallest index i at which either a row or a column will be completely painted in mat.
 *
 *
 *
 * Example 1:
 *
 * image explanation for example 1
 * Input: arr = [1,3,4,2], mat = [[1,4],[2,3]]
 * Output: 2
 * Explanation: The moves are shown in order, and both the first row and second column of the matrix become fully painted at arr[2].
 * Example 2:
 *
 * image explanation for example 2
 * Input: arr = [2,8,7,4,1,3,5,6,9], mat = [[3,2,5],[1,4,6],[8,7,9]]
 * Output: 3
 * Explanation: The second column becomes fully painted at arr[3].
 *
 *
 * Constraints:
 *
 * m == mat.length
 * n = mat[i].length
 * arr.length == m * n
 * 1 <= m, n <= 105
 * 1 <= m * n <= 105
 * 1 <= arr[i], mat[r][c] <= m * n
 * All the integers of arr are unique.
 * All the integers of mat are unique.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

import java.util.HashMap;
import java.util.Map;

public class _2661_First_Completely_Painted_Row_or_Column {

    public int firstCompleteIndex(int[] arr, int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        int n = arr.length;

        // Convert arr to map; value -> index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }

        int result = Integer.MAX_VALUE;
        // Check for all rows
        for (int row = 0; row < rows; row++) {

            // The maximum index will the min value to paint the row
            int maxRow = -1;
            for (int col = 0; col < cols; col++) {
                int idx = map.get(mat[row][col]);
                maxRow = Math.max(maxRow, idx);
            }

            result = Math.min(result, maxRow);
        }

        // Check for all cols
        for (int col = 0; col < cols; col++) {

            // The maximum index will the min value to paint the row
            int maxCols = -1;
            for (int row = 0; row < rows; row++) {
                int idx = map.get(mat[row][col]);
                maxCols = Math.max(maxCols, idx);
            }

            result = Math.min(result, maxCols);
        }

        return result;
    }
}
