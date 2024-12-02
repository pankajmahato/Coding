/**********************************************************************************
 *
 * https://leetcode.com/problems/longest-string-chain/
 *
 * You are given an array of words where each word consists of lowercase English letters.
 *
 * wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB.
 *
 * For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
 * A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.
 *
 * Return the length of the longest possible word chain with words chosen from the given list of words.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["a","b","ba","bca","bda","bdca"]
 * Output: 4
 * Explanation: One of the longest word chains is ["a","ba","bda","bdca"].
 * Example 2:
 *
 * Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
 * Output: 5
 * Explanation: All the words can be put in a word chain ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].
 * Example 3:
 *
 * Input: words = ["abcd","dbqca"]
 * Output: 1
 * Explanation: The trivial word chain ["abcd"] is one of the longest word chains.
 * ["abcd","dbqca"] is not a valid word chain because the ordering of the letters is changed.
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 16
 * words[i] only consists of lowercase English letters.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.dp;

import java.util.Arrays;

public class _1048_Longest_String_Chain {

//    public int longestStrChain(String[] words) {
//
//        // DP with top down
//        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
//
//        int n = words.length;
//
//        // dp[i][j] = Longest String chain till i-th index having j-th prev index
//        int dp[][] = new int[n][n];
//
//        for (int i = 0; i < n; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        return backtrack(words, n, dp, 0, -1);
//    }
//
//    private int backtrack(String[] words, int n, int[][] dp, int idx, int
//            prevIdx) {
//
//        if (idx == n) {
//            return 0;
//        }
//
//        if (prevIdx != -1 && dp[idx][prevIdx] != -1) {
//            return dp[idx][prevIdx];
//        }
//
//        int exclude = backtrack(words, n, dp, idx + 1, prevIdx);
//
//        int include = 0;
//
//        if (prevIdx == -1 || words[idx].length() - words[prevIdx].length() == 1
//                && isPredecessor(words[prevIdx], words[idx])) {
//            include = 1 + backtrack(words, n, dp, idx + 1, idx);
//        }
//
//        int result = Math.max(exclude, include);
//
//        if (prevIdx != -1) {
//            dp[idx][prevIdx] = result;
//        }
//
//        return result;
//    }
//
//    private boolean isPredecessor(String first, String second) {
//
//        boolean skipped = false;
//
//        int i = 0;
//        int j = 0;
//        int n1 = first.length();
//        int n2 = second.length();
//
//        while (i < n1 && j < n2) {
//            if (first.charAt(i) == second.charAt(j)) {
//                i++;
//                j++;
//            } else if (skipped == false) {
//                j++;
//                skipped = true;
//            } else {
//                return false;
//            }
//        }
//
//        return true;
//    }

    public int longestStrChain(String[] words) {

        // DP with bottom up
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        int n = words.length;

        // dp[i] = Longest String chain till i-th index
        int dp[] = new int[n];
        Arrays.fill(dp, 1);

        int max = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (words[i].length() - words[j].length() == 1 && isPredecessor(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    max = Math.max(max, dp[i]);
                }
            }
        }

        return max;

    }

    private boolean isPredecessor(String first, String second) {

        boolean skipped = false;

        int i = 0;
        int j = 0;
        int n1 = first.length();
        int n2 = second.length();

        while (i < n1 && j < n2) {
            if (first.charAt(i) == second.charAt(j)) {
                i++;
                j++;
            } else if (skipped == false) {
                j++;
                skipped = true;
            } else {
                return false;
            }
        }

        return true;
    }
}
