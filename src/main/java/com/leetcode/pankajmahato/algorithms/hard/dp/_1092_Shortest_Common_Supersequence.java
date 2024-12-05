/**********************************************************************************
 *
 * https://leetcode.com/problems/shortest-common-supersequence/
 *
 * Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. If there are multiple valid strings, return any of them.
 *
 * A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the string s.
 *
 *
 *
 * Example 1:
 *
 * Input: str1 = "abac", str2 = "cab"
 * Output: "cabac"
 * Explanation: 
 * str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
 * str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
 * The answer provided is the shortest such string that satisfies these properties.
 * Example 2:
 *
 * Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa"
 * Output: "aaaaaaaa"
 *
 *
 * Constraints:
 *
 * 1 <= str1.length, str2.length <= 1000
 * str1 and str2 consist of lowercase English letters.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.dp;

public class _1092_Shortest_Common_Supersequence {

    public String shortestCommonSupersequence(String str1, String str2) {

        // DP with bottom up
        int m = str1.length();
        int n = str2.length();

        // dp[i][j] = shortest common supersequence for string str1 of length i and str2 of length j
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {

                // When any one of the string is empty
                if (i == 0 || j == 0) {
                    dp[i][j] = i + j;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int len = dp[m][n];
        char[] strArr = new char[len];

        int i = m;
        int j = n;

        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                strArr[len - 1] = str1.charAt(i - 1);
                len--;
                i--;
                j--;
            } else {
                if (dp[i][j - 1] < dp[i - 1][j]) {
                    strArr[len - 1] = str2.charAt(j - 1);
                    j--;
                    len--;
                } else {
                    strArr[len - 1] = str1.charAt(i - 1);
                    i--;
                    len--;
                }
            }
        }

        while (i > 0) {
            strArr[len - 1] = str1.charAt(i - 1);
            len--;
            i--;
        }
        while (j > 0) {
            strArr[len - 1] = str2.charAt(j - 1);
            len--;
            j--;
        }

        return new String(strArr);
    }
}
