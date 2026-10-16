/**********************************************************************************
 *
 * https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/
 *
 * Given an integer array arr and an integer difference, return the length of the longest subsequence in arr which is an arithmetic sequence such that the difference between adjacent elements in the subsequence equals difference.
 *
 * A subsequence is a sequence that can be derived from arr by deleting some or no elements without changing the order of the remaining elements.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2,3,4], difference = 1
 * Output: 4
 * Explanation: The longest arithmetic subsequence is [1,2,3,4].
 * Example 2:
 *
 * Input: arr = [1,3,5,7], difference = 1
 * Output: 1
 * Explanation: The longest arithmetic subsequence is any single element.
 * Example 3:
 *
 * Input: arr = [1,5,7,8,5,3,4,2,1], difference = -2
 * Output: 4
 * Explanation: The longest arithmetic subsequence is [7,5,3,1].
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 105
 * -104 <= arr[i], difference <= 104
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1218_Longest_Arithmetic_Subsequence_of_Given_Difference {

//    public int longestSubsequence(int[] arr, int difference) {
//
//        // DP Top Down
//
//        int n = arr.length;
//
//        // do[i] = Length of sequence from ith index
//        int[] dp = new int[n];
//        Arrays.fill(dp, -1);
//
//        int result = 0;
//        for (int i = 0; i < n; i++) {
//
//            result = Math.max(result, 1 + solve(i, n, arr, difference, dp));
//        }
//
//        return result;
//    }
//
//    private int solve(int i, int n, int[] arr, int diff, int[] dp) {
//
//        if (dp[i] != -1) {
//            return dp[i];
//        }
//
//        int result = 0;
//
//        for (int j = i + 1; j < n; j++) {
//
//            int prev = arr[i];
//            int curr = arr[j];
//
//            if (curr - prev == diff) {
//                result = Math.max(result, 1 + solve(j, n, arr, diff, dp));
//            }
//        }
//
//        return dp[i] = result;
//    }

    public int longestSubsequence(int[] arr, int difference) {

        int n = arr.length;

        // num -> length ending at num with difference
        Map<Integer, Integer> map = new HashMap<>();

        int result = 1;
        for (int i = 0; i < n; i++) {

            int key = arr[i] - difference;
            if (map.containsKey(key)) {
                map.put(arr[i], map.get(key) + 1);
            } else {
                map.put(arr[i], 1);
            }

            result = Math.max(result, map.get(arr[i]));
        }

        return result;
    }
}
