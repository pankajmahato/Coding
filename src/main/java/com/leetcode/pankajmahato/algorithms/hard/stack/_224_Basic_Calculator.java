/**********************************************************************************
 *
 * https://leetcode.com/problems/basic-calculator/
 *
 * Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
 *
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 *
 *
 *
 * Example 1:
 *
 * Input: s = "1 + 1"
 * Output: 2
 * Example 2:
 *
 * Input: s = " 2-1 + 2 "
 * Output: 3
 * Example 3:
 *
 * Input: s = "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 3 * 105
 * s consists of digits, '+', '-', '(', ')', and ' '.
 * s represents a valid expression.
 * '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
 * '-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
 * There will be no two consecutive operators in the input.
 * Every number and running calculation will fit in a signed 32-bit integer.
 *
 **********************************************************************************/

package com.leetcode.pankajmahato.algorithms.hard.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class _224_Basic_Calculator {

    public int calculate(String s) {

        Deque<Integer> stack = new ArrayDeque<>();

        int result = 0;
        int sign = 1;
        int number = 0;
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == '+') {
                result += number * sign;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += number * sign;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                number = 0;
                sign = 1;
            } else if (c == ')') {
                result += number * sign;
                number = 0;
                int lastSign = stack.pop();
                int lastResult = stack.pop();
                result *= lastSign;
                result += lastResult;
            }
        }

        result += number * sign;
        return result;
    }
}
