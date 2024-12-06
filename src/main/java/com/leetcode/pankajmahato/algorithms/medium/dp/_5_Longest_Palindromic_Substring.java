/**********************************************************************************
 *
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 * Given a string s, return the longest 
 * palindromic
 *
 * substring
 *  in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.dp;

public class _5_Longest_Palindromic_Substring {

    public String longestPalindrome(String s) {

        // DP with top down
        int n = s.length();

        // dp[i][j] = is substring from i-th to j-th index is palindrome
        boolean[][] dp = new boolean[n][n];

        int maxLen = 0;
        int index = 0;

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                if (i == j) {
                    dp[i][j] = true;
                } else if (i + 1 == j) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }

                if (dp[i][j] == true && maxLen < len) {
                    maxLen = len;
                    index = i;
                }
            }
        }

        return s.substring(index, index + maxLen);
    }
}
