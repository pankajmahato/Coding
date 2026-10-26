/**********************************************************************************
 *
 * https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows/
 *
 * You are given an m x n binary matrix matrix.
 *
 * You can choose any number of columns in the matrix and flip every cell in that column (i.e., Change the value of the cell from 0 to 1 or vice versa).
 *
 * Return the maximum number of rows that have all values equal after some number of flips.
 *
 *
 *
 * Example 1:
 *
 * Input: matrix = [[0,1],[1,1]]
 * Output: 1
 * Explanation: After flipping no values, 1 row has all values equal.
 * Example 2:
 *
 * Input: matrix = [[0,1],[1,0]]
 * Output: 2
 * Explanation: After flipping values in the first column, both rows have equal values.
 * Example 3:
 *
 * Input: matrix = [[0,0,0],[0,0,1],[1,1,0]]
 * Output: 2
 * Explanation: After flipping values in the first two columns, the last two rows have equal values.
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] is either 0 or 1.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

import java.util.HashMap;
import java.util.Map;

public class _1072_Flip_Columns_For_Maximum_Number_of_Equal_Rows {

    public int maxEqualRowsAfterFlips(int[][] matrix) {

        // Store all equal rows and it's complement
        // Row and its complement produces same patter if we calculate only bit flips from 0th element
        // row1=[0,1,0,0] pattern=TFTT ( 0==0,0!=1,0==0,0==0 )
        // row2=[1,0,1,1] pattern=TFTT ( 1==1,1!=0,1==1,1==1 )
        // row3=[1,1,0,0] pattern=TTFF ( 1==1,1==1,1!=0,1!=0 )
        Map<String, Integer> map = new HashMap<>();

        for (int[] row : matrix) {

            StringBuilder pattern = new StringBuilder();
            for (int col : row) {

                if (row[0] == col) {
                    pattern.append("T");
                } else {
                    pattern.append("F");
                }
            }

            String key = pattern.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int result = 0;

        for (int freq : map.values()) {
            result = Math.max(result, freq);
        }

        return result;
    }
}
