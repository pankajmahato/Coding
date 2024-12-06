/**********************************************************************************
 *
 * https://leetcode.com/problems/palindromic-substrings/
 *
 * Given a string s, return the number of palindromic substrings in it.
 *
 * A string is a palindrome when it reads the same backward as forward.
 *
 * A substring is a contiguous sequence of characters within the string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * Example 2:
 *
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consists of lowercase English letters.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.dp;

public class _647_Palindromic_Substrings {

//    public int countSubstrings(String s) {
//
//        // DP with bottom up
//        int n = s.length();
//
//        int count = 0;
//
//        // dp[i][j] = Denotes whether the substring from i-th to j-th index is palindrome
//        Boolean[][] dp = new Boolean[n][n];
//
//        for (int i = 0; i < n; i++) {
//            for (int j = i; j < n; j++) {
//
//                if (isPalindrome(s, i, j, dp)) {
//                    count++;
//                }
//            }
//        }
//
//        return count;
//    }
//
//    private boolean isPalindrome(String s, int i, int j, Boolean[][] dp) {
//
//        if (i > j) {
//            return true;
//        }
//
//        if (dp[i][j] != null) {
//            return dp[i][j];
//        }
//
//        if (s.charAt(i) == s.charAt(j)) {
//            return dp[i][j] = isPalindrome(s, i + 1, j - 1, dp);
//        }
//
//        return dp[i][j] = false;
//    }

    public int countSubstrings(String s) {

        // DP with top down
        int n = s.length();

        int count = 0;

        // dp[i][j] = Denotes whether the substring from i-th to j-th index is palindrome
        boolean[][] dp = new boolean[n][n];

        for (int l = 1; l <= n; l++) {
            for (int i = 0; i + l - 1 < n; i++) {

                int j = i + l - 1;

                if (i == j) {
                    // Length of 1 is always palindrome
                    dp[i][j] = true;
                } else if (i + 1 == j) {
                    // Check for length 2
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    // Length more than 2 is palindrome is end characters are equal and inner
                    // substring is palindrome
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }

                if (dp[i][j] == true) {
                    count++;
                }
            }
        }

        return count;
    }
}
