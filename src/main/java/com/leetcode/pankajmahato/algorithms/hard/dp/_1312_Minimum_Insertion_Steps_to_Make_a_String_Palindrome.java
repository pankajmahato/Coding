/**********************************************************************************
 *
 * https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
 *
 * Given a string s. In one step you can insert any character at any index of the string.
 *
 * Return the minimum number of steps to make s palindrome.
 *
 * A Palindrome String is one that reads the same backward as well as forward.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "zzazz"
 * Output: 0
 * Explanation: The string "zzazz" is already palindrome we do not need any insertions.
 * Example 2:
 *
 * Input: s = "mbadm"
 * Output: 2
 * Explanation: String can be "mbdadbm" or "mdbabdm".
 * Example 3:
 *
 * Input: s = "leetcode"
 * Output: 5
 * Explanation: Inserting 5 characters the string becomes "leetcodocteel".
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 500
 * s consists of lowercase English letters.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.dp;

public class _1312_Minimum_Insertion_Steps_to_Make_a_String_Palindrome {

//    public int minInsertions(String s) {
//
//        // DP with top down
//        int n = s.length();
//
//        // dp[i][j] = Minimum number of insertion from i-th to j-th index
//        int[][] dp = new int[n][n];
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                dp[i][j] = -1;
//            }
//        }
//        int i = 0;
//        int j = n - 1;
//
//        return solve(s, i, j, dp);
//    }
//
//    private int solve(String s, int i, int j, int[][] dp) {
//
//        if (i >= j) {
//            return 0;
//        }
//
//        if (dp[i][j] != -1) {
//            return dp[i][j];
//        }
//
//        if (s.charAt(i) == s.charAt(j)) {
//            return dp[i][j] = solve(s, i + 1, j - 1, dp);
//        } else {
//            int left = 1 + solve(s, i + 1, j, dp);
//            int right = 1 + solve(s, i, j - 1, dp);
//
//            return dp[i][j] = Math.min(left, right);
//        }
//    }

    public int minInsertions(String s) {

        // DP with bottom up
        int n = s.length();

        // dp[i][j] = Minimum number of insertion from i-th to j-th index
        // Minimum for len = 1 (i==j); dp[i][j] = 0
        int[][] dp = new int[n][n];

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {

                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    int left = 1 + dp[i][j - 1];
                    int right = 1 + dp[i + 1][j];

                    dp[i][j] = Math.min(left, right);
                }

            }
        }

        return dp[0][n - 1];
    }
}
