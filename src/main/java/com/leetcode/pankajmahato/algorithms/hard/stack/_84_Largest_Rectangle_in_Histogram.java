/**********************************************************************************
 *
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 * Explanation: The above is a histogram where width of each bar is 1.
 * The largest rectangle is shown in the red area, which has an area = 10 units.
 * Example 2:
 *
 *
 * Input: heights = [2,4]
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= heights.length <= 105
 * 0 <= heights[i] <= 104
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class _84_Largest_Rectangle_in_Histogram {

    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        int[] nsl = getNSL(heights, n);
        int[] nsr = getNSR(heights, n);

        int result = 0;

        for (int i = 0; i < n; i++) {
            int area = heights[i] * (nsr[i] - nsl[i] - 1);
            result = Math.max(result, area);
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
