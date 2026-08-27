/**********************************************************************************
 *
 * https://leetcode.com/problems/regular-expression-matching/
 *
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * Return a boolean indicating whether the matching covers the entire input string (not partial).
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input: s = "aa", p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 *
 * Input: s = "ab", p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 20
 * 1 <= p.length <= 20
 * s contains only lowercase English letters.
 * p contains only lowercase English letters, '.', and '*'.
 * It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.backtracking;

public class _10_Regular_Expression_Matching {

    public boolean isMatch(String s, String p) {

        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
        return solve(s, 0, p, 0, dp);
    }

    private boolean solve(String s, int sIdx, String p, int pIdx, Boolean[][] dp) {

        if (pIdx == p.length()) {
            return sIdx == s.length();
        }

        if (dp[sIdx][pIdx] != null) {
            return dp[sIdx][pIdx];
        }

        boolean firstCharMatched = false;
        if (sIdx < s.length() && (s.charAt(sIdx) == p.charAt(pIdx) || p.charAt(pIdx) == '.')) {
            firstCharMatched = true;
        }

        if (pIdx + 1 < p.length() && p.charAt(pIdx + 1) == '*') {

            boolean skip = solve(s, sIdx, p, pIdx + 2, dp);

            boolean take = firstCharMatched && solve(s, sIdx + 1, p, pIdx, dp);

            return dp[sIdx][pIdx] = skip || take;
        }

        return dp[sIdx][pIdx] = firstCharMatched && solve(s, sIdx + 1, p, pIdx + 1, dp);
    }
}
