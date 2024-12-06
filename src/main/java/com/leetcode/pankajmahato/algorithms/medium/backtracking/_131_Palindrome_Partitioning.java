/**********************************************************************************
 *
 * https://leetcode.com/problems/palindrome-partitioning/
 *
 * Given a string s, partition s such that every 
 * substring
 *  of the partition is a 
 * palindrome
 * . Return all possible palindrome partitioning of s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * Example 2:
 *
 * Input: s = "a"
 * Output: [["a"]]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 16
 * s contains only lowercase English letters.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _131_Palindrome_Partitioning {

//    public List<List<String>> partition(String s) {
//
//        // Backtracking
//        List<String> curr = new ArrayList<>();
//        List<List<String>> result = new ArrayList<>();
//
//        backtrack(s, 0, curr, result);
//        return result;
//    }
//
//    private void backtrack(String s, int idx, List<String> curr, List<List<String>> result) {
//
//        if (idx == s.length()) {
//            result.add(new ArrayList(curr));
//        }
//
//        for (int i = idx; i < s.length(); i++) {
//            if (isPalindrome(s, idx, i)) {
//                curr.add(s.substring(idx, i + 1));
//                backtrack(s, i + 1, curr, result);
//                curr.remove(curr.size() - 1);
//            }
//        }
//    }
//
//    private boolean isPalindrome(String s, int i, int j) {
//        while (i <= j) {
//            if (s.charAt(i) != s.charAt(j)) {
//                return false;
//            }
//            i++;
//            j--;
//        }
//
//        return true;
//    }

    public List<List<String>> partition(String s) {

        // DP with bottom up
        int n = s.length();

        // dp[i][j] = is substring [i....j] palindrome
        boolean[][] dp = new boolean[n][n];

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

        List<String> curr = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();

        backtrack(s, 0, curr, result, dp);
        return result;
    }

    private void backtrack(String s, int idx, List<String> curr, List<List<String>> result, boolean[][] dp) {

        if (idx == s.length()) {
            result.add(new ArrayList(curr));
        }

        for (int i = idx; i < s.length(); i++) {
            if (dp[idx][i] == true) {
                curr.add(s.substring(idx, i + 1));
                backtrack(s, i + 1, curr, result, dp);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
