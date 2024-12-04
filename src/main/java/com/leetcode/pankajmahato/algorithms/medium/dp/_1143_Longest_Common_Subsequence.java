/**********************************************************************************
 *
 * https://leetcode.com/problems/longest-common-subsequence/
 *
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
 *
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 *
 *
 *
 * Example 1:
 *
 * Input: text1 = "abcde", text2 = "ace" 
 * Output: 3  
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 *
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 *
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 *
 *
 * Constraints:
 *
 * 1 <= text1.length, text2.length <= 1000
 * text1 and text2 consist of only lowercase English characters.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.dp;

import java.util.Arrays;

public class _1143_Longest_Common_Subsequence {

//    public int longestCommonSubsequence(String text1, String text2) {
//
//        // DP with top down
//
//        // dp[i][j] = Longest common subsequence till i-th and j-th characters of text1 and text2
//        int[][] dp = new int[text1.length()][text2.length()];
//        for (int i = 0; i < text1.length(); i++) {
//            Arrays.fill(dp[i], -1);
//        }
//
//        int i = 0;
//        int j = 0;
//
//        return solve(text1, i, text2, j, dp);
//    }
//
//    private int solve(String text1, int i, String text2, int j, int[][] dp) {
//
//        // Either of the text is completed
//        if (i >= text1.length() || j >= text2.length()) {
//            return 0;
//        }
//
//        if (dp[i][j] != -1) {
//            return dp[i][j];
//        }
//
//        // Both the characters are same so matching length is increased by 1
//        if (text1.charAt(i) == text2.charAt(j)) {
//            return dp[i][j] = 1 + solve(text1, i + 1, text2, j + 1, dp);
//        }
//
//        // Skip character from text1 and keep for text2
//        int first = solve(text1, i + 1, text2, j, dp);
//
//        // Keep character from text1 and skip for text2
//        int second = solve(text1, i, text2, j + 1, dp);
//
//        // Return the max from either
//        return dp[i][j] = Math.max(first, second);
//    }

    public int longestCommonSubsequence(String text1, String text2) {

        // DP with bottom up

        int m = text1.length();
        int n = text2.length();

        // dp[i][j] = Longest common subsequence of text1 of length i and text2 of length j
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    // Keep character from text1 and take previous for text2
                    int first = dp[i][j - 1];

                    // Take previous character from text1 and keep for text2
                    int second = dp[i - 1][j];

                    // Keep the max from either
                    dp[i][j] = Math.max(first, second);
                }
            }
        }

        int idx = dp[m][n];
        char[] resultArr = new char[idx];

        int i = m;
        int j = n;
        while (i > 0 && j > 0) {

            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                resultArr[idx - 1] = text1.charAt(i - 1);
                idx--;
                i--;
                j--;
            } else {

                if (dp[i][j - 1] > dp[i - 1][j]) {
                    j--;
                } else {
                    i--;
                }
            }
        }

        String result = new String(resultArr);
//        System.out.println(result);

        return dp[m][n];
    }
}
