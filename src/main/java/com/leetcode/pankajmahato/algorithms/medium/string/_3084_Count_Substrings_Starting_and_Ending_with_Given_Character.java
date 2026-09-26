/**********************************************************************************
 *
 * https://leetcode.com/problems/count-substrings-starting-and-ending-with-given-character/
 *
 * You are given a string s and a character c. Return the total number of substrings of s that start and end with c.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abada", c = "a"
 *
 * Output: 6
 *
 * Explanation: Substrings starting and ending with "a" are: "abada", "abada", "abada", "abada", "abada", "abada".
 *
 * Example 2:
 *
 * Input: s = "zzz", c = "z"
 *
 * Output: 6
 *
 * Explanation: There are a total of 6 substrings in s and all start and end with "z".
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s and c consist only of lowercase English letters.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.string;

public class _3084_Count_Substrings_Starting_and_Ending_with_Given_Character {

    public long countSubstrings(String s, char c) {

        int n = s.length();

        int count = 0;

        long result = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                result = result + count + 1; // +1 for the matching single character substring
                count++;
            }
        }

        return result;
    }
}
