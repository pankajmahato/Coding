/**********************************************************************************
 *
 * https://leetcode.com/problems/palindrome-partitioning-ii/
 *
 * Given a string s, partition s such that every 
 * substring
 *  of the partition is a 
 * palindrome
 * .
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * Example 2:
 *
 * Input: s = "a"
 * Output: 0
 * Example 3:
 *
 * Input: s = "ab"
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 2000
 * s consists of lowercase English letters only.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.dp;

public class _132_Palindrome_Partitioning_II {

//    public int minCut(String s) {
//
//        // DP with bottom up and recursion (gives TLE)
//        int n = s.length();
//
//        // dp[i][j] = is substring [i...j] palindrome
//        boolean[][] dp = new boolean[n][n];
//
//        // cutsDP[i][j] = minimum number of partitions (cuts) between(inclusive) i and j index
//        Integer[][] cutsDP = new Integer[n][n];
//
//        for (int i = 0; i < n; i++) {
//            dp[i][i] = true;
//        }
//
//        for (int len = 2; len <= n; len++) {
//            for (int i = 0; i + len - 1 < n; i++) {
//
//                int j = i + len - 1;
//                if (s.charAt(i) == s.charAt(j)) {
//                    if (len == 2) {
//                        dp[i][j] = true;
//                    } else {
//                        dp[i][j] = dp[i + 1][j - 1];
//                    }
//                }
//            }
//        }
//
//        return backtrack(s, 0, n - 1, dp, cutsDP);
//    }
//
//    private int backtrack(String s, int i, int j, boolean[][] dp, Integer[][]
//            cutsDP) {
//
//        if (cutsDP[i][j] != null) {
//            return cutsDP[i][j];
//        }
//
//        if (dp[i][j] == true) {
//            return cutsDP[i][j] = 0;
//        }
//
//        int min = Integer.MAX_VALUE;
//        for (int cut = i; cut < j; cut++) {
//
//            int temp = 1 + backtrack(s, i, cut, dp, cutsDP) + backtrack(s, cut + 1, j,
//                    dp, cutsDP);
//            min = Math.min(min, temp);
//        }
//
//        return cutsDP[i][j] = min;
//    }

    public int minCut(String s) {

        // DP with bottom up and bottom up
        int n = s.length();

        // dp[i][j] = is substring [i...j] palindrome
        boolean[][] dp = new boolean[n][n];

        // cutsDP[i] = minimum number of partitions (cuts) between from 0th to i-th
        // index
        int[] cutsDP = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {

                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (dp[0][i] == true) {
                cutsDP[i] = 0;
            } else {
                cutsDP[i] = Integer.MAX_VALUE;
                for (int k = 0; k < i; k++) {
                    if (dp[k + 1][i] == true) {
                        cutsDP[i] = Math.min(cutsDP[i], 1 + cutsDP[k]);
                    }
                }
            }
        }

        return cutsDP[n - 1];
    }
}
