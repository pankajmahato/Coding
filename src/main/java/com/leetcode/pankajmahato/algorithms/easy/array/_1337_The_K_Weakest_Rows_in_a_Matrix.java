/**********************************************************************************
 *
 * https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
 *
 * You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians). The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all the 0's in each row.
 *
 * A row i is weaker than a row j if one of the following is true:
 *
 * The number of soldiers in row i is less than the number of soldiers in row j.
 * Both rows have the same number of soldiers and i < j.
 * Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.
 *
 *
 *
 * Example 1:
 *
 * Input: mat = 
 * [[1,1,0,0,0],
 *  [1,1,1,1,0],
 *  [1,0,0,0,0],
 *  [1,1,0,0,0],
 *  [1,1,1,1,1]], 
 * k = 3
 * Output: [2,0,3]
 * Explanation: 
 * The number of soldiers in each row is: 
 * - Row 0: 2 
 * - Row 1: 4 
 * - Row 2: 1 
 * - Row 3: 2 
 * - Row 4: 5 
 * The rows ordered from weakest to strongest are [2,0,3,1,4].
 * Example 2:
 *
 * Input: mat = 
 * [[1,0,0,0],
 *  [1,1,1,1],
 *  [1,0,0,0],
 *  [1,0,0,0]], 
 * k = 2
 * Output: [0,2]
 * Explanation: 
 * The number of soldiers in each row is: 
 * - Row 0: 1 
 * - Row 1: 4 
 * - Row 2: 1 
 * - Row 3: 1 
 * The rows ordered from weakest to strongest are [0,2,3,1].
 *
 *
 * Constraints:
 *
 * m == mat.length
 * n == mat[i].length
 * 2 <= n, m <= 100
 * 1 <= k <= m
 * matrix[i][j] is either 0 or 1.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.easy.array;

import java.util.PriorityQueue;

public class _1337_The_K_Weakest_Rows_in_a_Matrix {

    public int[] kWeakestRows(int[][] mat, int k) {

        int rows = mat.length;
        int cols = mat[0].length;

        // {1's count, index}
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            int val = Integer.compare(b[0], a[0]);

            if (val == 0) {
                return Integer.compare(b[1], a[1]);
            }

            return val;
        });

        for (int i = 0; i < rows; i++) {

            int count = getCountUsingBinarySearch(mat[i]);
            maxHeap.add(new int[]{count, i});

            if (maxHeap.size() > k) {
                maxHeap.remove();
            }
        }

        int[] result = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            result[i] = maxHeap.remove()[1];
        }

        return result;
    }

    private int getCountUsingBinarySearch(int[] arr) {

        int index = -1;

        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {

            int mid = l + (r - l) / 2;
            if (arr[mid] == 1) {
                index = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return index + 1;
    }
}
