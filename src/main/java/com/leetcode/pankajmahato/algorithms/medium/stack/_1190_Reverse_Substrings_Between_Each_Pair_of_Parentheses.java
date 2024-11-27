/**********************************************************************************
 *
 * https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 *
 * You are given a string s that consists of lower case English letters and brackets.
 *
 * Reverse the strings in each pair of matching parentheses, starting from the innermost one.
 *
 * Your result should not contain any brackets.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "(abcd)"
 * Output: "dcba"
 * Example 2:
 *
 * Input: s = "(u(love)i)"
 * Output: "iloveu"
 * Explanation: The substring "love" is reversed first, then the whole string is reversed.
 * Example 3:
 *
 * Input: s = "(ed(et(oc))el)"
 * Output: "leetcode"
 * Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 2000
 * s only contains lower case English characters and parentheses.
 * It is guaranteed that all parentheses are balanced.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class _1190_Reverse_Substrings_Between_Each_Pair_of_Parentheses {

    public String reverseParentheses(String s) {

        int n = s.length();
        Deque<Integer> stack = new ArrayDeque<>();
        // Undirected Map of '(' to ')'
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                map.put(i, stack.peek());
                map.put(stack.peek(), i);
                stack.pop();
            }
        }

        // Denotes direction; 1 = left to right; -1 = right to left;
        int flag = 1;

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i >= 0 && i < n) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = map.get(i);
                // Flip direction
                flag = -flag;
            } else {
                sb.append(s.charAt(i));
            }

            i = i + flag;
        }

        return sb.toString();
    }
}
