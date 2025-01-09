/**********************************************************************************
 *
 * https://leetcode.com/problems/remove-duplicate-letters/
 *
 * Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is 
 * the smallest in lexicographical order
 *  among all possible results.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "bcabc"
 * Output: "abc"
 * Example 2:
 *
 * Input: s = "cbacdcbc"
 * Output: "acdb"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of lowercase English letters.
 *
 *
 * Note: This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.string;

import java.util.Stack;

public class _316_Remove_Duplicate_Letters {

    public String removeDuplicateLetters(String s) {

        int n = s.length();
        int N = 26;
        int[] lastIndex = new int[N];
        boolean[] used = new boolean[N];

        for (int i = 0; i < n; i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {

            char ch = s.charAt(i);
            int idx = ch - 'a';

            if (used[idx] == true) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > ch && lastIndex[stack.peek() - 'a'] > i) {
                used[stack.peek() - 'a'] = false;
                stack.pop();
            }

            stack.push(ch);
            used[ch - 'a'] = true;
        }

        char[] chars = new char[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            chars[i] = stack.pop();
        }

        return new String(chars);
    }
}
