/**********************************************************************************
 *
 * https://leetcode.com/problems/flip-string-to-monotone-increasing/
 *
 * A binary string is monotone increasing if it consists of some number of 0's (possibly none), followed by some number of 1's (also possibly none).
 *
 * You are given a binary string s. You can flip s[i] changing it from 0 to 1 or from 1 to 0.
 *
 * Return the minimum number of flips to make s monotone increasing.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "00110"
 * Output: 1
 * Explanation: We flip the last digit to get 00111.
 * Example 2:
 *
 * Input: s = "010110"
 * Output: 2
 * Explanation: We flip to get 011111, or alternatively 000111.
 * Example 3:
 *
 * Input: s = "00011000"
 * Output: 2
 * Explanation: We flip to get 00000000.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s[i] is either '0' or '1'.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.dp;

public class _926_Flip_String_to_Monotone_Increasing {

//    public int minFlipsMonoIncr(String s) {
//
//        // DP with top down
//        int n = s.length();
//        char[] str = s.toCharArray();
//
//        // dp[i][j] = minimum number of flips till i-th index having prev j(0 or 1)
//        Integer[][] dp = new Integer[n][2];
//
//        return solve(str, n, 0, 0, dp);
//    }
//
//    private int solve(char[] str, int n, int idx, int prev, Integer[][] dp) {
//
//        if (idx == n) {
//            return 0;
//        }
//
//        if (dp[idx][prev] != null) {
//            return dp[idx][prev];
//        }
//
//        int flip = Integer.MAX_VALUE;
//        int skip = Integer.MAX_VALUE;
//
//        if (str[idx] == '0') {
//            if (prev == 1) { // 10
//                flip = 1 + solve(str, n, idx + 1, 1, dp);
//            } else { // 00
//                flip = 1 + solve(str, n, idx + 1, 1, dp);
//                skip = solve(str, n, idx + 1, 0, dp);
//            }
//        } else {
//            if (prev == 1) { // 11
//                skip = solve(str, n, idx + 1, 1, dp);
//            } else { // 01
//                flip = 1 + solve(str, n, idx + 1, 0, dp);
//                skip = solve(str, n, idx + 1, 1, dp);
//            }
//        }
//
//        return dp[idx][prev] = Math.min(flip, skip);
//    }

    public int minFlipsMonoIncr(String s) {

        // DP with bottom up
        int n = s.length();
        char[] str = s.toCharArray();

        // Store count of '1' till i-th index
        int countOnes = 0;
        int flips = 0;

        for (int i = 0; i < n; i++) {
            if (str[i] == '1') {
                countOnes++;
            }

            // Flip only if '0' found as '1' is always monotonic increasing
            if (str[i] == '0') {
                flips = Math.min(countOnes, flips + 1);
            }
        }
        return flips;
    }
}
