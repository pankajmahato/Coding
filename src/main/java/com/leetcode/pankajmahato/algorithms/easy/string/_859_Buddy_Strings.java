/**********************************************************************************
 *
 * https://leetcode.com/problems/buddy-strings/
 *
 * Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal, otherwise, return false.
 *
 * Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].
 *
 * For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
 *
 *
 * Example 1:
 *
 * Input: s = "ab", goal = "ba"
 * Output: true
 * Explanation: You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is equal to goal.
 * Example 2:
 *
 * Input: s = "ab", goal = "ab"
 * Output: false
 * Explanation: The only letters you can swap are s[0] = 'a' and s[1] = 'b', which results in "ba" != goal.
 * Example 3:
 *
 * Input: s = "aa", goal = "aa"
 * Output: true
 * Explanation: You can swap s[0] = 'a' and s[1] = 'a' to get "aa", which is equal to goal.
 *
 *
 * Constraints:
 *
 * 1 <= s.length, goal.length <= 2 * 104
 * s and goal consist of lowercase letters.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.easy.string;

public class _859_Buddy_Strings {

    public boolean buddyStrings(String s, String goal) {

        if (s.length() != goal.length()) {
            return false;
        }

        if (s.equals(goal)) {
            return checkFreq(s);
        }

        int diff1 = -1;
        int diff2 = -1;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) != goal.charAt(i)) {
                if (diff1 == -1) {
                    diff1 = i;
                } else if (diff2 == -1) {
                    diff2 = i;
                } else {
                    // More than 2 different places between s & goal
                    return false;
                }
            }
        }

        if (diff1 != -1 && diff2 != -1) {
            // check if after swap it becomes equal
            return s.charAt(diff1) == goal.charAt(diff2) && s.charAt(diff2) == goal.charAt(diff1);
        } else {
            return false;
        }
    }

    private boolean checkFreq(String s) {

        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {

            freq[s.charAt(i) - 'a']++;

            if (freq[s.charAt(i) - 'a'] > 1) {
                return true;
            }
        }

        return false;

    }
}
