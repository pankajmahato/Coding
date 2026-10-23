/**********************************************************************************
 *
 * https://leetcode.com/problems/generate-parentheses/
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 8
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _22_Generate_Parentheses {

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        StringBuilder curr = new StringBuilder();

        solve(n, 0, 0, curr, result);

        return result;
    }

    private void solve(int n, int open, int close, StringBuilder curr, List<String> result) {

        if (open == n && close == n) {
            result.add(curr.toString());
            return;
        }

        if (open < n) {
            curr.append("(");
            open++;
            solve(n, open, close, curr, result);
            curr.deleteCharAt(curr.length() - 1);
            open--;
        }
        if (close < open) {
            curr.append(")");
            close++;
            solve(n, open, close, curr, result);
            curr.deleteCharAt(curr.length() - 1);
            close--;
        }
    }
}
