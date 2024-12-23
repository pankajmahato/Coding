/**********************************************************************************
 *
 * https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/
 *
 * You are given a string s consisting only of characters 'a' and 'b'​​​​.
 *
 * You can delete any number of characters in s to make s balanced. s is balanced if there is no pair of indices (i,j) such that i < j and s[i] = 'b' and s[j]= 'a'.
 *
 * Return the minimum number of deletions needed to make s balanced.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aababbab"
 * Output: 2
 * Explanation: You can either:
 * Delete the characters at 0-indexed positions 2 and 6 ("aababbab" -> "aaabbb"), or
 * Delete the characters at 0-indexed positions 3 and 6 ("aababbab" -> "aabbbb").
 * Example 2:
 *
 * Input: s = "bbaaaaabb"
 * Output: 2
 * Explanation: The only solution is to delete the first two characters.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s[i] is 'a' or 'b'​​.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.stack;

public class _1653_Minimum_Deletions_to_Make_String_Balanced {

    public int minimumDeletions(String s) {

        int n = s.length();

        // Count of A in the right side
        int countA = 0;
        // Count of B in the right side
        int countB = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                countA++;
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                countA--;
            }
            result = Math.min(result, countB + countA);
            if (s.charAt(i) == 'b') {
                countB++;
            }
        }

        return result;
    }
}
