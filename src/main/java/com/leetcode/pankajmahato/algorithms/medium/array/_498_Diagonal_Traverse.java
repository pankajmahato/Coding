/**********************************************************************************
 *
 * https://leetcode.com/problems/diagonal-traverse/
 *
 * Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,4,7,5,3,6,8,9]
 * Example 2:
 *
 * Input: mat = [[1,2],[3,4]]
 * Output: [1,2,3,4]
 *
 *
 * Constraints:
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * -105 <= mat[i][j] <= 105
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _498_Diagonal_Traverse {

    public int[] findDiagonalOrder(int[][] mat) {

        int row = mat.length;
        int col = mat[0].length;

        Map<Integer, List<Integer>> diagonalMap = new HashMap<>();

        // All elements in same diagonal(top to down) is (i+j)
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int key = i + j;
                diagonalMap.computeIfAbsent(key, a -> new ArrayList<>()).add(mat[i][j]);
            }
        }

        int[] result = new int[row * col];

        boolean flip = false;
        int count = 0;
        for (int i = 0; i <= row + col - 2; i++) {
            List<Integer> list = diagonalMap.get(i);
            if (flip == true) {
                for (int k = 0; k < list.size(); k++) {
                    result[count] = list.get(k);
                    count++;
                }
            } else {
                for (int k = list.size() - 1; k >= 0; k--) {
                    result[count] = list.get(k);
                    count++;
                }
            }

            flip = !flip;
        }

        return result;
    }
}
