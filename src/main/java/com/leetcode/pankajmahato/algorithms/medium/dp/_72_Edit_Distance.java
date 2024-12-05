/**********************************************************************************
 *
 * https://leetcode.com/problems/edit-distance/
 *
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 *
 * You have the following three operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 *
 *
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation: 
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 *
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation: 
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 *
 *
 * Constraints:
 *
 * 0 <= word1.length, word2.length <= 500
 * word1 and word2 consist of lowercase English letters.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.dp;

import java.util.Arrays;

public class _72_Edit_Distance {

//    public int minDistance(String word1, String word2) {
//
//        // DP with top down (fill from bottom)
//
//        int m = word1.length();
//        int n = word2.length();
//
//        // dp[i][j] = Minimum number of operations for word1 of index i and word2 of index j
//        int[][] dp = new int[m][n];
//
//        for (int i = 0; i < m; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        return solve(word1, m, word2, n, 0, 0, dp);
//    }
//
//    private int solve(String word1, int m, String word2, int n, int i, int j, int[][] dp) {
//
//        if (i == m) {
//            // Return the length(operations) of remaining letters in word2
//            return n - j;
//        }
//        if (j == n) {
//            // Return the length(operations) of remaining letters in word1
//            return m - i;
//        }
//
//        if (dp[i][j] != -1) {
//            return dp[i][j];
//        }
//
//        if (word1.charAt(i) == word2.charAt(j)) {
//            return dp[i][j] = solve(word1, m, word2, n, i + 1, j + 1, dp);
//        }
//
//        int insert = 1 + solve(word1, m, word2, n, i, j + 1, dp);
//        int delete = 1 + solve(word1, m, word2, n, i + 1, j, dp);
//        int replace = 1 + solve(word1, m, word2, n, i + 1, j + 1, dp);
//
//        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
//    }

//    public int minDistance(String word1, String word2) {
//
//        // DP with top down (fill from top)
//
//        int m = word1.length();
//        int n = word2.length();
//
//        // dp[i][j] = Minimum number of operations for word1 of length i and word2 of length j
//        int[][] dp = new int[m + 1][n + 1];
//
//        for (int i = 0; i <= m; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        return solve(word1, m, word2, n, m, n, dp);
//    }
//
//    private int solve(String word1, int m, String word2, int n, int i, int j, int[][] dp) {
//
//        if (i == 0) {
//            // Return the length(operations) of remaining letters in word2
//            return j;
//        }
//        if (j == 0) {
//            // Return the length(operations) of remaining letters in word1
//            return i;
//        }
//
//        if (dp[i][j] != -1) {
//            return dp[i][j];
//        }
//
//        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
//            return dp[i][j] = solve(word1, m, word2, n, i - 1, j - 1, dp);
//        }
//
//        int insert = 1 + solve(word1, m, word2, n, i, j - 1, dp);
//        int delete = 1 + solve(word1, m, word2, n, i - 1, j, dp);
//        int replace = 1 + solve(word1, m, word2, n, i - 1, j - 1, dp);
//
//        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
//    }

    public int minDistance(String word1, String word2) {

        // DP with bottom up

        int m = word1.length();
        int n = word2.length();

        // dp[i][j] = Minimum number of operations for word1 of length i and word2 of length j
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    // Return the length(operations) of remaining letters in word1 or word2
                    dp[i][j] = i + j;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int insert = 1 + dp[i][j - 1];
                    int delete = 1 + dp[i - 1][j];
                    int replace = 1 + dp[i - 1][j - 1];

                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        return dp[m][n];
    }
}
