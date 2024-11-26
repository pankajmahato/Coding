/**********************************************************************************
 *
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 *
 * Given a string s of '(' , ')' and lowercase English characters.
 *
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
 *
 * Formally, a parentheses string is valid if and only if:
 *
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 *
 *
 * Example 1:
 *
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 * Example 2:
 *
 * Input: s = "a)b(c)d"
 * Output: "ab(c)d"
 * Example 3:
 *
 * Input: s = "))(("
 * Output: ""
 * Explanation: An empty string is also valid.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s[i] is either '(' , ')', or lowercase English letter.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.stack;

public class _1249_Minimum_Remove_to_Make_Valid_Parentheses {

    public String minRemoveToMakeValid(String s) {

        StringBuilder temp = new StringBuilder();
        int open = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                temp.append(c);
            } else if (c == '(') {
                open++;
                temp.append(c);
            } else if (c == ')' && open > 0) {
                open--;
                temp.append(c);
            }
        }

        if (open == 0) {
            return temp.toString();
        }

        StringBuilder result = new StringBuilder();

        for (int i = temp.length() - 1; i >= 0; i--) {
            if (open > 0 && temp.charAt(i) == '(') {
                open--;
                continue;
            } else {
                result.append(temp.charAt(i));
            }
        }

        return result.reverse().toString();
    }
}
