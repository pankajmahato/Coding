/**********************************************************************************
 *
 * https://leetcode.com/problems/sum-of-subarray-minimums/
 *
 * Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [3,1,2,4]
 * Output: 17
 * Explanation: 
 * Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
 * Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
 * Sum is 17.
 * Example 2:
 *
 * Input: arr = [11,81,94,43,3]
 * Output: 444
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 3 * 104
 * 1 <= arr[i] <= 3 * 104
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class _907_Sum_of_Subarray_Minimums {

    public int sumSubarrayMins(int[] arr) {

        int n = arr.length;
        int[] nsl = getNSL(arr, n);
        int[] nsr = getNSR(arr, n);

        int result = 0;
        int limit = 1_000_000_007;
        for (int i = 0; i < n; i++) {

            int left = i - nsl[i];
            int right = nsr[i] - i;

            long totalCount = (long) left * right;

            long totalSum = totalCount * arr[i];

            result = (int) ((result + totalSum) % limit);
        }

        return result;
    }

    private int[] getNSL(int[] arr, int n) {

        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {

            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                    stack.pop();
                }

                result[i] = stack.isEmpty() ? -1 : stack.peek();
            }

            stack.push(i);
        }

        return result;
    }

    private int[] getNSR(int[] arr, int n) {

        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[n];

        for (int i = n - 1; i >= 0; i--) {

            if (stack.isEmpty()) {
                result[i] = n;
            } else {
                while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                    stack.pop();
                }

                result[i] = stack.isEmpty() ? n : stack.peek();
            }

            stack.push(i);
        }

        return result;
    }
}
