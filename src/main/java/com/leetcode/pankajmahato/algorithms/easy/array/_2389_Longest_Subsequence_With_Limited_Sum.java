/**********************************************************************************
 *
 * https://leetcode.com/problems/longest-subsequence-with-limited-sum/description/
 *
 * You are given an integer array nums of length n, and an integer array queries of length m.
 *
 * Return an array answer of length m where answer[i] is the maximum size of a subsequence that you can take from nums such that the sum of its elements is less than or equal to queries[i].
 *
 * A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,5,2,1], queries = [3,10,21]
 * Output: [2,3,4]
 * Explanation: We answer the queries as follows:
 * - The subsequence [2,1] has a sum less than or equal to 3. It can be proven that 2 is the maximum size of such a subsequence, so answer[0] = 2.
 * - The subsequence [4,5,1] has a sum less than or equal to 10. It can be proven that 3 is the maximum size of such a subsequence, so answer[1] = 3.
 * - The subsequence [4,5,2,1] has a sum less than or equal to 21. It can be proven that 4 is the maximum size of such a subsequence, so answer[2] = 4.
 * Example 2:
 *
 * Input: nums = [2,3,4,5], queries = [1]
 * Output: [0]
 * Explanation: The empty subsequence is the only subsequence that has a sum less than or equal to 1, so answer[0] = 0.
 *
 *
 * Constraints:
 *
 * n == nums.length
 * m == queries.length
 * 1 <= n, m <= 1000
 * 1 <= nums[i], queries[i] <= 106
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.easy.array;

import java.util.Arrays;

public class _2389_Longest_Subsequence_With_Limited_Sum {

    public int[] answerQueries(int[] nums, int[] queries) {

        int n = nums.length;
        int m = queries.length;

        Arrays.sort(nums);
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];

        int[] result = new int[m];

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        for (int i = 0; i < m; i++) {
            result[i] = binarySearchUpperBound(prefixSum, queries[i]) + 1;
        }

        return result;
    }

    private int binarySearchUpperBound(int[] nums, int val) {

        int left = 0;
        int right = nums.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= val) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
