/**********************************************************************************
 *
 * https://leetcode.com/problems/maximal-rectangle/
 *
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 6
 * Explanation: The maximal rectangle is shown in the above picture.
 * Example 2:
 *
 * Input: matrix = [["0"]]
 * Output: 0
 * Example 3:
 *
 * Input: matrix = [["1"]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * rows == matrix.length
 * cols == matrix[i].length
 * 1 <= row, cols <= 200
 * matrix[i][j] is '0' or '1'.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class _85_Maximal_Rectangle {

    public int maximalRectangle(char[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int[] heights = new int[n];

        int result = 0;
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    heights[j] = 0;
                } else {
                    heights[j] += 1;
                }
            }

            int[] nsl = getNSL(heights, n);
            int[] nsr = getNSR(heights, n);

            for (int j = 0; j < n; j++) {
                int width = nsr[j] - nsl[j] - 1;
                int area = heights[j] * width;
                result = Math.max(result, area);
            }
        }

        return result;
    }

    private int[] getNSL(int[] arr, int n) {

        int[] nsl = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                nsl[i] = -1;
            } else {
                while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                    stack.pop();
                }

                nsl[i] = stack.isEmpty() ? -1 : stack.peek();
            }

            stack.push(i);
        }

        return nsl;
    }

    private int[] getNSR(int[] arr, int n) {

        int[] nsr = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                nsr[i] = n;
            } else {
                while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                    stack.pop();
                }

                nsr[i] = stack.isEmpty() ? n : stack.peek();
            }

            stack.push(i);
        }

        return nsr;
    }
}
