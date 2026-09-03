/**********************************************************************************
 *
 * https://leetcode.com/problems/largest-submatrix-with-rearrangements/
 *
 * You are given a binary matrix matrix of size m x n, and you are allowed to rearrange the columns of the matrix in any order.
 *
 * Return the area of the largest submatrix within matrix where every element of the submatrix is 1 after reordering the columns optimally.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[0,0,1],[1,1,1],[1,0,1]]
 * Output: 4
 * Explanation: You can rearrange the columns as shown above.
 * The largest submatrix of 1s, in bold, has an area of 4.
 * Example 2:
 *
 *
 * Input: matrix = [[1,0,1,0,1]]
 * Output: 3
 * Explanation: You can rearrange the columns as shown above.
 * The largest submatrix of 1s, in bold, has an area of 3.
 * Example 3:
 *
 * Input: matrix = [[1,1,0],[1,0,1]]
 * Output: 2
 * Explanation: Notice that you must rearrange entire columns, and there is no way to make a submatrix of 1s larger than an area of 2.
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m * n <= 105
 * matrix[i][j] is either 0 or 1.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

import java.util.Arrays;
import java.util.Comparator;

public class _1727_Largest_Submatrix_With_Rearrangements {

    public int largestSubmatrix(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        int[] previousRow = new int[col];
        int maxArea = 0;

        for (int i = 0; i < row; i++) {

            int[] currentRow = matrix[i];
            for (int j = 0; j < col; j++) {
                if (currentRow[j] == 1) {
                    currentRow[j] = currentRow[j] + previousRow[j];
                }
            }

            int[] heights = Arrays.stream(currentRow).boxed()
                    .sorted(Comparator.reverseOrder())
                    .mapToInt(x -> x)
                    .toArray();

            for (int k = 0; k < col; k++) {
                int base = k + 1;
                int height = heights[k];
                maxArea = Math.max(maxArea, base * height);
            }

            previousRow = currentRow;
        }

        return maxArea;
    }
}
