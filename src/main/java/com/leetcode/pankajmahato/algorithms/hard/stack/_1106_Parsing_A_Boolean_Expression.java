/**********************************************************************************
 *
 * https://leetcode.com/problems/parsing-a-boolean-expression/
 *
 * A boolean expression is an expression that evaluates to either true or false. It can be in one of the following shapes:
 *
 * 't' that evaluates to true.
 * 'f' that evaluates to false.
 * '!(subExpr)' that evaluates to the logical NOT of the inner expression subExpr.
 * '&(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical AND of the inner expressions subExpr1, subExpr2, ..., subExprn where n >= 1.
 * '|(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical OR of the inner expressions subExpr1, subExpr2, ..., subExprn where n >= 1.
 * Given a string expression that represents a boolean expression, return the evaluation of that expression.
 *
 * It is guaranteed that the given expression is valid and follows the given rules.
 *
 *
 *
 * Example 1:
 *
 * Input: expression = "&(|(f))"
 * Output: false
 * Explanation: 
 * First, evaluate |(f) --> f. The expression is now "&(f)".
 * Then, evaluate &(f) --> f. The expression is now "f".
 * Finally, return false.
 * Example 2:
 *
 * Input: expression = "|(f,f,f,t)"
 * Output: true
 * Explanation: The evaluation of (false OR false OR false OR true) is true.
 * Example 3:
 *
 * Input: expression = "!(&(f,t))"
 * Output: true
 * Explanation: 
 * First, evaluate &(f,t) --> (false AND true) --> false --> f. The expression is now "!(f)".
 * Then, evaluate !(f) --> NOT false --> true. We return true.
 *
 *
 * Constraints:
 *
 * 1 <= expression.length <= 2 * 104
 * expression[i] is one following characters: '(', ')', '&', '|', '!', 't', 'f', and ','.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _1106_Parsing_A_Boolean_Expression {

    public boolean parseBoolExpr(String expression) {

        Deque<Character> stack = new ArrayDeque<>();
        int n = expression.length();

        for (char c : expression.toCharArray()) {
            if (c == ',') {
                continue;
            } else if (c == ')') {
                List<Character> subExpr = new ArrayList<>();
                while (!stack.isEmpty() && stack.peek() != '(') {
                    subExpr.add(stack.pop());
                }
                stack.pop();
                char operator = stack.pop();
                boolean currResult = solveExpression(subExpr, operator);
                stack.push(currResult ? 't' : 'f');
            } else {
                stack.push(c);
            }
        }

        return stack.pop() == 't' ? true : false;
    }

    private boolean solveExpression(List<Character> subExpr, char operator) {

        switch (operator) {
            case '!': {
                return subExpr.get(0) == 't' ? false : true;
            }
            case '&': {
                for (int i = subExpr.size() - 1; i >= 0; i--) {
                    if (subExpr.get(i) == 'f') {
                        return false;
                    }
                }

                return true;
            }
            case '|': {
                for (int i = subExpr.size() - 1; i >= 0; i--) {
                    if (subExpr.get(i) == 't') {
                        return true;
                    }
                }

                return false;
            }
        }

        return false;
    }
}
