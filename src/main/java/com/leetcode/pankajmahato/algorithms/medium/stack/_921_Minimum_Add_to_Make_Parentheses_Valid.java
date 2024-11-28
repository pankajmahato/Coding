/**********************************************************************************
 *
 * https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
 *
 * A parentheses string is valid if and only if:
 *
 * It is the empty string,
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.
 *
 * For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
 * Return the minimum number of moves required to make s valid.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "())"
 * Output: 1
 * Example 2:
 *
 * Input: s = "((("
 * Output: 3
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s[i] is either '(' or ')'.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.stack;

public class _921_Minimum_Add_to_Make_Parentheses_Valid {

    public int minAddToMakeValid(String s) {

        int open = 0;
        int close = 0;
        int n = s.length();
        // Count number of open and close brackets
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else if (open > 0) {
                open--;
            } else {
                close++;
            }
        }

        // After elimination of all balanced brackets the pattern is always
        // ))).....(((
        // To balance we need open + close

        return open + close;
    }
}
